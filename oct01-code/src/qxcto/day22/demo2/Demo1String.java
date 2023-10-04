package qxcto.day22.demo2;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/10/01/16:50
 * @Description:
 */
public class Demo1String {
    public static void main(String[] args) {
        //三种创建字符串方式
        String str1 = new String();//空字符串
        char[] ch = new char[]{'2', '5', '3', '0'};
        String str2 = new String(ch);
        byte[] by = new byte[]{97, 65, 4, 77};
        String str3 = new String(by);

        System.out.println(str1 + "\n" + str2 + "\n" + str3 + "\n" + "barbie");
    }
}
