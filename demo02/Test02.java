package review.demo02;

import static review.demo02.Test01.test01StaticMethod;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/10/09/23:32
 * @Description: 静态方法调用静态方法
 */
public class Test02 {
    public static void test02StaticMethod(){
        System.out.println("执行test02的静态方法");
    }
    public void test02Method(){
        System.out.println("执行test02的非静态方法");
    }


    public static void main(String[] args) {
        System.out.println("Test02类内main方法执行");

        //调类内部静态方法
        test02StaticMethod();

        //调用同包不同类的静态方法
        test01StaticMethod();

    }
}
