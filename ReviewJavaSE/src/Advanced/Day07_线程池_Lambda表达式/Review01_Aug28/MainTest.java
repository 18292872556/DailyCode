package Advanced.Day07_线程池_Lambda表达式.Review01_Aug28;


import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/28/下午4:10
 * @Description:
 */
public class MainTest {
    // Day06 线程、同步、线程状态练习题
// 要求：每题独立完成；题目只给要求，不给实现步骤。
// 避免重复考察同一个知识点或完全相同的代码写法，并覆盖本章主要知识点。
    /*齐思： 接口重写实现都用Lambda*/

// 01. 继承Thread创建线程
// 自定义线程类，接收线程名称并重写run()。
// 启动线程后输出线程名称和0~9，观察main线程与子线程的执行顺序。
private static void demo01(){
    Thread t1 = new Thread(() -> {
        for(int i = 0; i < 10; i++){
            System.out.println(i);
        }
    });

    t1.start();

    //main线程
    for(int i = 11; i < 20; i++){
        System.out.println(i);
    }

}

// 02. 使用Thread构造方法创建带名称的线程
// 使用Runnable作为任务，并通过Thread(Runnable,String)指定线程名称。
// 在线程中输出当前线程名称以及一段任务信息。
    private static void demo02(){
        Thread t1 = new Thread(() -> System.out.println("demo02的runnable重写run方法"), "demo02线程");
    }

// 03. 验证start()与run()的区别
// 创建一个线程对象，分别观察直接调用run()和调用start()时的执行效果。
// 要求通过输出当前线程名称判断代码究竟由哪个线程执行。
    /*这个还真不知道区别，课件里好像没讲*/
    private static void demo03(){
        Thread t1 = new Thread(() -> {
            System.out.println("demo03重写run的信线程,观察run和start方法区别");
        },"demo03线程");

        t1.run();
        t1.start();
    }

// 04. 获取当前线程对象
// 在线程任务中分别使用getName()和Thread.currentThread()获取线程信息。
// 输出“线程名称：xxx，线程对象：xxx”，观察Thread对象字符串中的信息。
    private static void demo04(){
        System.out.println("线程名称：" + Thread.currentThread().getName());
        System.out.println("线程对象：" + Thread.currentThread());
    }

// 05. 使用匿名内部类创建两个不同任务的线程
// 不单独定义Runnable实现类，直接创建两个线程并分别指定不同任务。
// 要求两个线程名称不同，并让两个任务同时开始执行。
    /*感觉和Day06考察的好像差不多？主要应该是多了Lambda和线程池，速战速决吧*/
    private static void demo05(){
        Thread t1 = new Thread(() -> {
            System.out.println("run() -> demo05线程1在run");
        },"demo05线程1");
        Thread t2 = new Thread(() -> {
            System.out.println("run() -> demo05线程2在run");
        },"demo05线程2");
        t1.start();
        t2.start();
    }

// 06. 使用同一个Runnable对象创建两个线程
// 创建一个Runnable任务对象，再使用它创建两个Thread线程。
// 在任务中维护一个成员变量并输出变化，观察两个线程是否共享该Runnable对象的数据。
    private static void demo06(){
        Runnable r = new Demo06Runnable();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
    }

// 07. 验证sleep()作用于当前线程
// 创建线程A，让A在执行过程中sleep 2秒；main线程不要sleep。
// 输出A睡眠前后的信息，观察sleep期间main线程是否仍能继续执行。
    private static void demo07(){
        System.out.println(Thread.currentThread().getName());//输出main的状态
        System.out.println(Thread.currentThread().getState());

        Thread A = new Thread(() -> {
            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        },"线程A");
        A.start();

        System.out.println(Thread.currentThread().getName());//输出main的状态
        System.out.println(Thread.currentThread().getState());
        /* ● 疑惑： 怎么获取到main的名字直接访问状态？万一此刻获取的线程不是main是A呢？*/

    }

// 08. 设计一个简单的“交错执行”效果
// 创建两个线程分别循环输出A0~A9和B0~B9，并在循环中加入短暂sleep。
// 不要求严格交替，只观察两个线程是否会出现交错执行。
    private static void demo08(){
        Thread t1 = new Thread(() -> {
            try{
                Thread.sleep(3000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            for(int i = 0; i < 10; i++){
                System.out.println('A' + i);
            }
        }, "demo08的A线程");
        Thread t2 = new Thread(() -> {
            try{
                Thread.sleep(3000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            for(int i = 0; i < 10; i++){
                System.out.println('B' + i);
            }
        }, "demo08的B线程");

        t1.start();
        t2.start();

    }

// 09. 制造线程安全问题
// 使用一个Runnable对象保存100张票，创建三个窗口线程同时卖票。
// 故意不加同步控制，观察是否可能出现重复售票或卖出不存在的票。
    private static void demo09(){
        Runnable runnable = new Demo09Runnable();
        Thread t1 = new Thread(runnable, "窗口1");
        Thread t2 = new Thread(runnable, "窗口2");
        Thread t3 = new Thread(runnable, "窗口3");
        t1.start();
        t2.start();
        t3.start();
    }

// 10. 验证共享资源的竞态问题
// 创建两个线程操作同一个共享计数器，分别执行1000次count++。
// 运行多次并观察最终结果，思考为什么结果可能小于预期值。
    private static void demo10(){
//        Runnable r = new Runnable(){
//            private int count;
//            @Override
//            public void run() {
//                for(int i = 0; i < 1000; i++){
//                    count++;
//                };
//            }
//        };
//
//        Thread t1 = new Thread(r, "demo10线程1");
//        Thread t2 = new Thread(r, "demo10线程2");
//        t1.start();
//        t2.start();
        /*因为这里要求的是两个线程操作同一个共享计数器，既然共享了，就不存在分别执行1000次count，
        而是共同执行1000次所以结果？等下，好像并不是这道题的思路。重写*/
        Demo10Runnable r1 = new Demo10Runnable();
        Demo10Runnable r2 = new Demo10Runnable();
        Thread t1 = new Thread(r1, "demo10线程1");
        Thread t2 = new Thread(r2, "demo10线程2");
        /*这里把Demo10Runnable里的count定义为static类型，这样r1，r2就共享这个资源，但是因为
        * 是不同的对象，所以操作也是独立进行，可以完成分别+1000的任务，而不是合在一起+1000次*/
        t1.start();
        t2.start();
        System.out.println("r1最终的count：" + r1.getCount());
        System.out.println("r2最终的count：" + r2.getCount());

        /*分析为什么最后结果可能小于2000,因为count++不是一个原子操作，不是不可分割的
        * 没有写同步的话，就是两个线程抢CPU抢来抢去，可能t1线程刚刚读到count刚刚读取到是0，然后准备+1,
        * 就被t2线程抢走了然后t2那边读到count=0,+1结果是1。回到t1其实这个时候count已经是1了
        * 但是因为被抢之前t1读到的count是0，所以+1后依然记得是1.等于白+*/
    }

// 11. 使用同步代码块解决售票问题
// 在共享票数基础上，用synchronized代码块保护“判断+修改”操作。
// 三个线程共同售卖100张票，要求不能出现重复票和负数票。
    private static void demo11(){
//        Runnable r1 = () -> {
//
//        };哦不能这样写，因为有成员变量
        Runnable runnable = new Runnable(){
            private int count = 20;
            Object lock = new Object();
            @Override
            public void run() {
                synchronized(lock){
                    while(count > 0){
                        try{
                            Thread.sleep(3000);//模拟出票时间3s
                        }catch(InterruptedException e){
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() +
                                "正在卖：" + count--);
                    }
                }

            }
        };

        Thread t1 = new Thread(runnable, "窗口1");
        Thread t2 = new Thread(runnable, "窗口2");
        Thread t3 = new Thread(runnable, "窗口3");
        t1.start();
        t2.start();
        t3.start();
    }

// 12. 使用指定锁对象保护共享资源
// 创建一个独立Object作为锁，两个线程访问同一个共享计数器。
// 要求同步代码块使用同一个锁对象，验证两个线程是否能互斥执行。
    private static void demo12(){
        /*首先思考，怎么验证互斥执行，就是不会互相抢占？
        还是用count++来验证，一个+的时候另一个无法访问就无法拆分，可以正常的加够*/
        Runnable runnable = new Runnable(){
            private int count = 0;
            @Override
            public void run() {
                synchronized(this){
                    for(int i = 0; i < 10; i++){
                        System.out.println(Thread.currentThread().getName() +
                                "正在：" + count++);
                    }
                }
            }
        };

        Thread t1 = new Thread(runnable, "demo12线程1");
        Thread t2 = new Thread(runnable, "demo12线程2");

        t1.start();
        t2.start();
    }

// 13. 观察不同锁对象的效果
// 创建两个内容相同但不是同一个对象的锁，让两个线程分别使用它们同步。
// 在同步代码块中sleep一段时间，观察两个线程是否仍可能同时执行。
    /*咋观察是不是同时执行呢？同步里写的循环输出，如果同时进行，
    输出就是不是一次性循环完。而是中间被穿插另一个线程的输出。就这样验证吧*/
    private static void demo13(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                synchronized(this){
                    for(int i = 0; i < 10; i++){
                        System.out.println(i);
                    }
                }
            }
        };
        Runnable r2 = new Runnable() {
            Object lock = new Object();
            @Override
            public void run() {
                synchronized(lock){
                    for(int i = 0; i < 10; i++){
                        System.out.println(i);
                    }
                }
            }
        };

        Thread t1 = new Thread(r1, "demo13线程1");
        Thread t2 = new Thread(r1, "demo13线程2");
        t1.start();
        t2.start();
    }

// 14. 使用synchronized实例方法
// 创建共享Runnable对象，将修改共享数据的操作封装为synchronized实例方法。
// 创建多个线程调用该方法，验证实例方法隐含的锁对象是谁。
    private static int count = 0;
    private  static synchronized void counter(){
        for(int i = 0; i < 10; i++){
            System.out.println(count++);//每个线程都分别+10次
        }
        System.out.println("锁对象是：" + Thread.currentThread().getName());
    }
    private static void demo14(){
        /*咋验证实力方法隐含的锁对象？一般实例同步方法的锁就是类对象本身this，
        static类型的锁对象就是类名.class。到时候输出一下正在运行的线程名就行*/
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                counter();
            }
        };

        Thread t1 = new Thread(r1, "demo14线程1");
        Thread t2 = new Thread(r1, "demo14线程2");
        Thread t3 = new Thread(r1, "demo14线程3");
    }

// 15. 使用static synchronized方法
// 创建static共享计数器，并使用static synchronized方法修改它。
// 使用多个线程调用该方法，思考static同步方法锁住的是哪个对象。
    /*是类名.class*/
    private static int flag = 0;
    private static synchronized void flager(){
        for(int i = 0; i < 10; i++){
            System.out.println(flag++);
        }
        System.out.println("锁对象：" + Thread.currentThread().getName());
    }
    private static void demo15(){
        Runnable runnable = () -> flager();
        Thread t1 = new Thread(runnable, "demo15线程1");
        Thread t2 = new Thread(runnable, "demo15线程2");
        Thread t3 = new Thread(runnable, "demo15线程3");

        t1.start();
        t2.start();
        t3.start();
    }

// 16. 对比实例同步方法与静态同步方法
// 分别创建实例同步方法和static同步方法，并让线程同时调用。
// 通过注释说明两者的锁对象分别是什么，并判断两者是否使用同一把锁。
    private synchronized static void syn01(){
        /*static的锁对象是类名.class*/
        System.out.println("static同步方法的锁对象是：" + Thread.currentThread().getName());
    }
    private synchronized  void syn02(){
        /*实例方法的锁对象是 this 就是new MainTest()*/
        System.out.println("static同步方法的锁对象是：" + Thread.currentThread().getName());

    }
    private static void demo16(){
        Runnable runnable = () -> {
            syn01();
            new MainTest().syn02();
        };

        Thread t1 = new Thread(runnable);
        t1.start();
    }

// 17. 使用ReentrantLock解决线程安全
// 使用ReentrantLock保护共享票数，多个线程共同卖票。
// 要求正确调用lock()和unlock()，观察加锁后的执行效果。
    private static void demo17(){
        Runnable runnable = new Runnable() {
            int count = 20;
            @Override
            public void run() {
                ReentrantLock lock = new ReentrantLock();
                lock.lock();
                while(count > 0){
                    try{
                        Thread.sleep(3000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在卖："
                    + count--);
                }
                lock.unlock();
            }
        };

        Thread t1 = new Thread(runnable, "窗口1");
        Thread t2 = new Thread(runnable, "窗口2");
        Thread t3 = new Thread(runnable, "窗口3");
        t1.start();
        t2.start();
        t3.start();
    }

// 18. 对比Lock与synchronized
// 使用ReentrantLock改写一个同步代码块中的临界区。
// 在注释中说明Lock需要显式加锁、释放锁，而synchronized由语法结构管理锁。
   // 就是把 synchronized { 共享数据操作 } 这种同步代码块，改写成 Lock.lock() +
// try { 共享数据操作 } finally { Lock.unlock() }。
    /*这题目没啥意义，直接改成包子铺和吃包子算了*/
    private static void demo18(){
        /*不懂啥意思，问了出题gpt给出了新的解释。就是要finally*/
        //因为上节20题的等待唤醒很费时间，写的很差。这里也不知道要写什么案例，所以这里复刻一次
        //按照包子铺和吃包子的食客来写这个互相的等待唤醒，要求是做一个包子就吃一个
        //没有多余的囤积
        //并且把同步方法改成lock锁，在finally多加一层保险。防止出现异常不释放锁对象
//        BaoZi bz = new BaoZi("");
//        Thread 包子铺 = new Thread(() -> {
//
//        });
//        Thread 食客 = new Thread(() -> {
//
//        });

        Demo18BaoZi bz = new Demo18BaoZi();
        Demo18BaoZiPu baoZiPu = new Demo18BaoZiPu(bz);
        Demo18ShiKe shiKe = new Demo18ShiKe(bz);
        baoZiPu.start();
        shiKe.start();

    }

// 19. 观察NEW与RUNNABLE状态
// 创建线程但先不要启动，输出它的状态；调用start()后再尝试观察状态。
// 必要时在run()中加入sleep，让RUNNABLE状态更容易被观察。
    private static void demo19(){
        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 10; i++){
                System.out.println(i);
            }
        }, "demo19线程1");
        //不启动t1又要观察她的状态，只能用另一个线程来观察她的状态并输出
        Thread t2 = new Thread(() -> {
            while(true){
                System.out.println("t1的状态 ：" + Thread.currentThread().getState());
            }
        }, "demo19线程2");
        t2.start();
        t1.start();
    }

