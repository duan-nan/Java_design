package cn.nylg.Utils;

import javax.swing.*;

public abstract class BaseJFrame extends JFrame {
    /**
     * 无参构造方法
     */
    public BaseJFrame() {
        this.AddFontAndSoOn();
        this.AddListener();
        this.AddJFrame();
        this.AddElement();
    }
    /**
     * 有参构造方法
     * @param Title
     */
    public BaseJFrame(String Title) {
        super(Title);
    }

    protected void init(){
        this.AddFontAndSoOn();
        this.AddListener();
        this.AddJFrame();
        this.AddElement();
    }
    /**
     * 对组建进行添加
     */
    protected abstract void AddElement();
    /**
     * 设置字体以及组建的设置
     */
    protected abstract void AddFontAndSoOn();
    /**
     * 对组件进行监听
     */
    protected abstract void AddListener();
    /**
     * 设置Frame的大小位置以及是否可变等
     */
    protected abstract void AddJFrame();

}
