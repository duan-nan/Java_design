package cn.nylg.Dao.Impl;

import cn.nylg.Dao.UserDao;
import cn.nylg.Utils.JDBCUtils;
import cn.nylg.model.User;
import cn.nylg.model.bookContent;
import cn.nylg.model.books;

import java.sql.*;
import java.util.LinkedList;

/**
 * 持久层 操作数据
 */
public class UserDaoImpl implements UserDao {
    static LinkedList<Object> list = new LinkedList<Object>();

    /**
     * 用户进行登录的操作
     *
     * @param account
     * @return
     */
    @Override
    public User Login(String account) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet res = null;
        User user = new User();
        try {
            con = JDBCUtils.GetConnection();
            String sql = "select * from lendsystem Where username = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, account);
            res = pstmt.executeQuery();
            while (res.next()) {
                String username = res.getString("username");
                if (username.equals(account)) {
                    String name = res.getString("name");
                    String password = res.getString("password");
                    String stuIdnumber = res.getString("stuIdnumber");
                    String lendbooks = res.getString("lendbooks");
                    String phone = res.getString("phone");
                    int credit = res.getInt("credit");
                    Date lendDate = res.getDate("lendDate");
                    Date returnDate = res.getDate("returnDate");
                    user = new User(name, username, password, stuIdnumber, lendbooks, phone, credit, lendDate, returnDate);
                    break;

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.Close(res, pstmt, con);
        }
        return user;
    }

    /**
     * 用户修改信息
     *
     * @param username 修改信息的用户的用户名
     * @param name     修改后的姓名
     * @param password 修改后的密码
     * @param phone    修改后的电话
     * @return
     */
    @Override
    public User changeInformation(String username, String name, String password, String phone) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = JDBCUtils.GetConnection();
            String sql = "update lendsystem set name=?,password=?,phone=?where username=?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, password);
            stmt.setString(3, phone);
            stmt.setString(4, username);
            int i = stmt.executeUpdate();
            if (i > 0) {
                System.out.println("修改成功！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
     * @param stuId
     * @param userName
     * @param password
     * @param credit
     * @return
     */
    @Override
    public User register(String stuId, String userName, String password, String credit) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = JDBCUtils.GetConnection();

            String sql = "insert into lendsystem(stuidnumber,username,password,credit) values(?,?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, stuId);
            stmt.setString(2, userName);
            stmt.setString(3, password);
            stmt.setString(4, credit);
            int i = stmt.executeUpdate();
            if (i > 0) {
                System.out.println("添加成功！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
     * @param username
     * @param name
     * @param phone
     * @return
     */
    @Override
    public User finishInformation(String username, String name, String phone) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = JDBCUtils.GetConnection();
            String sql = "update  lendsystem set name=?,phone=? where username = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, phone);
            stmt.setString(3, username);
            int i = stmt.executeUpdate();
            if (i > 0) {
                System.out.println("信息更新成功！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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

    @Override
    public User updateLendBooks(String username, String lendBooks) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = JDBCUtils.GetConnection();
            String sql = "update lendsystem set lendbooks=? where username = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, lendBooks);
            stmt.setString(2, username);
            int i = stmt.executeUpdate();
            if (i > 0) {
                System.out.println("信息更新成功！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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

    @Override
    public User checkPerson(String username) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet res = null;
        User user = new User();
        try {
            con = JDBCUtils.GetConnection();
            String sql = "select * from lendsystem Where username = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, username);
            res = pstmt.executeQuery();
            while (res.next()) {
                String username1 = res.getString("username");
                if (username.equals(username1)) {
                    String name = res.getString("name");
                    String password = res.getString("password");
                    String stuIdnumber = res.getString("stuIdnumber");
                    String lendbooks = res.getString("lendbooks");
                    String phone = res.getString("phone");
                    int credit = res.getInt("credit");
                    Date lendDate = res.getDate("lendDate");
                    Date returnDate = res.getDate("returnDate");
                    user = new User(name, username, password, stuIdnumber, lendbooks, phone, credit, lendDate, returnDate);
                    break;

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.Close(res, pstmt, con);
        }
        return user;
    }

    /**
     * 查看数据库中借书人的借书信息
     *
     * @param username
     */
    @Override
    public LinkedList<Object> checkLendBook(String username) {
        Connection con = null;
        Statement stmt = null;
        ResultSet res = null;
        User user = null;
        try {
            con = JDBCUtils.GetConnection();
            stmt = con.createStatement();
            String sql = "select * from lendsystem";
            res = stmt.executeQuery(sql);
            while (res.next()) {
                String name = res.getString("name");
                String username1 = res.getString("username");
                String password = res.getString("password");
                String stuidNumber = res.getString("stuidNumber");
                String lendbooks = res.getString("lendbooks");
                String phone = res.getString("phone");
                int credit = res.getInt("credit");
                Date lendDate = res.getDate("lendDate");
                Date returnDate = res.getDate("returnDate");
                user = new User(name, username1, password, stuidNumber, lendbooks, phone, credit, lendDate, returnDate);
                list.add(user);
            }
            return list;
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
        return list;
    }

    /**
     *
     */

    @Override
    public bookContent getContent(String bookName) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet res = null;
        bookContent book = null;
        try {
            con = JDBCUtils.GetConnection();
            String sql = "select content from lendsystem Where username = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, bookName);
            res = pstmt.executeQuery();
            while (res.next()) {
                String username = res.getString("bookName");
                if (username.equals(bookName)) {
                    String BookName = res.getString("bookname");
                    String content = res.getString("content");
                    book = new bookContent(BookName,content);
                    break;

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.Close(res, pstmt, con);
        }
        return book;
    }

    @Override
    public String returnBook(String bookName) {
        Connection con = JDBCUtils.GetConnection();
        String sql = "";
        //con.prepareStatement()
        return null;
    }
}
