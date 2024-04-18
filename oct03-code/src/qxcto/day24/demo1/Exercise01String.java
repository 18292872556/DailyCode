package qxcto.day24.demo1;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/10/03/18:24
 * @Description: 定义一个数组，把数组{1,2,3}按照指定格式拼接成一个字符串。
 * 格式:[word1#word2#word3]
 *
 * 思路：先把数组转化为字符串String,但注意分隔需要加逗号到字符串，再用split替换为#
 * 此处默认为字符串数组
 */
public class Exercise01String {
    public static void main(String[] args) {
        String[] strArr = {"hello", "甄嬛", "流朱", "barbie"};
        System.out.println(fromArrayToString(strArr));
    }
    public static String fromArrayToString(String[] array){
        String str = "[";

        for (int i = 0; i < array.length; i++) {
            if(i == array.length - 1){
                str += array[i];
            }else{
                str += array[i] + "#";
            }
        }
        str += "]";
        return str;
    }
}
