package qxcto.day22.demo1;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/10/01/16:28
 * @Description: 筛选集合中的随机数
 * 用一个大集合存入20个随机数字，然后筛选其中的偶数，
 * 放到小集合当中。要求使用自定义的方法来实现筛选，集合当返回值
 */
public class Exercise04List {
    public static void main(String[] args) {
        System.out.println(evenNumber(20));
    }

    //参数：确定传入大集合的随机数个数
    public static ArrayList<Integer> evenNumber(int size){
        ArrayList<Integer> maxList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Random r = new Random();
            maxList.add(r.nextInt());
        }
        System.out.println(maxList);

        ArrayList<Integer> minList = new ArrayList<>();
        for (int i = 0; i < maxList.size(); i++) {
            if(maxList.get(i) % 2 == 0){
                minList.add(maxList.get(i));
            }
        }
        return minList;
    }

}
