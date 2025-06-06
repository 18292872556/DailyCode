package com.qx.cto.Demo02.FileInput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: xuexuezi
 * @Date: 2025/06/06/18:07
 * @Description:


 */
public class Demo01FileInput {
    public static void main(String[] args) throws IOException{
        demo01();
        demo02();
    }
    // ★?练习_文件复制（①一次复制一个字节，②使用数组缓冲一次复制多个字节）
    private static void demo02() throws IOException{
        //C:\Users\hasee\Pictures\Camera Roll\壁纸\QQ图片20200301220447.jpg
        //从外面复制一个图片进来
        //FileInputStream fis1 = new FileInputStream("C:\\Users\\hasee\\Pictures\\Camera Roll\\壁纸\\QQ图片20200301220447.jpg");
        FileInputStream fis1 = new FileInputStream("C:\\Users\\hasee\\Pictures\\Camera Roll\\壁纸\\guidao.jpg");
        FileOutputStream fos1 = new FileOutputStream("June5\\demo02_1迪士尼公主图2.jpg");
        byte[] b1 = new byte[10];
        int len = 0;
        //System.out.println((len = fis1.read(b1)) + "," + len);// ●赋值表达式的返回值就是被赋值的变量的值
        while((len = fis1.read(b1)) != -1){
            System.out.println(Arrays.toString(b1));//打印一下每次复制图片的字节
            fos1.write(b1);//每次10个字节的复制
        }

    }

    //？字节输入流使用File构造，①从b.txt中一次读一个字节，②从c.txt中一次读3个字节
    private static void demo01()throws IOException {
        FileInputStream fis1 = new FileInputStream("June5" + File.separator + "demo01_5");
        //一次读一个
        int len = fis1.read();
        System.out.println((char)len);

        //一次读一个但读完
        while((len = fis1.read()) != -1){
            System.out.print((char)len);
        }
        System.out.println();

        //一次读三个，读完
        byte[] b1 = new byte[3];
        while((len = fis1.read(b1)) != -1){
            System.out.println(new String(b1));
        }
    }

}
