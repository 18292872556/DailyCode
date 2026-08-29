package Advanced.Day07_线程池_Lambda表达式.Review01_Aug28;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/28/下午4:50
 * @Description:
 */
public class Demo09Runnable implements Runnable{
    private int count = 100;

    @Override
    public void run() {
        while(count > 0){
            try{
                Thread.sleep(4000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "正在卖：" + count--);
        }
    }
}
