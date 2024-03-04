package code01.permissions;

import code01.MyClass;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/03/04/21:28
 * @Description:
 */
public class MyZi extends MyClass {

    public void test(){
        System.out.println("子类访问方法");
       //注意，如果子类也使用new MyClass访问，因为不同包，又不用super，相当于是陌生类访问了。
        //父类MyClass中的proctected类型成员，将无法在子类中访问。所以必须用super
        //new MyClass().num;
        System.out.println(super.num);
        super.method();
    }
}
