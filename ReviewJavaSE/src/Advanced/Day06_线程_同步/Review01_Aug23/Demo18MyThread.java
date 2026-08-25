package Advanced.Day06_线程_同步.Review01_Aug23;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/25/下午4:30
 * @Description:
 * 创建Object类型的共享锁对象和“等待线程”。
 * // 等待线程获取锁后调用wait()进入无限等待，并在被唤醒后继续输出一条信息。
 */
public class Demo18MyThread extends Thread{
    Object lock;
    //要求传参为锁对象
    public Demo18MyThread(Object lock, String name) {
        super(name);
        this.lock = lock;
    }
    @Override
    public void run() {
        synchronized (lock) {
            try{
                lock.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "从无限等待中被唤醒，获取到了锁对象继续执行");

        }
    }

}
