package Advanced.Day06_线程_同步.Review01_Aug23;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/25/上午10:34
 * @Description:
 */
public class Demo13Runnable implements Runnable{
    private int count = 10;
    Object obj = new Object();
    @Override
    public void run(){
//        while(true){//这是一个保持线程一直执行的条件，但是如果count为0的话就线程执行着也没什么用，所以还是先不写了
//
//        }
        synchronized(obj){
            while(count > 0){
                System.out.println(Thread.currentThread().getName() + "线程拿到了" + count--);
            }

        }

    }
}
