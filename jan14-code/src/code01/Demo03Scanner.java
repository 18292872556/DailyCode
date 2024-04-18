package code01;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/01/14/23:47
 * @Description:
 */
public class Demo03Scanner {
    public static void main(String[] args) {
        //输入四句话并合并
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        str1 += sc.next();
        str1 += sc.next();
        str1 += sc.next();
        System.out.println(str1);

        //输入三个int数，输出最大的
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();
        num1 = num1 > num2 ? num1 : num2;
        num3 = num1 > num3 ? num1 : num3;
        System.out.println(num3);


    }

}
