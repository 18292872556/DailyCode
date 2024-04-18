package qxcto.day23.demo1;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/10/02/19:00
 * @Description: 字符串的方法
 */
public class Demo3StringMethod {
    public static void main(String[] args) {
        //字符串的获取相关方法-------------------------------------------------------
        String str1 = "Hi~Barbie";
        System.out.println(str1.length());
        System.out.println(str1.concat("Hi~Ken"));
        System.out.println("索引3的字符" + str1.charAt(3));
        str1 = str1.concat("bie~hello java $ rusty lake is fate 1 larua is blossom");
        System.out.println("str1 : " + str1);
        System.out.println("第一次出现bie的索引位置：" + str1.indexOf("bie"));
        //字符串的截取方法
        System.out.println("从4截取" + str1.substring(4));
        System.out.println("从[7,13)截取" + str1.substring(7,13));
        //字符串的转换相关方法
        char[] ch = str1.toCharArray();
        System.out.println("char数组：" + ch);
        System.out.println(Arrays.toString(ch));

        byte[] by = str1.getBytes();
        System.out.println("by数组：" + by + Arrays.toString(by));
        for (int i = 0; i < by.length; i++) {
            System.out.print(by[i] + ",");
        }
        System.out.println();

        String str2 = "Hoow doo yoou doo?";
        System.out.println("str2" + str2);
        System.out.println(str2.replace("oo", "*"));

        //字符串的分割方法
        String[] str3 = str1.split("a");
        System.out.println("根据a划分str1："+ str1);
        for (int i = 0; i < str3.length; i++) {
            System.out.println(str3[i]);
        }

    }
}
