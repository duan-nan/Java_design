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
import java.util.*;


public class UserJFrame extends BaseJFrame {
    private JPanel BigPanel = new JPanel();
    private JPanel MainPanel = new JPanel();
    private JPanel SmallPanel = new JPanel();
    private JPanel rowPanel = new JPanel();
    //给SmallPanel定义标签
    private JLabel TitleLabel = new JLabel("用 户 信 息");
    private JLabel Label = new JLabel("----------------");
    private JLabel UsernameLabel = new JLabel("用户名：");
    private JLabel Name = new JLabel("姓名：");
    private JLabel Phone = new JLabel("电话：");
    private JLabel StuIdLabel = new JLabel("学号：");
    private JLabel CreditLabel = new JLabel("信誉：");
    private JLabel Label1 = new JLabel("未来属于那些坚信");
    private JLabel Label2 = new JLabel("    自己梦想之美的家伙");
    //给SmallPanel定义文本框
    private JTextField UsernameField = new JTextField();
    private JTextField NameField = new JTextField();
    private JTextField PhoneField = new JTextField();
    private JTextField StuIdField = new JTextField();
    private JTextField CreditField = new JTextField();
    //给BigPanel定义按钮栏
    private JButton LendButton = new JButton("资料大厅");
    private JButton RecordButton = new JButton("个人书库");
    private JButton ChangeButton = new JButton("修改密码");
    private JButton ExitButton = new JButton("退出系统");
    private JButton finishButton = new JButton("个人信息完善");

    DefaultTableModel model = null;
    JTable Table = null;
    JScrollPane pane = null;

    private JLabel chooseLabel = new JLabel("请输入Id/书名进行借阅:");
    private JTextField chooseField = new JTextField();
    private JButton chooseButton = new JButton("确定");

    /**
     * 无参构造方法
     */
    public UserJFrame() {
        this.init();
    }

    /**
     * 有参构造方法
     *
     * @param Title
     */
    public UserJFrame(String Title) {
        super(Title);
        this.init();
    }

    /**
     * 对组建进行添加
     */
    @Override
    protected void AddElement() {
        //表格面板
        rowPanel.add(chooseButton);
        rowPanel.add(chooseField);
        rowPanel.add(chooseLabel);
        rowPanel.add(pane);
        //rowPanel.add(Table);
        //大面板添加
        BigPanel.add(rowPanel);
        BigPanel.add(LendButton);
        BigPanel.add(RecordButton);
        BigPanel.add(ChangeButton);
        BigPanel.add(ExitButton);
        //小面板添加
        SmallPanel.add(finishButton);
        SmallPanel.add(Label2);
        SmallPanel.add(Label1);
        SmallPanel.add(CreditField);
        SmallPanel.add(PhoneField);
        SmallPanel.add(NameField);
        SmallPanel.add(UsernameField);
        SmallPanel.add(StuIdField);
        SmallPanel.add(CreditLabel);
        SmallPanel.add(Phone);
        SmallPanel.add(Name);
        SmallPanel.add(UsernameLabel);
        SmallPanel.add(StuIdLabel);
        SmallPanel.add(Label);
        SmallPanel.add(TitleLabel);
        //窗口添加面板
        this.add(BigPanel);
        this.add(SmallPanel);
        this.add(MainPanel);
    }

