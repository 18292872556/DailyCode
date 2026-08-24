package Advanced.Day06_线程_同步.Review01_Aug23;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/24/下午6:10
 * @Description:
 */
public class Demo11Runnable implements Runnable {
    private int ticket = 50;
    @Override
    public void run() {
        while(true){
            sellTicket();
        }
    }
    private synchronized void sellTicket(){
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
