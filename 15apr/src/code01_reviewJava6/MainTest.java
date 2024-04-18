package code01_reviewJava6;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/04/12/18:45
 * @Description: 复习 JavaSE 6
 */
public class MainTest {
    public static void main(String[] args) {
        /*1. 创建一个成员内部类，在其他类中用直接和间接两种方式，访问该内部类及方法。*/
        //注意有参无参无所谓,构造方法有就行
        //demo01();
        /*
        * 2. 在【成员内部类】中，在内部类方法和外部类方法中访问同名的，局部变量，内部类成员变量，外部类成员变量。
        * 对比【局部内部类】访问同名变量的情况。
        */
        demo02();




        /* 3. 成员内部类：在外部类访问成员内部类成员，在内部类访问外部类成员。
        * 4. 分析 外部类，成员内部类，局部内部类的权限修饰符可能性。
        * 5. 判断，局部内部类访问局部变量对错
        * 6. 使用匿名内部类实现接口（两个抽象方法），并多次调用其中方法
        * 7. 使用匿名内部类new匿名对象，调用两个方法*/


    }

    private static void demo02() {
        Demo02 obj1 = new Demo02();
        Demo02.Inner obj2 = new Demo02().new Inner();
        obj1.method();
        obj2.method();
        obj1.partInner();

    }

    private static void demo01(){
        Demo01 obj1 = new Demo01();
        Demo01.Inner obj2 = new Demo01().new Inner();
        Demo01.Inner obj3 = new Demo01(30).new Inner();
        Demo01.Inner obj4 = obj1.new Inner(40);

        obj2.method();
        obj3.method();
        obj4.method();
    }
}
