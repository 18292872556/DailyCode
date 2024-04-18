package qxcto.day01.demo01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/09/25/21:23
 * @Description: 两个对象使用同一种方法的内存图
 */
public class Demo02PhoneTwo {
    public static void main(String[] args) {
        Phone one = new Phone();
        Phone two = new Phone();

        one.brand = "苹果";
        one.price = 10000.0;
        one.color = "粉";
        one.call("小乔");
        one.sendMessage();

        two.brand = "华为";
        two.color = "紫";

        two.call("小齐");
        two.sendMessage();



    }




}
