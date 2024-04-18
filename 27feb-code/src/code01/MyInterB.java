package code01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/02/25/7:49
 * @Description:
 */
public interface MyInterB {
    int NUM = 20;
    int BNUM = 30;

    Float abMethod1();
    Integer abMethod2();

    public default void deMethod1(){
        System.out.println("接口B的默认方法1，A,B,C中重名");
//        method1();
//        method2();

    }
    public default void deMethod2(){
        System.out.println("接口B的默认方法2，B，C中重名");
    }
    public static void stMethod1(){
        System.out.println("接口B的静态方法，A,B,C中重名");
//        method2();
        //method1();调不了，静态方法中调用非静态方法得new对象，但接口不能new对象
    }
    public static void stMethod2(){
        System.out.println("接口B自己的静态方法");
    }

    //因为Java8不能写这些
//    private void method1(){
//        System.out.println("B的重复代码，私有");
//    }
//    private static void method2(){
//        System.out.println("B的重复代码，私有静态");
//    }



}
