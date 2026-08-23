package Advanced.Day06_线程_同步.Review01_Aug23;


/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/23/下午5:37
 * @Description:
 */
public class MainTest {
    // 1. 继承Thread创建线程
// 定义MyThread继承Thread，重写run()方法。
// 要求线程启动后循环输出0~19，并在每次输出前打印当前线程名称。
    private static void demo01(){
        MyThread myThread = new MyThread("新线程");
        myThread.start();
    }
// 2. Thread构造方法传递线程名称
// 定义一个带String参数的构造方法，将传入的名称设置为线程名称。
// 在main方法中创建名称为“小强”的线程并启动。
    private static void demo02(){
        /*同上，改名即可*/
    }
// 3. 使用Runnable接口创建线程
// 定义MyRunnable实现Runnable，在run()中循环输出0~9以及当前线程名称。
// 在main方法中创建Runnable对象，再创建Thread对象并启动线程。
    private static void demo03(){
        MyRunnable mr = new MyRunnable();
        Thread thread = new Thread(mr, "线程1");
        thread.start();
    }
// 4. Runnable实现资源共享
// 创建Ticket实现Runnable，成员变量ticket初始值为30。
// 创建3个线程共同使用同一个Ticket对象，每个线程循环卖票直到票卖完。
    private static void demo04(){
        Ticket ticket = new Ticket();
        Thread thread1 = new Thread(ticket, "窗口1");
        Thread thread2 = new Thread(ticket, "窗口2");
        Thread thread3 = new Thread(ticket, "窗口3");

        thread1.start();
        thread2.start();
        thread3.start();
        /*会存在线程安全问题，但这道题没提就先不考虑，后面有专门要练习线程安全的题*/
    }
// 5. Thread常用方法：sleep()
// 创建一个线程循环输出1~5，每输出一个数字后暂停500毫秒。
// 捕获sleep()产生的InterruptedException。
    private static void demo05(){
        Demo05Thread dt = new Demo05Thread();
        dt.start();
    }
// 6. currentThread()
// 创建一个线程，在run()中获取当前正在执行的线程对象。
// 输出该线程的名称以及线程对象本身。
    private static void demo06(){
        Demo06Thread dt = new Demo06Thread();
        dt.start();
    }
// 7. 匿名内部类创建Runnable线程
// 不单独定义Runnable实现类，直接使用匿名内部类创建线程任务。
// 线程启动后输出10次“Hello Thread”。
    private static void demo07(){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10; i++){
                    System.out.println("Hello Thread");
                }
            }
        };

        Thread thread = new Thread(r);
        thread.start();
    }
// 8. 多线程交替执行
// 创建两个线程，分别输出“A0~A9”和“B0~B9”，两个线程同时启动。
// 要求两个线程都通过Runnable接口创建。
    private static void demo08(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10; i++){
                    System.out.println("A" + i);
                }
            }
        };
        Thread thread1 = new Thread(r1, "线程1");
        thread1.start();

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10; i++){
                    System.out.println("B" + i);
                }
            }
        };
        Thread thread2 = new Thread(r2, "线程2");
        thread2.start();
    }
// 9. 模拟线程安全问题
// 创建Ticket实现Runnable，ticket初始值为50，创建3个线程共同售票。
// 在售票前使用sleep(100)模拟出票耗时，观察并输出售票结果。
    private static void demo09(){
        
    }
// 10. 同步代码块解决售票安全问题
// 修改上一题的Ticket，使判断剩余票数和ticket--的操作放入同步代码块。
// 要求3个窗口仍然共享同一个Ticket对象。
// 11. 同步方法解决售票安全问题
// 创建Ticket实现Runnable，ticket初始值为50。
// 将售票操作单独封装成sellTicket()同步方法，并在run()中循环调用。
// 12. Lock解决售票安全问题
// 使用ReentrantLock为Ticket添加锁。
// 售票操作执行前加锁，操作结束后释放锁，保证ticket不会出现重复或负数。
// 13. 多个线程使用同一把锁
// 创建两个线程共同修改一个共享count变量。
// 使用同一个Object对象作为同步代码块的锁，最终保证count结果正确。
// 14. static共享资源的线程安全
// 定义static int count=0，创建两个线程分别执行1000次count++。
// 使用同步代码块保证最终输出count为2000。
// 15. 非static同步方法
// 创建Counter类，定义成员变量count和add()方法。
// 将add()定义为同步方法，创建两个线程共享同一个Counter对象并执行1000次累加。
// 16. static同步方法
// 定义static成员变量count，并定义static同步方法add()对count执行累加。
// 创建两个线程分别执行1000次add()，最后输出count。
// 17. 计时等待Timed Waiting
// 创建MyThread继承Thread，循环输出0~9。
// 每输出一个数字后sleep(1000)，并捕获InterruptedException。
// 18. Waiting等待
// 创建Object类型的共享锁对象和“等待线程”。
// 等待线程获取锁后调用wait()进入无限等待，并在被唤醒后继续输出一条信息。
// 19. notify唤醒线程
// 在上一题基础上创建“唤醒线程”，等待3秒后获取同一把锁。
// 调用notify()唤醒等待线程，并输出唤醒提示。
// 20. wait与notify协作
// 创建两个线程模拟“生产者”和“消费者”：消费者没有数据时wait()。
// 生产者生产数据后调用notify()，消费者被唤醒后继续执行。
// 21. wait带参数
// 创建线程获取共享锁后调用wait(3000)。
// 3秒内没有被唤醒时自动继续执行，并输出线程恢复运行的提示。
// 22. 查看线程状态
// 创建一个Thread对象但不要立即调用start()。
// 分别在创建线程后、线程启动后输出thread.getState()的结果。
// 23. 制造BLOCKED状态
// 创建两个线程使用同一个锁对象。
// 让线程A持有锁并sleep一段时间，同时让线程B尝试获取同一把锁。
// 24. 综合线程状态练习
// 创建线程并依次让它经历新建、可运行、计时等待和终止等状态。
// 在合适的时间输出thread.getState()观察状态变化。
}
