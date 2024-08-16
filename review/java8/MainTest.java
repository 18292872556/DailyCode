package review.java8;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: xuexuezi
 * @Date: 2024/08/08/21:03
 * @Description:
 */
public class MainTest {

    public static void main(String[] args) {
        //1.判断Date不同参数构造的输出
        //demo01();
        //2. 输出当前日期，输出当前日期对应的毫秒值。
        //demo02();
        //3. 把Date日期按照格式"yy-MM-dd HH:mm:ss"转为String类型，把"yyyy年M月d日 H时m分s秒"的String转为Date
        //demo03();
        //4. 用日期时间相关的API，计算一个人已经出生了多少天。
        //demo04();
        //5. 获取Calendar对象，输出日历当前年，月，日。分别设置年，月，日；同时设置年，月，日；对年增加4，月减少2
        //demo5();
        //6. 把日历转换为日期
        //demo06();
//        shaChaTest();
        //7. 测试for循环打印数字1-9999所需要使用的时间（毫秒）
        //demo07();
        //8. 将src数组中前3个元素，复制到dest数组的前3个位置上
        //demo08();
        //9. ①StringBuilder无参构造容量多少？②为什么使用StringBuilder
        //demo09();
        //10. ①3种常用方法构造StringBuilder,②使用append,链式编程给StringBuilder对象增添字符
        //demo10();
        //11. 把String类型和StringBuilder互相转换
        //demo11();
        //12.写装箱的4种方法，说明八种数据类型分别都有几种方式可构造包装类，构造过程中的注意点
        //demo12();
        //13. 写拆箱的1种
        //demo13();
        //♥ 14. 回忆自动拆箱和自动装箱的情况，分析自动和不自动写法对比*4
        //demo14();
        //♥ 15. 基本类型转String,3种方式
//        demo15();
        //16. 把所有字符串转对应基本类型
        //demo16();
        //17.复习基本类型指哪些
        //demo17();
        //18. 总结 区分object类，包装类和StringBuilder对象的toString()。Date对象和Canlendar对象的getTime()
        //String类和包装类的valueOf();包装类的 xxxparse()和xxxValue()
        demo18();


    }

    private static void demo18() {
        /*toString方法，要么是输出对象信息，要么是转String*/
        //①Object()的toString方法，跟直接输出对象的结果相同，(类名带括号表对象，这是Object对象的方法）
        //不重写输出的是对象的类名后跟地址：一般会自己重写一些想打印的属性等等
        Object obj1 = "String: 123$@#";
        System.out.println(obj1.toString() + "\n" + obj1);
        //② 包装类的toString(): 把基本数据类型转String
        String str1 = Integer.toString(123);
        //StringBuilder()的:把StringBuilder对象转String对象
        StringBuilder strB1 = new StringBuilder(1234);
        String str2 = strB1.toString();

        /*getTime()方法 ☃理解为细化时间单位*/
        //① Date()的 ：转毫秒
        long time = new Date().getTime();
        //② Calendar()的 ： 转Date
        Date date1 = Calendar.getInstance().getTime();

        /*valueOf() 基本都是哪个类的静态方法就转成这个类对象*/
        //① String的：把基础数据 -> String
        //② 包装类的： 把基础数据转 -> 包装类
        double d1 = 123.2132;
        char ch1 = '对';
        String str3 = String.valueOf(d1);
        Character ch2 = Character.valueOf(ch1);

        /*包装类的 parseXxx和xxxValue ：记带xxx的是 转基本数据类型*/
        //static parseXxx是String -> 基础数据类型(可以理解类似SimpleDateFormat中的parse方法，意为解析，就是把字符串类型的码值根据规则解析
        //xxxValue是包装类() -> 基础数据
        int in1 = Integer.parseInt("1234");
        Double d2 = Double.valueOf(123.123);
        double d3 = d2.doubleValue();
    }

    private static void demo17() {
        //基本数据类型指4类8种：
        // 整数：byte(1) short(2) int(4) long(8) 字节为x,范围统一是-2^(x-1) ~ 2^(x-1) - 1
        // 字符: char(2) 0~ 65535
        // 小数：float(4) double(8) 科学计数法，分别是指数两位和三位
        // 布尔: boolean

        //其中boolean不讨论字节
    }

