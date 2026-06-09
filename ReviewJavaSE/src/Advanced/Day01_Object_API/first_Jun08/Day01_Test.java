package Advanced.Day01_Object_API.first_Jun08;

import java.text.DateFormat;
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
 * @Date: 2026/06/08/下午3:28
 * @Description:
 */
public class Day01_Test {
    //题目 2：编写测试类StudentTest，创建 3 个Student对象（两个属性完全相同，一个不同），
    // 分别调用toString()打印对象，调用equals()比较对象，验证重写效果。
    public static void main(String[] args) throws ParseException {
//        Student stu1 = new Student(01, "Barbie", 28);
//        Student stu2 = new Student(01, "Barbie", 28);
//        Student stu3 = new Student(02, "Barbie", 28);
//        System.out.println(stu1);
//        System.out.println(stu2);
//        System.out.println(stu3);
//
//        System.out.println(stu1.equals(stu2));
//        System.out.println(stu1.equals(stu3));
//        System.out.println(stu2.equals(stu3));
//
//
//        //【日期时间类】
//        //题目 1：使用Date和SimpleDateFormat实现：① 获取当前系统时间，
//        // 格式化为"yyyy年MM月dd日 HH:mm:ss"并打印；② 将字符串"2023-05-20 13:14:00"解析
//        // 为Date对象，打印该对象的毫秒值。
//        Date d1 = new Date();
//        DateFormat df1 = new SimpleDateFormat("G yyyy年MM月dd日 HH:mm:ss");
//        String str1 = df1.format(d1);
//        System.out.println(str1);
//
//        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String str2 = "2023-05-20 13:14:00";
//        Date d2 = df2.parse(str2);//throws ParseException解析会有异常需要处理
//        System.out.println(d2.getTime());//获取毫秒值
//
//        //题目 2：使用Calendar类实现：① 获取当前年份、月份（修正为 1-12）、当月第几天并打印；
//        // ② 将年份设置为 2025，月份设置为 10 月，日期加 5 天，转换为Date对象后格式化打印。
//        Calendar cal = Calendar.getInstance();
//        System.out.println("当前年份： " + cal.get(Calendar.YEAR)
//        + "\n当前月份： " + (cal.get(Calendar.MONTH) + 1)
//        + "\n当月第几天：" +cal.get(Calendar.DAY_OF_MONTH));
//        cal.set(Calendar.YEAR, 2025);
//        cal.set(Calendar.MONTH, 9);//10月要设置数字9
//        cal.add(Calendar.DAY_OF_MONTH, 5);
//        Date d3 = cal.getTime();
//        System.out.println(df2.format(d3));
//
//        //题目 3：编写程序，接收用户输入的出生日期（格式：yyyy-MM-dd），计算并输出该用户从出生
//        // 到当前时间的总天数（需处理 “未出生” 的情况）。
//        System.out.println("请输出出生日期，按照yyyy-MM-dd的格式");
//        boolean flag = false;
//        Date d4;
//        do{
//            Scanner sc = new Scanner(System.in);
//            String str3 = sc.next();
//            DateFormat df3 = new SimpleDateFormat("yyyy-MM-dd");
//            try{
//                d4 = df3.parse(str3);
//                Date currentDate = new Date();
//                //加一段判断年份和月份是否正确的
////                Calendar cal2 = Calendar.getInstance();
////                cal2.setTime(d4);
////                if(cal2.get(Calendar.YEAR) <= 0 || cal2.get(Calendar.MONTH) <= 0 ||
////                        cal2.get(Calendar.MONTH) > 12 || cal2.get(Calendar.DAY_OF_MONTH) <= 0){
////                    flag = true;
////                    System.out.println("年份月份或日期不存在，请重新输入");
////                }
//                long diff = currentDate.getTime() - d4.getTime();//时间差值
//                if(diff < 0){
//                    System.out.println("还没出生");
//                }else{
//                    System.out.println("你出生的日期是" + df1.format(d4) + "你已经出生" + diff/1000/60/60/24 + "天");
//                }
//            }catch(ParseException e){
//                flag = true;//定义一个判断来在错误输入的情况下重复输入
//                System.out.println("输入格式错误请重新输入");
//            }
//        }while(flag);
        /*输入错误日期和年份也会继续判断,计算错误，所以还是判定一下正确年份

        //-1-13-45
        //你出生的日期是Sat Feb 14 00:00:00 CST 1你已经出生740098天
        //优化成换DateFormat形式打印
        //你出生的日期是0001年02月14日 00:00:00你已经出生740098天
        //你出生的日期是公元前 0001年02月14日 00:00:00你已经出生740098天

//        1-2-14
//        你出生的日期是Mon Feb 14 00:00:00 CST 1你已经出生739732天
//         你出生的日期是0001年02月14日 00:00:00你已经出生739732天
//         你出生的日期是公元 0001年02月14日 00:00:00你已经出生739732天

        //错误原因是-1是公元前两年，0是公元前1年，但Date里不会打印0只有1？
        //可以加一个判定输入年份不能是负数，月份不可以超过12的，如果有2月30也会自动解读为3月往后延续
         ●优化年月日限定数字，出现问题，判断不了。因为Date只是存毫秒值，然后转成日期，跟实际输入的日期并不一样。
        所以并没有什么错，唯一的错就是年份0会输出成1*/



        //【System 类】
        //题目 1：使用System.currentTimeMillis()计算 “遍历 100000 次 for 循环” 的耗时（毫秒），
        // 并打印耗时结果。
        //题目 2：定义源数组int[] src = {10,20,30,40,50}，
        // 目标数组int[] dest = {99,88,77,66,55}，使用System.arraycopy()将源数组中
        // 索引 1 开始的 3 个元素，复制到目标数组索引 2 开始的位置，打印复制后的目标数组。
//        long begin = System.currentTimeMillis();
//        for(int i = 0; i < 100000; i++){
//            System.out.println(i + ",");
//        }
//        long end = System.currentTimeMillis();
//        System.out.println("循环100000次耗时" + (end - begin) + "毫秒" +
//                (end - begin)/1000 + "秒");
//
//        int[] src = {10, 20, 30, 40, 50};
//        int[] dest = {99, 88, 77, 66, 55};
//        System.arraycopy(src,1,dest,2,3);
//        System.out.println(Arrays.toString(dest));

        //【StringBuilder 类】
        //题目 1：使用StringBuilder实现字符串拼接：依次添加"Java"、"基础"、"复习"、2024、true，
        // 最终转换为String类型并打印。
        //题目 2：对比String和StringBuilder的拼接性能：分别使用String（s += i）
        // 和StringBuilder（append(i)）完成 10000 次数字拼接，计算并打印两者的耗时（毫秒），
        // 验证StringBuilder的性能优势。
//        StringBuilder sb1 = new StringBuilder();
//        sb1 = sb1.append("Java").append("基础").append("复习").append(2024).append(true);
//        String str = sb1.toString();
//        System.out.println(str);
//
//        long begin = System.currentTimeMillis();
//        for(int i = 0; i < 10000; i++){
//            String str2 = "";
//            str2 = str2 + i;
//        }
//        long end = System.currentTimeMillis();
//        System.out.println("String + 拼接10000次耗时" + (end - begin) + "毫秒");//22//28
//
//        begin = System.currentTimeMillis();
//        for(int i = 0; i < 10000; i++){
//            StringBuilder sb2 = new StringBuilder();
//            sb2 = sb2.append(i);
//        }
//        end = System.currentTimeMillis();
//        System.out.println("StringBuilder.append拼接10000次耗时" + (end - begin) + "毫秒");//2//4


        //【包装类】
        //题目 1：手动实现 “装箱” 和 “拆箱”：① 将基本类型int num = 100转换为Integer对象
        // （两种方式：构造器、valueOf()）；② 将Integer对象转换为int基本类型；
        // ③ 测试自动装箱（Integer i = 200）和自动拆箱（i = i + 50）。
        //Integer in1 = new Integer(10);
        Integer in1 = Integer.valueOf(10);
        int num1 = in1.intValue();
        Integer in2 = 10;
        in2 = in2 + 50;//先拆后装in2 = Integer.valueOf(in2.intValue() + 50);
//        //题目 2：实现基本类型与字符串的转换：① 将double num = 3.1415转换为字符串；
        double num = 3.1415;
        String str1 = num + "";
//        //先转包装类再转String
        Double num2 = Double.valueOf(num);
        String str2 = num2.toString();
//        //String.valueOf(值)
        String str3 = String.valueOf(num);
        System.out.println(str1 + "," + str2 + "," + str3);
        // ② 将字符串"12345"转换为int类型，"98.6"转换为double类型，"true"转换为boolean类型；
        String str4 = "12345";
        int num3 = Integer.parseInt(str4);
        String str5 = "98.6";
        double db = Double.parseDouble(str5);
        String str6 = "true";
        boolean b = Boolean.parseBoolean(str6);
        // ③ 处理字符串"abc"转换为int时的异常（可选：捕获NumberFormatException）。
        try{
            String str7= "abc";
            int num4 = Integer.parseInt(str7);
        }catch(NumberFormatException e){
            //e.printStackTrace();
            System.out.println(e);
        }
        //二、答题要求
        //所有代码需符合 Java 语法规范，类名、变量名命名见名知意；
        //日期解析、字符串转基本类型等可能抛出异常的场景，需正确处理（throws/try-catch）；
        //禁止直接复制现成代码，需手写实现核心逻辑；
        //每个题目独立编写类，类名与题目对应（如Student.java、BirthdayDaysCalculator.java）

    }
}
