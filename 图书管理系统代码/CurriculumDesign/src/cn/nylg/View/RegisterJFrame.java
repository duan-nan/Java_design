package cn.nylg.View;

import cn.nylg.Dao.Impl.UserDaoImpl;
import cn.nylg.Dao.UserDao;
import cn.nylg.Utils.BaseJFrame;
import cn.nylg.Utils.MyPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class RegisterJFrame extends BaseJFrame {
    private JPanel jPanel = new JPanel();
    private JLabel StuIdLabel = new JLabel("学号：");
    private JLabel UsernameLabel = new JLabel("用户名：");
    private JLabel PasswordLabel = new JLabel("密码：");
    private JLabel RePasswordLabel = new JLabel("确认密码：");
    private JTextField StuIdField = new JTextField();
    private JTextField UsernameField = new JTextField();
    private JPasswordField PasswordField = new JPasswordField();
    private JPasswordField RePasswordField = new JPasswordField();
    private JButton OKButton = new JButton("确认");
    private JTextArea LookTextField = new JTextArea();

    /**
     * 无参构造方法
     */
    public RegisterJFrame() {
        this.init();
    }

    /**
     * 有参构造方法
     *
     * @param Title
     */
    public RegisterJFrame(String Title) {
        super(Title);
        this.init();
    }

    /**
     * 对组建进行添加
     */
    @Override
    protected void AddElement() {
        jPanel.add(LookTextField);
        jPanel.add(OKButton);
        jPanel.add(UsernameField);
        jPanel.add(RePasswordField);
        jPanel.add(PasswordField);
        jPanel.add(StuIdField);
        jPanel.add(RePasswordLabel);
        jPanel.add(PasswordLabel);
        jPanel.add(UsernameLabel);
        jPanel.add(StuIdLabel);
        this.add(jPanel);
    }

    /**
     * 设置字体以及组建的设置
     */
    @Override
    protected void AddFontAndSoOn() {
        jPanel.setLayout(null);//取消面板布局
        jPanel = new MyPanel(new ImageIcon("src\\cn\\nylg\\Main\\RegisterJFrame.jpg").getImage());//给面板设置背景
        jPanel.setLayout(null);//再次取消面板布局
        //给标签设置字体和大小
        StuIdLabel.setBounds(150, 30, 80, 30);//学号位置的设置
        StuIdLabel.setFont(new Font("楷体", Font.BOLD, 20));//学号样式和大小的设置
        UsernameLabel.setBounds(130, 80, 100, 30);//用户名位置的设置
        UsernameLabel.setFont(new Font("楷体", Font.BOLD, 20));//用户名样式和大小的设置
        PasswordLabel.setBounds(150, 130, 80, 20);//密码位置的设置
        PasswordLabel.setFont(new Font("楷体", Font.BOLD, 20));//密码样式和大小的设置
        RePasswordLabel.setBounds(110, 180, 110, 20);//密码位置的设置
        RePasswordLabel.setFont(new Font("楷体", Font.BOLD, 20));//密码样式和大小的设置
        //给文本框设置大小和字体
        StuIdField.setBounds(210, 30, 150, 30);//学号文本框位置的设置
        StuIdField.setFont(new Font("楷体", Font.BOLD, 20));//学号文本框样式和大小的设置
        StuIdField.setToolTipText("学号");
        UsernameField.setBounds(210, 80, 150, 30);//用户名文本框位置的设置
        UsernameField.setFont(new Font("楷体", Font.BOLD, 20));//用户名文本框样式和大小的设置
        UsernameField.setToolTipText("用户名");
        PasswordField.setBounds(210, 130, 150, 30);//密码文本框位置的设置
        PasswordField.setFont(new Font("宋体", Font.BOLD, 20));//密码文本框样式和大小的设置
        PasswordField.setToolTipText("密码");
        RePasswordField.setBounds(210, 180, 150, 30);//密码文本框位置的设置
        RePasswordField.setFont(new Font("宋体", Font.BOLD, 20));//密码文本框样式和大小的设置
        RePasswordField.setToolTipText("请再次输入密码");
        //设置按钮
        OKButton.setBounds(230, 220, 60, 30);
        //设置提示语句
        LookTextField.setBounds(30, 10, 30, 200);
        LookTextField.setEnabled(false);//设置文本框为不可选中
        LookTextField.setFont(new Font("楷体", Font.BOLD, 19));//设置文本框的字体和大小
        LookTextField.setText("学\n号\n只\n能\n定\n义\n一\n次\n！");//设置文本框的内容
    }

    /**
     * 对组件进行监听
     */
    @Override
    protected void AddListener() {
        KeyListener keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                char ch = keyEvent.getKeyChar();//录入键盘信息
                if (ch < '0' || ch > '9') {
                    keyEvent.consume();//停止录入键盘信息
                }
                String StuId = StuIdField.getText();//获取学号长度
                if (StuId.length() >= 9) {//限制学号的长度
                    keyEvent.consume();//停止录入键盘信息
                }
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
            }
        };
        StuIdField.addKeyListener(keyListener);
        KeyListener keyListener1 = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                char ch = keyEvent.getKeyChar();//录入键盘信息
                if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) {

                } else {
                    keyEvent.consume();//停止录入键盘信息
                }
                String usernameFieldText = UsernameField.getText();
                if (usernameFieldText.length() >= 9) {
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
        UsernameField.addKeyListener(keyListener1);
        KeyListener keyListener2 = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {//获取密码
                String ch = new String(PasswordField.getPassword());
                if (ch.length() > 16) {//判断语句
                    keyEvent.consume();//停止录入键盘信息
                }
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
            }
        };
        PasswordField.addKeyListener(keyListener2);
        KeyListener keyListener3 = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {//获取第二次输入的密码
                String ch1 = new String(RePasswordField.getPassword());
                if (ch1.length() > 16) {//判断语句
                    keyEvent.consume();//停止录入键盘信息
                }
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
            }
        };
        RePasswordField.addKeyListener(keyListener3);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String stuID = StuIdField.getText();
                String credit = "100";
                String username = UsernameField.getText();
                String password = new String(PasswordField.getPassword());//获取密码
                String rePassword = new String(RePasswordField.getPassword()); //获取第二次输入的密码
                if (password.equals(rePassword) && (!"".equals(password)) && (!"".equals(rePassword))) {//密码相同注册成功
                    UserDao userDao = new UserDaoImpl();
                    userDao.register(stuID,username,password,credit);
                    JOptionPane.showMessageDialog(RegisterJFrame.this, "恭喜你注册成功！");
                    RegisterJFrame.this.setVisible(false);//设置为不可见
                    RegisterJFrame.this.dispose();
                    new LoginJFrame("登录界面");

                } else {
                    //JDialog jDialog = new JDialog(RegisterJFrame.this, "对不起，您两次输入的密码不同！");
                    JOptionPane.showMessageDialog(RegisterJFrame.this, "对不起，您两次输入的密码不同！");
                    RePasswordField.setText("");
                }
            }
        };
        OKButton.addActionListener(listener);
    }

    /**
     * 设置Frame的大小位置以及是否可变等
     */
    @Override
    protected void AddJFrame() {
        this.setBounds(450, 200, 500, 300);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new RegisterJFrame("1");
    }
}