    /**
     * String转基本数据类型
     * 转不了char，就像char也不能用String构造一样
     */
    private static void demo16() {
        byte by1 = Byte.parseByte("127");
        int num1 = Integer.parseInt("1234");
        short sh1 = Short.parseShort("32767");
        long l1 = Long.parseLong("23333432");

        //char ch1 = Character.p

        double d1 = Double.parseDouble("12.234");
        float f1 = Float.parseFloat("123.21432");

        boolean b1 = Boolean.parseBoolean("true");

        System.out.println(by1 + "\n" + num1 + "\n" + sh1 + "\n" + l1 + "\n" + d1 + "\n" + f1 + "\n" + b1);
    }

    /**
     * 基本类型转String
     */
    private static void demo15() {
        //① "+"
        String str1 = 123 + "$%";
        //② 包装类静态方法
        String str2 = Integer.toString(123);
        //③ String 静态方法
        String str3 = String.valueOf(123);

        System.out.println(str1 + "\n" + str2 + "\n" + str3);

    }

    /**
     * 自动拆箱，自动装箱: 基本类型的数据和包装类之间可以自动的相互转换
     * JDK 1.5 之后粗线的新特性
     */
    private static void demo14() {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(12);//自动装箱：list1.add(new Integer(12));参数是int,但集合元素要求是Integer。
        list1.add(123);
        list1.add(123);
        int num = list1.get(2);//自动拆箱：list1.get(2).intValue;返回的Integer被int接收
        System.out.println("list1" + list1);
        System.out.println("list1.get(2)： " + num);

        Integer in1 = 14;//自动装箱：直接把int类型的整数赋值包装类
        // 相当于 Integer in1 = new Integer(14);
        System.out.println(in1);

        int num2 = in1;//自动拆箱：相当于int num2 = in1.intValue();
        in1 = in1 +2;//自动拆箱和自动装箱： in1是包装类，无法直接参与运算，可以自动转换为基本数据类型，
        // 在进行计算in1+2;就相当于 in2.intValue() + 2 = 16
        // in1 = in2.intValue() + 2 = 16 又是一个自动装箱
        System.out.println(in1);
    }


    //拆箱
    private static void demo13() {
        Boolean b1 = Boolean.valueOf(true);
        Float f1 = Float.valueOf(12.23F);

        boolean b2 = b1.booleanValue();
        float f2 = f1.floatValue();

        System.out.println(b1 + "\n" + b2 + "\n" + f1 + "\n" + f2);

    }

    //装箱
    private static void demo12() {
        //装箱的两种构造方法
        Double d1 = new Double(13.24);
        Double d2 = new Double("123.2431");
        //装箱的两种静态方法
        Double d3 = Double.valueOf(14.14);
        Double d4 = Double.valueOf("15.15");
        //♥ 其中Character不能用字符串做参数装箱，只能用char类型。其他七种基本数据类型都可以，包括boolean
        // float装箱，必须带后缀F。
        // long主要看参数数据大小是否超过int类型，超过的话要L,
        // 没超过就不用，也没错，因为int装箱为Long，先转long自动转换，再装箱为Long，不影响
        // short,byte装箱时，参数整数需要强转为(short)(byte)，再装箱。因为整数默认是int，而int范围大于byte,short
        //  ● 装箱数据内容必须符合包装类型的要求，否则异常



    }


    //String和StringBuilder互相转化
    private static void demo11() {
         String str1 = "字符串1，*&%frfdFD12";
        StringBuilder strB1 = new StringBuilder(str1);
        System.out.println("str1转化的strB1: " + strB1);
        String str2 = strB1.toString();//输出一个对象的toString和直接输出是一个东西
        System.out.println("strB1转化的str2: " + str2);
    }

