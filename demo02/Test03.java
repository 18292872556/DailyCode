package review.demo02;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/10/10/1:19
 * @Description: 非静态方法调用类内部方法
 */
public class Test03 {
    public static void test03StaticMethod(){
        System.out.println("执行test03静态方法");
    }
    public void test03Method(){
        System.out.println("执行test03非静态方法");
    }

    public void method(){
        test03StaticMethod();
        test03Method();
    }

    public static void main(String[] args) {
        System.out.println("Test03类内main方法执行");
        new Test03().method();
    }

}
