package Advanced.Day07_线程池_Lambda表达式.Review01_Aug28;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/29/下午10:26
 * @Description:
 */
public class Demo18BaoZiPu extends Thread{
    Demo18BaoZi bz;
//    public Demo18BaoZiPu(Demo18BaoZi bz) {
//        this.bz = bz;
//    }
    //传递这个包子的共享资源，并且顺便作为锁对象，因为包子是生产一个吃一个
    //锁对象用包子来当正好，比如包子铺先做包子出来当自己的锁对象，然后唤醒
    //食客线程，食客线程要获取的也是这同一个包子对象，获取不到可设置包子状态false
    //就睡眠等待

    @Override
    public void run() {

    }
}
