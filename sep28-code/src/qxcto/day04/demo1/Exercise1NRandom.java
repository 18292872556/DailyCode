package qxcto.day04.demo1;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/09/28/16:11
 * @Description: Random 练习1
 * 生成 1-n 之间的随机数
 */
public class Exercise1NRandom {
    public static void main(String[] args) {
        nRandom(100, 10);
    }
    //生成m,个[1,n]之间的随机数
    public static void nRandom(int m, int n){
        Random r = new Random();
        for (int i = 0; i < m; i++) {
            System.out.println(r.nextInt(n) + 1);//[0,n)->[1,n+1)->[1,n]
        }
    }

}
