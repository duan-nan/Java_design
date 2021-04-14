package cn.nylg.service;

import cn.nylg.Dao.Impl.bookDaoImpl;
import cn.nylg.Dao.bookDao;
import cn.nylg.model.books;

import javax.swing.table.DefaultTableModel;

public interface bookManger {
    public bookDao book = new bookDaoImpl();
    /**
     * 查看图书信息
     */
    public Object[][] check();
    /**
     * 借书
     * @param idOrBookName 书籍的编号或者书名
     * @return
     */
    public String lendBook(String idOrBookName);
    /**
     * 管理员添加图书
     * @param book 对象
     * @return
     */
    public String saveBook(books book);
    /**
     * 管理员删除书籍
     * @param idOrName 书籍的编号或者书名
     * @return
     */
    public String deleteBook(String idOrName);
    /**
     * 管理员修改书籍信息
     * @param idOrName 书籍的编号或者书名
     * @return
     */
    public String changeBook(String idOrName,books book);
}
