package cn.nylg.service;

import cn.nylg.Dao.Impl.UserDaoImpl;
import cn.nylg.Dao.UserDao;
import cn.nylg.model.User;
import cn.nylg.model.bookContent;

import java.util.LinkedList;

public interface UserService {
    public UserDao lendsystem = new UserDaoImpl();
    /**
     * 用户登录
     */
    public String Login(String username, String password);
    /**
     * 传入一个用户名和密码
     * @param username  返回一个String类型的字符串
     * @return
     */
    public Object[][] check(String username);
    /**
     * 个人借阅书籍查询
     * @return 返回一个二维数组，数组中存放着书名，借书日期，还书日期
     */
    public LinkedList<String> checkLendBook(String username);
    /**
     *
     * @param bookName
     * @return
     */
    public bookContent getContent(String bookName);
    /**
     *
     * @param bookName
     * @return
     */
    public String returnBook(String bookName);
}
