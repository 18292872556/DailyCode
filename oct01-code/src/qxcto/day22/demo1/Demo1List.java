package qxcto.day22.demo1;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/09/28/18:31
 * @Description: ArrayList
 */
public class Demo1List {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("哈哈");
        list1.add("呵呵");
        list1.add("barbie");
        System.out.println(list1);//[哈哈, 呵呵]
        list1.remove(1);
        System.out.println(list1);
        System.out.println(list1.size());
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(5);
        list2.add(45);
        System.out.println(list2);
        list2.remove(2);
        System.out.println(list2);
        for (int i = 0; i < list2.size(); i++) {
            System.out.println(list2.get(i));
        }
    }
}
