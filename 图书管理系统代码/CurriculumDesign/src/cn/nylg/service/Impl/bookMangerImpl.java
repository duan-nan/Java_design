package cn.nylg.service.Impl;


import cn.nylg.Dao.Impl.UserDaoImpl;
import cn.nylg.Dao.Impl.bookDaoImpl;
import cn.nylg.Dao.UserDao;
import cn.nylg.Dao.bookDao;
import cn.nylg.Utils.JDBCUtils;
import cn.nylg.model.User;
import cn.nylg.model.books;
import cn.nylg.service.bookManger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class bookMangerImpl implements bookManger {
    private cn.nylg.Dao.bookDao bookDao = new bookDaoImpl();

    /**
     * @return
     */
    @Override//将数据保存在二维数组中
    public Object[][] check() {
        bookDao.checkBooks();
        LinkedList<Object> list = bookDaoImpl.list;
        int size = bookDaoImpl.list.size();
        Object[][] datas = new Object[size][size];
        for (int i = 0; i < size; i++) {
            books book = (books) list.get(i);
            datas[i][0] = book.getId();
            datas[i][1] = book.getBookName();
            datas[i][2] = book.getAuthor();
            datas[i][3] = book.getCount();
            datas[i][4] = book.getValue();
            datas[i][5] = book.getLendCount();
        }
        return datas;
    }

    /**
     * 借书
     *
     * @param idOrBookName 编号或者书名
     * @return 返回字符串
     */
    @Override
    public String lendBook(String idOrBookName) {
        bookDao bookDao = new bookDaoImpl();
        String s = bookDao.lendBook(idOrBookName);
        String a = null;
        HashMap<String, User> userBox = UserServiceImpl.userBox;
        Set<Map.Entry<String, User>> entries = userBox.entrySet();
        Iterator<Map.Entry<String, User>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, User> entry = iterator.next();
            User value = entry.getValue();
            int credit = value.getCredit();
            if (credit > 60) {
                LinkedList<Object> list = bookDaoImpl.list;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    books book = (books) list.get(i);
                    int id = book.getId();
                    String ID = "";
                    ID = Integer.toString(id);
                    if (idOrBookName.equals(ID) || idOrBookName.equals(book.getBookName())) {
                        int count = book.getCount();
                        int lendCount = book.getLendCount();
                        if (count == 0) {
                            a = "对不起，该书已经暂时没有库存。\n请您选择其他书籍。";
                        } else {
                            if ("该书存在！".equals(s)) {
                                a = "恭喜您借阅成功！";
                                book.setCount(count--);
                                book.setLendCount(lendCount++);
                                // value.setLendBooks(value.getLendBooks()+","+book.getBookName());
                                String lendBooks = value.getLendBooks() + "," + book.getBookName();
                                UserDao userDao = new UserDaoImpl();
                                userDao.updateLendBooks(value.getUsername(), lendBooks);
                                bookDao.updateBookInfo(book.getBookName(), count--, lendCount++);
                            } else if ("对不起未发现您要借阅的书籍！".equals(s)) {
                                a = "对不起未发现您要借阅的书籍！";
                            }
                        }
                    }
                }

            } else {
                a = "对不起，您的信誉较低。\n请拨打客服电话86-1234567来寻求解决方案";
            }
        }
        return a;
    }

    /**
     * 管理员添加图书
     *
     * @param book 对象
     * @return
     */
    @Override
    public String saveBook(books book) {
        String s = bookDao.saveBook(book);
        return s;
    }

    /**
     * 管理员删除书籍
     *
     * @param idOrName
     * @return
     */
    @Override
    public String deleteBook(String idOrName) {
        String s = bookDao.deleteBook(idOrName);
        return s;
    }

    /**
     * 管理员修改书籍信息
     *
     * @param idOrName 书籍的编号或者书名
     * @return
     */
    @Override
    public String changeBook(String idOrName,books book) {
        String s = bookDao.changeBook(idOrName, book);
        return s;
    }

}