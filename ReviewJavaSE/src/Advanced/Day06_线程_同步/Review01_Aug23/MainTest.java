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


        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10; i++){
                    System.out.println("B" + i);
                }
            }
        };
        Thread thread2 = new Thread(r2, "线程2");
        thread1.start();
        thread2.start();
    }
// 9. 模拟线程安全问题
// 创建Ticket实现Runnable，ticket初始值为50，创建3个线程共同售票。
// 在售票前使用sleep(100)模拟出票耗时，观察并输出售票结果。
    private static void demo09(){
        Demo09Runnable d9r = new Demo09Runnable();
        Thread t1 = new Thread(d9r, "线程1");
        Thread t2 = new Thread(d9r, "线程2");
        Thread t3 = new Thread(d9r, "线程3");

        t1.start();
        t2.start();
        t3.start();
        /*会有0，-1*/
    }
// 10. 同步代码块解决售票安全问题
// 修改上一题的Ticket，使判断剩余票数和ticket--的操作放入同步代码块。
// 要求3个窗口仍然共享同一个Ticket对象。
    private static void demo10(){
        Demo10Runnable d10r = new Demo10Runnable();
        Thread t1 = new Thread(d10r, "线程1");
        Thread t2 = new Thread(d10r, "线程2");
        Thread t3 = new Thread(d10r, "线程3");

        t1.start();
        t2.start();
        t3.start();
    }
// 11. 同步方法解决售票安全问题
// 创建Ticket实现Runnable，ticket初始值为50。
// 将售票操作单独封装成sellTicket()同步方法，并在run()中循环调用。
    private static void demo11(){
        Demo11Runnable d11r = new Demo11Runnable();
        Thread t1 = new Thread(d11r, "线程1");
        Thread t2 = new Thread(d11r, "线程2");
        Thread t3 = new Thread(d11r, "线程3");

        t1.start();
        t2.start();
        t3.start();
    }
// 12. Lock解决售票安全问题
// 使用ReentrantLock为Ticket添加锁。
// 售票操作执行前加锁，操作结束后释放锁，保证ticket不会出现重复或负数。

    private static void demo12(){
        Demo12Runnable d12r = new Demo12Runnable();
        Thread t1 = new Thread(d12r, "线程1");
        Thread t2 = new Thread(d12r, "线程2");
        Thread t3 = new Thread(d12r, "线程3");

        t1.start();
        t2.start();
        t3.start();

    }

// 13. 多个线程使用同一把锁
// 创建两个线程共同修改一个共享count变量。
// 使用同一个Object对象作为同步代码块的锁，最终保证count结果正确。
    private static void demo13(){
       /*思考这种情况是不是只能两个线程用同一个Runnable，不可以继承Thread写两个不同的Thread?
       * 因为那样的话，就不是同一个count变量了？或者跟最开始练习Thread继承一样，写一个自定义线程类对象
       * 然后在本方法执行也算一个线程，然后变量定义到main线程里？或者把变量作为不同线程的参数？好像不行，
       * 线程的构造方法没有这种自定义参数的情况，只有target用Runnable实现类对象，或者String定义名字
       * 算是被main调用的main线程。但如果是3个以上的线程要共享同一个count
       * 应该就只能用同一个Runnable了吧*/

        //因为题目没有详细说明怎么使用count，所以还是写成像卖票一样，哪个线程在运行就对count--
        Demo13Runnable d13r = new Demo13Runnable();
        Thread t1 = new Thread(d13r,"线程1");
        Thread t2 = new Thread(d13r,"线程2");

        t1.start();
        t2.start();
    }
// 14. static共享资源的线程安全
// 定义static int count=0，创建两个线程分别执行1000次count++。
// 使用同步代码块保证最终输出count为2000。
    private static void demo14(){
        /*思考：如果不使用同步代码块会怎么样呢？run方法里执行count++的时候应该只有一句
        * 好像不用同步代码块，最后也会是2000？想不到会出错的可能性，就算执行到一半被并行抢前执行了
        * 好像也不会多+一次？count++这种程度应该不会分开执行吧？
        * 哦！想到一种可能出错的情况，比如A线程此刻访问到的count是2，准备++。此时B抢到了因为A还没++完成
        * 所以count还是2，所以B就是+完是3，A又抢到，继续+但因为A被抢之前认知的count还是2，新加的并没有同步到A线程count++的执行语句？
        * 应该是这样，因为之前卖票的案例也是这样出现线程安全问题的。根本原因应该在于ticket--也会先读取到，然后被抢占
        * 再--？*/
        /*确定了：count++,ticket--都是复合操作不是原子操作。理解的完全正确，就是因为count++
        * 分为 int temp = count; temp = temp + 1; count = temp;
        * 所以例如A线程在第2步读到count = 2 的时候被B抢了，B线程读到count=2,+完=3。
        * 回到A线程之前读到的还是2,+完 = 3就是会重复+。*/

        Demo14Runnable d14r1 = new Demo14Runnable();
        Demo14Runnable d14r2 = new Demo14Runnable();
        Thread t1 = new Thread(d14r1, "线程1");
        Thread t2 = new Thread(d14r2, "线程2");
        /*注意：重点在于需要两个线程对同一个count进行++,同时又需要两个线程分别对count++1000次
        * 只能使用static类变量，同类不同对象来创造线程*/

        t1.start();
        t2.start();
    }
