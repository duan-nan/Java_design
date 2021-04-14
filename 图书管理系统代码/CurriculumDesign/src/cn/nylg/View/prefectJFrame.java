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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class prefectJFrame extends BaseJFrame {
    private JPanel mainPanel = new JPanel();
    private JLabel titleLabel = new JLabel("个人信息完善");
    private JLabel nameLabel = new JLabel("姓名：");
    private JLabel phoneLabel = new JLabel("电话：");
    private JTextField nameField = new JTextField();
    private JTextField phoneField = new JTextField();
    private JButton OKButton = new JButton("确定");

    /**
     * 无参构造方法
     */
    public prefectJFrame() {
        this.init();
    }

    /**
     * 有参构造方法
     *
     * @param Title
     */
    public prefectJFrame(String Title) {
        super(Title);
        this.init();
    }

    /**
     * 对组建进行添加
     */
    @Override
    protected void AddElement() {
        mainPanel.add(OKButton);
        mainPanel.add(phoneLabel);
        mainPanel.add(phoneField);
        mainPanel.add(nameLabel);
        mainPanel.add(nameField);
        mainPanel.add(titleLabel);
        this.add(mainPanel);
    }

    /**
     * 设置字体以及组建的设置
     */
    @Override
    protected void AddFontAndSoOn() {
        mainPanel.setLayout(null);//自定义布局
        mainPanel = new MyPanel(new ImageIcon("src\\cn\\nylg\\Main\\finish.jpeg").getImage());
        mainPanel.setLayout(null);//自定义布局
        Font font = new Font("楷体", Font.BOLD, 20);//设置字体
        titleLabel.setBounds(100, 20, 300, 40);//设置大小
        titleLabel.setOpaque(false);//不遮挡背景图片
        titleLabel.setFont(new Font("楷体", Font.BOLD, 40));//设置字体
        nameLabel.setBounds(80, 90, 80, 30);//设置大小
        nameLabel.setFont(font);//设置字体
        nameLabel.setOpaque(false);//不遮挡背景图片
        phoneLabel.setBounds(80, 150, 80, 30);//设置大小
        phoneLabel.setFont(font);//设置字体
        phoneLabel.setOpaque(false);//不遮挡背景图片
        nameField.setBounds(150, 90, 200, 30);//设置大小
        nameField.setToolTipText("姓名");//设置提示语句
        nameField.setOpaque(false);//不遮挡背景图片
        phoneField.setBounds(150, 150, 200, 30);//设置大小
        phoneField.setToolTipText("电话");//设置提示语句
        phoneField.setOpaque(false);//不遮挡背景图片
        OKButton.setBounds(200, 200, 80, 30);//设置大小
        OKButton.setForeground(Color.GRAY);//设置文字颜色
        OKButton.setHorizontalTextPosition(JButton.CENTER);//文字居中
        OKButton.setToolTipText("确定");//设置提示语句
    }

    /**
     * 对组件进行监听
     */
    @Override
    protected void AddListener() {
        ActionListener oklListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String name = nameField.getText();//获取nameField文本框内容
                String phone = phoneField.getText();//获取phoneField文本框内容
                if ((!"".equals(nameField)) && (!"".equals(phoneField))) {
                    HashMap<String, User> userBox = UserServiceImpl.userBox;//调用UserServiceImpl内的HashMap集合
                    Set<Map.Entry<String, User>> set = userBox.entrySet();
                    Iterator<Map.Entry<String, User>> it = set.iterator();
                    while (it.hasNext()) {//便利集合
                        Map.Entry<String, User> entry = it.next();
                        User user = entry.getValue();//获取Value值
                        String username = user.getUsername();
                        UserDao userDao = new UserDaoImpl();
                        userDao.finishInformation(username, name, phone);//弹窗显示信息
                        JOptionPane.showMessageDialog(prefectJFrame.this, "信息更新成功！请重新登录");
                        prefectJFrame.this.setVisible(false);//设置当前窗口为不可见
                        prefectJFrame.this.dispose();//销毁当前窗口
                        new LoginJFrame("登录");
                    }
                }
            }
        };
        OKButton.addActionListener(oklListener);
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
        new prefectJFrame("信息完善");
    }
}
