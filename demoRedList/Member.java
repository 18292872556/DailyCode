package qxcto.day09.demoRedList;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/11/02/22:23
 * @Description: 问题，怎么确定红包还有没有呢，怎么选。要全部遍历一遍?
 * 因为红包内金额是随机放入的，所以抢的时候按顺序抢就行
 */
public class Member extends User{
    public Member(){

    }
    public Member(String name, double money){
        super(name, money);
    }

    //成员收红包
    public void receive(ArrayList<Double> redList){
        //按顺序收
        int i = 0;
        for (i = 0; i < redList.size() && redList.get(i) == 0; i++) {
            //若一直拿到空红包，说明被抢完
//            index = (int)(Math.random() * redList.size());//[0,size)整数
            //按顺序拿就行，因为红包集合里本来数就是乱放的
            //除非拿到的是0说明被抢过了，就看红包集合里的下一位
        }
        if (i == redList.size()) {//遍历完了，且遍历过的红包金额全为0
            System.out.println("我" + this.getName() + "手慢了，红包被抢完了！");
            return;
        }
        this.setMoney(this.getMoney() + redList.get(i));
        System.out.println("我" + this.getName() + "收了第" + (i + 1) + "个红包，金额：" + redList.get(i) + "余额：" + this.getMoney());
        redList.set(i, 0.0);

    }
}
