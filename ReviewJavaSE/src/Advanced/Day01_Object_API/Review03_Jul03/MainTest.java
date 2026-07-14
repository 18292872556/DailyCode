package Advanced.Day01_Object_API.Review03_Jul03;

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
 * @Date: 2026/07/03/下午12:30
 * @Description:
 */
public class MainTest {
    private static void demo01(){
        //一、按知识点分类的编程练习题（仅提需求，需手写代码实现）
        //【Object 类】
        //题目 1：定义一个Student类，包含学号（id）、姓名（name）、年龄（age）属性，
        // 重写toString()方法，要求返回格式为"Student{id=1001, name='张三', age=18}"；
        // 重写equals()方法，要求仅当两个学生对象的学号、姓名、年龄都相同时返回true，
        // 否则返回false（需处理空指针问题）。

        //题目 2：编写测试类StudentTest，创建 3 个Student对象（两个属性完全相同，一个不同），
        // 分别调用toString()打印对象，调用equals()比较对象，验证重写效果。

        Student stu1 = new Student(01, "barbie", 30);
        Student stu2 = new Student(01, "Barbie", 30);
        Student stu3 = new Student(01, "Barbie", 30);
        System.out.println(stu1.equals(stu2));
        System.out.println(stu2.equals(stu3));
        System.out.println(stu1.equals(stu3));
        System.out.println("打印stu2:" + stu2);
    }
    private static void demo02(){
        //【日期时间类】
        //题目 1：使用Date和SimpleDateFormat实现：① 获取当前系统时间，
        // 格式化为"yyyy年MM月dd日 HH:mm:ss"并打印；② 将字符串"2023-05-20 13:14:00"解析
        // 为Date对象，打印该对象的毫秒值。
        Date data1 = new Date();//空参就是当前时间
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        System.out.println(sdf1.format(data1));

        String str1 = "2023-05-20 13:14:00";
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date2 = sdf2.parse(str1);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    private static void demo03(){
        //【日期时间类】
        //题目 1：使用Date和SimpleDateFormat实现：① 获取当前系统时间，
        // 格式化为"yyyy年MM月dd日 HH:mm:ss"并打印；② 将字符串"2023-05-20 13:14:00"解析
        // 为Date对象，打印该对象的毫秒值。
        Date data1 = new Date();//空参就是当前时间
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        System.out.println(sdf1.format(data1));

        String str1 = "2023-05-20 13:14:00";
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date2 = sdf2.parse(str1);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    private static void demo04(){
        //题目 2：使用Calendar类实现：① 获取当前年份、月份（修正为 1-12）、当月第几天并打印；
        // ② 将年份设置为 2025，月份设置为 10 月，日期加 5 天，转换为Date对象后格式化打印。

        Calendar cal = Calendar.getInstance();//日历空参也是当前时间
        /*注意！月份是从一月开始对应数字为0，星期是从星期天开始对应数字为1*/
        System.out.println("或许当前年份、月份、当月第几天" + cal.get(Calendar.YEAR) + ","
                + cal.get(Calendar.MONTH) + "," + cal.get(Calendar.DAY_OF_MONTH));

        cal.set(Calendar.YEAR, 2025);
        cal.set(Calendar.MONTH, 9);
        cal.add(Calendar.DAY_OF_MONTH, 5);
        Date date2 = cal.getTime();
        //Date 格式化
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf3.format(date2));
    }
    private static void demo05(){
        //题目 3：编写程序，接收用户输入的出生日期（格式：yyyy-MM-dd），计算并输出该用户从出生
        // 到当前时间的总天数（需处理 “未出生” 的情况）。
        boolean flag = true;
        while(flag) {
            System.out.println("输入你的出生日期,格式请遵循yyyy-MM-dd,分别为年-月-日的数字即可：");
            Scanner sc = new Scanner(System.in);
            String str = sc.next();
            if(str.equals("T")) {
                return;
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            try {
                Date birthDate = sdf.parse(str);
                Date now = new Date();
                long time = now.getTime() - birthDate.getTime();
                if(time < 0) {
                    System.out.println("未出生");

                }else{
                    System.out.println("已经出生：" + time/1000/60/60/24);

                }
                return;//能走到这说明前面parse没出错

            } catch (ParseException e) {
                System.out.println("输入的格式错误，请重新输入!退出请输入 \"T\"");
            }

        }

    }
    private static void demo06(){
        //【System 类】
        //题目 1：使用System.currentTimeMillis()计算 “遍历 100000 次 for 循环”
        // 的耗时（毫秒）并打印耗时结果。
        long begin = System.currentTimeMillis();
        int flag = 0;
        for(int i = 0; i <100000; i++){
            flag = i;
        }
        long end = System.currentTimeMillis();
        System.out.println("遍历100000的时间是：" + (end - begin) + "ms");

        //题目 2：定义源数组int[] src = {10,20,30,40,50}，
        // 目标数组int[] dest = {99,88,77,66,55}，使用System.arraycopy()将源数组中
        // 索引 1 开始的 3 个元素，复制到目标数组索引 2 开始的位置，打印复制后的目标数组。
        int[] src = {10, 20, 30, 40, 50};
        int[] dest = {99, 88, 77, 66, 55};
        System.arraycopy(src, 1, dest, 2,3);

        System.out.println("复制之后：" + dest);
    }
    private static void demo07(){
        //【StringBuilder 类】
        //题目 1：使用StringBuilder实现字符串拼接：依次添加"Java"、"基础"、"复习"、2024、true，
        // 最终转换为String类型并打印。
        StringBuilder sb1 = new StringBuilder();
        sb1.append("Java").append("基础").append("复习").append("2024").append("true");
        String str = sb1.toString();
        System.out.println(str);

        //题目 2：对比String和StringBuilder的拼接性能：分别使用String（s += i）
        // 和StringBuilder（append(i)）完成 10000 次数字拼接，计算并打印两者的耗时（毫秒），
        // 验证StringBuilder的性能优势。
        StringBuilder sb2 = new StringBuilder();
        String str2 = "";
        long begin = System.currentTimeMillis();
        for(int i = 0; i <100000; i++){
            sb2.append(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("String10万次循环" + (end - begin) + "ms");

        long begin2 = System.currentTimeMillis();
        for(int i = 0; i <100000; i++){
            str2 += i;
        }
        long end2 = System.currentTimeMillis();
        System.out.println("StringBuilder10万次循环" + (end - begin) + "ms");

    }
    private static void demo08(){
        //【包装类】
        //题目 1：手动实现 “装箱” 和 “拆箱”：① 将基本类型int num = 100转换为Integer对象
        // （两种方式：构造器、valueOf()）；
        Integer in1 = Integer.valueOf(12);


        
        // ② 将Integer对象转换为int基本类型；
        int num1 = in1.intValue();
        // ③ 测试自动装箱（Integer i = 200）和自动拆箱（i = i + 50）。

        //题目 2：实现基本类型与字符串的转换：① 将double num = 3.1415转换为字符串；
        String str1 = "" + 3.1415;
        String str2 = Double.toString(3.1415);
        String str3 = String.valueOf(3.1415);
        String str4 = new StringBuilder().append(3.1415).toString();

        // ② 将字符串"12345"转换为int类型，"98.6"转换为double类型，"true"转换为boolean类型；
        int num2 = Integer.parseInt("12345");
        double num3 = Double.parseDouble("98.6");
        boolean num4 = Boolean.parseBoolean("true");

        // ③ 处理字符串"abc"转换为int时的异常（可选：捕获NumberFormatException）。
        try {
            int num5 = Integer.parseInt("abc");
        }catch(NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {

//        demo01();
//        demo02();
//        demo03();
//        demo04();
        demo05();
        demo06();
        demo07();
        demo08();









        //二、答题要求
        //所有代码需符合 Java 语法规范，类名、变量名命名见名知意；
        //日期解析、字符串转基本类型等可能抛出异常的场景，需正确处理（throws/try-catch）；
        //禁止直接复制现成代码，需手写实现核心逻辑；
        //每个题目独立编写类，类名与题目对应（如Student.java、BirthdayDaysCalculator.java）
    }

}
