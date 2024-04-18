package qxcto.code02extends.code02_1visit;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/11/08/20:42
 * @Description: P152~P156 这个包下做 继承.访问 的练习测试
 * 在继承的关系中，“子类就是一个父类“例如教师是一个员工，称为"is-a"关系
 *
 */
public class TestVisit {

    public static void main(String[] args) {
        Employee e1 = new Employee();
        Teacher t1 = new Teacher();
        Assistant a1 = new Assistant();

        //父类Employee有方法method,两个子类Teacher,Assistant，
        // 也会自然继承父类的方法，即使什么都没写，也是默认包括的
        e1.method();
        t1.method();//不重写的话执行父类的内容
        a1.method();

        //子类也包含父类的变量，所以也可以直接调用，默认包括
        System.out.println(e1.numE);//10
        System.out.println(t1.numT);//20
        System.out.println(t1.numE);//10

        //父与子类中成员变量重名的情况num
        Employee eT = new Teacher();//父类引用名可以接收子类对象
        //情况1：直接通过子类对象访问成员变量
        //等号左边是谁，就优先用谁，没有则向上找（向上指从直接父类往上的父类）
        System.out.println(e1.num);//10
        System.out.println(t1.num);//20
        System.out.println(eT.num);//10，这个对象的等号左边引用是Employee类所以访问其中的num
        System.out.println(t1.numE);//10，子类中没有所以向上找
        //情况2：间接通过成员方法访问成员变量
        //在类的成员方法中调用成员变量，哪个类中的方法就调用哪个类中的成员变量，如果访问没有这个变量就向上找
        //调用时，看这个方法属于谁，就调用谁中的成员变量
        e1.methodEmNum();//10，方法属于父类，调用Employee中的num
        t1.methodTeNum();//20
        t1.methodEmNum();//10
        a1.methodAsNum();//10，因为Assistant类中没有num，所以向上在父类中找
        a1.methodEmNum();//10

        //父与子类中成员方法重名的情况method方法
        //?疑惑这样不算是子类重写父类方法吗？其实就是重写
        //创建的对象是谁就优先用谁的成员方法
        e1.method();//员工类，父类方法
        t1.method();//教师类，子类方法
        eT.method();//教师类，子类方法，new的对象是Teacher类，与重名变量区别开，重名变量是看等号左边
        a1.method();//助理类，向上找，父类方法，Assistant类中没有这个方法所以向上找








    }
}
