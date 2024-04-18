package code01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/03/04/21:27
 * @Description:
 */
public class MyClass {
    public int num = 10;

    public void method(){
        System.out.println("MyClass方法执行");
    }
    public void test(){
        method();
        num = 20;
        System.out.println(num);
    }
}
