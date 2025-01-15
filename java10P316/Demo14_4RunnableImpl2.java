package java10P316;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: xuexuezi
 * @Date: 2025/01/15/22:35
 * @Description: 同步代码块用静态同步方法隐含的锁对象RunnableImpl.class
 */
public class Demo14_4RunnableImpl2 implements Runnable{
    private  int ticket = 100;
    @Override
    public void run() {
        while(true){
            synchronized(Demo14_4RunnableImpl2.class){
                if(ticket > 0){
                    System.out.println("在卖" + ticket + "号票");
                    ticket--;
                }
            }
        }
    }
}
