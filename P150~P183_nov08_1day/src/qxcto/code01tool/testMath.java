package qxcto.code01tool;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/11/08/19:59
 * @Description: P150~P151
 */
public class testMath {
    public static void main(String[] args) {
        //
        double d1 = -3.4;
        double d2 = 345.5424;
        double d3 = 65.23452346;
        double d4 = 7655.434689765;
        System.out.println(Math.abs(d1));//绝对值
        System.out.println(Math.ceil(d2));//向上取整
        System.out.println(Math.floor(d3));//向下取整
        System.out.println(Math.round(d4));//四舍五入
        System.out.println(Math.round(d2));
        /* 计算在-10.8到5.9之间，绝对值大于6或者小于2.1的整数有多少个？
        绝对值 > 6, < -6 && > 6（5.9不可能大于6）。绝对值 < 2.1, < 2.1 && > - 2.1
        -> < -6 或 < 2.1 && > -2.1
        */
        //新的边界包含：对浮点数左界向上取整，右界向下取整。
        //[ceil(-10.8),floor(5.9)]->[-9, 5]
        int count = 0;
        double i = 0.0;
        for(i = Math.ceil(-10.8); i <= Math.floor(5.9); i++){//注意此处i为double，但也符合整数，也可以++
            if(i < -6 || (i > -2.1 && i < 2.1)){
                count++;
                System.out.println(i);
            }
        }
        System.out.println("符合的数有:" + count + "个");
    }

}
