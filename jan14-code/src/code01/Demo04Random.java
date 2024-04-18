package code01;

import java.util.Random;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/01/15/2:33
 * @Description:
 */
public class Demo04Random {
    public static void main(String[] args) {
//        Random rd2 = new Random(10);
//        double numDouble4 = rd2.nextDouble();//循环多少次都固定产生0.7304302967434272
//        int numInt6 = rd2.nextInt(5);//固定产生3
//        System.out.println(numDouble4);
//        System.out.println(numInt6);

        //想生成，[3,9]的随机数
//        for (int i = 0; i < 10; i++) {
//            Random r1 = new Random();
//            System.out.print("Random:" + (r1.nextInt(7) + 3));
//
//            System.out.print(" Math:" + (int)(3 + Math.random() * 7) );
//            System.out.println();
//        }

        //猜数字
        boolean flag = true;
        System.out.println("请输入猜的数字，范围1~100");
        int tmp = new Random().nextInt(100) + 1;
        int time = 0;
        while(flag){
            time++;
            Scanner sc = new Scanner(System.in);
            if(sc.hasNextInt()){
                int num = sc.nextInt();
                if(num < 1 || num > 100){
                    System.out.println("不在范围内，范围是1~100");
                    continue;
                }
                if(num > tmp){
                    System.out.println("猜大了");
                }else if(num < tmp){
                    System.out.println("猜小了");
                }else{
                    System.out.println("恭喜你猜对了！本轮用了" + time + "次");
                    break;
                }
            }else{
                System.out.println("输错了，不是整数，重新输");
            }


        }



    }
}
