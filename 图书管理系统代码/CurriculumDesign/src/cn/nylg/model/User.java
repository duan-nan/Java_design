package cn.nylg.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private static final long serialVersionUID = 6418156077118748084L;//标识
    private String name;//姓名
    private String username;//用户名
    private String password;//密码
    private String stuIdNumber;//学号
    private String lendBooks;//借走的书
    private String phone; //电话
    private int Credit;//信誉
    private Date lendDate;//借书时间
    private Date returnDate;//还书时间

    public User() {
    }

    public User(String name, String username, String password, String stuIdNumber, String lendBooks, String phone, int credit, Date lendDate, Date returnDate) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.stuIdNumber = stuIdNumber;
        this.lendBooks = lendBooks;
        this.phone = phone;
        Credit = credit;
        this.lendDate = lendDate;
        this.returnDate = returnDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStuIdNumber() {
        return stuIdNumber;
    }

    public void setStuIdNumber(String stuIdNumber) {
        this.stuIdNumber = stuIdNumber;
    }

    public String getLendBooks() {
        return lendBooks;
    }

    public void setLendBooks(String lendBooks) {
        this.lendBooks = lendBooks;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCredit() {
        return Credit;
    }

    public void setCredit(int credit) {
        Credit = credit;
    }

    public Date getLendDate() {
        return lendDate;
    }

    public void setLendDate(Date lendDate) {
        this.lendDate = lendDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", stuIdNumber='" + stuIdNumber + '\'' +
                ", lendBooks='" + lendBooks + '\'' +
                ", phone='" + phone + '\'' +
                ", Credit=" + Credit +
                ", lendDate=" + lendDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
