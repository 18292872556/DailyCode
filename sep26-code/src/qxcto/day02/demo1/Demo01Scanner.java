package qxcto.day02.demo1;
import java.util.Scanner;
/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/09/26/20:14
 * @Description:
 */
public class Demo01Scanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入一个int给sc");
        int num = sc.nextInt();
        System.out.println("输入一个String给num");
        String str = sc.next();
        System.out.println("输出接收的sc,num");
        System.out.println(num + "," + str);

    }
}
