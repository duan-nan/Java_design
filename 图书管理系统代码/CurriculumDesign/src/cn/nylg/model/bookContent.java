package cn.nylg.model;

public class bookContent {
    private String bookName;
    private String content;

    public bookContent() {
    }

    public bookContent(String bookName, String content) {
        this.bookName = bookName;
        this.content = content;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "bookContent{" +
                "bookName='" + bookName + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
