package com.qxcto.putStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileOutputStream;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: xuexuezi
 * @Date: 2025/07/05/16:46
 * @Description:
 */
public class Demo01InOutputStream {
    public static void main(String[] args) throws IOException{
        //test02();
        //demo01();
        demo02();
        demo03();
    }
    //文件复制，②使用数组缓冲一次复制多个字节）
    private static void demo03() throws IOException{
        FileInputStream fis1 = new FileInputStream("july08\\src\\demo03文本文件.txt");//ABCDE
        FileOutputStream fos1 = new FileOutputStream("july08\\demo03_2读文件.txt");
        int len = 0;
        byte[] b1 = new byte[3];
        while((len = fis1.read(b1)) != -1){
            //如何防止读到b1中的无效数据（上轮读取到的）
            //fos1.write(b1);//demo03_2读文件：ABCDEC
            fos1.write(b1,0,len);//★用write的三参数//demo03_2读文件：ABCDE
        }
        fos1.close();
        fis1.close();
    }
    /*?练习_文件复制（①一次复制一个字节，*/
    private static void demo02() throws IOException{
        //把外部的一张图片复制到当前项目下
        FileInputStream fis1 = new FileInputStream("C:\\Users\\hasee\\Pictures\\Camera Roll\\头像\\20220612034131_fd301.jpg");
        FileOutputStream fos1 = new FileOutputStream("july08\\复制图片1.jpeg");
        int len = 0;
        while((len = fis1.read()) != -1){
            fos1.write(len);
        }
        fos1.close();
        fis1.close();
    }

    /**
     * ？字节输入流使用File构造，①从demo01_2中一次读一个字节，②从demo01_5中一次读3个字节
     */
    private static void demo01() throws IOException{
        FileInputStream fis1 = new FileInputStream("july08\\demo01_2");
        FileInputStream fis2 = new FileInputStream("july08\\demo01_5");
        System.out.println("--------------每个文件读三次----------");
        int len1 = 0;//获取每次读到的字节
        int len2 = 0;//获取读到字节的有效个数

        byte[] b1 = new byte[3];//用长度为3的字节数组接收

        /*每个文件读三次*/
        len1 = fis1.read();//只读一次
        System.out.print((char)len1);
        len1 = fis1.read();//只读一次
        System.out.print((char)len1);
        len1 = fis1.read();//只读一次
        System.out.println((char)len1);

        len2 = fis2.read(b1);
        System.out.print(new String(b1));
        len2 = fis2.read(b1);
        System.out.print(new String(b1));
        len2 = fis2.read(b1);
        System.out.println(new String(b1));


//        /*循环一直读，读到文件结束*/
        System.out.println("--------------循环一直读，读到文件结束--------------");
        System.out.println("demo01_2:");
        while((len1 = fis1.read()) != -1){
            System.out.print((char)len1);//获取到的字节强转字符
        }

        System.out.println("demo01_5:");
        while((len2 = fis2.read(b1)) != -1){

//            System.out.println(b1);//是数组地址//[B@19e1023e
//            System.out.println(Arrays.toString(b1));//打印字节数组元素，第一次为//[52, 45, 49]
            System.out.print(new String(b1,0,len2));
            //★把字节数组转为字符型可以按照字符串格式打印，并且按照有效长度转字符串并打印。避免多输出上次读取到的无效数据
        }

    }

    private static void test02() throws IOException{
        //1. append为false,或无append
        FileOutputStream fos1 = new FileOutputStream("july08\\demo01_2", false);
        fos1.write("1-1 false write".getBytes());//被覆盖
        FileOutputStream fos2 = new FileOutputStream("july08\\demo01_2");
        fos2.write("1-2 no append write ".getBytes());
        fos1.close();
        fos2.close();

        //2. 指向同一路径的不同流对象append为false,但最后一次为true
        FileOutputStream fos3 = new FileOutputStream("july08\\demo01_3", true);
        fos3.write("2-1 true write".getBytes());//被覆盖
        FileOutputStream fos4 = new FileOutputStream("july08\\demo01_3", false);
        fos4.write("2-2 false write".getBytes());
        fos3.close();
        fos4.close();

        //3. 指向同一路径的不同流对象append为true,但最后一次为false
        FileOutputStream fos5 = new FileOutputStream("july08\\demo01_4",false);
        fos5.write("3-1 falsel write".getBytes());
        FileOutputStream fos6 = new FileOutputStream("july08\\demo01_4", true);
        fos6.write("3-2 true write\r\n".getBytes());//追加成功
        fos5.close();
        fos6.close();

        //4.两个流都是true
        FileOutputStream fos7 = new FileOutputStream("july08\\demo01_5",true);
        fos7.write("4-1 true write".getBytes());
        FileOutputStream fos8 = new FileOutputStream("july08\\demo01_5",true);
        fos8.write("4-2 true write\n".getBytes());
        fos7.close();
        fos8.close();
    }
}
