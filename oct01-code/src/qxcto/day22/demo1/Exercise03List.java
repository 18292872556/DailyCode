package qxcto.day22.demo1;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/10/01/16:18
 * @Description: 按指定格式遍历集合字符串即ArrayList<String>
 * 定义以指定格式打印集合的方法(ArrayList类型作为参数）使用{}扩起集合，使用@分隔元素，
 * 格式参照{元素1@元素2@元素3@元素4}
 */
public class Exercise03List {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("一");
        list.add("二");
        list.add("三");

        printArray(list);

    }
    public static void printArray(ArrayList<String> list){
        System.out.print("{");
        for (int i = 0; i < list.size(); i++) {
            if(i == list.size() - 1){
                System.out.print(list.get(i));
            }else{
                System.out.print(list.get(i) + "@");
            }
        }
        System.out.println("}");
    }
}
