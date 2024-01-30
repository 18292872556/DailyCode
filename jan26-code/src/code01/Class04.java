package code01;
import static code01.Class03.*;
/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/01/26/15:50
 * @Description:
 */
public class Class04 {
    int num1;
    static int num3;
    static void stMethod1(){
        Class04 c4 = new Class04();
        c4.num1 = 30;
        num2 = 40;
        System.out.println("num1:" + c4.num1 + "num2:" + num2);
        System.out.println("Class04的静态方法执行");

    }

    public static void main(String[] args) {
        stMethod();
    }
}
