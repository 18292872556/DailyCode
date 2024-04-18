package qxcto.day09.demoRedList;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/11/02/19:35
 * @Description: 测试发红包的过程
 */
public class DemoTest {
    public static void main(String[] args) {
        Manager m1 = new Manager("群主", 10000);
//        System.out.println();
//        Manager m2 = new Manager();

        //发红包的份数，总共发100块
        ArrayList<Double> redList = m1.send(4,1000);
        System.out.println(redList);
        int sum = 0;
        for (int i = 0; i < redList.size(); i++) {
            sum += redList.get(i);
        }
        System.out.println("检查红包总额是否正确" + sum);

        //把所有群成员存入集合,泛型定义为父类，两个子类对象都可以存进去
        ArrayList<Member> group = new ArrayList<>();
        group.add(m1);//唯一一个发红包的群主
        group.add(new Member("A", 0));
        group.add(new Member("B", 0));
        group.add(new Member("C", 40));
        group.add(new Member("D", 0));
        group.add(new Member("E", 3));
        group.add(new Member("F", 0));

        for (int i = 0; i < group.size(); i++) {//所有成员都开始抢红包
            group.get(i).receive(redList);
        }







    }
}
