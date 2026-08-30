package Advanced.Day07_线程池_Lambda表达式.Review01_Aug28;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/29/下午10:26
 * @Description:
 */
public class Demo18ShiKe extends Thread{
    Demo18BaoZi  bz;
    public Demo18ShiKe(Demo18BaoZi bz) {
        this.bz = bz;//从外部接收共享资源来消耗,强制要求一定要有
    }

    @Override
    public void run() {
        synchronized (bz) {
            while(true){
                if(bz.flag == false){
                    try{
                        bz.wait();
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
                System.out.println("食客来吃包子：" + bz.xian);
                bz.flag = false;
                bz.notify();
            }

        }
    }
}
