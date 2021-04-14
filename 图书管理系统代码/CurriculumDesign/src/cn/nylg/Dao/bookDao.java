package cn.nylg.Dao;

import cn.nylg.model.books;

import javax.swing.table.DefaultTableModel;
import java.util.HashMap;

public interface bookDao {
    public static HashMap<Integer,books> map = new HashMap<Integer, books>();
    /**
     *查询数据
     * @return
     */
    public books checkBooks();

    /**
     * 借书
     * @param idOrBookName 书籍的编号或者书名
     * @return
     */
    public String lendBook(String idOrBookName);

    public books updateBookInfo(String name,int count,int lenCount);

    /**
     * 添加书籍
     * @param book 对象
     * @return
     */
    public String saveBook(books book);

    /**
     * 删除书籍
     * @param idOrName 书籍的编号或者书名
     * @return
     */
    public String deleteBook(String idOrName);

    /**
     * 修改书籍信息
     * @param idOrName 书籍的编号或者书名
     * @param book 对象
     * @return
     */
    public String changeBook(String idOrName,books book);
}
