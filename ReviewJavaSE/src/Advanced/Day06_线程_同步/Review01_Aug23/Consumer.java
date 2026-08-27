package Advanced.Day06_线程_同步.Review01_Aug23;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/25/下午5:28
 * @Description:
 * 暂时不用了，作废
 */
public class Consumer extends Thread {
    private int count = 0;
    private Object lock;
    public Consumer(Object lock, int count){
        this.lock = lock;
        this.count = count;
    }

    @Override
    public void run() {
        synchronized (lock){
            if(count == 0){//有一个问题开始设定的就是，如果没有生产资料，消费者要等待
                //但这样写，消费者根本无法被唤醒是因为什么？类似于生产了很多消费资料根本不会进入这层
                //为什么写到if之后也不会被唤醒呢？因为没休眠吗？
                try{
                    lock.wait();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println("被唤醒了。开始消费");
            while(count > 0){
                System.out.println("消费：" + count--);
            }
        }
    }
}
