package code02;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/01/26/17:20
 * @Description: Arrays工具类
 */
public class Demo01 {
    public static void main(String[] args) {
        String str1 = Class01.generateStr(20,95);
        System.out.println(str1);

        char[] ch = str1.toCharArray();
        Arrays.sort(ch);
        for (int i = ch.length - 1; i >= 0; i--) {
            System.out.print(ch[i] + ",");
        }
    }
}