    private static void demo10() {
        //3种，空参数，String参数，int参数。比较常用来构造StringBuilder
        //测试空参的大小，发现append追加没有条件，可以无限追加。不知道初始16个字符大小有啥意义
//        strB1 = "一二三四五六七八九十一二三四五六";
        StringBuilder strB1 = new StringBuilder();
        strB1 = new StringBuilder();
        strB1.append("一二三四五六七八九十一二三四五六").append("七八九十").append("一二三四五六七八九十");
        System.out.println("StrB1:" + strB1);

        //用string,int,空都可以构造
        StringBuilder strB2 = new StringBuilder("ABCabc");
        String str = "defDEF";
        StringBuilder strB3 = new StringBuilder(str);
        StringBuilder strB4 = new StringBuilder(1234555);
        System.out.println("strB2:" + strB2);
        System.out.println("strB3:" + strB3);
        System.out.println("strB4" + strB4);
    }


    private static void demo09() {
        /*StringBuilder无参构造16个字符长度，1个字符 = 2字节，2字节=16bit。
        一个汉字也是1个字符，一个英文或者数字也是1个字符
        * 为什么使用StringBuilder？*/

        //如果用String进行字符串加减,如下过程，会产生3个字符串abc,123,abc123，非常占用空间
        String str1 = "abcdefgh";
        String str2 = str1 + "12345678";
        System.out.println("String:" + str2);

        //而使用StringBuilder,就1一个对象
        StringBuilder strB1 = new StringBuilder();
        strB1.append("abcdefgh").append("12345678");
        System.out.println("StringBuilder:" + strB1);

    }

    private static void printArray(int[] arr){
        int size = arr.length;
        for (int i : arr) {
            System.out.print(i);
            size--;
            if(size != 0){
                System.out.print(",");
            }else{
                System.out.println();
            }
        }
    }

    private static void demo08() {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {6, 7, 8, 9, 10};
        printArray(arr1);
        printArray(arr2);
        System.arraycopy(arr1, 0, arr2, 0, 3);
        printArray(arr1);
        printArray(arr2);
    }

    private static void demo07() {
        long start = System.currentTimeMillis();
        for(int i = 1; i <= 9999; i++){
            System.out.print(i + " ");
        }

        long end = System.currentTimeMillis();
        System.out.println();
        System.out.println(end - start);
    }

    private static void demo06() {
        Calendar c1 = Calendar.getInstance();
        c1.set(2024, 7, 31);//因为八月就31天，超出的算下个月，例32就是九月1日，
        //c1.set(2024,8,0);//2024 7(我们八月) 31
        //c1.set(2024,6,0);//2024 5(我们六月) 30

        //c1.set(2024,8,31);//2024 9Oct 1 //因为9月就30天
        //c1.set(2024, 7, 34);//2024 8Sep 3
        printCalendar(c1);

        //c1.add(Calendar.YEAR, 1);
        Date d1 = c1.getTime();//可以简单理解getTime指细化时间，Date细化就是毫秒值，日历细化就是Date
        System.out.println("Calendar().getTime() " + d1);
        long time = d1.getTime();
        System.out.println("Date().getTime() " + time);

        d1.setTime(time + 88200000);//一天零30分钟 = 88200000毫秒
        c1.setTime(d1);
        printCalendar(c1);
    }

    //每次打印Calendar具体时间都太尼玛麻烦了，写个方法接收
    private static void printCalendar(Calendar c){
        //注意：其中月份+1，因为日历中的
        System.out.println("YEAR:" + c.get(Calendar.YEAR) + "MONTH:" + c.get(Calendar.MONTH) + " DAY_OF_MONTH:"
                + c.get(Calendar.DAY_OF_MONTH) + " HOUR_OF_DAY" + c.get(Calendar.HOUR_OF_DAY) + " MINUTE:"
                + c.get(Calendar.MINUTE) + " SECOND:" + c.get(Calendar.SECOND) + " DAY_OF_WEEK:"
                + c.get(Calendar.DAY_OF_WEEK));

    }

