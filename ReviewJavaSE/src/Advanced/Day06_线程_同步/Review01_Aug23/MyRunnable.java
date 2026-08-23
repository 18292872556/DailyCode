package Advanced.Day06_线程_同步.Review01_Aug23;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/23/下午5:42
 * @Description:
 */
public class MyRunnable implements Runnable{
    @Override
    public void run(){
        for(int i=0; i<10; i++){
            System.out.println(Thread.currentThread().getName()+ i);
        }
    }
}
