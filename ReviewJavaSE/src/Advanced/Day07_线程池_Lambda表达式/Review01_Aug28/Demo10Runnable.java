package Advanced.Day07_线程池_Lambda表达式.Review01_Aug28;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/28/下午5:09
 * @Description:
 */
public class Demo10Runnable implements Runnable{
    private static int count = 0;

    public int getCount(){
        return count;
    }

    @Override
    public void run() {
        for(int i = 0; i < 1000; i++){
            count++;
        }
    }
}
