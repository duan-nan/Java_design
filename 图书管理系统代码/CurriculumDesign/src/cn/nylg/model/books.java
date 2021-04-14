package cn.nylg.model;

import java.io.Serializable;

public class books implements Serializable {

    private static final long serialVersionUID = 2406233171588390076L;

    private int id;
    private String bookName;
    private String author;
    private int count;
    private int value;
    private int lendCount;

    public books() {
    }

    public books(int id, String bookName, String author, int count, int value, int lendCount) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.count = count;
        this.value = value;
        this.lendCount = lendCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getLendCount() {
        return lendCount;
    }

    public void setLendCount(int lendCount) {
        this.lendCount = lendCount;
    }

    @Override
    public String toString() {
        return "books{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", count=" + count +
                ", value=" + value +
                ", lendCount=" + lendCount +
                '}';
    }
}
