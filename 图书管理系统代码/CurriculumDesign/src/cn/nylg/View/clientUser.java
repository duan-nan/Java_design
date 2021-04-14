package cn.nylg.View;

import cn.nylg.Utils.BaseJFrame;
import cn.nylg.Utils.MyPanel;
import cn.nylg.model.User;
import cn.nylg.model.bookContent;
import cn.nylg.service.Impl.UserServiceImpl;
import cn.nylg.service.UserService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class clientUser extends BaseJFrame {
    private ImageIcon icon = new ImageIcon("src\\cn\\nylg\\Main\\personal.jpg");
    private SimpleDateFormat sdf = new SimpleDateFormat();
    private JPanel mainPanel = new JPanel();
    private JPanel bigPanel = new JPanel();
    private JPanel smallPanel = new JPanel();
    private JTextArea Area = null;
    private JLabel TitleLabel = new JLabel("个 人 书 库");
    private JLabel firstLabel = new JLabel("书籍一：");
    private JLabel secondLabel = new JLabel("书籍二：");
    private JLabel thirdLabel = new JLabel("书籍三：");
    private JLabel fourLabel = new JLabel("书籍四：");
    private JButton firstButton = new JButton("阅读", icon);
    private JButton secondButton = new JButton("阅读", icon);
    private JButton thirdButton = new JButton("阅读", icon);
    private JButton fourButton = new JButton("阅读", icon);
    private JTextField firstField = new JTextField();
    private JTextField secondField = new JTextField();
    private JTextField thirdField = new JTextField();
    private JTextField fourField = new JTextField();
    private JLabel returnLabel = new JLabel("输入书名进行归还：");
    private JTextField returnField = new JTextField();
    private JButton returnButton = new JButton("确定", icon);
    private JLabel lendLabel = new JLabel("借书日期:");
    private JLabel ReturnLabel = new JLabel("还书日期:");
    private JTextField lendField = new JTextField();
    private JTextField ReturnField = new JTextField();


    /**
     * 无参构造方法
     */
    public clientUser() {
        this.init();
    }

    /**
     * 有参构造方法
     *
     * @param Title
     */
    public clientUser(String Title) {
        super(Title);
        this.init();
    }

    /**
     * 对组建进行添加
     */
    @Override
    protected void AddElement() {

        //bigPanel.add(Area);
        bigPanel.add(lendField);
        bigPanel.add(lendLabel);
        bigPanel.add(ReturnLabel);
        bigPanel.add(ReturnField);


        smallPanel.add(returnButton);
        smallPanel.add(returnField);
        smallPanel.add(returnLabel);
        smallPanel.add(firstButton);
        smallPanel.add(firstField);
        smallPanel.add(firstLabel);
        smallPanel.add(secondButton);
        smallPanel.add(secondField);
        smallPanel.add(secondLabel);
        smallPanel.add(thirdButton);
        smallPanel.add(thirdField);
        smallPanel.add(thirdLabel);
        smallPanel.add(fourButton);
        smallPanel.add(fourLabel);
        smallPanel.add(fourField);
        smallPanel.add(TitleLabel);
        mainPanel.add(bigPanel);
        mainPanel.add(smallPanel);
        this.add(mainPanel);
    }

    /**
     * 设置字体以及组建的设置
     */
    @Override
    protected void AddFontAndSoOn() {
        mainPanel = new MyPanel(new ImageIcon("src\\cn\\nylg\\Main\\17.jfif").getImage());
        mainPanel.setLayout(null);
        smallPanel.setLayout(null);
        smallPanel.setBounds(10, 10, 250, 540);
        smallPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        smallPanel.setOpaque(false);
        bigPanel.setLayout(null);
        bigPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        bigPanel.setBounds(270, 10, 705, 540);
        bigPanel.setOpaque(false);
        Font font = new Font("楷体", Font.BOLD, 20);
        TitleLabel.setBounds(25, 30, 200, 30);
        TitleLabel.setFont(new Font("楷体", Font.BOLD, 35));
        firstLabel.setBounds(10, 100, 100, 30);
        firstLabel.setFont(font);
        firstField.setBounds(90, 100, 150, 30);
        firstField.setOpaque(false);
        firstField.setFont(font);
        firstField.setEnabled(false);
        firstButton.setBounds(80, 140, 80, 30);
        firstButton.setFont(font);
        firstButton.setHorizontalTextPosition(JButton.CENTER);
        secondLabel.setBounds(10, 180, 100, 30);
        secondLabel.setFont(font);
        secondField.setBounds(90, 180, 150, 30);
        secondField.setOpaque(false);
        secondField.setFont(font);
        secondField.setEnabled(false);
        secondButton.setBounds(80, 220, 80, 30);
        secondButton.setFont(font);
        secondButton.setHorizontalTextPosition(JButton.CENTER);
        thirdLabel.setBounds(10, 260, 100, 30);
        thirdLabel.setFont(font);
        thirdField.setBounds(90, 260, 150, 30);
        thirdField.setOpaque(false);
        thirdField.setFont(font);
        thirdField.setEnabled(false);
        thirdButton.setBounds(80, 300, 80, 30);
        thirdButton.setFont(font);
        thirdButton.setHorizontalTextPosition(JButton.CENTER);
        fourLabel.setBounds(10, 340, 100, 30);
        fourLabel.setFont(font);
        fourField.setBounds(90, 340, 150, 30);
        fourField.setOpaque(false);
        fourField.setFont(font);
        fourField.setEnabled(false);
        fourButton.setBounds(80, 380, 80, 30);
        fourButton.setFont(font);
        fourButton.setHorizontalTextPosition(JButton.CENTER);

        returnLabel.setBounds(10, 450, 220, 30);
        returnLabel.setFont(font);
        returnField.setFont(font);
        returnField.setBounds(30, 480, 130, 40);
        returnField.setOpaque(false);

        returnButton.setBounds(180, 486, 60, 30);
        returnButton.setHorizontalTextPosition(JButton.CENTER);

        lendLabel.setFont(font);
        lendLabel.setBounds(10, 10, 100, 30);
        lendField.setFont(font);
        lendField.setBounds(110, 10, 150, 30);
        lendField.setEnabled(false);
        lendField.setOpaque(false);
        ReturnLabel.setFont(font);
        ReturnLabel.setBounds(380, 10, 100, 30);
        ReturnField.setFont(font);
        ReturnField.setBounds(480, 10, 150, 30);
        ReturnField.setOpaque(false);
        ReturnField.setEnabled(false);

        HashMap<String, User> userBox = UserServiceImpl.userBox;
        Set<Map.Entry<String, User>> set = userBox.entrySet();
        Iterator<Map.Entry<String, User>> it = set.iterator();
        while (it.hasNext()) {
            Map.Entry<String, User> entry = it.next();
            User user = entry.getValue();
            String name = user.getName();
            String booksName = user.getLendBooks();
            Date lendDate = user.getLendDate();
            Date returnDate = user.getReturnDate();
//            UserService userService = new UserServiceImpl();
//            LinkedList<String> linkedList = userService.checkLendBook(name);
//            String Name = linkedList.getFirst();
//            String booksName = linkedList.get(1);
//            String lendDate = linkedList.get(2);
//            String returnDate = linkedList.getLast();
            lendField.setText(String.valueOf(lendDate));
            ReturnField.setText(String.valueOf(returnDate));
            String[] split = booksName.split(",");
            for (int i = 0; i < split.length; i++) {
                if ("".equals(split.length)) {
                    break;
                } else {
                    if ("".equals(firstField)) {
                        firstField.setText(split[i]);
                    } else {
                        if ("".equals(secondField)) {
                            secondField.setText(split[i]);
                        } else {
                            if ("".equals(thirdField)) {
                                thirdField.setText(split[i]);
                            } else {
                                if ("".equals(fourField)) {
                                    fourField.setText(split[i]);
                                }
                            }
                        }
                    }
                }

            }
            firstField.setText(split[0]);
            secondField.setText(split[1]);
            thirdField.setText(split[2]);
            fourField.setText(split[3]);
        }
    }

    /**
     * 对组件进行监听
     */
    @Override
    protected void AddListener() {
        ActionListener firstListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(clientUser.this, "对不起，该服务尚未开启！");
            }
        };
        firstButton.addActionListener(firstListener);
        ActionListener secondListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(clientUser.this, "对不起，该服务尚未开启！");
            }
        };
        secondButton.addActionListener(secondListener);
        ActionListener thirdListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(clientUser.this, "对不起，该服务尚未开启！");
            }
        };
        thirdButton.addActionListener(thirdListener);
        ActionListener fourListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(clientUser.this, "对不起，该服务尚未开启！");
            }
        };
        fourButton.addActionListener(fourListener);
        ActionListener OkListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String name = returnField.getText();

            }
        };
        returnButton.addActionListener(OkListener);
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
        new clientUser("1");

    }
}
