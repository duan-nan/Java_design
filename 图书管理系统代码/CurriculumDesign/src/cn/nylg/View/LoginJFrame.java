package cn.nylg.View;

import cn.nylg.Utils.BaseJFrame;
import cn.nylg.Utils.MyPanel;
import cn.nylg.service.Impl.UserServiceImpl;
import cn.nylg.service.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LoginJFrame extends BaseJFrame {
    private JPanel jPane = new JPanel();
    private JLabel UsernameLabel = new JLabel("用户名：");
    private JLabel PasswordLabel = new JLabel("密码：");
    private JLabel UpWordFiled = new JLabel("图  书  借  阅  系  统");
    private JTextField UsernameFiled = new JTextField();
    private JPasswordField PasswordField = new JPasswordField();
    private JButton LoginButton = new JButton("登录");
    private JButton RegButton = new JButton("注册");

    /**
     * 无参构造方法
     * init为父类的方法
     */
    public LoginJFrame() {
        this.init();//调用父类成员方法
    }

    /**
     * 有参构造方法
     * Title将主函数中输入 标题 的传递给父类
     * 从而完成对窗口的命名
     *
     * @param Title
     */
    public LoginJFrame(String Title) {
        super(Title);//父类为BaseJFrame
        this.init();//调用父类成员方法
    }

    /**
     * 对组建进行添加
     */
    @Override
    protected void AddElement() {
        // 调用父类方法初始化的时候并没有JPane
        jPane.add(RegButton);
        jPane.add(LoginButton);
        jPane.add(PasswordField);
        jPane.add(UsernameFiled);
        jPane.add(PasswordLabel);
        jPane.add(UsernameLabel);
        jPane.add(UpWordFiled);
        this.add(jPane);
    }

    /**
     * 设置字体以及组建的设置
     */
    @Override
    protected void AddFontAndSoOn() {
        jPane.setLayout(null);//将面板设置为自定义布局
        jPane.setBackground(Color.WHITE);
        //为JPanel设置背景
        jPane = new MyPanel(new ImageIcon("src\\cn\\nylg\\Main\\LoginJFrame.jpeg").getImage());
        jPane.setLayout(null);//将面板设置为自定义布局
        //设置字体以及大小
        UpWordFiled.setFont(new Font("楷体", Font.BOLD, 30));
        UpWordFiled.setBounds(70, 30, 350, 50);//设置标签的位置
        //设置学号密码字体
        UsernameLabel.setBounds(110, 100, 90, 30);
        UsernameLabel.setFont(new Font("楷体", Font.BOLD, 20));
        PasswordLabel.setBounds(120, 150, 80, 30);
        PasswordLabel.setFont(new Font("楷体", Font.BOLD, 20));
        //设置文本行，大小,
        UsernameFiled.setBounds(200, 100, 150, 30);
        UsernameFiled.setFont(new Font("楷体", Font.BOLD, 20));
        UsernameFiled.setOpaque(false);//设置username文本框为透明，为了不遮挡背景图片
        UsernameFiled.setBorder(BorderFactory.createLineBorder(Color.WHITE));//对文本框的边框可进行设置
        PasswordField.setBounds(200, 150, 150, 30);
        PasswordField.setFont(new Font("宋体", Font.BOLD, 20));
        PasswordField.setOpaque(false);//设置password文本框为透明，为了不遮挡背景图片
        PasswordField.setBorder(BorderFactory.createLineBorder(Color.WHITE));//对文本框的边框可进行设置
        //对按钮进行设置
        LoginButton.setBounds(130, 200, 80, 30);
        //LoginButton.setContentAreaFilled(false);登录按钮设置为透明
        LoginButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        RegButton.setBounds(330, 200, 80, 30);
        //RegButton.setContentAreaFilled(false);注册按钮设置为透明
        RegButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        //设置左上角图标
        this.setIconImage(new ImageIcon("src\\cn\\nylg\\LoginJFrame.jpeg").getImage());
    }

    /**
     * 对组件进行监听
     */
    //对LoginButton进行监视
    @Override
    protected void AddListener() {
        KeyListener keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                char ch = keyEvent.getKeyChar();
                if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) {

                } else {
                    keyEvent.consume();
                }
                String username = UsernameFiled.getText();
                if (username.length() > 16) {
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
        UsernameFiled.addKeyListener(keyListener);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //调用UserService对象
                UserService user = new UserServiceImpl();
                //得到Username文本框中的内容
                String username = UsernameFiled.getText();
                //得到password文本框中的内容，但得到是数组
                char[] password = PasswordField.getPassword();
                //将数组转换为字符串用于equals的比较
                String Password = new String(password);
                //调用Login方法
                String s = user.Login(username, Password);
                if ("管理员登录！".equals(s)) {
                    System.out.println(s);
                    LoginJFrame.this.setVisible(false);
                    LoginJFrame.this.dispose();
                    new mangerJFrame("管理界面");
                } else if ("登陆成功！".equals(s)) {
                    System.out.println(s);
                    LoginJFrame.this.setVisible(false);
                    LoginJFrame.this.dispose();
                    new UserJFrame("用户界面");
                } else {
                    //弹出对话框，提示登录失败
                    JOptionPane.showMessageDialog(LoginJFrame.this, s);
                    //清空password文本框的内容
                    PasswordField.setText("");
                }
            }
        };//对登录按钮进行监听
        LoginButton.addActionListener(listener);
        //对注册按钮进行监听
        ActionListener listener1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                LoginJFrame.this.setVisible(false);//设置为不可见
                LoginJFrame.this.dispose();//销毁资源
                new RegisterJFrame("注册");

            }
        };//对注册按钮进行监听
        RegButton.addActionListener(listener1);
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
        new LoginJFrame("1");
    }
}
