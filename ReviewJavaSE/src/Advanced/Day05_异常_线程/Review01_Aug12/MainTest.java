package Advanced.Day05_异常_线程.Review01_Aug12;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public static void demo05(){
        People p1 = new People(01, "Barbie", 19);
        People p2 = new People(01, "Barbie", -2);
        People p3 = new People(01, "Barbie", 9);
        List<People> peopleList = new ArrayList<>();
        peopleList.addAll(Arrays.asList(p1, p2, p3));
        for(People p : peopleList){
            if(p.age < 0){
                throw new ArithmeticException();
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
//要求：观察运行时异常是否必须强制处理。
    private static void demo09(){
        String name = null;
        System.out.println(name.length());//不用处理
    }

//题目10：编写方法测试Checked异常。
//要求：调用可能产生IOException的方法并处理。
    private static void demo10(){
        try{
            FileOutputStream fout = new FileOutputStream("ReviewJavaSE\\src\\Advanced\\Day05_异常_线程\\Review01_Aug12\\a.txt");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

//题目11：创建自定义异常类AgeException。
//要求：继承Exception并添加构造方法。
    private static void demo11(){
        
    }

//题目12：使用AgeException校验年龄。
//要求：年龄不符合要求时抛出自定义异常。

//题目13：模拟用户注册功能。
//要求：用户名为空时抛出自定义注册异常。

//题目14：测试异常向上调用传播。
//要求：三个方法嵌套调用，观察异常传递过程。

//题目15：使用printStackTrace查看异常信息。
//要求：输出异常类型、原因和代码位置。

//题目16：分析Error和Exception区别。
//要求：分别举出属于两者的异常类型。

//题目17：判断异常处理方式。
//要求：区分哪些异常需要try-catch，哪些可以不用。

//题目18：使用finally关闭资源。
//要求：模拟资源对象，在finally中完成关闭操作。

//题目19：使用try-with-resources关闭流。
//要求：创建资源对象并验证自动关闭。

//题目20：综合异常处理。
//要求：模拟登录流程并使用多种异常处理机制。
}
