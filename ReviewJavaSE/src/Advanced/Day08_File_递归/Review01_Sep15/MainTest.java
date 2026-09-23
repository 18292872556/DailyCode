package Advanced.Day08_File_递归.Review01_Sep15;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/09/15/下午6:16
 * @Description:
 */
public class MainTest {
    // Day08【File类、递归】练习题
// 完成标准：20题全部独立写出并运行验证，即视为本章完成。

// 01【File对象创建】
// 分别使用 String 路径、父路径+子路径、父File对象+子路径创建3个File对象。
// 路径可使用项目目录下的测试文件或目录。
    private static void demo01(){
        File f1 = new File("ReviewJavaSE/src/Advanced/Day08_File_递归/Review01_Sep15" +
                "demo01");
        File f2 = new File("ReviewJavaSE/src/Advanced/Day08_File_递归/Review01_Sep15" +
                "demo01.txt", "a.txt");
        File f3 = new File(f1, "b.txt");

    }



// 02【File路径信息】
// 创建一个File对象，分别输出它的绝对路径、构造时使用的路径、名称。
// 要求分别使用 getAbsolutePath()、getPath()、getName()。
    private static void demo02(){
        File f1 = new File("ReviewJavaSE/src/Advanced/Day08_File_递归/Review01_Sep15/" +
                "demo02.txt");

        System.out.println("f1绝对路径：" + f1.getAbsolutePath());
        System.out.println("f1构造时候的相对路径：" + f1.getPath());
        System.out.println("f1名称:" + f1.getName());


    }

// 03【文件长度与类型】
// 创建一个指向实际文件的File对象，输出文件大小，并判断它是否存在、是否为文件。
// 再创建一个实际目录进行同样的存在性和类型判断。
    private static void demo03(){
        File f1 = new File("ReviewJavaSE/src/Advanced/Day08_File_递归/Review01_Sep15" +
                "MainTest.java");//本文件
        System.out.println("f1是否存在：" + f1.exists());
        System.out.println("f1文件大小：" + f1.length());
        System.out.println("f1是否为文件：" + f1.isFile());

        File dir1 = new File("ReviewJavaSE/src/Advanced/Day08_File_递归/Review01_Sep15" );
        //本目录
        System.out.println("dir1是否存在：" + dir1.exists());
        System.out.println("dir1文件大小：" + dir1.length());
        System.out.println("dir是否为目录" + dir1.isDirectory());

    }

// 04【相对路径与绝对路径】
// 分别使用一个绝对路径和一个相对路径创建File对象。
// 输出二者的绝对路径，观察相对路径最终对应到项目目录下的什么位置。
    private static void demo04(){
        File f1 = new File("ReviewJavaSE/src/Advanced/Day08_File_递归/Review01_Sep15");
        File f2 = new File("C:\\Users\\XueXueZi\\xue_file\\2领域\\IDEA_Project\\JavaSE\\ReviewJavaSE\\src\\Advanced\\Day08_File_递归\\Review01_Sep15");
        System.out.println("相对路径的f1的绝对路径：" + f1.getAbsolutePath());
        System.out.println("绝对路径的f2的绝对路径：" + f2.getAbsolutePath());
    }

// 05【创建文件】
// 创建一个File对象指向项目目录下不存在的txt文件。
// 使用 createNewFile() 创建它，并分别输出创建前后 exists() 的结果。
    private static void demo05(){
        File f1 = new File("ReviewJavaSE/src/Advanced/Day08_File_递归/Review01_Sep15/demo04.txt");
        System.out.println("demo04.txt是否存在：" + f1.exists());
        try{
            f1.createNewFile();
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("demo04.txt是否存在：" + f1.exists());
    }

// 06【创建目录】
// 分别使用 mkdir() 和 mkdirs() 创建目录。
// 要求通过实际运行验证：mkdir() 与 mkdirs() 在创建多级目录时有什么区别。
    private static void demo06(){
//        File dir1 = new File("ReviewJavaSE/src/Advanced/Day08_File_递归/Review01_Sep15/demo06.txt");
        File dir1 = new File("ReviewJavaSE/src/Advanced/Day08_File_递归/Review01_Sep15/demo06/demo06.txt");
        File dir2 = new File("ReviewJavaSE/src/Advanced/Day08_File_递归/Review01_Sep15/demo06/A/demo06.txt");
        System.out.println("mkdir创建两层目录：" + dir1.mkdir());
        System.out.println("mkdirs创建两层目录：" + dir1.mkdirs());
        System.out.println("mkdirs创建三层目录：" + dir2.mkdirs());

    }

// 07【删除文件和目录】
// 创建一个测试文件和一个空目录并删除它们。
// 再创建一个包含文件的目录，尝试删除该目录，观察 delete() 的结果。
    private static void demo07(){
        /*delete删目录的时候只能删除空目录*/
        File f1 = new File("ReviewJavaSE/src/Advanced/Day08_File_递归/Review01_Sep15/demo07/demo07.txt");
        File dir1 = new File("ReviewJavaSE/src/Advanced/Day08_File_递归/Review01_Sep15/demo07");
        dir1.mkdirs();
        try{
            f1.createNewFile();

        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("删目录（非空）：" + dir1.delete());
        System.out.println("删文件：" + f1.delete());
        System.out.println("删目录（空）：" + dir1.delete());
    }

// 08【遍历目录】
// 创建一个实际存在的测试目录，使用 list() 遍历并输出其中所有子文件和子目录的名称。
// 再使用 listFiles() 遍历并输出每个File对象。
    private static void demo08(){
        File dir1 = new File("ReviewJavaSE/src/Advanced/Day08_File_递归/Review01_Sep15/demo08/A/txt");
        File f1 = new File("ReviewJavaSE/src/Advanced/Day08_File_递归/Review01_Sep15/demo08/B.txt");
        File f2 = new File("ReviewJavaSE/src/Advanced/Day08_File_递归/Review01_Sep15/demo08/C.txt");
        File f3 = new File("ReviewJavaSE/src/Advanced/Day08_File_递归/Review01_Sep15/demo08/D.txt");
        dir1.mkdirs();
        try{
            f1.createNewFile();
            f2.createNewFile();
            f3.createNewFile();
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("FileList遍历");
        for(File f : dir1.listFiles()){
            System.out.println(f);
        }
        System.out.println("StringList遍历");
        for(String f : f1.list()){
            System.out.println(f);
        }

    }

// 09【listFiles判断】
// 编写代码遍历一个目录中的所有File对象。
// 根据 isFile() 和 isDirectory() 分别输出“文件”和“目录”。
    private static void demo09(){
        //就遍历上一个的吧
        File dir1 = new File("ReviewJavaSE/src/Advanced/Day08_File_递归/Review01_Sep15/demo09/A/txt");
        File f1 = new File("ReviewJavaSE/src/Advanced/Day08_File_递归/Review01_Sep15/demo09/B.txt");
        File f2 = new File("ReviewJavaSE/src/Advanced/Day08_File_递归/Review01_Sep15/demo09/C.txt");
        File f3 = new File("ReviewJavaSE/src/Advanced/Day08_File_递归/Review01_Sep15/demo09/D.txt");
        dir1.mkdirs();
        try{
            f1.createNewFile();
            f2.createNewFile();
            f3.createNewFile();
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("FileList遍历");
        for(File f : dir1.listFiles()){
            System.out.print(f + " ");
            if(f.isDirectory()){
                System.out.println("是目录");
            }else if(f.isFile()){
                System.out.println("是文件");
            }

        }
    }

// 10【递归基础】
// 编写一个递归方法 countDown(int n)，从n开始依次输出到1。
// 要求设置明确的递归结束条件，不能无限递归。
    private static void demo10(){
        countDown(10);
    }
    private static void countDown(int n){
        if(n > 1){//最后一次调用就是2-1为1
            countDown(n-1);

//            return n;
        }
        System.out.println(n);
//        return 0 ;

    }

// 11【递归累加】
// 编写递归方法 getSum(int n)，计算1~n的累加和。
// 例如传入5，返回15。

// 12【递归阶乘】
// 编写递归方法 getFactorial(int n)，计算n的阶乘。
// 例如传入5，返回120，并设置正确的递归出口。

// 13【递归执行过程】
// 在递归求阶乘的方法中加入输出，观察方法调用和返回的过程。
// 用5测试，理解为什么递归最终能够返回到最初调用的方法。

// 14【递归遍历目录】
// 编写 printDir(File dir)，递归遍历一个目录的所有层级。
// 文件输出“文件名+绝对路径”，目录输出“目录+绝对路径”。

// 15【递归搜索.java文件】
// 在递归遍历目录的基础上，只输出名称以“.java”结尾的文件。
// 遇到目录继续递归，遇到其他文件不输出。

// 16【FileFilter】
// 使用 listFiles(FileFilter) 改写上一题，不再在遍历循环中判断是否保留文件。
// 过滤规则：保留“.java”文件和目录。

// 17【FileFilter匿名内部类】
// 使用FileFilter匿名内部类实现过滤器，并在accept()中完成判断。
// 返回true表示保留：“.java”文件或目录；否则返回false。

// 18【Lambda改写FileFilter】
// 将上一题的FileFilter匿名内部类改写成Lambda表达式。
// 保持过滤规则不变：“.java”文件或目录。

// 19【综合：递归文件搜索】
// 编写searchJava(File dir)，递归搜索指定目录及所有子目录中的“.java”文件。
// 使用FileFilter + Lambda筛选，只打印符合条件的文件绝对路径。

// 20【综合：文件统计】
// 编写递归方法统计指定目录下所有文件的数量，并返回总数。
// 目录只负责继续递归，文件数量+1，最终输出文件总数。

    public static void main(String[] args) {
        demo10();
    }
}
