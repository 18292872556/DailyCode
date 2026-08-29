package Advanced.Day07_线程池_Lambda表达式.Review01_Aug28;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/28/下午4:39
 * @Description:
 */
public class Demo06Runnable implements Runnable {
    private int count = 0;

    @Override
    public void run(){
        while(count < 10){
            System.out.println("count:" + count++);

        }
    }
}