    //5. 获取Calendar对象，输出日历当前年，月，日。
    // 分别设置年，月，日；同时设置年，月，日；对年增加4，月减少2
    private static void demo5() {
//        Calendar c1 = Calendar.getInstance();
//        System.out.println(Calendar.YEAR + ", " + c1.get(Calendar.YEAR));//1, 2024
        Calendar c1 = Calendar.getInstance();
//        System.out.println(c1.get(Calendar.YEAR) + "," + c1.get(Calendar.MONTH) + ","
//                + c1.get(Calendar.DAY_OF_MONTH));
        printCalendar(c1);

        c1.set(Calendar.YEAR, 2028);
        c1.set(Calendar.MONTH, 11);//12月 = 0月
        c1.set(Calendar.DAY_OF_MONTH, 12);
//        System.out.println(c1.get(Calendar.YEAR) + "," + c1.get(Calendar.MONTH) + ","
//                + c1.get(Calendar.DAY_OF_MONTH));
        printCalendar(c1);
        c1.set(2026, 1, 13);
//        System.out.println(c1.get(Calendar.YEAR) + "," + c1.get(Calendar.MONTH) + ","
//                + c1.get(Calendar.DAY_OF_MONTH));
        printCalendar(c1);


        c1.add(Calendar.YEAR, -2);//? 2026 add 10 = 2035
        c1.add(Calendar.MONTH, 11);//月份：1 add -5 = 8// 0 11 10 9 8
//        System.out.println(c1.get(Calendar.YEAR) + "," + c1.get(Calendar.MONTH) + ","
//                + c1.get(Calendar.DAY_OF_MONTH));
        printCalendar(c1);
    }
    private static void shaChaTest(){
        //测试add结果为什么不成功

//        System.out.println(c1.get(Calendar.YEAR) + "年" + c1.get(Calendar.MONTH) + "月"
//                + c1.get(Calendar.DAY_OF_MONTH) + "日\n" + c1.get(Calendar.HOUR_OF_DAY) + "："
//                + c1.get(Calendar.MINUTE) + "：" + c1.get(Calendar.SECOND) + "\n"
//                + c1.get(Calendar.DAY_OF_WEEK));

        //因为今天是2024/8/13星期二，但是重新创建新的Calendar,一直打印今天7月13，DAY_OF_WEEK = 3。
        //已知，西方月份的0-11 对应我们东方的1-12月，但星期也说不通咋回事。2026年 add 10 也= 2035 非常傻叉
        //故此处统一测试
        //calendar.setTime(date);
//        Date d1 = new Date();
//        System.out.println("当前的Date:" + d1);
        Calendar c1 = Calendar.getInstance();
//        System.out.println("当前的Calendar: ");
//        printCalendar(c1);//这个是自己写的方法
//        /*当前的Date:Tue Aug 13 21:16:51 CST 2024
//        当前的Calendar:
//        2024年8月13日
//        21：16：51
//        星期：3*/
//        //因为Date显示的是正确的，今天是2024/8/13 星期二 直接把日期转日历，我倒要看看对不对
//        c1.setTime(d1);
//        System.out.println("Date转Calendar: ");
//        printCalendar(c1);
//        //ok跟c1原本一样，但不确定c1有没有成功接收date,所以把Date的日 时分秒都 - 1 1:10:10，看看
//
//        long setTime = d1.getTime() - 90600000;
//        d1.setTime(setTime);//1天1小时10分换算成毫秒值
//        System.out.println("改后的Date:" + d1);
//        c1.setTime(d1);
//        System.out.println("Date转Calendar: ");
//        printCalendar(c1);

        /*测Calendar的add失败原因：设置DAY_OF_MONTH和DAY_OF_WEEK冲突情况下以后设置的为准*/
        c1.set(2024, 5, 22);
//        System.out.println(c1.get(Calendar.YEAR) + "," + c1.get(Calendar.MONTH) + ","
//                + c1.get(Calendar.DAY_OF_MONTH));
        printCalendar(c1);

        c1.set(Calendar.DAY_OF_MONTH, 24);
        c1.set(Calendar.HOUR, 12);//12小时制
        //c1.set(Calendar.HOUR_OF_DAY,23);
        c1.set(Calendar.MINUTE, 12);
        c1.set(Calendar.SECOND, 00);
        c1.set(Calendar.DAY_OF_WEEK, 6);

//        c1.add(Calendar.YEAR, 10);//? 2026 add 10 = 2036
//        c1.add(Calendar.MONTH, 5);//月份：1 add -5 = 8// 0 11 10 9 8

        printCalendar(c1);
        System.out.println(c1.getTime());

    }

