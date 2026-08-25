package Advanced.Day06_线程_同步.Review01_Aug23;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/25/下午4:00
 * @Description:
 *  static同步方法
 * // 定义static成员变量count，并定义static同步方法add()对count执行累加。
 * // 创建两个线程分别执行1000次add()，最后输出count。
 */
public class Demo16rRunnable implements Runnable {
    static int count = 0;
    @Override
    public void run() {
        add();
    }
    public static synchronized void add() {
        for(int i = 0; i < 1000; i++){
            count++;
        }
    }
}
