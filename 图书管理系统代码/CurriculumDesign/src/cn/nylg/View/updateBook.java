package cn.nylg.View;

import cn.nylg.Utils.BaseJFrame;
import cn.nylg.Utils.MyPanel;
import cn.nylg.model.books;
import cn.nylg.service.Impl.bookMangerImpl;
import cn.nylg.service.bookManger;
import org.w3c.dom.css.RGBColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class updateBook extends BaseJFrame {
    private JPanel mainPanel = new JPanel();
    private JLabel nameLabel = new JLabel("name");
    private JLabel authorLabel = new JLabel("Author");
    private JLabel countLabel = new JLabel("Count");
    private JLabel valueLabel = new JLabel("Value");
    private JLabel lendCountLabel = new JLabel("lendCount");
    private JTextField nameField = new JTextField();
    private JTextField authorField = new JTextField();
    private JTextField countField = new JTextField();
    private JTextField valueField = new JTextField();
    private JTextField lendCountField = new JTextField();
    private JButton OkButton = new JButton("确定");
    private JButton returnButton = new JButton("返回上一级");
    private JLabel changeLabel1 = new JLabel("请输入id或者书名");
    private JLabel changeLabel2 = new JLabel("进行修改:");
    private JTextField changeField = new JTextField();

    /**
     * 无参构造方法
     */
    public updateBook() {
        this.init();
    }

    /**
     * 有参构造方法
     *
     * @param Title
     */
    public updateBook(String Title) {
        super(Title);
        this.init();
    }

    /**
     * 对组建进行添加
     */
    @Override
    protected void AddElement() {
        mainPanel.add(changeField);
        mainPanel.add(changeLabel1);
        mainPanel.add(changeLabel2);
        mainPanel.add(nameField);
        mainPanel.add(nameLabel);
        mainPanel.add(authorField);
        mainPanel.add(authorLabel);
        mainPanel.add(countField);
        mainPanel.add(countLabel);
        mainPanel.add(valueField);
        mainPanel.add(valueLabel);
        mainPanel.add(lendCountField);
        mainPanel.add(lendCountLabel);
        mainPanel.add(OkButton);
        this.add(mainPanel);
    }

    /**
     * 设置字体以及组建的设置
     */
    @Override
    protected void AddFontAndSoOn() {
        mainPanel = new MyPanel(new ImageIcon("src\\cn\\nylg\\Main\\update.jpg").getImage());
        mainPanel.setLayout(null);
        Font font = new Font("楷体", Font.BOLD, 20);
        nameLabel.setBounds(50, 110, 50, 30);
        nameLabel.setFont(font);
        nameLabel.setForeground(Color.red);
        authorLabel.setBounds(180, 110, 100, 30);
        authorLabel.setFont(font);
        authorLabel.setForeground(Color.red);
        countLabel.setBounds(300, 110, 100, 30);
        countLabel.setFont(font);
        countLabel.setForeground(Color.red);
        valueLabel.setBounds(420, 110, 100, 30);
        valueLabel.setFont(font);
        valueLabel.setForeground(Color.red);
        lendCountLabel.setBounds(520, 110, 120, 30);
        lendCountLabel.setFont(font);
        lendCountLabel.setForeground(Color.red);
        nameField.setBounds(35, 160, 80, 30);
        nameField.setFont(font);
        authorField.setBounds(170, 160, 80, 30);
        authorField.setFont(font);
        countField.setBounds(290, 160, 80, 30);
        countField.setFont(font);
        valueField.setBounds(420, 160, 80, 30);
        valueField.setFont(font);
        lendCountField.setBounds(540, 160, 80, 30);
        lendCountField.setFont(font);

        OkButton.setBounds(280, 210, 100, 40);
        OkButton.setFont(font);
        OkButton.setToolTipText("确定");
        OkButton.setOpaque(false);

        changeLabel1.setBounds(40,20,220,30);
        changeLabel1.setFont(font);
        changeLabel1.setForeground(Color.DARK_GRAY);
        changeLabel2.setBounds(140,50,220,30);
        changeLabel2.setFont(font);
        changeLabel2.setForeground(Color.DARK_GRAY);
        changeField.setBounds(245,30,100,40);
        //changeField.setOpaque(false);
    }

    /**
     * 对组件进行监听
     */
    @Override
    protected void AddListener() {
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String name = nameField.getText();
                String author = authorField.getText();
                String count = countField.getText();
                String value = valueField.getText();
                String lendCount = lendCountField.getText();
                books book = new books();
                book.setBookName(name);
                book.setAuthor(author);
                book.setCount(Integer.parseInt(count));
                book.setValue(Integer.parseInt(value));
                book.setLendCount(Integer.parseInt(lendCount));
                String idOrName = changeField.getText();
                bookManger bookManger = new bookMangerImpl();
                String s = bookManger.changeBook(idOrName,book);
                if ("修改成功！".equals(s)){
                    JOptionPane.showMessageDialog(updateBook.this,s);
                    updateBook.this.setVisible(false);
                    updateBook.this.dispose();
                    new mangerJFrame("管理页面");
                }

            }
        };
        OkButton.addActionListener(actionListener);
    }

    /**
     * 设置Frame的大小位置以及是否可变等
     */
    @Override
    protected void AddJFrame() {
        this.setBounds(350, 350, 700, 300);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new updateBook("1");
    }
}
