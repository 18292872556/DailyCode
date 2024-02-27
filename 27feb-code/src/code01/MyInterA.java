package code01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/02/25/7:49
 * @Description:
 */
public interface MyInterA {
    public static final int NUM = 10;

    public abstract Object abMethod1();
    public abstract Integer abMethod2();

    public default void deMethod1(){
        System.out.println("接口A的默认方法，A,B,C中重名");
//        method1();
//        method2();

    }
    public static void stMethod1(){
        System.out.println("接口A的静态方法，A,B,C中重名");
//        method2();
        //method1();调不了，静态方法中调用非静态方法得new对象，但接口不能new对象
    }
    /*复习，1.静态方法中调用：①静态方法或变量，内部直接调（外部静态导入也是直接调），外部类名.
    * ②非静态方法，统一用对象名.调用
    * 2.非静态方法中调用：①内部类，不论静态或非静态，都直接调
    * ②外部类，静态用类名.，非静态用对象.*/
    //因为Java8不能写这些
//    private void method1(){
//        System.out.println("A的重复代码，私有");
//    }
//    private static void method2(){
//        System.out.println("A的重复代码，私有静态");
//    }



}
