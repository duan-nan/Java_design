package cn.nylg.Dao.Impl;

import cn.nylg.Dao.bookDao;
import cn.nylg.Utils.JDBCUtils;
import cn.nylg.model.books;

import java.sql.*;
import java.util.HashMap;
import java.util.LinkedList;

public class bookDaoImpl implements bookDao {
    public static HashMap<Integer, books> map = new HashMap<Integer, books>();
    public static LinkedList<Object> list = new LinkedList<>();

    /**
     * @return
     */
    @Override
    public books checkBooks() {
        Connection con = null;
        Statement stmt = null;
        ResultSet res = null;
        books book = new books();
        try {
            con = JDBCUtils.GetConnection();
            stmt = con.createStatement();
            String sql = "select * from books";
            res = stmt.executeQuery(sql);
            while (res.next()) {
                int id = res.getInt("id");
                String books = res.getString("Books");
                String author = res.getString("Author");
                int count = res.getInt("Count");
                int value = res.getInt("Value");
                int lendCount = res.getInt("lendCount");
                book = new books(id, books, author, count, value, lendCount);
                list.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (res != null) {
                try {
                    res.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 借书
     *
     * @param idOrBookName
     * @return
     */
    @Override
    public String lendBook(String idOrBookName) {
        int Count = 0;
        String result = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try {
            con = JDBCUtils.GetConnection();
            String sql = "select * from books Where  id = ? or books= ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1,idOrBookName);
            stmt.setString(2,idOrBookName);
            res = stmt.executeQuery();
            while (res.next()){
                Count = res.getInt(1);
            }
            if (Count==0){
                result = "对不起未发现您要借阅的书籍！";
            }else {
                result = "该书存在！";
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (res != null) {
                try {
                    res.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    @Override
    public books updateBookInfo(String name,int count,int lendCount) {

        String result = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet res = null;
        try {
            con = JDBCUtils.GetConnection();
            String sql = "update books set Count = ?,lendCount=? where books=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,count);
            pstmt.setInt(2,lendCount);
            pstmt.setString(3,name);
            int i = pstmt.executeUpdate();
            if (i>0){
                System.out.println("修改成功！");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (res != null) {
                try {
                    res.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 添加书籍
     *
     * @param book
     * @return
     */
    @Override
    public String saveBook(books book) {
        String result = null;
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = JDBCUtils.GetConnection();
            String sql = "insert into books (books,author,count,value,lendCount) values(?,?,?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, book.getBookName());
            stmt.setString(2, book.getAuthor());
            stmt.setInt(3, book.getCount());
            stmt.setInt(4, book.getValue());
            stmt.setInt(5, book.getLendCount());
            int i = stmt.executeUpdate();
            if (i > 0) {
                result = "添加成功！";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }if (con!=null){
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return result;
    }

    /**
     * 删除书籍
     *
     * @param idOrName
     * @return
     */
    @Override
    public String deleteBook(String idOrName) {
        String result = null;
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = JDBCUtils.GetConnection();
            String sql = "delete from books Where id=? or books=?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1,idOrName);
            stmt.setString(2,idOrName);
            int i = stmt.executeUpdate();
            if (i > 0) {
                result = "删除成功！";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }if (con!=null){
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return result;
    }

    /**
     * @param idOrName 书籍的编号或者书名
     * @return
     */
    @Override
    public String changeBook(String idOrName,books book) {
        String result = null;
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = JDBCUtils.GetConnection();
            String sql = "update books set books=?,author=?,count=?,value=?,lendCount=?  Where id=? or books=?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1,book.getBookName());
            stmt.setString(2,book.getAuthor());
            stmt.setInt(3,book.getCount());
            stmt.setInt(4,book.getValue());
            stmt.setInt(5,book.getLendCount());
            stmt.setString(6,idOrName);
            stmt.setString(7,idOrName);
            int i = stmt.executeUpdate();
            if (i > 0) {
                result = "修改成功！";
            }else {
                result = "对不起，您要修改的书籍不存在！";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }if (con!=null){
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return result;
    }
}