    //4. 用日期时间相关的API，计算一个人已经出生了多少天。
    private static void demo04() {
        System.out.println("请按照格式\"yy-MM-dd\"输入您的出生日期");
        Scanner sc = new Scanner(System.in);
        String strBirth = sc.next();//默认就是字符型
        Date dateNow = new Date();
        long now = dateNow.getTime();
        DateFormat sdf = new SimpleDateFormat("yy-MM-dd");
        Date dateBirth = null;

        try{
            dateBirth = sdf.parse(strBirth);//这种写法生命周期只在括号内，所以要在外面定义
        }catch(Exception e){
            System.out.println("输入错误！请按照格式\"yy-MM-dd\"重新输入出生日期：");
            demo04();
        }
        /*优化，有一个问题：比如出生日期是明天，也计算是今天出生？思考问题是否出在是按照出生日期0时0分开始计算的？
        即跟第二天时间差值不到24小时就算作同一天？这个问题怎么解决，只能是生日的时分秒和当日的相同，才能精确到某某一天
        ，出生日期早于今天的，不会出现这个问题，因为按出生日期的0点算，到今天必然有一天零几个小时。
        把今天的dateNow时分秒取出来给dateBirth算上，有一个问题比如10月和8月，字符数是不同的。如果想靠格式化后的字符串
        提取时分秒不可行，查到了Date的过时方法，就是分别取出时分秒，再分别设置给出生日期的时分秒，还是不行。
        因为取当前测试时间精度最多只能取到秒，但实际底层还有毫秒，而给未来的出生日期赋值也只能赋到秒。
        减下来差值就会是0秒后多少多少毫秒，还是不会超过24小时
        差值永远在24小时以内，还是算作是同一天。哪怕日期有差一天，太复杂了也没意义不考虑了

        最终解决或者在未来的情况设定出生日期时间当天的23:59:59，这样必然符合按日期算的需求
        唯一缺点是如果是明天出生，如果在今天的23:59:59开始测试，差值有可能小于24，算作同一天，错误的打印为今天出生。*/

        long birth = dateBirth.getTime();
        long second = now - birth;
        System.out.print("当前日期：" + dateNow + "\n您的出生日期：" + dateBirth);
        if(second < 0){//保持一个毫秒值的情况，不然除到天数会出现差的小时<24，日期不同也算作同一天了
            dateBirth.setHours(23);
            dateBirth.setMinutes(59);
            dateBirth.setSeconds(59);//
            birth = dateBirth.getTime();
            second = (now - birth)/1000/60/60/24;
            System.out.println("您距离出生还有" + -second + "天");
        }else if(second > 0){
            second = (now - birth)/1000/60/60/24;
            System.out.println("您已经出生" + second + "天");

        }else{
            System.out.println("恭喜您，今天出生了！");
        }

    }

    //3. 把Date日期按照格式"yy-MM-dd HH:mm:ss"转为String类型，把"yyyy年M月d日 H时m分s秒"的String转为Date
    private static void demo03(){
        DateFormat sdf1 = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        Date dateNow = new Date();
        String strNow = sdf1.format(dateNow);
        System.out.println(dateNow + "\n" + "->" + strNow);

        String strDate = "2016年4月27日 21时23分59秒";
        DateFormat sdf2 = new SimpleDateFormat("yyyy年M月d日 H时m分s秒");
        Date dateSet = null;//如果传入的字符串不符合规则，就有异常会报错，需要抛出一下异常
        try {
            dateSet = sdf2.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(strDate + "\n" + "->" + dateSet);


    }

    private static void demo02() {
        Date dateNow = new Date();
        System.out.println(dateNow);
        System.out.println(dateNow.getTime());
    }

    private static void demo01() {
        Date date1 = new Date();
        System.out.println(date1);
        Date date2 = new Date(0);
        System.out.println(date2);
        long time = date1.getTime();
        System.out.println(time);//54.63989126870878年，1970+54=2024年，0.63……年=233.56……天=7.78月
    }
}
