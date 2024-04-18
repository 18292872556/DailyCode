package code01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/01/26/15:50
 * @Description: 测试互相静态导入后，同名方法和同名变量的情况
 */
public class Class03 {
    int num1;
    static int num2;
    static void stMethod(){
        Class03 c3 = new Class03();
        c3.num1 = 10;
        num2 = 20;
        System.out.println("num1:" + c3.num1 + "num2:" + num2);
        System.out.println("Class03的静态方法执行");
    }
}
