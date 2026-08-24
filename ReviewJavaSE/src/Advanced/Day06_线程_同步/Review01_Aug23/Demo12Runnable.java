package Advanced.Day06_线程_同步.Review01_Aug23;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/24/下午6:17
 * @Description:
 * lock锁
 */
public class Demo12Runnable implements Runnable {
    private int ticket = 50;
    Lock lock = new ReentrantLock();
    @Override
    public void run() {
        while(true){
            lock.lock();
            if(ticket > 0){
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "正在卖" + ticket--);
            }
            lock.unlock();
        }
    }
}
