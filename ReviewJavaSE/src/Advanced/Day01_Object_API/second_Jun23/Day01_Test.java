package Advanced.Day01_Object_API.second_Jun23;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/06/23/下午2:19
 * @Description:
 */
public class Day01_Test {
    public static void main(String[] args) {
        //一、按知识点分类的编程练习题（仅提需求，需手写代码实现）
        //【Object 类】
        //题目 1：定义一个Student类，包含学号（id）、姓名（name）、年龄（age）属性，
        // 重写toString()方法，要求返回格式为"Student{id=1001, name='张三', age=18}"；
        // 重写equals()方法，要求仅当两个学生对象的学号、姓名、年龄都相同时返回true，
        // 否则返回false（需处理空指针问题）。

        //题目 2：编写测试类StudentTest，创建 3 个Student对象（两个属性完全相同，一个不同），
        // 分别调用toString()打印对象，调用equals()比较对象，验证重写效果。
        Student stu1 = new Student(01, "Barbie", 30);
        Student stu2 = new Student(02, "Barbie", 30);
        Student stu3 = new Student(01, "Barbie", 30);
        System.out.println(stu1);
        System.out.println(stu2);
        System.out.println(stu3);
        System.out.println("stu1 == stu2:" + stu1.equals(stu2));
        System.out.println("stu2 == stu3:" + stu2.equals(stu3));
        System.out.println("stu1 == stu3:" + stu1.equals(stu3));


        //【日期时间类】
        //题目 1：使用Date和SimpleDateFormat实现：① 获取当前系统时间，
        // 格式化为"yyyy年MM月dd日 HH:mm:ss"并打印；② 将字符串"2023-05-20 13:14:00"解析
        // 为Date对象，打印该对象的毫秒值。
        Date date1 = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        System.out.println(sdf2.format(date1));
        String str1 = "2023-05-20 13:14:00";

        try {
            Date date2 = sdf.parse(str1);
            System.out.println(date2.getTime());
        }catch(Exception e){
            System.out.println(e);
        }

        //题目 2：使用Calendar类实现：① 获取当前年份、月份（修正为 1-12）、当月第几天并打印；
        // ② 将年份设置为 2025，月份设置为 10 月，日期加 5 天，转换为Date对象后格式化打印。
        Calendar cal1 = Calendar.getInstance();
        System.out.println("当前年，月,当月天" + cal1.get(Calendar.YEAR) + "," +
                (cal1.get(Calendar.MONTH) + 1 )+ "," + cal1.get(Calendar.DAY_OF_MONTH));
        cal1.set(Calendar.YEAR, 2025);
        cal1.set(Calendar.MONTH, 9);
        cal1.add(Calendar.DAY_OF_MONTH, 5);

        Date date3 = cal1.getTime();
        System.out.println(date3);

        //题目 3：编写程序，接收用户输入的出生日期（格式：yyyy-MM-dd），计算并输出该用户从出生
        // 到当前时间的总天数（需处理 “未出生” 的情况）。
        boolean flag = false;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("请根据格式：\'yyyy-MM-dd\'输入出生日期，yyyy年，MM月，dd日");
            String birth = sc.next();
            SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
            Date date4 = new Date();//获取当前时间
            try {
                Date date5 = sdf3.parse(birth);
                long current = date4.getTime();
                long borthTime = date5.getTime();
                long time = current - borthTime;
                if (time < 0) {
                    System.out.println("未出生");
                }else{
                    System.out.println("已经出生" + time/1000/60/60/24 + "天");
                }
            } catch (ParseException e) {
                System.out.println(e);
                System.out.println("输入生日日期格式错误，请重新输入");
                flag = true;
            }
        }while(flag);


