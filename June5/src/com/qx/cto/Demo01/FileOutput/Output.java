package com.qx.cto.Demo01.FileOutput;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: xuexuezi
 * @Date: 2025/06/05/15:17
 * @Description:
 *
 *
 *
 *
 */
public class Output {
    public static void main(String[] args) throws IOException{
//        demo01();
        demo02();

    }

    /*文件存储的原理和记事本打开文件的原理*/
    //一切皆字节，文件全部以字节形式存储到硬盘中
    //打开文件时，根据存储的字节在ASCII码表中查询转换即可

    //？字节输出流的续写和换行①覆盖原文件写法②不覆盖原文件而是追加续写并换行
    private static void demo02() throws IOException {
        //1. append为false,或无append
        FileOutputStream fos1 = new FileOutputStream("June5\\demo01_2", false);
        fos1.write("1-1 第一次写入false流对象".getBytes());//被覆盖
        FileOutputStream fos2 = new FileOutputStream("June5\\demo01_2");
        fos2.write("1-2 第二次写入没有append存在的情况".getBytes());
        fos1.close();
        fos2.close();

        //2. 指向同一路径的不同流对象append为false,但最后一次为true
        FileOutputStream fos3 = new FileOutputStream("June5\\demo01_3", true);
        fos3.write("2-1 第一次写入true".getBytes());//被覆盖
        FileOutputStream fos4 = new FileOutputStream("June5\\demo01_3", false);
        fos4.write("2-2 第二次写入false".getBytes());
        fos3.close();
        fos4.close();

        //3. 指向同一路径的不同流对象append为true,但最后一次为false
        FileOutputStream fos5 = new FileOutputStream("June5\\demo01_4",false);
        fos5.write("3-1第一次写入false".getBytes());
        FileOutputStream fos6 = new FileOutputStream("June5\\demo01_4", true);
        fos6.write("3-2 第二次写入true\r\n".getBytes());//追加成功
        fos5.close();
        fos6.close();//但重复运行追加失败，因为fos5为false

        //4.两个流都是true
        FileOutputStream fos7 = new FileOutputStream("June5\\demo01_5",true);
        fos7.write("4-1 第一次写入true".getBytes());
        FileOutputStream fos8 = new FileOutputStream("June5\\demo01_5", true);
        fos8.write("4-2 第二次写入false\n".getBytes());//追加成功
        fos7.close();
        fos8.close();//重复运行追加成功

    }

    //？字节输出流写入数据“你好balabala”到当前模块下a.txt文件；使用write的三种方法,写入数组的中间一段
    private static void demo01() throws IOException{
        FileOutputStream fos1 = new FileOutputStream("June5\\demo01_1");//只能单级创建文件
        byte[] b1 = "你好balabala".getBytes();

//        for(int i=0; i < b1.length; i++){
//            fos1.write(b1[i]);
//        }


        fos1.write(b1);
//
//        fos1.write(b1, 2, 4);//�好


        //手动删除后CTRL + S保存，看一眼已经写过的文件有没有内容，输出一下
//        FileInputStream fis = new FileInputStream("June5\\demo01_1");
//        byte[] b2 = new byte[10];
//        fis.read(b2);
//        System.out.println(new String (b2));
    }
}
