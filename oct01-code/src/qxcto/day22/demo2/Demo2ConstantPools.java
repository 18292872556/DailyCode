package qxcto.day22.demo2;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/10/01/20:54
 * @Description: 字符串常量池equalsIgnoreCase
 */
public class Demo2ConstantPools {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";
        char[] charArray = {'a', 'b', 'c'};
        String str3 = new String(charArray);

        byte[] byteArray = { 'a', 'b', 'c'};
        String str4 = new String(byteArray);

        byte[] b2 ={'a', 'b', 'c'};
        String str5 = new String(b2);

        System.out.println(str1 == str2);//true
        System.out.println(str2 == str3);//false
        System.out.println(str3 == str4);//false
        System.out.println(str4 == str5);//false

        System.out.println(str1.equals(str2));//true
        System.out.println(str2.equals(str3));//true
        System.out.println(str3.equals(str4));//true
        System.out.println(str4.equals(str5));//true

        System.out.println(str1.equalsIgnoreCase("ABC"));//true


    }
}
