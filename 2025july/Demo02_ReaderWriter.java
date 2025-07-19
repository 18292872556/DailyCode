import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: xuexuezi
 * @Date: 2025/07/08/23:48
 * @Description:
 *
 */
public class Demo02_ReaderWriter {
    public static void main(String[] args) throws IOException{
//        demo01();
//        demo02();
        demo03();
    }

    /*？字符输出流的续写和换行,
    ①第一次运行成功续写，多次运行不成功续写
    ②第一次运行成功续写，多次运行也成功
    ③单次多次都不成功续写
    ④没有单次运行续写失败，多次成功的情况。因为多次运行先续写成功，随后的单次运行中就被覆盖*/
    private static void demo03() throws IOException{
        //①
        FileWriter fw1 = new FileWriter("july18\\src\\writable02_3_1.txt");
        FileWriter fw2= new FileWriter("july18\\src\\writable02_3_1.txt",true);
        fw1.write("null");
        fw2.write("true\n");

        //②
        FileWriter fw3 = new FileWriter("july18\\src\\writable02_3_2.txt",true);
        FileWriter fw4= new FileWriter("july18\\src\\writable02_3_2.txt",true);
        fw3.write("true");
        fw4.write("true\n");

        //③
        FileWriter fw5 = new FileWriter("july18\\src\\writable02_3_3.txt",false);
        FileWriter fw6 = new FileWriter("july18\\src\\writable02_3_3.txt");
        fw5.write("false");
        fw6.write("null\n");

        //④
        FileWriter fw7 = new FileWriter("july18\\src\\writable02_3_4.txt",true);
        FileWriter fw8 = new FileWriter("july18\\src\\writable02_3_4.txt",false);
        fw7.write("true");
        fw8.write("false\n");

        fw1.flush();
        fw2.flush();
        fw3.flush();
        fw4.flush();
        fw5.flush();
        fw6.flush();
        fw7.flush();
        fw8.flush();

    }


    /*？字符输出流的基本使用_ ？字符输出流写数据的5种方法（写入字符数组一部分）*/
    private static void demo02() throws IOException{
        FileWriter fw1 = new FileWriter("july18\\src\\writable02");//输出时，文件不存在会自动创建，但是只能单级创建
        //字符输出流肯定是写入字符
        // ①写入一个字符
        fw1.write(48);
        fw1.write(65);
        fw1.write(97);
        fw1.write('\n');//换行符

        //②写入一个字符数组What are you looking at?
        char[] ch1 = new String("What are you looking at?\n").toCharArray();
        fw1.write(ch1);
        //③写入一个字符数组的一部分
        fw1.write(ch1, 9, ch1.length-9);
        //④写入一个字符串
        String str1 = new String("写入本字符串~");
        fw1.write(str1);
        //⑤写入一个字符串的一部分
        fw1.write(str1, 2,4);
        /*该句之前，文件内容没有任何写入*/
        fw1.flush();
        fw1.close();
    }

    /*？字符输入流，一次读一个字符；一次读多个字符*/
    private static void demo01() throws IOException {
        FileReader fr1 = new FileReader("july18\\src\\Readable02");
        int len = 0;//获取读到的字符,以Ascii码的int形式获取
        //一次读一个字符
//        while((len = fr1.read()) != -1) {
//            System.out.print((char) len);//给Demo02-demo01文件字符输入流读的
//        }// ●这次循环读完文件内容，后续同一个流对象就读不出了，因为已经读完了。

        //一次读多个字符
        len = 0;
        char[] ch1 = new char[3];
        while((len = fr1.read(ch1)) != -1){// ●此处len不再是接收读到的字符，而是返回一次读多个字符的有效字符个数
            System.out.print(new String(ch1, 0, len));//把获取的字符数组，按字符串形式打印
            //给Demo02-demo01文件字符输入流读的

            //两种输出方式的区别
            //给De[给, D, e]
            //mo0[m, o, 0]
            System.out.println(Arrays.toString(ch1));//打印成[,]的形式的字符数组
            //[给, D, e]
            //[m, o, 0]
            //[2, -, d]
            //[e, m, o]
            //[0, 1, 文]
            //[件, 字, 符]
            //[输, 入, 流]
            //[读, 的, 流]
        }
    }

}
