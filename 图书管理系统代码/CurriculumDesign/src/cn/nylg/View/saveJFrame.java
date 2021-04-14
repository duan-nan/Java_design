package cn.nylg.View;

import cn.nylg.Utils.BaseJFrame;
import cn.nylg.Utils.MyPanel;
import cn.nylg.model.books;
import cn.nylg.service.Impl.bookMangerImpl;
import cn.nylg.service.bookManger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class saveJFrame extends BaseJFrame {
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

    /**
     * 无参构造方法
     */
    public saveJFrame() {
        this.init();
    }

    /**
     * 有参构造方法
     *
     * @param Title
     */
    public saveJFrame(String Title) {
        super(Title);
        this.init();
    }

    /**
     * 对组建进行添加
     */
    @Override
    protected void AddElement() {
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
        mainPanel = new MyPanel(new ImageIcon("src\\cn\\nylg\\Main\\save.jfif").getImage());
        mainPanel.setLayout(null);
        Font font = new Font("楷体",Font.BOLD,20);
        nameLabel.setBounds(50,10,50,30);
        nameLabel.setFont(font);
        authorLabel.setBounds(180,10,100,30);
        authorLabel.setFont(font);
        countLabel.setBounds(300,10,100,30);
        countLabel.setFont(font);
        valueLabel.setBounds(420,10,100,30);
        valueLabel.setFont(font);
        lendCountLabel.setBounds(520,10,120,30);
        lendCountLabel.setFont(font);
        nameField.setBounds(35,60,80,30);
        nameField.setFont(font);
        authorField.setBounds(170,60,80,30);
        authorField.setFont(font);
        countField.setBounds(290,60,80,30);
        countField.setFont(font);
        valueField.setBounds(420,60,80,30);
        valueField.setFont(font);
        lendCountField.setBounds(540,60,80,30);
        lendCountField.setFont(font);

        OkButton.setBounds(280,110,100,40);
        OkButton.setFont(font);
        OkButton.setToolTipText("确定");
        OkButton.setOpaque(false);
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
                bookManger bookManger = new bookMangerImpl();
                String s = bookManger.saveBook(book);
                if ("添加成功！".equals(s)){
                    JOptionPane.showMessageDialog(saveJFrame.this,s);
                    saveJFrame.this.setVisible(false);
                    saveJFrame.this.dispose();
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
        this.setBounds(350, 350, 700, 200);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new saveJFrame("1");
    }
}
