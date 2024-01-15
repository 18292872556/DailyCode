package code01;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/01/14/23:44
 * @Description: 匿名对象
 */
public class Demo02 {
    public static void method1(Scanner sc){
        System.out.println("输入几个整数，判断最小值");

        int num = sc.nextInt();
        int max = num;
        for(int i = 0; i < 5; i++){
            if(sc.hasNextInt()){
                num = sc.nextInt();
                max = num < max? num: max;
            }
            else{
                String str = sc.next();//把错误数据先读取掉，免得后续又读到
                System.out.println("输入的不是整数，重新输");

            }
        }
        System.out.println(max);

    }

    public static Scanner method2(){
        Scanner sc = new Scanner(System.in);
        return sc;
    }

    public static void main(String[] args) {
        //1.匿名对象做参数，方法用来输入和并打印输入的数
        //method1(new Scanner(System.in));

        Scanner sc = method2();
        System.out.println(sc.next());


    }
}
