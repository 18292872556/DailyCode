package Advanced.Day05_异常_线程.Review01_Aug12;

import javax.security.auth.login.LoginException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/12/下午6:03
 * @Description:
 */
public class MainTest {
    //题目1：创建一个数组越界异常。
//要求：使用try-catch捕获ArrayIndexOutOfBoundsException。
    public static void demo01(){
        int[] arr = {1,2,3};
        try{
            int num = arr[3];
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }
    //题目2：创建一个除0异常。
//要求：使用try-catch捕获ArithmeticException并处理。
    public static void demo02(){
        try{
            int num = 10/0;
        }catch(ArithmeticException e){
            e.printStackTrace();
        }
    }
//题目3：测试try-catch-finally执行顺序。
//要求：分别在三个代码块输出内容，观察执行结果。
public static void demo03(){
    //资源释放？只能用流了

    try {
        int num = 10/0;
    }catch(Exception e){
        e.printStackTrace();
    }finally{
        System.out.println("demo03结束");
    }
}

//题目4：验证finally一定执行。
//要求：try中主动抛出异常，观察finally是否执行。
    public static void demo04(){
        try{
            int[] arr = {1,2,3};
            int num = arr[3];
            System.out.println("try中输出");
        }finally{
            System.out.println("demo04结束");
        }
    }

//题目5：使用throw主动抛出异常。
//要求：年龄小于0时手动抛出异常。
    public static void demo05()throws AgeException{
        People p1 = new People(01, "Barbie", 19);
        People p2 = new People(01, "Barbie", -2);
        People p3 = new People(01, "Barbie", 9);
        List<People> peopleList = new ArrayList<>();
        peopleList.addAll(Arrays.asList(p1, p2, p3));
        for(People p : peopleList){
            if(p.age < 0){
                throw new AgeException();
            }
        }
    }

//题目6：使用throws声明异常。
//要求：定义方法抛出异常，由调用者处理。
    private static void demo06()throws Exception{
        int num = 10/0;
    }

//题目7：编写多个catch捕获不同异常。
//要求：分别处理数组越界和除0异常。
    private static void demo07(){
        try{
            int num = 10/0;

            int[]arr = {1,2,3};
            int num2 = arr[3];
        }catch(ArithmeticException e){
            e.printStackTrace();
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }

//题目8：调整多个catch顺序。
//要求：验证父类异常不能写在子类异常前面。
    private static void demo08(){
        try{
            int num = 10/0;

            int[]arr = {1,2,3};
            int num2 = arr[3];
        }catch(ArithmeticException e){
            e.printStackTrace();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

//        try{
//            int num = 10/0;
//
//            int[]arr = {1,2,3};
//            int num2 = arr[3];
//        }catch(Exception e){
//            e.printStackTrace();
//        }catch(ArrayIndexOutOfBoundsException e){//红线，编译错误
//            System.out.println(e.getMessage());
//        }
    }


//题目9：编写方法测试RuntimeException。
//要求：观察运行时异常是否必须强制处理。不是
    private static void demo09(){
        String name = null;
        System.out.println(name.length());//RuntimeException不用处理,但会中断程序
    }

//题目10：编写方法测试Checked异常。
//要求：调用可能产生IOException的方法并处理。
    private static void demo10(){
        try{
            FileOutputStream fout = new FileOutputStream("ReviewJavaSE\\src\\Advanced\\Day05_异常_线程\\Review01_Aug12\\demo10.txt");
            fout.write("demo10输出的文件".getBytes());
        }catch(IOException e){
            e.printStackTrace();
        }
    }

//题目11：创建自定义异常类AgeException。
//要求：继承Exception并添加构造方法。
    private static void checkAge(int age)throws AgeException{
        if(age < 0){
            throw new AgeException("年龄不可<0");
        }
    }

    private static void demo11(){
        People p1 = new People(01, "Barbie", 19);
        People p2 = new People(02, "Barbie", -3);

        try{
            checkAge(p2.age);
            System.out.println("年龄正常");
        }catch(AgeException e){
            e.printStackTrace();
        }
    }


//题目12：使用AgeException校验年龄。
//要求：年龄不符合要求时抛出自定义异常。
    private static void demo12(){
        People p1 = new People(01, "Barbie", -2);
        People p2 = new People(01, "Barbie", 19);
        try{
            checkAge(p1.age);
            checkAge(p2.age);
        }catch(AgeException e){
            e.printStackTrace();
        }
    }

//题目13：模拟用户注册功能。
//要求：用户名为空时抛出自定义注册异常。
    private static void checkRegister(String uname)throws RegisterException{
        if(uname == null || uname.isEmpty()){
            throw new RegisterException("用户名不可为空");
        }
    }
    private static void demo13(){
        System.out.println("模拟注册，请输入用户名");
        Scanner sc = new Scanner(System.in);
        //sc的所有接收方法里，只有nextLine()是读取当前行的可能读到空字符串
        String uname = sc.nextLine();

        try{
            checkRegister(uname);

        }catch(RegisterException e){
            e.printStackTrace();
        }

        try{
            checkRegister(null);
        }catch(RegisterException e){
            e.printStackTrace();
        }

    }

    //题目14：编写数组索引查询方法。
//要求：方法接收数组和索引并返回元素，传入错误索引，分析异常产生位置及调用链传递过程。
    private static int getElement(int index, int... arr){
        int element = arr[index];

        return element;

    }
    private static void demo14(){
        int num;
        try {
            num = getElement(9, 1, 4, 2, 35, 3, 90);
            System.out.println("获取到的元素为" + num);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    /*分析异常产生和传递过程：
    ①196调用192
    ②192行产生异常，因为索引越界，产生ArrayIndexOutOfBoundsException。
    这个异常JVM认识，Java本身对此有描述，内容包括异常名称，内容，产生位置
    会把这些信息封装到异常对象中。new ArrayIndexOutOfBoundsException(9)
    ③JVM把这个异常抛回给调用者也就是196行
    ④继续把这个异常抛给最初调用者main()方法,main方法没有处理异常，就会继续把异常抛给调用者JVM
    当JVM收到异常后，将异常中的名称、异常内容、位置都显示在控制台，同时使程序立刻终止*/

//题目15：使用printStackTrace查看异常信息。
//要求：输出异常类型、原因和代码位置。
    private static void demo15(){
        try{
            int num = 10/0;
        }catch(Exception e){
            e.printStackTrace();//打印异常的类型，原因，出现的位置
            System.out.println(e.getMessage());//原因
        }
    }

//题目16：分析Error和Exception区别。
//要求：分别举出属于两者的异常类型。
    private static void demo16()throws ArithmeticException{
        //Error是错误，程序员无法处理，只能避免。异常Exception是可以捕获处理
        /*int[] arr = new int[Integer.MAX_VALUE];//OutOfMemoryError内存不足错误

        int num = 10/0;*/
    }

//题目17：判断异常处理方式。
//要求：区分哪些异常需要try-catch，哪些可以不用。
    private static void demo17(){
        //RuntimeException可以不处理也能通过编译运行，只是也会终止程序
        //例如空指针，数组越界异常，字符串越界，数学异常，数字格式化异常

        //Exception必须处理，认为是编译时异常
        //IO输入输出异常，解析异常，文件不存在异常
    }

//题目18：使用finally关闭资源。
//要求：模拟资源对象，在finally中完成关闭操作。
    private static void demo18(){
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream("ReviewJavaSE/src/Advanced/Day05_异常_线程/Review01_Aug12/demo18.txt");
            fos.write("demo18输出的文件".getBytes());
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(fos != null){
                try{
                    fos.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }

        }
    }

//题目19：使用try-with-resources关闭流。
//要求：创建资源对象并验证自动关闭。
    private static void demo19(){
        //指的就是jdk7之后可以自动释放资源的写法
        try(FileOutputStream fos = new FileOutputStream("ReviewJavaSE/src/Advanced/Day05_异常_线程/Review01_Aug12\\demo19.txt")){
            fos.write("demo19输出的文件".getBytes());
        }catch(IOException e){
            e.printStackTrace();
        }
    }


//题目20：综合异常处理。
//要求：模拟登录流程并使用多种异常处理机制。
    /*思路：注册用户名异常，用户名为空，用户名重复
    * 登录，用户名不存在异常，密码错误异常*/

    static LinkedHashMap<String, String> unamePassMap = new LinkedHashMap<>();
    private static void logIn(){
        int flag = 0;
        System.out.println("登录请输入用户名和密码：");
        Scanner sc = new Scanner(System.in);
        String uname = sc.next();
        String pass = sc.next();
        try{
            if(uname == null || uname.isEmpty() || pass == null || pass.isEmpty()){
                throw new LoginException("用户名和密码不可为空");
            }else if(unamePassMap.containsKey(uname) == false){
                throw new LoginException("用户名不存在");
            }else if(unamePassMap.get(uname) != pass){
                throw new LoginException("密码错误");
            }
        }catch(LoginException e){
            flag = 1;
            e.printStackTrace();
        }finally{
            if(flag == 1){//说明登录失败，重新登录
                logIn();
            }
        }
        System.out.println("用户" + uname +"登录成功");

    }
    private static void signUp(){
        int flag = 0;
        System.out.println("请输入要注册的账号和密码，回车隔开，在6到12个字符之间的长度：");
        Scanner sc = new Scanner(System.in);
        String uname = sc.next();
        String pass = sc.next();
        try{
            if(uname == null || uname.isEmpty() || pass == null || pass.isEmpty()){
                throw new RegisterException("用户名和密码都不可为空，请重新输入");
            }
            if(uname.length() > 12 || pass.length() > 12){
                throw new RegisterException("用户名或密码长度过长，请重新输入");
            }
            if(uname.length() < 6 || pass.length() < 6 ){
                throw new RegisterException("用户名或密码长度过短，请重新输入");
            }
            if(unamePassMap.containsKey(uname)){
                throw new RegisterException("用户名重复，请重新输入");
            }
        }catch(RegisterException e){
            flag = 1;//说明注册失败
            e.printStackTrace();
        }finally{
            if(flag == 1){
                signUp();
            }
        }
        //走到这没有被终止，说明注册成功
        System.out.println("注册成功");
        unamePassMap.put(uname, pass);
    }

    private static void demo20(){
        //已存在的用户和密码

        unamePassMap.put("Barbie", "1231#@!");
        unamePassMap.put("Ken", "1231#@!");

        int flag = 0;
        while(0 == flag){
            System.out.println("请选择要进行的操作：1.登录，2.注册,3.退出。输入对应数字即可例如：1");
            Scanner sc = new Scanner(System.in);
            int choose = sc.nextInt();
            if(choose == 1){
                //开始登录
                logIn();
            }
            if(choose == 2){
                //开始注册
                signUp();
            }
            if(choose == 3){
                flag = 1;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        demo01();
        demo02();
        demo03();
        try {
            demo04();
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            demo05();
        }catch (AgeException e){
            e.printStackTrace();
        }

        try {
            demo06();
        }catch(Exception e) {
            e.printStackTrace();
        }
            demo07();
            demo08();

        try{
            demo09();
        }catch (Exception e){
            e.printStackTrace();
        }

//            demo10();
//            demo11();
//            demo12();
//            demo13();
//            demo14();
//            demo15();
//            demo16();
//            demo17();
//            demo18();
//            demo19();
            demo20();

    }
}
