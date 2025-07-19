import java.io.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: xuexuezi
 * @Date: 2025/07/19/3:50
 * @Description:
 */
public class Demo03_jdk_IOException {
    public static void main(String[] args) throws IOException{
//        demo01();
//        demo02();
//        demo03();
        demo04();

       // test01();//读写同步进行，刚写的，读不出来？可以的，记得刷新缓存！
    }

    /*？复制图片文件,①字节流②字符流*/
    private static void demo04() throws IOException{
        //字节流
        //C:\Users\hasee\Pictures\Camera Roll\电影电视剧截图\公主.PNG
        FileInputStream fis1 = new FileInputStream("C:\\Users\\hasee\\Pictures\\Camera Roll\\电影电视剧截图\\公主.PNG");
        FileOutputStream fos1 = new FileOutputStream("july19\\src\\复制图1.PNG");//从外面读，读完写入当前项目模块路径下
        int len = 0;
        while((len = fis1.read()) != -1){
            fos1.write(len);//一次一个字节的复制
        }
        //字符流
        //C:\Users\hasee\Pictures\Camera Roll\电影电视剧截图\公主2.PNG
//        FileReader fr1 = new FileReader("C:\\Users\\hasee\\Pictures\\Camera Roll\\电影电视剧截图\\公主2.PNG");
//        FileWriter fw1 = new FileWriter("july19\\src\\复制图2.PNG");
//        int len2 ;
//        while((len2 = fr1.read()) != -1){
//            fw1.write(len2);//一次一个字符的复制
//            fw1.flush();
//        }
        //不成功，解码出错。跳过


    }


    private static void test01() throws IOException{

        FileWriter fw1 = new FileWriter("july19\\src\\readable03.txt", true);
        FileReader fr1 = new FileReader("july19\\src\\readable03.txt");

        fw1.write("刚写的试试能不能下句读出来\n");
        fw1.flush();
        char[] ch1 = new char[4];
        int len = 0;
        while((len = fr1.read(ch1)) != -1){
            System.out.print(new String(ch1, 0, len));//new String的返回值就是字符串本身
        }
    }


    /*③JDK1.9之后,很鸡肋，单独在外部定义流对象还是要抛出异常或者单独处理*/
    private static void demo03() throws IOException{
        System.out.println("--------------jdk1.9后-------------");
        //③jdk1.9之后

        FileWriter fw2 = new FileWriter("july19\\src\\readable03.txt", true);
        FileReader fr1 = new FileReader("july19\\src\\readable03.txt");
        //还要抛出异常，根本没意义。或者用jdk1.7之前的写一大堆包含finally的，或者用jdk1.7之后的直接定义在try()里

        try(fw2;fr1) {
            fw2.write("jdk1.9后，第三次写入数据\n");
            fw2.flush();
            char[] ch1 = new char[4];
            int len = 0;
            while((len = fr1.read(ch1)) != -1){
                System.out.print(new String(ch1, 0, len));//new String的返回值就是字符串本身
            }
        }catch(IOException e){
            e.toString();
        }
    }
    /*②JDK1.7之后处理流异常*/
    private static void demo02() {
        System.out.println("--------------jdk1.7后-------------");

        //②jdk1.7之后，无需finally，try中内容结束时自动释放流对象
        try (FileOutputStream fos = new FileOutputStream("july19\\src\\readable03.txt", true);
             FileInputStream fis = new FileInputStream("july19\\src\\readable03.txt")) {
            fos.write("jdk1.7后，第二次写入数据\n".getBytes());
            int len = 0;
            while((len = fis.read()) != -1) {
                System.out.print(len+" ");
                System.out.print((char)len);
            }
        }catch (IOException e){
            e.getMessage();
        }
    }



    /*使用try_catch_finally处理流中的异常①JDK1.7之前处理流异常；*/
    private static void demo01() {
        System.out.println("--------------jdk1.7前-------------");

        //以字符输出流为例
        //①jdk1.7之前,麻烦在close方法需要在finally中必然执行，但自身又有流异常还有空指针异常。都需要处理
        FileWriter fw1 = null;
        try{
            fw1 = new FileWriter("july19\\src\\readable03.txt", true);
            fw1.write("jdk1.7前，第一次写入数据\n");
            fw1.flush();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(fw1 != null){
                try {
                    fw1.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }

    }

}
