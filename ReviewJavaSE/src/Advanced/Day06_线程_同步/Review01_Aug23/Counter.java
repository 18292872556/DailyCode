package Advanced.Day06_线程_同步.Review01_Aug23;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/25/下午3:54
 * @Description:
 *  非static同步方法
 * // 创建Counter类，定义成员变量count和add()方法。
 * // 将add()定义为同步方法，创建两个线程共享同一个Counter对象并执行1000次累加。
 */
public class Counter implements Runnable{
    private int count = 0;
    //两个线程共享同一个Counter对象，所以Counter类经常要实现Runnable
    public void run(){
        add();
    }

    public synchronized void add(){
        while(count < 1000){

            System.out.println(Thread.currentThread().getName() + "-" + ++count);
        }

    }
}