// 15. 非static同步方法
// 创建Counter类，定义成员变量count和add()方法。
// 将add()定义为同步方法，创建两个线程共享同一个Counter对象并执行1000次累加。
    private static void demo15(){
        Counter counter = new Counter();
        Thread t1 = new Thread(counter, "线程1");
        Thread t2 = new Thread(counter, "线程2");

        t1.start();
        t2.start();
    }
// 16. static同步方法
// 定义static成员变量count，并定义static同步方法add()对count执行累加。
// 创建两个线程分别执行1000次add()，最后输出count。
    private static void demo16(){
        Counter counter = new Counter();
        Thread t1 = new Thread(counter, "线程1");
        Thread t2 = new Thread(counter, "线程1");

        t1.start();
        t2.start();
    }
// 17. 计时等待Timed Waiting
// 创建MyThread继承Thread，循环输出0~9。
// 每输出一个数字后sleep(1000)，并捕获InterruptedException。
   private static void demo17(){
       Demo17MyThread d17t = new Demo17MyThread();
       d17t.start();
   }
// 18. Waiting等待
// 创建Object类型的共享锁对象和“等待线程”。
// 等待线程获取锁后调用wait()进入无限等待，并在被唤醒后继续输出一条信息。
static Object lock = new Object();
    /*因为18,19要用同一个锁对象，所以一起定义在这个类里，锁作为这个类的成员，这样两个线程可以一起访问到*/

    private static void demo18(){
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run(){
//                synchronized (obj){
//
//                }
//            }
//        }, "无限等待线程");匿名内部类的写法不够好
        Demo18MyThread d18t = new Demo18MyThread(lock, "demo18无限等待");
        d18t.start();
    }
// 19. notify唤醒线程
// 在上一题基础上创建“唤醒线程”，等待3秒后获取同一把锁。
// 调用notify()唤醒等待线程，并输出唤醒提示。
    private static void demo19(){
        Demo19Thread d19t = new Demo19Thread(lock, "等3s后唤醒");
        d19t.start();
    }
// 20. wait与notify协作
/*真是超级难，做下来第一个很难很耗时间的题目*/
// 创建两个线程模拟“生产者”和“消费者”：消费者没有数据时wait()。
// 生产者生产数据后调用notify()，消费者被唤醒后继续执行。
    static Object lock20 = new Object();
    static int count = 0;//统计生产了几个
//    static boolean running = true;//停止生产的判定
    static int flag = 0;//统计限定生产次数
    private static void demo20(){
        /*把这个要消费的消费品作为一个数字吧，取走以后就是0，生产了就是1,2之类的。
        如果一直没被消费也在持续生产积累。用同一个锁*/

        Thread pro = new Thread("生产者"){
            @Override
            public void run() {
//                if(flag >= 20){
//                    running = false;
//                }
                while(flag <20){
                    try{
                        Thread.sleep(500);//等一下再生产，好看能不能让消费者和生产者交错进行
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }//把睡眠放同步外面，如果放在锁里，睡的这5s也不会释放锁，会一直占用
                    synchronized (lock20){
                        //只有生产一份生产资料的时候在同步代码块里，因为不想一次生产很多再消费
                        //而是尽量交替进行
                        flag++;
                        System.out.println("生产者生产的count:" + ++count + "唤醒消费者"
                        + "累计生产：" + flag);
                        //输出语句在真正唤醒的前或后应该都可以，因为都在同步里
                        lock20.notify();
                    }
                }

            }
        };
        Thread con = new Thread("消费者"){
            @Override
            public void run() {
                while(true){//完美，改了这个消费者终于能一直消费了，但是交替协作的非常有序，不会堆积生产资料
                    //输出结果基本上就是只要唤醒了就会开始消费，没有再被生产者抢去资源积累2个没消费的情况
                    synchronized (lock20){
                        /*思考：等待的过程只能写到同步块里，因为是用了锁对象
                         * 但为什么只执行了一次消费？考虑，只要count不为0就会跳出循环，需要一个外层循环
                         * 让线程一直执行*/
                        while(count == 0){//开始写的if有问题，只会等待一次，消费到count为0线程执行完就自然结束了
                            //有一个问题开始设定的就是，如果没有生产资料，消费者要等待
                            //但这样写，消费者根本无法被唤醒是因为什么？类似于生产了很多消费资料根本不会进入这层
                            //为什么写到if之后也不会被唤醒呢？因为没休眠吗？
                            try{
                                lock20.wait();
                            }catch(InterruptedException e){
                                e.printStackTrace();
                            }
                        }
                        System.out.println("被唤醒了。开始消费");
                        while(count > 0){
                            System.out.println("消费：" + count-- );
                        }
                    }
                }

            }
        };
        /*又考虑到一个问题，两个线程需要共享count，也要共享锁。但执行的操作不同所以不能用同一个Runnable对象
        * 所以count和lock都通过构造器传递吧，因为是自定义的线程类*/

        /*重大问题 ● count 是一个 int。
而 int 是基本数据类型，传给构造方法时是传值。改成Integer也不行，因为这是不可变的，修改的话又是创建一个新的引用
只能继续之前的想法，就是在同一个类方法里匿名内部类两个线程*/
//        Producer pro = new Producer(lock20, count);
//        Consumer con = new Consumer(lock20, count);
        pro.start();
        con.start();//两个线程同时进行。什么时候停止？设置一个生产者累计生产了20个就停止，
        // 消费者这边没等到唤醒就无限等待,生产者那边累计够了进入判断就不再生产
        /*？疑问：线程还会存在吗？好像只是不进行什么有效操作而已，两个线程还都是存在的，没有被终止
        * 没学到什么终止，run自然结束就是终止*/

    }
// 21. wait带参数
// 创建线程获取共享锁后调用wait(3000)。
// 3秒内没有被唤醒时自动继续执行，并输出线程恢复运行的提示。
    private static void demo21(){
        /*分析，这里不需要特殊的写，只要wait这种可以被提前唤醒的就行
        * 要使用wait就一定有锁对象，就用同步代码块*/
        /*谁来唤醒呢?再写一个唤醒的线程，两个线程使用同一个锁对象*/
        Thread wait = new Thread(() -> {
            synchronized (lock) {
                try{
                    lock.wait(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("3s睡醒了，恢复执行");
            }
        },"等3s线程");
        Thread wake = new Thread(() -> {
            synchronized (lock) {
                lock.notify();
                System.out.println("唤醒睡3s线程");
            }
        }, "唤醒线程");

        wait.start();
        wake.start();

    }
// 22. 查看线程状态
// 创建一个Thread对象但不要立即调用start()。
// 分别在创建线程后、线程启动后输出thread.getState()的结果。
    private static void demo22(){
        Thread t = new Thread("demo22线程");
        System.out.println(t.getState());
        t.start();
        System.out.println(t.getState());
    }
// 23. 制造BLOCKED状态
// 创建两个线程使用同一个锁对象。
// 让线程A持有锁并sleep一段时间，同时让线程B尝试获取同一把锁。
    private static void demo23(){
        Object lock = new Object();
        Thread A = new Thread(() -> {
            synchronized(lock){
                try{
                     Thread.sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("线程A睡醒了");
            }

        }, "线程A");//等于是重写了匿名Runnable实现类

        Thread B = new Thread("线程B"){
            @Override
            public void run() {

//                System.out.println(Thread.currentThread().getName() +
//                        "线程B状态：" + Thread.currentThread().getState());
                synchronized (lock) {
                    System.out.println("B获取到了锁");
                }
                //获取不到的状态怎么输出
//                System.out.println(Thread.currentThread().getName() +
//                        "状态：" + Thread.currentThread().getState());


            }

        };
        A.start();
//        try{
//            Thread.sleep(5000);
//
//        }catch(InterruptedException e){
//            e.printStackTrace();
//        }
        /*要查看B的BLOCKED状态只能用第三个线程，或者调试控制台*/
        B.start();

        new Thread(() -> {
//            try{
//                Thread.sleep(5000);
//            }catch(InterruptedException e){
//                e.printStackTrace();
//            }
            while (B.getState() != Thread.State.TERMINATED) {
                System.out.println("C检测B状态：" + B.getState());
                try{
                    Thread.sleep(2000);//睡一下再检测输出B的状态，不然输出的太频繁
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
// 24. 综合线程状态练习
// 创建线程并依次让它经历新建、可运行、计时等待和终止等状态。
// 在合适的时间输出thread.getState()观察状态变化。
    private static void demo24(){
        //终止就是自然结束了run方法执行完了，while(true)不会自然结束，
        // 最好是用while(running)改变running为flase来终止程序
        Thread A = new Thread(() -> {
            for(int i = 0; i < 10; i++){
                System.out.print(i + ",");
            }
            //System.out.println("A线程状态：" + Thread.currentThread().getState());

            try{
                Thread.sleep(5000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }

        },"demo24线程");
       // System.out.println("A线程状态：" + A.getState());//NEW
        A.start();

        new Thread(() -> {
            while(A.getState() != Thread.State.TERMINATED){
                System.out.println("A线程状态：" + A.getState());
                try{
                    Thread.sleep(1000);//停的不短不长，不要一个状态输出太多次
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }


            System.out.println("A线程状态：" + A.getState());

        },"检测A状态的线程").start();
    }

    public static void main(String[] args) {
//        demo01();
//        demo02();
//        demo03();
//        demo04();
//        demo05();
//        demo06();
//        demo07();
//        demo08();
//        demo09();
//        demo10();
//        demo11();
//        demo12();
//        demo13();
//        demo14();
//        demo15();
//        demo16();
//        demo17();

//        demo18();
//        demo19();

//        demo20();老大难

//        demo21();
//        demo22();
//        demo23();
        demo24();
    }

}
