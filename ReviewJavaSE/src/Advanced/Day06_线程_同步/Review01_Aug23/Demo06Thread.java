package Advanced.Day06_线程_同步.Review01_Aug23;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/23/下午5:53
 * @Description:
 */
public class Demo06Thread extends Thread {
    @Override
    public void run() {
        System.out.println("线程名称：" + getName());
        System.out.println("线程对象本身：" + Thread.currentThread());
    }
}
