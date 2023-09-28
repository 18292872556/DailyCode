package qxcto.day04.demo1;

import java.util.Random;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/09/28/16:41
 * @Description: Random 练习2：猜数字，整数，范围1~100
 */
public class Exercise2GuessNumber {
    public static void main(String[] args) {
        guessNumber();
    }
    public static void guessNumber(){
        //无限制次数
        int num = new Random().nextInt(100) + 1;
        int count = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("猜数字游戏开始，数字范围为[1,100]的整数");
        while(true){
            System.out.println("请输入猜测的数字：");
            int n = sc.nextInt();
            count++;
            if(n == num){
                System.out.println("猜对了！该数字是"+ num +"本轮猜测" + count+"次");
                break;
            }else if(n < num){
                System.out.println("猜小了");
            }else{
                System.out.println("猜大了");
            }
        }
        System.out.println("游戏结束~");
    }
}
