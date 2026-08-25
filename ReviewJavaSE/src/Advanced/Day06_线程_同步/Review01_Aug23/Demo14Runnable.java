package Advanced.Day06_线程_同步.Review01_Aug23;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/25/上午11:44
 * @Description:
 */
public class Demo14Runnable implements Runnable{
    private static int count = 0;
    Lock lock = new ReentrantLock();
    @Override
    public void run() {
        lock.lock();
        for(int i = 0; i < 1000; i++){
            count++;
            System.out.println(Thread.currentThread().getName()+":"+count);
        }
    }
}
