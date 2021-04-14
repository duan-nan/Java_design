package cn.nylg.View;

import cn.nylg.Utils.BaseJFrame;
import cn.nylg.Utils.MyPanel;
import cn.nylg.model.User;
import cn.nylg.service.Impl.UserServiceImpl;
import cn.nylg.service.Impl.bookMangerImpl;
import cn.nylg.service.bookManger;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class mangerJFrame extends BaseJFrame {
    private JPanel mainPanel = new JPanel();
    private JPanel bigPanel = new JPanel();
    private JPanel smallPanel = new JPanel();
    private JLabel titleLabel = new JLabel("管理员信息");
    private JLabel Label = new JLabel("————————————");
    private JLabel nameLabel = new JLabel("姓名:");
    private JLabel usernameLabel = new JLabel("用户名:");
    private JLabel phoneLabel = new JLabel("电话:");
    private JLabel TiTle = new JLabel("图  书  列  表");
    private JTextField nameField = new JTextField();
    private JTextField usernameField = new JTextField();
    private JTextField phoneField = new JTextField();
    private JTable Table = null;
    private DefaultTableModel model = null;
    private JScrollPane pane = null;
    private JLabel deleteLabel = new JLabel("请输入id或者书名进行删除:");
    private JTextField deleteField = new JTextField();
    private JButton deleteButton = new JButton("删除图书");
    private JButton saveButton = new JButton("添加图书");
    private JButton changeButton = new JButton("修改图书");
    private JButton checkButton = new JButton("查看图书");
    private JLabel changeLabel1 = new JLabel("请在修改页面输入");
    private JLabel changeLabel2 = new JLabel("id或者书名进行修改！");
    private  bookManger bookManger = new bookMangerImpl();
    /**
     * 无参构造方法
     */
    public mangerJFrame() {
        this.init();
    }

    /**
     * 有参构造方法
     *
     * @param Title
     */
    public mangerJFrame(String Title) {
        super(Title);
        this.init();
    }

    /**
     * 对组建进行添加
     */
    @Override
    protected void AddElement() {
        bigPanel.add(checkButton);
        bigPanel.add(deleteField);
        bigPanel.add(saveButton);
        bigPanel.add(deleteLabel);
        bigPanel.add(deleteButton);
        bigPanel.add(TiTle);
        bigPanel.add(pane);
        smallPanel.add(changeLabel1);
        smallPanel.add(changeLabel2);
        smallPanel.add(changeButton);
        smallPanel.add(phoneField);
        smallPanel.add(usernameField);
        smallPanel.add(nameField);
        smallPanel.add(nameLabel);
        smallPanel.add(phoneLabel);
        smallPanel.add(usernameLabel);
        smallPanel.add(Label);
        smallPanel.add(titleLabel);
        mainPanel.add(smallPanel);
        mainPanel.add(bigPanel);
        this.add(mainPanel);
    }

    /**
     * 设置字体以及组建的设置
     */
    @Override
    protected void AddFontAndSoOn() {
        mainPanel = new MyPanel(new ImageIcon("src\\cn\\nylg\\Main\\manager.jpg").getImage());
        mainPanel.setLayout(null);
        bigPanel.setBounds(10, 10, 790, 545);
        bigPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        bigPanel.setOpaque(false);
        smallPanel.setBounds(810, 10, 165, 545);
        smallPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        smallPanel.setLayout(null);
        smallPanel.setOpaque(false);
        Font font = new Font("楷体", Font.BOLD, 20);
        titleLabel.setBounds(15, 30, 150, 30);
        titleLabel.setFont(new Font("楷体", Font.BOLD, 25));
        Label.setBounds(0, 80, 230, 10);
        Label.setFont(font);
        TiTle.setBounds(300, 10, 700, 30);
        TiTle.setFont(new Font("楷体", Font.BOLD, 35));
        nameLabel.setBounds(50, 130, 60, 30);
        nameLabel.setFont(font);
        nameField.setBounds(20, 170, 130, 30);
        nameField.setFont(font);
        nameField.setHorizontalAlignment(JTextField.CENTER);
        nameField.setToolTipText("姓名");
        nameField.setEnabled(false);
        usernameLabel.setBounds(40, 220, 160, 30);
        usernameLabel.setFont(font);
        usernameField.setBounds(20, 260, 130, 30);
        usernameField.setFont(font);
        usernameField.setHorizontalAlignment(JTextField.CENTER);
        usernameField.setToolTipText("用户名");
        usernameField.setEnabled(false);
        phoneLabel.setBounds(50, 300, 60, 30);
        phoneLabel.setFont(font);
        phoneField.setBounds(20, 340, 130, 30);
        phoneField.setFont(font);
        phoneField.setHorizontalAlignment(JTextField.CENTER);
        phoneField.setToolTipText("电话");
        phoneField.setEnabled(false);


        HashMap<String, User> userBox = UserServiceImpl.userBox;
        Set<Map.Entry<String, User>> set = userBox.entrySet();
        Iterator<Map.Entry<String, User>> it = set.iterator();
        while (it.hasNext()) {
            Map.Entry<String, User> entry = it.next();
            User user = entry.getValue();
            nameField.setText(user.getName());
            phoneField.setText(user.getPhone());
            usernameField.setText(user.getUsername());
        }

        bigPanel.setLayout(null);
        String[] title = {"id", "bookName", "Author", "Count", "Value", "lendCount"};
        bookManger books = new bookMangerImpl();
        Object[][] check = books.check();
        model = new DefaultTableModel(check, title);
        Table = new JTable(model);
        //Table.setBounds(0, 0, 700, 500);
        Table.getTableHeader().getColumnModel().getColumn(0).setPreferredWidth(10);
        Table.getTableHeader().getColumnModel().getColumn(3).setPreferredWidth(10);
        Table.getTableHeader().getColumnModel().getColumn(4).setPreferredWidth(10);
        Table.getTableHeader().getColumnModel().getColumn(5).setPreferredWidth(10);
        //Table.setEnabled(false);
        Table.setRowHeight(40);
        Table.getTableHeader().setFont(new Font("宋体", Font.BOLD, 15));
        pane = new JScrollPane(Table);
        pane.setBounds(0, 0, 780, 400);
        Table.setFont(new Font("宋体", Font.BOLD, 15));
        Table.getTableHeader().setReorderingAllowed(false);
        pane.setBounds(0, 50, 790, 400);

        deleteLabel.setBounds(10, 450, 200, 30);
        deleteLabel.setFont(new Font("楷书", Font.BOLD, 15));
        deleteField.setBounds(40, 490, 100, 40);
        deleteField.setOpaque(false);
        deleteButton.setBounds(220, 475, 120, 40);
        deleteButton.setToolTipText("删除图书");
        deleteButton.setFont(font);

        saveButton.setBounds(420, 475, 120, 40);
        saveButton.setToolTipText("添加图书");
        saveButton.setFont(new Font("楷书", Font.BOLD, 20));

        checkButton.setBounds(620, 475, 120, 40);
        checkButton.setToolTipText("查看图书");
        checkButton.setFont(new Font("楷书", Font.BOLD, 20));

        changeButton.setBounds(20, 480, 120, 40);
        changeButton.setToolTipText("修改图书信息");
        changeButton.setFont(new Font("楷书", Font.BOLD, 20));

        changeLabel1.setBounds(10,400,130,30);
        changeLabel1.setFont(new Font("楷书",Font.BOLD,15));
        changeLabel2.setBounds(10,430,150,30);
        changeLabel2.setFont(new Font("楷书",Font.BOLD,15));

    }

    /**
     * 对组件进行监听
     */
    @Override
    protected void AddListener() {
        ActionListener saveListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mangerJFrame.this.setVisible(false);
                mangerJFrame.this.dispose();
                new saveJFrame("添加图书");
            }
        };
        saveButton.addActionListener(saveListener);
        ActionListener checkListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mangerJFrame.this.setVisible(false);
                mangerJFrame.this.dispose();
                new mangerJFrame("管理界面");
            }
        };
        checkButton.addActionListener(checkListener);
        ActionListener deleteListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String idOrName = deleteField.getText();
                String s = bookManger.deleteBook(idOrName);
                if ("删除成功！".equals(s)){
                    JOptionPane.showMessageDialog(mangerJFrame.this,s);
                    mangerJFrame.this.setVisible(false);
                    mangerJFrame.this.dispose();
                    new mangerJFrame("管理页面");
                }
            }
        };
        deleteButton.addActionListener(deleteListener);
        ActionListener changeListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mangerJFrame.this.setVisible(false);
                mangerJFrame.this.dispose();
                new updateBook("修改界面");
            }
        };
        changeButton.addActionListener(changeListener);
    }

    /**
     * 设置Frame的大小位置以及是否可变等
     */
    @Override
    protected void AddJFrame() {
        this.setBounds(300, 100, 1000, 600);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new mangerJFrame("1");
    }
}
