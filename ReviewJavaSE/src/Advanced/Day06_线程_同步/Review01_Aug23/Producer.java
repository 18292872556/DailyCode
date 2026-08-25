package Advanced.Day06_线程_同步.Review01_Aug23;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/25/下午5:19
 * @Description:
 */
public class Producer extends Thread {
     private Object lock;
    private int count = 0;
    private int flag = 0;
    boolean running = true;
    public Producer(Object lock, int count){
        this.lock = lock;
        this.count = count;
    }
    @Override
    public void run() {

        while(running){
            synchronized (lock){
                count++;
                flag++;
                lock.notify();
                System.out.println("生产者生产的count:" + count + "唤醒消费者");
            }
            if(flag >= 20){
                running = false;
            }
        }

    }
}
