package Advanced.Day06_线程_同步.Review01_Aug23;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/25/下午4:05
 * @Description:
 * 计时等待Timed Waiting
 * // 创建MyThread继承Thread，循环输出0~9。
 * // 每输出一个数字后sleep(1000)，并捕获InterruptedException。
 */
public class Demo17MyThread extends Thread{


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
