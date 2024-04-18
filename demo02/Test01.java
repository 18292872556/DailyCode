package review.demo02;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/10/09/23:16
 * @Description: 静态方法调用非静态方法 ，必须通过对象调用
 */
public class Test01 {
    public static void test01StaticMethod() {
        System.out.println("执行test01静态方法");
    }

    public void test01Method() {
        System.out.println("执行test01的非静态方法");
    }


    public static void main(String[] args) {
        System.out.println("Test01类内main执行");
        //调用本类方法------------------------

        //错误调用非静态方法
        //test01Method();

        //匿名对象调用非静态方法
        new Test01().test01Method();
        //创建对象调用非静态方法
        Test01 t1 = new Test01();
        t1.test01Method();

        //调用同包不同类方法-------------
        new Test02().test02Method();
        Test02 t2 = new Test02();
        t2.test02Method();


    }
}
