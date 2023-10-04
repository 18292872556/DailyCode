package qxcto.day22.demo1;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/09/30/18:53
 * @Description:  集合练习题：生成6个1~33之间的随机整数，添加到集合，并遍历
 */
public class Exercise1List {
    public static void main(String[] args) {
        for (int n = 0; n < 1000; n++) {//测试100次
            Random r = new Random();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                int num = r.nextInt(33) + 1;
                list.add(num);
                
            }
            System.out.println(list);

        }
    }
}
