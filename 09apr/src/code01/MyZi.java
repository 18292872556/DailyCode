package code01;

import code01.inter.MyClass;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/04/09/9:33
 * @Description:
 */
public class MyZi extends MyClass {
    public void test(){
        System.out.println("子类访问方法");
        //new MyClass().num = 30;不同包的子类访问被protected修饰的父类成员，必须用super,如果用new相当于陌生类无法访问
        System.out.println(super.num);
        super.method();
    }
}
