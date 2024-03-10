package code02;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/03/10/16:59
 * @Description: 匿名内部类
 */
public class MainTest {
    public static void main(String[] args) {
        /*实现类实现接口方法并调用*/
        MyInterfaceImpl obj1 = new MyInterfaceImpl();
        obj1.method();
        /*匿名内部类重写接口的抽象方法  */
        MyInterface obj2 = new MyInterface(){
            @Override
            public void method() {
                System.out.println("obj2 匿名内部类实现method方法");
            }
        };
        obj2.method();

        //------------------------------------
        MyInterface2 obj3 = new MyInterface2(){
            @Override
            public void method1() {
                System.out.println("obj3 匿名内部类实现method1方法");
            }
            @Override
            public void method2() {
                System.out.println("obj3 匿名内部类实现method2方法");
            }
        };
        //注意匿名内部类是有对象名的，可以多次调用方法
        obj3.method1();
        obj3.method2();
        obj3.method2();

        //想再使用这个匿名内部类，再new一次相同的对象。只能再写一次内容相同的匿名内部类
        MyInterface2 obj4 = new MyInterface2(){
            @Override
            public void method1() {
                System.out.println("obj4 匿名内部类实现method1方法");
            }
            @Override
            public void method2() {
                System.out.println("obj4 匿名内部类实现method2方法");
            }
        };
        obj4.method1();
        obj4.method2();



        //-----------------------------------------------------------
        //匿名内部类的匿名对象
        new MyInterface2(){
            @Override
            public void method1() {
                System.out.println("匿名对象 的匿名内部类实现 method1 方法");
            }
            @Override
            public void method2() {
                System.out.println("匿名对象 的匿名内部类实现 method2 方法");
            }
        }.method1();
        //匿名对象只能调用一次方法，调用method2就再创建一次匿名对象
        new MyInterface2(){
            @Override
            public void method1() {
                System.out.println("匿名对象 的匿名内部类实现 method1 方法");
            }
            @Override
            public void method2() {
                System.out.println("匿名对象 的匿名内部类实现 method2 方法");
            }
        }.method2();

    }
}
