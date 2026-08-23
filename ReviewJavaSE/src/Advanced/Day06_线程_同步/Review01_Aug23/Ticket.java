package Advanced.Day06_线程_同步.Review01_Aug23;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/23/下午5:45
 * @Description:
 */
public class Ticket implements Runnable{
    int ticket = 30;
    @Override
    public void run() {
        while(true){
            //窗口一直开着
            if(ticket > 0){//有票就卖
                try{//出票需要50ms
                    Thread.sleep(50);
                }catch(InterruptedException e){
                    e.printStackTrace();//捕获sleep方法会产生的中断异常
                }
                System.out.println(Thread.currentThread().getName() + "正在卖：" + ticket--);
            }
        }
    }
}
