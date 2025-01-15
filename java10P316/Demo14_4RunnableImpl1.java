package java10P316;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: xuexuezi
 * @Date: 2025/01/15/22:03
 * @Description: 静态同步方法
 */
public class Demo14_4RunnableImpl1 implements Runnable{
    private static int ticket = 100;
    @Override
    public void run() {
        while(true){
            sellTicket();
        }
    }
    //静态方法中只能访问静态变量，静态成员优先于对象池成员，没有this,就没有非静态成员
    static synchronized void sellTicket(){
        if(ticket > 0){
            System.out.println("卖出第" + ticket + "张票");
            ticket--;
        }
    }
}
