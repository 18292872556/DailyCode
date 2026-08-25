package Advanced.Day06_线程_同步.Review01_Aug23;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/25/下午4:48
 * @Description:
 * 在上一题基础上创建“唤醒线程”，等待3秒后获取同一把锁。
 * // 调用notify()唤醒等待线程，并输出唤醒提示。
 */
public class Demo19Thread extends Thread {
    Object lock = new Object();
    public Demo19Thread(Object lock, String name) {
        super(name);
        this.lock = lock;
    }
    @Override
    public void run() {
        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        synchronized (lock) {
            lock.notify();
            System.out.println("Demo19来唤醒了");
        }
    }
}
