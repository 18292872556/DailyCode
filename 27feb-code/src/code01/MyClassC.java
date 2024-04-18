package code01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/02/25/7:50
 * @Description:
 */
public class MyClassC {
    void deMethod1(){
        System.out.println("------类C的默认方法1，A,B,C中重名------");
        method1();
        method2();
        System.out.println("------------------------------------");
    }
    public void deMethod2(){
        System.out.println("类C的默认方法2，B,C中重名");
    }
    public static void stMethod1(){
        System.out.println("----类C的静态方法，A,B,C中重名,调内部私有静态方法---");
        method2();
        System.out.println("-------------------------------");
        //method1();调不了，静态方法中调用非静态方法得new对象，但接口不能new对象
    }
    private void method1(){
        System.out.println("类C的重复代码，私有");
    }
    private static void method2(){
        System.out.println("类C的重复代码，私有静态");
    }
}