// 20. 观察TIMED_WAITING状态
// 创建一个线程，在run()中调用Thread.sleep(3000)。
// 使用另一个线程持续观察目标线程状态，记录其进入TIMED_WAITING以及之后恢复的状态。
    private static void demo20(){
        Thread t1 = new Thread(() -> {
            try{
                Thread.sleep(3000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }, "线程1");
        Thread t2 = new Thread(() -> {
            while(true){
                System.out.println("demo20t1的状态：" + t1.getState());
            }
        }, "线程2");
        t2.start();
        t1.start();
    }

// 21. 观察BLOCKED状态
// 让线程A持有同一个锁并sleep较长时间，再让线程B尝试进入该同步代码块。
// 使用第三个线程观察B的状态，尽可能捕获B处于BLOCKED的时刻。
    static Object obj = new Object();
    private static void demo21(){
        Thread A = new Thread(()->{
            synchronized(obj){
                try {
                    Thread.sleep(5000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }, "A");

        Thread B = new Thread(()->{
            synchronized(obj){
                System.out.println("B获取到同步锁");
            }
        }, "B");

        Thread C = new Thread(()->{
            long begin = System.currentTimeMillis();
            while(true){
                System.out.println("B的状态：" + B.getState());
                long end = System.currentTimeMillis();
                if(end - begin > 5000){
                    break;
                }
            }//因为只想输入一段时间不想一直无限循环，考虑有没有计时器类似的写法

        }, "C");

        C.start();
        A.start();
        B.start();
    }

// 22. 理解sleep与锁的关系
// 让线程A在synchronized代码块中sleep 3秒，同时让线程B尝试获取同一把锁。
// 观察A睡眠时是否仍然持有锁，并记录B的状态变化。
    /*怎么观察A睡眠时是否仍然持有锁？同时检测他两的状态*/
    private static void demo22(){
        Thread A = new Thread(()->{
            synchronized(obj){
                try{
                    Thread.sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("A睡醒了");
            }
        }, "线程A");
        Thread B = new Thread(()->{
            synchronized(obj){
                System.out.println("B获取到锁");
            }
        }, "线程B");

        Thread C = new Thread(()->{
            long begin = System.currentTimeMillis();
            while(true){
                System.out.println("A的状态：" + A.getState());
                System.out.println("B的状态：" + B.getState());
                long end = System.currentTimeMillis();
                if(end - begin > 5000){
                    break;
                }
            }

        }, "线程C");

    }


// 23. 使用wait()进入WAITING
// 创建两个线程共享同一个锁，线程A在同步代码块中调用wait()。
// 使用另一个线程观察A的状态，确认A进入WAITING后不再继续执行后面的代码。
    private static void demo23(){
        Thread A = new Thread(()->{
            synchronized(obj){
                try{
                    obj.wait();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("wait后的代码");
            }
        });
        Thread B = new Thread(()->{
            System.out.println("A的状态：" + A.getState());
        });

        A.start();
        B.start();
    }
// 24. 使用notify()唤醒等待线程
// 在上一题基础上，让线程B获取同一把锁后调用notify()。
// 观察A被唤醒后的状态以及它是否会立即继续执行。
    /*怎么叫被唤醒后是否会立即执行，这怎么观察得到啊？只能debug调试还是根据输出判断？*/
    private static void demo24(){
        //或者就让C线程不跟A,B用同一把锁。然后一直观察A的状态，循环重复输出A的状态
        //如果A被唤醒了，那就是从Waiting到RUN或者BLOCKED,如果能检测到A有BLOCKED状态
        //说明没有立刻执行，因为没有立刻获取到锁
        Thread A  = new Thread(()->{
            synchronized(obj){
                try{
                    obj.wait();

                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        Thread B = new Thread(()->{
            synchronized(obj){
                obj.notify();
            }
        });

        //优化计时写法，学了gpt的提醒还可以把重复状态过滤掉，这就是我之前想做的！
        Thread C = new Thread(()->{
        long end = System.currentTimeMillis() + 5000;
        Thread.State lastState = null;
            while(System.currentTimeMillis() < end){
                Thread.State currentState = A.getState();
                if(currentState != lastState){
                    System.out.println("A的状态：" + A.getState());
                    lastState = currentState;
                }
            }

        });
    }
// 25. 理解wait()会释放锁
// 让线程A获取锁后调用wait()，让线程B随后尝试进入同一个同步代码块。
// 通过输出证明A进入WAITING后，B可以获得原本由A持有的锁。
    private static void demo25(){
        Thread A = new Thread(()->{
            synchronized(obj){
                System.out.println("A获取到锁");
                try{
                    obj.wait();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("A被唤醒");
            }
        });
        //思考这个唤醒怎么写，首先，等待和唤醒都是在同步代码块中的写法
        //因为等待和唤醒的都是同步中的交互。那有个问题一直没获取到锁的话就无法进入同步代码块
        //又怎么样才能执行唤醒操作呢，wait会释放锁，不像sleep
        Thread B = new Thread(()->{
            synchronized(obj){
                System.out.println("B获取到锁");
                if(A.getState() != Thread.State.WAITING){
                    obj.notify();
                    System.out.println("B唤醒A,也说明A在WAITING状态，B是能获取到锁的。wait()会释放锁对象");
                }
            }
        });
    }

// 26. 理解被notify后的重新竞争
// 让A调用wait()进入等待，B调用notify()后继续持有锁一段时间。
// 观察A被通知后是否能够立刻执行，记录A可能经历的状态变化。
    /*A当然不能立即执行，而是BLOCKED阻塞状态，等待B线程同步代码块执行完成才能获得锁*/
    private static void demo26(){
        Thread A = new Thread(()->{
            synchronized(obj){
                try{
                    obj.wait();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        Thread B = new Thread(()->{
            synchronized(obj){
                obj.notify();
                try{
                    Thread.sleep(5000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        threadTrace(A);
    }
    //在想观察状态这个这几个方法老用，不如封装成一个方法，传要检测状态的线程即可
    private static void threadTrace(Thread t){//连续检测10s
        Thread Trace = new Thread(()-> {
            long end = System.currentTimeMillis() + 10000;
            Thread.State lastState = null;
            while(System.currentTimeMillis() < end){
                Thread.State state = t.getState();
                if(state != lastState){
                    System.out.println(t.getName() + "的状态：" + state);
                    lastState = state;
                }
            }
        });
        Trace.start();
    }

// 27. 使用wait(long)进入TIMED_WAITING
// 创建等待线程调用wait(3000)，不创建主动唤醒线程。
// 观察线程是否会在超时时间结束后自动恢复执行。
    private static void demo27(){
        Thread A = new Thread(()->{
            synchronized(obj){
                try{
                    obj.wait(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("恢复执行");
            }
        });
        A.start();
    }

// 28. 比较wait()与wait(long)
// 分别让两个线程调用wait()和wait(3000)，观察它们进入的状态。
// 思考为什么一个可以自动结束等待，而另一个必须依赖通知。
    private static void demo28(){
        /*因为一个是无限等待，只能唤醒。一个是计时等待，没有唤醒。自己也能醒*/
        Thread t1 = new Thread(()->{
            synchronized(obj) {
                try {
                    obj.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("wait()结束？");
            }
        });
        t1.start();
        Thread t2 = new Thread(()->{
            synchronized(obj) {
                try{
                    obj.wait(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("wait(3000)结束");
            }
        });
        t2.start();

    }
// 29. 验证wait(long)可以提前结束
// 让线程A调用wait(5000)，线程B在较短时间后调用notify()。
// 观察A是否一定等待满5秒，并正确描述“等待结束”的原因。
    private static void demo29(){
        Thread A = new Thread(()->{
            synchronized(obj){
                long begin = System.currentTimeMillis();
                try{
                    obj.wait(5000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                long end = System.currentTimeMillis();
                System.out.println("等了：" + (end - begin) + "ms");
            }
        });
        Thread B = new Thread(()->{
            synchronized(obj){
                obj.notify();
            }
        });
    }
// 30. 生产者消费者基础模型
// 用一个共享int表示生产资料数量：生产者不断增加，消费者没有资料时wait()。
// 生产者生产后notify()，消费者被唤醒后消费资料，要求两个线程共享同一份数据。
    static int num = 0;
    private static void demo30(){
        //共享int，两个线程共享同一份数据。int是值传递，
        // 如果定义成局部变量，无法将线程内部对值的修改传递回来
        //如果考虑在Runnable的实现类里共享，那run方法又无法区分开
        //所以要么把这个int包装到一个单独的类里，作为一个对象的成员变量，或者类的成员变量来访问
        //线程就自定义用构造方法的参数来接收这个类对象或类的成员变量int
        //要么直接写在当前这个类里做成员变量，然后当前方法匿名内部类重写线程，也可以访问到这个变量

        Thread pro = new Thread(()->{
            for(int i = 0; i < 10; i++){
                synchronized(obj){
                    System.out.println("生产者生产第：" + ++num);
                    obj.notify();
                }
            }
        });
        Thread con = new Thread(()->{
            while(true){
                synchronized(obj){
                    if(num == 0){
                        try{
                            obj.wait();
                        }catch(InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    //开始消费
                    System.out.println("消费者消费第:" + num--);
                }
            }

        });

        pro.start();
        con.start();
    }

// 31. 修正消费者的等待条件
// 在生产者消费者模型中，消费者不能只使用if判断一次是否有数据。
// 使用while重新检查条件，避免被唤醒后条件已经不满足仍继续消费。

// 32. 设计生产结束条件
// 生产者累计生产指定数量后自然结束，消费者在没有资料且生产已经结束时也应退出。
// 要求增加一个“生产是否结束”的共享状态，并通过锁保证判断和修改安全。

// 33. 综合观察线程状态
// 设计程序观察目标线程经历NEW、RUNNABLE、TIMED_WAITING、BLOCKED、WAITING等状态。
// 使用其他线程观察目标线程，并在注释中写出每种状态产生的原因。

// 34. 判断线程何时真正终止
// 创建一个执行完run()后自然结束的线程，使用另一个线程观察其状态。
// 输出TERMINATED并说明“线程终止”与“线程对象仍然存在”之间的区别。

// 35. 综合线程同步与状态
// 两个线程竞争同一把锁：A持锁sleep，B等待锁；A释放锁后B继续执行。
// 使用第三个线程观察B的状态变化，并写出B从RUNNABLE到BLOCKED再到RUNNABLE的原因。

    public static void main(String[] args) {
        demo18();
    }
}
