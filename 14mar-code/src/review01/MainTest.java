package review01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/03/14/9:51
 * @Description: 复习 JavaSE①
 */
public class MainTest {
    public static void main(String[] args) {
        /*1、 把234（DEC）转为BIN*/
        //DEC是十进制，BIN是二进制
        //辗转相除，
        // 2|234 …… 0
        // 2|117 …… 1
        // 2|58 …… 0
        // 2|29 …… 1
        // 2|14 …… 0
        // 2|7 …… 1
        // 2|3 …… 1
        // 2|1 …… 1
        //  0
        //结果就是 11101010
        //验证 2^1 + 2^3 + 2^5 + 2^6 + 2^7 = 234 正确
        /*2. 把 0110 1010 1100（BIN）转为DEC十进制*/
        // 2^2 + 2^3 + 2^5 + 2^7 + 2^9 + 2^10 = 1708
        /*3. 买一个100Mbps的宽带，问下载速度最快多少*/
        //100Mb/s，一个bit是1位，1Byte = 8 bit
        // 100/8 = 12.5 MB/s
        /*4. DOS操作系统下指令，按照给出指令操作。打开cmd,切换盘符到D盘，
        进入一个文件夹，打印当前目录下文件，选择一个进入时只打前半部分名称使用补全快捷键，
        返回上级文件夹，清屏，返回根目录，退出*/
        //Win + R，输入cmd打开程序控制窗口
        // D:进入D盘
        // dir查看当前路径下文件，cd 文件名进入，查看后cd 一半文件名，
        // tab补全or替换选择，cd..返回上级目录，cd / 返回根目录
        /*5. 判断数据类型定义，分析错误并改正*/
        //		   ●byte b1 = y;//字符必须以''修饰，或者用整型赋值，相当于是他的ASCII码
        //        int i1 = 1243;
        //         ●char c1 = "@";//char 类型赋值字符，必须''
        //         ●char c2 = '';//不可为空字符
        //         ●char c3 = '34';//有且只能有一个字符
        //        char c4 = '齐';
        //        short s1 = 235;
        //        int i2 = 235;
        //         ●s1 = i2;
        // 复习short是2字节，16位。int类型的整数只要小于short范围，就会有一个常量优化，如int i2 = 235; s1 = i1，就错。
        //        double d1= 325.214;
        //         ●float f1 = 1.2;//从double到float,范围变小，必须强转，或1.2F表明类型不是double而是float
        //        float f2 = 0;
        //         ●long l1 = 1235321434543;//long是8字节，64位。int最大值21亿左右，这里必须带L。不然没有这么大的整数，常数部分报错
        //        boolean bb1 = true;
        //        String ss1 = "";
        //         ●String ss2 = 's';//String类型必须""修饰
        //        String ss3 = " 45# 53对";

        /*6、不同数据类型运算，判断对错，并改正*/
        //        byte num1 = 10;
        //        num1 += 3;
        //        byte num2 = 10;
        //         ●num2 = num2 + 3;
        //
        //        int num2;
        //         ●System.out.println(num2);
        //
        //        int x, y, z;
        //        double a = 1, b = 3.4, c = 5.6;
        //
        //        byte b1 = 34;
        //        byte b2 = 5;
        //         ●byte b3 = 128;//1字节，最大127
        //        short s1 = 98;//2字节
        //        short s2 = 23;//常量优化1
        //         ●short s3 = 32768;最大2^15 -1 ，32767
        //        char c1 = '中';
        //        char c2 = 65535;
        //         ●char c3 = 65536;最大65535
        //        long l1 = 12345L;
        //        double d1 = 23.53;
        //
        //        int num3 = b1 + s1;
        //        ● byte num4 = b2 + s1;
        //        ●char num5 = b2 + s1 + c1;
        //
        //        b2 += s1;//复合赋值运算符隐含一个强转
        //
        //         ●int num6 = l1 + c2 + b2;多种是数据类型一起计算，结果是范围最大的那个即l1，Long类型
        //        long num7 = l1 + c2 + b2;
        //        double num8 = c2 + d1;
        //
        // 		 ●num3 > 7 ? num3 = '*' : num3 = '%';结果必须被使用，输出或赋值

        /*7. 逻辑运算符判断程序运行结果*/
        int num1 = 10;
        int num2 = 34;
        char num3 = '7';
        char num4 = 97;
        //--------------------------------------------------
        //前置++和后置的区别，||，|两个或运算符区别
        if (num1 < 9 || ++num4 > 97) {
            System.out.println(num4);//b(98)  ●一般字符不论怎么赋值，直接输出都是字符形式
        }
        if (num1 < 9 || num4++ <= 98) {
            System.out.println(num4 + 0);//99  ●运算了，提升为int类型
        }
        if (num1 > 9 || num4++ <= 98) {
            System.out.println(num4);//c(99)//||前半部分执行true，后半部分不做判断不执行
        }
        if (num1 > 9 | num4++ <= 98) {
            System.out.println(num4);//d(100)// | 前半部分true,后半部分也要判断执行
        }

        //&&,&两个并运算符区别
        //10,34,'7'(55)
        if (++num1 > 10 && ++num2 > 34 && ++num3 > '7') {
            System.out.println(num1 + "," + num2 + "," + num3);
        }//11,35,8(56)
        if (++num1 < 10 && ++num2 > 34 && ++num3 > '7') {
            ;
        } else {
            System.out.println(num1 + "," + num2 + "," + num3);
        }//12,35,8(57)
        if (++num1 < 10 & ++num2 > 34 & ++num3 > '7') {
            ;
        } else {
            System.out.println(num1 + "," + num2 + "," + num3);
        }//13,36,9(58)

        if (num1++ > 11 || ++num2 > 34 || ++num3 > '7') {
            System.out.println(num1 + "," + num2 + "," + num3);
        }//14,36,9(58)
        if (num1++ > 12 | ++num2 > 35 | ++num3 > '8') {
            System.out.println(num1 + "," + num2 + "," + num3);
        }//15,37,10(59)

        if (num1 < 0 || num1 > 0 && num1++ <= 15) {
            System.out.println(num1);
        }//16
        if ((num1 < 0 && num1 > 0) && num1++ >= 16) {
            ;
        } else {
            System.out.println(num1);

        }//16 ,前段false,后段不执行

        num3 = '%';
        System.out.println(num3);//字符
        System.out.println(num3 + 0);//ascii码

        num3 = '(';
        switch (num3) {
            case '*':
                System.out.println("num3是*");
            case '(':
                System.out.println("num3是(");
            case '$':
                System.out.println("num3是$");
                break;
            case '@':
                System.out.println("num3是@");
                break;
            default:
                System.out.println();
                break;
        }
        //num3是(
        // num3是$

    }
}