    /**
     * 设置字体以及组建的设置
     */
    @Override
    protected void AddFontAndSoOn() {
        //设置smallPanel
        SmallPanel.setLayout(null);//自定义布局
        SmallPanel.setBounds(810, 10, 170, 540);//设置位置
        SmallPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));//设置颜色
        SmallPanel.setOpaque(false);//不遮挡背景
        //设置BigPanel      背景
        MainPanel = new MyPanel(new ImageIcon("src\\cn\\nylg\\Main\\5.jfif").getImage());
        //设置BigPanel
        BigPanel.setLayout(null);//自定义布局
        BigPanel.setBounds(10, 10, 790, 540);//设置BigPanel 的位置
        BigPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));//设置边框颜色
        BigPanel.setOpaque(false);
        //给Small设置标签
        Font font = new Font("楷体", Font.BOLD, 20);
        TitleLabel.setBounds(20, 10, 150, 70);//用户栏大标题
        TitleLabel.setFont(font);//大标题字体大小设置
        Label.setBounds(0, 60, 200, 60);//-----分割线
        Label.setFont(font);//分割线字体大小设置
        StuIdLabel.setBounds(0, 90, 80, 60);//学号标签设置
        StuIdLabel.setFont(font);
        UsernameLabel.setBounds(0, 140, 100, 60);//用户名标签设置
        UsernameLabel.setFont(font);//用户名字体大小设置
        Name.setBounds(0, 190, 80, 60);//姓名标签设置
        Name.setFont(font);//姓名字体大小设置
        Phone.setBounds(0, 240, 80, 60);//电话标签设置
        Phone.setFont(font);//电话字体大小设置
        CreditLabel.setBounds(10, 290, 80, 60);//信誉标签设置
        CreditLabel.setFont(new Font("楷体", Font.BOLD, 19));//信誉字体大小设置
        Label1.setBounds(0, 400, 190, 30);//标签大小的设置
        Label1.setFont(new Font("楷体", Font.BOLD, 15));//字体设置
        Label1.setForeground(Color.RED);//标签内文字颜色的设置
        Label2.setBounds(0, 440, 190, 30);//标签大小的设置
        Label2.setFont(new Font("楷体", Font.BOLD, 15));//字体设置
        Label2.setForeground(Color.RED);//标签内文字颜色的设置
        //给SmallPanel设置文本框

//        User user = new User();
        Font font1 = new Font("楷体", Font.BOLD, 15);//设置字体
        StuIdField.setBounds(60, 105, 100, 25);//设置学号文本框位置大小
//        StuIdField.setText(user);//设置文本框内容
        StuIdField.setHorizontalAlignment(JTextField.CENTER);//文本框内容置于文本框中心位置
        StuIdField.setFont(font1);//设置字体
        StuIdField.setOpaque(false);//不遮挡背景
        StuIdField.setEnabled(false);//不可选中
        UsernameField.setBounds(75, 155, 90, 25);//设置用户名文本框位置大小
//        UsernameField.setText(user.getUsername());//设置文本框内容
        UsernameField.setHorizontalAlignment(JTextField.CENTER);//文本框内容置于文本框中心位置
        UsernameField.setFont(font1);//设置字体
        UsernameField.setOpaque(false);//不遮挡背景
        UsernameField.setEnabled(false);//不可选中
        NameField.setBounds(60, 200, 100, 25);//设置姓名文本框位置大小
//        NameField.setText(user.getName());//设置文本框内容
        NameField.setHorizontalAlignment(JTextField.CENTER);//文本框内容置于文本框中心位置
        NameField.setFont(font1);//设置字体
        NameField.setOpaque(false);//不遮挡背景
        NameField.setEnabled(false);//不可选中
        PhoneField.setBounds(60, 250, 100, 25);//设置电话文本框位置大小
//        PhoneField.setText(user.getPhone());//设置文本框内容
        PhoneField.setHorizontalAlignment(JTextField.CENTER);//文本框内容置于文本框中心位置
        PhoneField.setFont(font1);//设置字体
        PhoneField.setOpaque(false);//不遮挡背景
        PhoneField.setEnabled(false);//不可选中
        CreditField.setBounds(60, 305, 100, 25);//设置信誉文本框位置大小
