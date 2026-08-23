package Advanced.Day05_异常_线程.Review02_Aug22;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/22/上午9:58
 * @Description:
 */
public class MainTest {
    //题目1：创建一个数组越界异常。
//要求：使用try-catch捕获ArrayIndexOutOfBoundsException。
    private static void demo01(){
        try{
            int[] arr = {1, 2, 3};
            int num = arr[3];
        }catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }

//题目2：创建一个除0异常。
//要求：使用try-catch捕获ArithmeticException并处理。
    private static void demo02(){
        try{
            int num = 10/0;
        }catch(ArithmeticException e){
            e.printStackTrace();
        }
    }

//题目3：测试try-catch-finally执行顺序。
//要求：分别在三个代码块输出内容，观察执行结果。
    private static void demo03(){
        try{
            System.out.println("try中输出1");
            int num = 10/0;
            System.out.println("try中异常后输出2");
        }catch(ArithmeticException e){
            e.printStackTrace();
            System.out.println("catch中输出3");
        }finally{
            System.out.println("finally中输出4");
        }
        /*预估应该是1,3,4*/
    }

//题目4：验证finally一定执行。
//要求：try中主动抛出异常，观察finally是否执行。
    /*一定执行*/

//题目5：使用throw主动抛出异常。
//要求：年龄小于0时手动抛出异常。
    private static void demo05(){
        int[] ageArr = {0,-4,12,31};
        for(int age : ageArr){
            if(age < 0){
                try{
                    throw new Exception(age + "错误，年龄不可小于0");

                }catch(Exception e){
                    System.out.println(e);
                }
                /*最好是try处理，用声明来抛出的话，外部调用方法还是要处理
                * 如果一直不try处理，最终调用的main方法也抛出就会中止程序*/
            }
        }
    }

//题目6：使用throws声明异常。
//要求：定义方法抛出异常，由调用者处理。
    private static void demo06()throws Exception{
        throw new Exception("我就想抛出一个异常");
    }

//题目7：编写多个catch捕获不同异常。
//要求：分别处理数组越界和除0异常。
    private static void demo07(){
        try{
            int num = 10/0;
            int[] arr ={1,2,3};
            num = arr[3];
        }catch(ArithmeticException e){
            e.printStackTrace();
        }catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
        /*猜测这里的输出应该是只捕获了除0异常，因为出现异常后try后的内容不会执行是中断*/
    }

//题目8：调整多个catch顺序。
//要求：验证父类异常不能写在子类异常前面。
    private static void demo08(){
        try{
            int num = 10/0;
        }catch(ArithmeticException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }

//        try{
//            int num = 10/0;
//        }catch(Exception e){
//            e.printStackTrace();
//        }catch(ArithmeticException e){
//            e.printStackTrace();
//        }
        /*错误写法，因为父类异常包含子类，后面的子类异常捕获永不会执行*/
    }

//题目9：编写方法测试RuntimeException。
//要求：观察运行时异常是否必须强制处理。
    private static void demo09(){
        int num = 10/0;
        //不需要强制处理，但是程序会中断，后续方法都没有运行
    }

//题目10：编写方法测试Checked异常。
//要求：调用可能产生IOException的方法并处理。
    private static void demo10(){
        try{
            FileOutputStream fos1 = new FileOutputStream("ReviewJavaSE/src/Advanced/Day05_异常_线程/Review02_Aug22/demo10.txt");
            fos1.write("demo10输出，题目10要求\n编写方法测试Checked异常\n调用可能产生IOExeption的方法并处理".getBytes());
            fos1.close();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            System.out.println("可以看到IOException这种Checked异常是强制要求处理的\n不处理就标红");
        }
    }

//题目11：创建自定义异常类AgeException。
//要求：继承Exception并添加构造方法。


//题目12：使用AgeException校验年龄。
//要求：年龄不符合要求时抛出自定义异常。
/*一般自定义的异常类，需要单独写一个异常的判定方法*/
private static void checkAgeException(int age)throws AgeException{
    if(age < 0){
        throw new AgeException("年龄不可小于0， 年龄为" + age + "错误");
    }
}
    private static void demo11_12(){
        try{
            checkAgeException(-2);
        }catch(AgeException e){
            e.printStackTrace();
        }
    }

//题目13：模拟用户注册功能。
//要求：用户名为空时抛出自定义注册异常。
    private static void checkRegisterException(String uname)throws RegisterException{
        if(uname == null || uname.trim().equals("")){
            throw new RegisterException("注册异常,用户名不可为空");
        }
    }
    private static void demo13(){
        Scanner sc = new Scanner(System.in);
        System.out.println("demo13----\n模拟注册：注意用户名无法包含空格也不可为空\n请输入符合的用户名");
        String uname = sc.nextLine();

        try {
            checkRegisterException(uname);
            System.out.println("注册成功，用户名为" + uname);
        }catch(RegisterException e){
            e.printStackTrace();
            System.out.println("注册失败");
        }
    }

//题目14：分析异常调用链。
//要求：main调用工具类方法，工具类方法发生异常，观察JVM打印的调用栈。
    /*以demo13为例子分析：
    * 首先是main调用demo13方法，然后demo13在174行调用checkRegisterException(uname)方法
    * 异常发生在164行，然后在方法体163行通过throws抛出到174行调用处
    * 发现有异常然后176行catch捕获处理*/

//题目15：使用printStackTrace查看异常信息。
//要求：输出异常类型、原因和代码位置。
    private static void demo15(){
        /*复习几种输出异常信息的方法
        * e.printStackTrace()是输出异常的原因，位置，类型
        * e.getMessage()是返回字符串，内容是异常发生的原因*/
        try{
            int num = 10/0;
        }catch(ArithmeticException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

//题目16：分析Error和Exception区别。
//要求：分别举出属于两者的异常类型。
    /*一个是错误，不应该通过捕获Error来设计正常的业务逻辑，例如栈溢出（递归没有出口），内存溢出（给数组长度定义Integer.MAX_VALUE）。
    * 会直接终止程序报错，只能改代码避免
    * 异常可以try捕获，不用修改原代码，只是在原代码的基础上加捕获的部分*/
    private static void test(){
        test();
    }
    private static void demo16(){
        //Error
        //int[] ageArr = new int[Integer.MAX_VALUE];
        /*Exception in thread "main" java.lang.OutOfMemoryError: Requested array size exceeds VM limit*/

        //test();
        /*Exception in thread "main" java.lang.StackOverflowError*/

        //Exception
        try {
            FileOutputStream fos = new FileOutputStream("");
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

    }

//题目17：判断异常处理方式。
//要求：区分哪些异常需要try-catch，哪些可以不用。
    /*① Checked类型需要try-catch处理
    * 常见：IOException、 FileNotFoundException
    * ② Runtime类型不需要，不是强制要求处理的，但运行起来有异常还是会终止程序
    * 常见： ArrayIndexOutOfBoundsException
    * NullPointerException、 CalssCastException
    *
    * */

//题目18：使用finally关闭资源。
//要求：模拟资源对象，在finally中完成关闭操作。
    private static void demo18(){
        FileOutputStream fos1 = null;
        try{
             fos1 = new FileOutputStream("ReviewJavaSE/src/Advanced/Day05_异常_线程/Review02_Aug22/demo18.txt");
            fos1.write(1);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }finally{
            if(fos1 != null){
                try{
                    fos1.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }

        }
    }

//题目19：使用try-with-resources关闭流。
//要求：创建资源对象并验证自动关闭。
    private static void demo19()throws IOException{//因为265行fos2的定义写法只能抛出
        //优化
        /*怎么验证自动关闭了？作用域本来就只在try中，再加上try结束资源已经释放了，要在那怎么验证？*/

        try(FileOutputStream fos1 = new FileOutputStream("ReviewJavaSE/src/Advanced/Day05_异常_线程/Review02_Aug22/demo19_1.txt")){
            fos1.write(12);
        }catch(IOException e){
            e.printStackTrace();
        }
        //这个写法是完全无法验证的


        //鸡肋的
        FileOutputStream fos2 = new FileOutputStream("ReviewJavaSE/src/Advanced/Day05_异常_线程/Review02_Aug22/demo19_1.txt");
        try(fos2){
            fos2.write(14);

        }catch(IOException e){
            e.printStackTrace();
        }
        //System.out.println(fos2.write(15));//有异常说明已经关闭流了


        //fos2.write("");
    }

//题目20：综合异常处理。
//要求：模拟登录流程并使用多种异常处理机制。
    /*思路：注册用户名异常，用户名为空，用户名重复
     * 登录，用户名不存在异常，密码错误异常*/
    //写下来注册异常有，用户名长度和密码长度不对，要求[6,12]用户名重复
    //登录异常就是，密码错，用户名不存在

    //想写完善一点就需要判定注册时用户名重复的情况
    static HashMap<String, String> userMap = new HashMap<>();
    //Map<String, String> userMap = Map.of("Barbie","8888","Ken", "12346");
    /* ● 这种创建方式会有一个问题，就是因为不可修改，所以遇到key重复的问题可能会异常
    *并且还有一个问题就是Map只是一个接口，

     *  ●*/
    private static void checkSignUp(String uname, String passWord)throws SignUpException {
        if(uname == null || uname.trim().equals("")){
            throw new SignUpException("用户名不可为空");
        }else if(userMap.containsKey(uname)){
            throw new SignUpException("用户名重复");
        }else if(uname.length() < 6 || uname.length() > 12){
            throw new SignUpException("用户名过长or过短，长度只能是6-12位");
        }else if(passWord.length() < 6 || passWord.length() > 12){
            throw new SignUpException("密码过长or过短，长度只能是6-12位");
        }
    }
    private static void checkSignIn(String uname, String pass)throws SignInException {
        if(pass == null || pass.trim().equals("")){
            throw new SignInException("密码不可为空");
        }else if(false == userMap.containsKey(uname)){
            throw new SignInException("用户名不存在");
        }else if(!pass.equals( userMap.get(uname))){
            throw new SignInException("密码不正确");
        }
    }
    private static void demo20(){
        userMap.put("Barbie", "8888");
        userMap.put("Ken", "12346");
        //注册
        Scanner sc = new Scanner(System.in);
        System.out.println("注册：请输入要注册的用户名和密码，回车换行隔开：");
        int flag = 0; //用来判断注册是否成功，不成功就重复
        try{
            String uname = sc.nextLine();
            String pass = sc.nextLine();
            checkSignUp(uname, pass);
            System.out.println("注册成功！");
            userMap.put(uname, pass);
        }catch(SignUpException e){
            e.printStackTrace();
            //flag = 1;
        }
//        finally{
//            while(flag == 1){
//                System.out.println("是否结束注册：是or否");
//                Scanner sc1 = new Scanner(System.in);
//                String str = sc1.next();
//                if("否" == str){
//                    demo20();//一个小递归，不应该这样写，因为会同时重复登录和注册
//                    flag = 0;
//                }else if("是" == str){
//                    System.out.println("-----结束注册-----");
//                    flag = 0;
//                }else{
//                    System.out.println("输入错误，请输入'是'：结束注册\n '否' 重新注册");
//                }
//            }
 //       }

        //登录
        System.out.println("登录：请输入用户名和密码");
        //flag = 0; //用来判断注册是否成功，不成功就重复
        try{
            String uname = sc.nextLine();
            String pass = sc.nextLine();
            checkSignIn(uname, pass);
            System.out.println("登录成功！");
        }catch(SignInException e){
            e.printStackTrace();
            //flag = 1;
        }
//        finally{
//            while(flag == 1){
//                System.out.println("是否结束登录：是or否");
//                Scanner sc1 = new Scanner(System.in);
//                String str = sc1.next();
//                if("否" == str){
//                    demo20();//一个小递归
//                    flag = 0;
//                }else if("是" == str){
//                    System.out.println("-----结束注册-----");
//                    flag = 0;
//                }else{
//                    System.out.println("输入错误，请输入'是'：结束注册\n '否' 重新注册");
//                }
//            }
//        }

    }

//题目21：开启新线程
//要求开启自定义的新线程MyThread，然后调用for循环。main线程也是循环10次打印正在执行哪个线程
    private static void demo21(){
        MyThread mt = new MyThread("新的线程");
        mt.start();

        for(int i = 0; i < 10; i++){
            System.out.println("main线程正在执行" + i);
        }
    }

    public static void main(String[] args) {
//        demo01();
//        demo02();
//        demo03();
//        demo05();
//        try{
//            demo06();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
        demo07();
        demo08();
        try{
            demo09();
        }catch(Exception e){

        }
//
//        demo10();
//        demo11_12();
//        demo13();
//        demo15();
//        demo16();
//        demo18();
//        try{
//            demo19();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
        demo20();
//        demo21();
    }
}
