package Advanced.Day06_线程_同步.Review01_Aug23;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/24/下午6:00
 * @Description:
 * 售票50张，耗时100ms
 */
public class Demo09Runnable implements Runnable {
    private int ticket = 50;
    @Override
    public void run() {
        while(true){
            //窗口一直开放
            if(ticket > 0){
                //有票可以卖
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "在卖票：" + ticket--);
            }
        }
    }
}
