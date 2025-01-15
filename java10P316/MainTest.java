package java10P316;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: xuexuezi
 * @Date: 2025/01/15/21:37
 * @Description:
 */
public class MainTest {
    public static void main(String[] args) {
        demo14_4();
    }

    /*静态同步方法解决卖票线程安全问题*/
    private static void demo14_4() {
        Demo14_4RunnableImpl1 r1 = new Demo14_4RunnableImpl1();
        Demo14_4RunnableImpl2 r2 = new Demo14_4RunnableImpl2();
        new Thread(r1).start();
        new Thread(r2).start();

    }
}
