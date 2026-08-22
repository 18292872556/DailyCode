package Advanced.Day05_异常_线程.Review02_Aug22;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/22/下午3:10
 * @Description:
 */
public class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println(getName() + "正在执行！" + i);
        }
    }
}
