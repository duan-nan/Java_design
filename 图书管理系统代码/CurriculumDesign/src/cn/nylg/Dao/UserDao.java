package cn.nylg.Dao;

import cn.nylg.model.User;
import cn.nylg.model.bookContent;

import java.sql.SQLException;
import java.util.LinkedList;

public interface UserDao {
    /**
     * 用户进行登录的操作
     * @param account
     * @return
     */
    public User Login(String account);

    /**
     * 用户修改信息
     * @param username  修改信息的用户的用户名
     * @param name      修改后的姓名
     * @param password  修改后的密码
     * @param phone     修改后的电话
     * @return
     */
    public User changeInformation(String username,String name,String password,String phone);

    /**
     *用户的注册信息
     * @param stuId 学号
     * @param userName 用户名
     * @param password  密码
     * @param credit 信誉
     * @return 返回一个user对象
     */
    public User register(String stuId,String userName,String password,String credit);
    /**
     *
     * @param username
     * @param name
     * @param phone
     * @return
     */
    public User finishInformation(String username,String name,String phone);
    /**
     *
     * @param username
     * @param lendBooks
     * @return
     */
    public User updateLendBooks(String username,String lendBooks);
    /**
     *
     * @param username
     * @return
     */
    public User checkPerson(String username);
    /**
     * 查看数据库中借书人的借书信息
     * @param username
     */
    public LinkedList<Object> checkLendBook(String username);
    /**
     *
     * @param bookName
     */
    public bookContent getContent(String bookName);
    /**
     *
     * @param bookName
     * @return
     */
    public String returnBook (String bookName);
}
