package Advanced.Day01_Object_API.Review05_Aug14;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/14/下午3:07
 * @Description:
 */
public class MainTest {
    //一、按知识点分类的编程练习题（仅提需求，需手写代码实现）
    //【Object 类】
    //题目 1：定义一个Student类，包含学号（id）、姓名（name）、年龄（age）属性，
    // 重写toString()方法，要求返回格式为"Student{id=1001, name='张三', age=18}"；
    // 重写equals()方法，要求仅当两个学生对象的学号、姓名、年龄都相同时返回true，
    // 否则返回false（需处理空指针问题）。

    //题目 2：编写测试类StudentTest，创建 3 个Student对象（两个属性完全相同，一个不同），
    // 分别调用toString()打印对象，调用equals()比较对象，验证重写效果。


    //【日期时间类】
    //题目 1：使用Date和SimpleDateFormat实现：① 获取当前系统时间，
    // 格式化为"yyyy年MM月dd日 HH:mm:ss"并打印；② 将字符串"2023-05-20 13:14:00"解析
    // 为Date对象，打印该对象的毫秒值。
    private static void demo03(){
        Date d1 = new Date();//当前日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        System.out.println(sdf.format(d1));

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = "2023-05-20 13:14:00";
        try {
            Date d2 = sdf2.parse(str);
            System.out.println("日期2023-05-20对应的毫秒值：" + d2.getTime());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //题目 2：使用Calendar类实现：① 获取当前年份、月份（修正为 1-12）、当月第几天并打印；
    // ② 将年份设置为 2025，月份设置为 10 月，日期加 5 天，转换为Date对象后格式化打印。

    private static void demo04(){
        /*回忆calendar表达日期的特殊之处月从一月但为0开始，周从周日开始并且周日为数字1*/
        Calendar cal1 = Calendar.getInstance();
        System.out.println("当前年，月" + cal1.get(Calendar.YEAR) +
                (cal1.get(Calendar.MONTH)+1) +
                cal1.get(Calendar.DAY_OF_MONTH)
        );

        cal1.set(Calendar.YEAR, 2025);
        cal1.set(Calendar.MONTH, 9);
        cal1.add(Calendar.DAY_OF_MONTH, 5);
        Date d1 = cal1.getTime();
        //格式化打印
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(d1));


    }

    //题目 3：编写程序，接收用户输入的出生日期（格式：yyyy-MM-dd），计算并输出该用户从出生
    // 到当前时间的总天数（需处理 “未出生” 的情况）。
    private static void demo05(){
        System.out.println("请输入出生日期，格式为yyyy-MM-dd：");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date d1 = sdf.parse(str);
            Date d2 = new Date();
            //判断，获得的日期在之前还是未来
            long day = d2.getTime() - d1.getTime();
            if(day < 0){
                System.out.println("未出生");
            }else{
                System.out.println("你已出生：" + (d2.getTime()-d1.getTime())/1000/60/60/24 + "天");
            }
        }catch(ParseException e){
            e.printStackTrace();
        }

    }


    //【System 类】
    //题目 1：使用System.currentTimeMillis()计算 “遍历 100000 次 for 循环” 的耗时（毫秒），
    // 并打印耗时结果。
    private static void demo06(){
        long begin = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++){
            int num = i;
        }
        long end = System.currentTimeMillis();
        System.out.println("打印100000次耗时：" + (end - begin));
    }

    //题目 2：定义源数组int[] src = {10,20,30,40,50}，
    // 目标数组int[] dest = {99,88,77,66,55}，使用System.arraycopy()将源数组中
    // 索引 1 开始的 3 个元素，复制到目标数组索引 2 开始的位置，打印复制后的目标数组。
    private static void demo07(){
        int[] src = {10,20,30,40,50};
        int[] dest = {99, 88, 77, 66, 55};
        System.arraycopy(src,1, dest, 2, 3);
        System.out.println("复制后的目标数组：");
        for(int i : dest){
            System.out.print(i + ",");
        }
    }
    //【StringBuilder 类】
    //题目 1：使用StringBuilder实现字符串拼接：依次添加"Java"、"基础"、"复习"、2024、true，
    // 最终转换为String类型并打印。
    private static void demo08(){
        StringBuilder str1 = new StringBuilder();
        str1.append("Java").append("基础").append("复习").append(2024).append(true);
        String str2 = str1.toString();
        System.out.println(str2);
    }
    //题目 2：对比String和StringBuilder的拼接性能：分别使用String（s += i）
    // 和StringBuilder（append(i)）完成 10000 次数字拼接，计算并打印两者的耗时（毫秒），
    // 验证StringBuilder的性能优势。
    private static void demo09(){
        long begin = System.currentTimeMillis();
        String str = null;
        for(int i = 0; i < 100000; i++){
            str = str + i ;
        }
        long end = System.currentTimeMillis();
        System.out.println("String拼接100000次耗时：" + (end - begin));

        StringBuilder str1 = new StringBuilder();
        begin = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++){
            str1.append(i);
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuilder拼接100000次耗时：" + (end - begin));
    }

    //【包装类】
    //题目 1：手动实现 “装箱” 和 “拆箱”：① 将基本类型int num = 100转换为Integer对象
    // （两种方式：构造器、valueOf()）；② 将Integer对象转换为int基本类型；
    // ③ 测试自动装箱（Integer i = 200）和自动拆箱（i = i + 50）。
    private static void demo10(){
        //装箱
        Integer in1 = Integer.valueOf(14);
        int num1 = in1.intValue();

        Integer in = 14;
        int num2 = in;
    }
    //题目 2：实现基本类型与字符串的转换：① 将double num = 3.1415转换为字符串，4种方法；
    // ② 将字符串"12345"转换为int类型，"98.6"转换为double类型，"true"转换为boolean类型；
    // ③ 处理字符串"abc"转换为int时的异常（可选：捕获NumberFormatException）。
    private static void demo11(){
        /* ● 转字符串，方法1，string ● */
        double num = 3.1415;
        String str = Double.valueOf(num).toString();
        String str2 = String.valueOf(num);
        String str3 = num +"";
        String str4 = new StringBuilder().append(num).toString();

        int num1 = Integer.parseInt("12345");
        double dou = Double.valueOf("98.6");//自动拆箱
        boolean bool = Boolean.valueOf("true");

        System.out.println("4中转为字符串的结果：" + str +"," + str2 +"," + str3 +"," + str4);
        System.out.println("字符串解析为基本数据类型：" + num1 + dou + bool);

        try{
            int num2 = Integer.parseInt("abc");
        }catch(NumberFormatException e){
            e.printStackTrace();
        }


    }
    //二、答题要求
    //所有代码需符合 Java 语法规范，类名、变量名命名见名知意；
    //日期解析、字符串转基本类型等可能抛出异常的场景，需正确处理（throws/try-catch）；
    //禁止直接复制现成代码，需手写实现核心逻辑；
    //每个题目独立编写类，类名与题目对应（如Student.java、BirthdayDaysCalculator.java）
    public static void main(String[] args) {
        demo03();
        System.out.println("----------------------");

        demo04();
        System.out.println("----------------------");

        demo05();
        System.out.println("----------------------");

        demo06();
        System.out.println("----------------------");

        demo07();
        System.out.println("----------------------");

        demo08();
        System.out.println("----------------------");

        demo09();
        System.out.println("----------------------");

        demo10();
        System.out.println("----------------------");

        demo11();
    }
}
