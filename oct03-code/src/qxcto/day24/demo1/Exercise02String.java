package qxcto.day24.demo1;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/10/03/18:45
 * @Description: 统计输入的字符串中各种字符的个数，键盘输入一个字符串，
 * 并且统计其中各种字符出现的次数。种类有：大写字母、小写字母、数字、其他。
 */
public class Exercise02String {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入任意字符串");
        String str = sc.next();

        int[] count = countChar(str);
        System.out.println("str:" + str);
        System.out.println("数字个数:" + count[0] + " 大写字母:" +
                count[1] + " 小写字母:" + count[2] + " 其他:" + count[3]);
    }
    public static int[] countChar(String str){
        char[] ch = str.toCharArray();
        //计数器count
        int[] count = new int[4];//4种,分别统计为数字，大写字母，小写字母，其他
        for (int i = 0; i < ch.length; i++) {
            if(ch[i] >= 48 && ch[i] <= 57){
                count[0]++;
            }else if(ch[i] >= 65 && ch[i] <= 90){
                count[1]++;
            }else if(ch[i] >= 97 && ch[i] <= 122){
                count[2]++;
            }else{
                count[3]++;
            }
        }
        return count;
    }
}
