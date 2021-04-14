package cn.nylg.Utils;

import java.util.HashMap;

/**
 * 因为管理对象而产生
 * 将控制权交给类来控制  IOC反转 控制反转
 *  生命周期托管
 */
public class MySpring {
    //定义一个集合来存储被创建的对象
    private static HashMap<String,Object> beanBox = new HashMap<String, Object>();
    //设计一个方法，获取任何一个类的对象
    public static <T>T getBean(String className){
        T obj = null;
        try {
            //1.从beanBox里获取对象
            obj = (T) beanBox.get(className);
           if (obj == null){//说明该对象没有被创建
               //通过类名获取Class
               Class clazz = Class.forName(className);
               //通过反射产生一个对象
               obj = (T)clazz.getDeclaredConstructor().newInstance();
               beanBox.put(className,obj);
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