        //【System 类】
        //题目 1：使用System.currentTimeMillis()计算 “遍历 100000 次 for 循环” 的耗时（毫秒），
        // 并打印耗时结果。
        long begin = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++){
            int j = i;
        }
        long end = System.currentTimeMillis();
        System.out.println("遍历100000次for循环耗时" + (end - begin) +"毫秒");
        //题目 2：定义源数组int[] src = {10,20,30,40,50}，
        // 目标数组int[] dest = {99,88,77,66,55}，使用System.arraycopy()将源数组中
        // 索引 1 开始的 3 个元素，复制到目标数组索引 2 开始的位置，打印复制后的目标数组。
        int[] src = {10,20,30,40,50};
        int[] dest = {99,88,77,66,55};
        System.arraycopy(src,1, dest, 2, 3);
        System.out.println("dest" + Arrays.toString(dest));

        //【StringBuilder 类】
        //题目 1：使用StringBuilder实现字符串拼接：依次添加"Java"、"基础"、"复习"、2024、true，
        // 最终转换为String类型并打印。
        StringBuilder sb1 = new StringBuilder();
        sb1.append("Java").append("基础").append("复习").append(2026).append(true);
        System.out.println(sb1);

        //题目 2：对比String和StringBuilder的拼接性能：分别使用String（s += i）
        // 和StringBuilder（append(i)）完成 10000 次数字拼接，计算并打印两者的耗时（毫秒），
        // 验证StringBuilder的性能优势。
        String str2 = "";
        StringBuilder sb2 = new StringBuilder();
        long begin1 = System.currentTimeMillis();
        for(int i = 0; i < 10000; i++) {
            str2 += i;
        }
        long end1 = System.currentTimeMillis();
        System.out.println("str2 += i 耗时:" + (end1-begin1) +"ms");

        long begin2 = System.currentTimeMillis();
        for(int i = 0; i < 10000; i++){
            sb2.append(i);
        }
        long end2 = System.currentTimeMillis();
        System.out.println("sb2.append(i) 耗时:" + (end2-begin2) +"ms");
        /*疑问？StringBuilder的append的参数要求类型？基本数据都可以*/

        //【包装类】
        //题目 1：手动实现 “装箱” 和 “拆箱”：① 将基本类型int num = 100转换为Integer对象
        // （两种方式：构造器、valueOf()）；② 将Integer对象转换为int基本类型；
        /*构造器用法jdk9后已经淘汰了*/
        Double d1 = Double.valueOf(123.23);
        Double f1 = Double.valueOf("123.23");
        Double f2 = Double.valueOf(123.23f);

        char c1 = Character.valueOf('@').charValue();

        // ③ 测试自动装箱（Integer i = 200）和自动拆箱（i = i + 50）。
        Integer i = 200;
        i = i + 50;

        //题目 2：实现基本类型与字符串的转换：① 将double num = 3.1415转换为字符串；
        /*基本数据转字符串的3种方法：① + "" ②StringBuilder,append添加后toString
        ③转为包装类后用包装类的toString方法④ String的valueOf*/
        double num = 3.1415;
        String str3 = num + "";
        String str4 = new StringBuilder().append(num).toString();
        String str5 = Double.valueOf(num).toString();
        String str6 = String.valueOf(num);
        // ② 将字符串"12345"转换为int类型，"98.6"转换为double类型，"true"转换为boolean类型；
        int in1 = Integer.valueOf("12345");//自动拆箱
        int in2 = Integer.parseInt("12345");

        double d2 = Double.valueOf("98.6");
        boolean b2 = Boolean.parseBoolean("true");


        // ③ 处理字符串"abc"转换为int时的异常（可选：捕获NumberFormatException）。
        try{
            int in3 = Integer.parseInt("abc");
        }catch(NumberFormatException e){
            System.out.println(e);
        }
        //二、答题要求
        //所有代码需符合 Java 语法规范，类名、变量名命名见名知意；
        //日期解析、字符串转基本类型等可能抛出异常的场景，需正确处理（throws/try-catch）；
        //禁止直接复制现成代码，需手写实现核心逻辑；
        //每个题目独立编写类，类名与题目对应（如Student.java、BirthdayDaysCalculator.java）
    }
}
