package review.demo02;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/10/10/2:09
 * @Description: 非静态方法调用外部类方法
 */
public class Test04 {
    public void method(){
        new Test03().test03Method();
        Test03.test03StaticMethod();
    }
    public static void main(String[] args) {
        new Test04().method();
    }
}
