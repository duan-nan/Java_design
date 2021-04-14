package cn.nylg.Utils;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    //绘制容器
    Image image;

    public MyPanel(Image image) {
        this.image = image;//设置背景为透明
    }

    @Override
    protected void paintComponent(Graphics g) {
        //获取父类原来绘制组建的方法
        super.paintComponent(g);
        //调整父类的宽度和高度
        g.drawImage(image,0,0,this.getWidth(),this.getHeight(),this);
    }
}
