package code02;

import java.util.Arrays;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/01/26/17:31
 * @Description:
 */
public class Class01 {
    // 用Arrays相关的API，将一个随机字符串中的所有字符升序排序，并倒序打印
    /*生成一个随机字符串
*/
    public static String generateStr(int maxSize, int maxValue){
        //已知，字符串范围0,65535。生成这个范围内的ASCII码即可
        //练习，用两种方法生成随机数
//        Random r = new Random();
//        int size = r.nextInt(maxSize + 1);
//        char[] ch = new char[size];
//        for (int i = 0; i < size; i++) {
//            ch[i] = (char)(r.nextInt(65536));
//        }

        //为了方便打印，还是取32~126
        if(maxValue > 95){
            System.out.println("重新输字符串最大值，为了方便打印不要超过95");
            return null;
        }

        int size = (int)(Math.random() * (maxSize + 1));
        int[] arr = new int[size];
        String str = new String();
        for (int i = 0; i < size ; i++) {
            arr[i] = (int)(Math.random() * maxValue) + 32;
            str += (char)arr[i];
        }
        return str;
    }
}
