package Advanced.Day06_线程_同步.Review01_Aug23;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/24/下午6:05
 * @Description:
 *
 * //同步代码块解决线程安全问题
 */
public class Demo10Runnable implements Runnable {
    private int ticket = 50;
    Object lock = new Object();
    @Override
    public void run() {
        while(true){
            synchronized(lock){
                if(ticket > 0){
                    try{
                        Thread.sleep(100);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在卖：" + ticket--);
                }
            }
        }
    }
}
