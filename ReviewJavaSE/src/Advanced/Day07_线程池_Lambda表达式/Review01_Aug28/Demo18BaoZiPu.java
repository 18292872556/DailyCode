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
    int count = 20;
    public Demo18BaoZiPu(Demo18BaoZi bz) {
        this.bz = bz;
    }//为啥不这样写，因为包子铺要做包子，不是吃包子不需要接收包子类型的参数传递
    //要这样写，因为要修改传进来的包子的数值
    //传递这个包子的共享资源，并且顺便作为锁对象，因为包子是生产一个吃一个
    //锁对象用包子来当正好，比如包子铺先做包子出来当自己的锁对象，然后唤醒
    //食客线程，食客线程要获取的也是这同一个包子对象，获取不到可设置包子状态false
    //就睡眠等待，所以包子状态也应该在包子对象里作为其中一条属性

    @Override
    public void run() {
        //包子铺先判断有没有包子，没有才做
        while(count > 0){//让线程一直进行，判断可以一直做
            synchronized(bz){//本题要求是把这个同步代码块换成lock锁，为了写在finally里
                if(bz.flag == true){
                    try{
                        bz.wait();
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
                //走到这说明没包子了开始做
                //随机做//大于等于 0.0 ，小于 1.0
                int math = (int)(Math.random() * 10);
                if(math %2 == 0){
                    bz.xian = "猪肉";
                }else{
                    bz.xian = "韭菜";
                }

                count--;//做count个包子就不做了
                System.out.println("包子铺做了：" + bz.xian + "包子，来吃");
                bz.flag = true;
                bz.notify();
            }

        }
    }
}