//        CreditField.setText(user.getCredit());//设置文本框内容
        CreditField.setHorizontalAlignment(JTextField.CENTER);//文本框内容置于文本框中心位置
        CreditField.setFont(font1);//设置字体
        CreditField.setOpaque(false);//不遮挡背景
        CreditField.setEnabled(false);//不可选中
        HashMap<String, User> userBox = UserServiceImpl.userBox;
        Set<Map.Entry<String, User>> set = userBox.entrySet();
        Iterator<Map.Entry<String, User>> it = set.iterator();
        while (it.hasNext()) {
            Map.Entry<String, User> entry = it.next();
            User user = entry.getValue();
            StuIdField.setText(user.getStuIdNumber());//设置文本框内容
            UsernameField.setText(user.getUsername());//设置文本框内容
            NameField.setText(user.getName());//设置文本框内容
            PhoneField.setText(user.getPhone());//设置文本框内容
            CreditField.setText(String.valueOf(user.getCredit()));//设置文本框内容
        }
        ImageIcon icon = new ImageIcon("src\\cn\\nylg\\Main\\LendButton.jpeg");
        //        //设置按钮的大小位置
        LendButton.setBounds(0, 0, 200, 40);//设置按钮的位置和大小
        RecordButton.setBounds(200, 0, 200, 40);//设置按钮的位置和大小
        ChangeButton.setBounds(390, 0, 200, 40);//设置按钮的位置和大小
        ExitButton.setBounds(585, 0, 205, 40);//设置按钮的位置和大小
        finishButton.setBounds(10, 470, 150, 45);
        finishButton.setHorizontalTextPosition(JButton.CENTER);
        finishButton.setOpaque(false);
        finishButton.setToolTipText("个人信息完善");
        finishButton.setIcon(icon);
        finishButton.setFont(new Font("楷体", Font.BOLD, 15));
        //icon.setImage(icon.getImage().getScaledInstance(200,40,-1));
        LendButton.setHorizontalTextPosition(JButton.CENTER);//文字居中
        RecordButton.setHorizontalTextPosition(JButton.CENTER);//文字居中
        ChangeButton.setHorizontalTextPosition(JButton.CENTER);//文字居中
        ExitButton.setHorizontalTextPosition(JButton.CENTER);//文字居中
        LendButton.setIcon(icon);
        RecordButton.setIcon(icon);
        ChangeButton.setIcon(icon);
        ExitButton.setIcon(icon);
        LendButton.setToolTipText("资料大厅");//鼠标放在按钮上有提示
        RecordButton.setToolTipText("个人书库");//鼠标放在按钮上有提示
        ChangeButton.setToolTipText("修改密码");//鼠标放在按钮上有提示
        ExitButton.setToolTipText("退出系统");//鼠标放在按钮上有提示
        LendButton.setFont(font);//设置字体
        RecordButton.setFont(font);//设置字体
        ChangeButton.setFont(font);//设置字体
        ExitButton.setFont(font);//设置字体

        rowPanel.setLayout(null);
        rowPanel.setBounds(5, 50, 780, 480);
        rowPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));


        String[] title ={"id", "bookName", "Author", "Count", "Value", "lendCount"};
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
        Table.setOpaque(false);
        pane.setOpaque(false);
        rowPanel.setOpaque(false);

        chooseLabel.setBounds(20, 420, 250, 40);
        chooseLabel.setFont(new Font("宋体", Font.BOLD, 15));
        chooseField.setBounds(200, 420, 200, 40);
        chooseField.setToolTipText("请输入Id/书名");
        chooseButton.setBounds(450, 420, 130, 40);
    }

    /**
     * 对组件进行监听
     */
    @Override
    protected void AddListener() {

        ActionListener ExitListener = new ActionListener() {
            @Override//退出按钮的监听
            public void actionPerformed(ActionEvent actionEvent) {
                UserJFrame.this.setVisible(false);
                UserJFrame.this.dispose();
            }
        };
        ExitButton.addActionListener(ExitListener);

        ActionListener changeListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new updateJFrame("修改界面");
                UserJFrame.this.setVisible(false);
                UserJFrame.this.dispose();
            }
        };
        ChangeButton.addActionListener(changeListener);
        ActionListener finishListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                UserJFrame.this.setVisible(false);
                UserJFrame.this.dispose();
                new prefectJFrame("个人信息完善");

            }
        };
        finishButton.addActionListener(finishListener);
        ActionListener rowListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String text = chooseField.getText();
                bookManger bookManger = new bookMangerImpl();
                String s = bookManger.lendBook(text);
                JOptionPane.showMessageDialog(UserJFrame.this, s);
                if ("恭喜您借阅成功！".equals(s)){
                    UserJFrame.this.setVisible(false);
                    UserJFrame.this.dispose();
                    new UserJFrame("用户界面");
                }

            }
        };
        chooseButton.addActionListener(rowListener);
        ActionListener personalListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                UserJFrame.this.setVisible(false);
                UserJFrame.this.dispose();
                new clientUser("个人书库");
            }
        };
        RecordButton.addActionListener(personalListener);
    }

    /**
     * 设置Frame的大小位置以及是否可变等
     */
    @Override
    protected void AddJFrame() {
        this.setBounds(300, 100, 1000, 600);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new UserJFrame("1");
    }

}
