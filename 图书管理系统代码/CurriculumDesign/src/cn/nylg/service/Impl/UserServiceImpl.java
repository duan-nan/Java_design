package cn.nylg.service.Impl;

import cn.nylg.Dao.Impl.UserDaoImpl;
import cn.nylg.Dao.UserDao;
import cn.nylg.model.User;
import cn.nylg.model.bookContent;
import cn.nylg.service.UserService;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 业务层，处理读出来的数据
 */
public class UserServiceImpl implements UserService {
    public static HashMap<String, User> userBox = new HashMap<String, User>();
    private UserDao lendSystem = new UserDaoImpl();

    /**
     * 用户登录
     */
    @Override
    public String Login(String username, String password) {
        User user = lendSystem.Login(username);

        if ("guanliyuan".equals(user.getUsername()) && user.getPassword().equals(password)) {
            userBox.put(username, user);
            return "管理员登录！";
        } else if (user.getUsername() != null && user.getPassword().equals(password)) {
            userBox.put(username, user);
            return "登陆成功！";
        }
        return "用户名或密码错误！";
    }

    @Override
    public Object[][] check(String username) {

        User user = lendSystem.checkPerson(username);
        String lendBooks = user.getLendBooks();
        Date lendDate = user.getLendDate();
        Date returnDate = user.getReturnDate();
        String[] split = lendBooks.split(",");
        Object[][] result = new Object[split.length][split.length];
        for (int i = 0; i < split.length; i++) {
            result[i][0] = split[0];
            result[i][1] = lendDate;
            result[i][2] = returnDate;
        }
        return result;
    }

    /**
     * 个人借阅书籍查询
     *
     * @return 返回一个二维数组，数组中存放着书名，借书日期，还书日期
     */
    @Override
    public LinkedList<String> checkLendBook(String username) {
        UserDao userDao = new UserDaoImpl();
        LinkedList<Object> list = userDao.checkLendBook(username);
        User user = (User) list.get(1);
        String name = user.getName();
        String BooksName = user.getLendBooks();
        Date lendDate = user.getLendDate();
        Date returnDate = user.getReturnDate();
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add(name);
        linkedList.add(BooksName);
        linkedList.add(String.valueOf(lendDate));
        linkedList.add(String.valueOf(returnDate));
        return linkedList;
    }

    /**
     *
     * @param bookName
     * @return
     */
    @Override
    public bookContent getContent(String bookName) {
        UserDao userDao = new UserDaoImpl();
        bookContent content = userDao.getContent(bookName);
        return content;
    }

    /**
     * @param bookName
     * @return
     */
    @Override
    public String returnBook(String bookName) {
        UserDao userDao = new UserDaoImpl();
        String s = userDao.returnBook(bookName);
        return s;
    }

}
