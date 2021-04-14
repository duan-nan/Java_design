package cn.nylg.View;

import cn.nylg.Dao.Impl.UserDaoImpl;
import cn.nylg.Dao.UserDao;
import cn.nylg.Utils.BaseJFrame;
import cn.nylg.Utils.MyPanel;
import cn.nylg.model.User;
import cn.nylg.service.Impl.UserServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class updateJFrame extends BaseJFrame {
    private JPanel mainPanel = new JPanel();
    private JLabel passwordLabel = new JLabel("密码:");
    private JLabel rePasswordLabel = new JLabel("确认密码:");
    private JLabel nameLabel = new JLabel("姓名:");
    private JLabel phoneLabel = new JLabel("电话:");
    private JLabel titleLabel = new JLabel("C  H  A  N  G  E  ");
    private JPasswordField passwordField = new JPasswordField();
    private JPasswordField rePasswordField = new JPasswordField();
    private JTextField nameField = new JTextField();
    private JTextField phoneField = new JTextField();
    private JButton OKButton = new JButton("确认");

    /**
     * 无参构造方法
     */
    public updateJFrame() {
        this.init();
    }

    /**
     * 有参构造方法
     * @param title 标题
     */
    public updateJFrame(String title) {
        super(title);
        this.init();
    }

    /**
     * 对组建进行添加
     */
    @Override
    protected void AddElement() {

        mainPanel.add(OKButton);
        mainPanel.add(phoneField);
        mainPanel.add(nameField);
        mainPanel.add(rePasswordField);
        mainPanel.add(passwordField);
        mainPanel.add(phoneLabel);
        mainPanel.add(nameLabel);
        mainPanel.add(rePasswordLabel);
        mainPanel.add(passwordLabel);
        mainPanel.add(titleLabel);
        this.add(mainPanel);
    }

    /**
     * 设置字体以及组建的设置
     */
    @Override
    protected void AddFontAndSoOn() {
        mainPanel.setLayout(null);
        mainPanel = new MyPanel(new ImageIcon("src\\cn\\nylg\\Main\\updateJFrame.jpg").getImage());
        mainPanel.setLayout(null);
        //给标签设置字体和大小
        Font font = new Font("楷体",Font.BOLD,20);
        titleLabel.setBounds(50,10,400,30);
        titleLabel.setForeground(Color.RED);
        titleLabel.setFont(new Font("楷体",Font.BOLD,20));
        passwordLabel.setBounds(80, 50, 80, 30);
        passwordLabel.setFont(font);
        rePasswordLabel.setBounds(40, 90, 100, 30);
        rePasswordLabel.setFont(font);
        nameLabel.setBounds(80,130,80,30);
        nameLabel.setFont(font);
        phoneLabel.setBounds(80,170,80,30);
        phoneLabel.setFont(font);
        //给文本框设置大小和字体
        passwordField.setBounds(160,50,200,30);
        passwordField.setFont(new Font("宋体",Font.BOLD,20));
        passwordField.setOpaque(false);
        rePasswordField.setBounds(160,90,200,30);
        rePasswordField.setFont(new Font("宋体",Font.BOLD,20));
        rePasswordField.setOpaque(false);
        nameField.setBounds(160,130,200,30);
        nameField.setFont(font);
        nameField.setOpaque(false);
        phoneField.setBounds(160,170,200,30);
        phoneField.setFont(font);
        phoneField.setOpaque(false);
        OKButton.setBounds(200,210,60,30);

    }

    /**
     * 对组件进行监听
     */
    @Override
    protected void AddListener() {
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String password = new String(passwordField.getPassword());
                String rePassword = new String(rePasswordField.getPassword());
                if (password.equals(rePassword) && (!"".equals(password)) && (!"".equals(rePassword))) {
                    HashMap<String, User> userBox = UserServiceImpl.userBox;
                    Set<Map.Entry<String, User>> set = userBox.entrySet();
                    Iterator<Map.Entry<String, User>> it = set.iterator();
                    while (it.hasNext()){
                        Map.Entry<String, User> entry = it.next();
                        User user = entry.getValue();
                        UserDao userDao = new UserDaoImpl();
                        String name = nameField.getText();
                        String phone = phoneField.getText();
                        String Password = new String(passwordField.getPassword());

                        userDao.changeInformation(user.getUsername(),name,password,phone);
                        updateJFrame.this.setVisible(false);
                        updateJFrame.this.dispose();
                        new UserJFrame("用户界面");
                    }

                }else {
                    JDialog message =  new JDialog(updateJFrame.this,"您两次输入的密码不同");
                    rePasswordField.setText("");
                }
            }
        };
        OKButton.addActionListener(buttonListener);
        KeyListener phoneListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                String phoneFieldText = phoneField.getText();
                if (phoneFieldText.length()>11){
                    keyEvent.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent keyEvent) {
            }
            @Override
            public void keyReleased(KeyEvent keyEvent) {
            }
        };
        phoneField.addKeyListener(phoneListener);
    }

    /**
     * 设置Frame的大小位置以及是否可变等
     */
    @Override
    protected void AddJFrame() {
        this.setBounds(450,200,500,300);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new updateJFrame("修改界面");
    }
}
