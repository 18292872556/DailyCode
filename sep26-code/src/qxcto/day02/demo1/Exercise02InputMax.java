package qxcto.day02.demo1;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/09/26/20:22
 * @Description: 练习二，输入三个数，求max先判断前2个哪个大，再把最大的跟第3个比较
 */
public class Exercise02InputMax {
    public static void main(String[] args) {
        inputMax();
    }
    public static double inputMax(){
        System.out.println("输入3个整数");
        Scanner sc = new Scanner(System.in);
        double num1 = sc.nextDouble();
        double num2 = sc.nextDouble();
        double num3 = sc.nextDouble();
        double max = num1 < num2 ? num2 : num1;
        max = max < num3 ? num3 : max;
        System.out.println("max:" + max);
        return max;

    }

}
