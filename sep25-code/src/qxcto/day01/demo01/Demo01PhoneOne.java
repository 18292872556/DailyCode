package qxcto.day01.demo01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/09/25/21:11
 * @Description: 测试一个Phone对象
 */
public class Demo01PhoneOne {
    public static void main(String[] args) {
        Phone one = new Phone();
        one.brand = "苹果";
        one.price = 8799.0;
        one.call("小明");
        one.sendMessage();
        System.out.println(one.brand);
        System.out.println(one.price);
        System.out.println(one.color);
    }
}
