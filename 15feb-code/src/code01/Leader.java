package code01;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/02/15/14:34
 * @Description: 群主
 */
public class Leader extends Member{
    public Leader(double balance){
        this.balance = balance;
    }


    public ArrayList<Integer> send(int count, int money){
        if(money > getBalance()){
            System.out.println("余额不足，请重新设置红包金额");
            return null;
        }

        ArrayList<Integer> redList = new ArrayList<>();
        //分配红包过程，因为都是整数，如果每份都是小数的话，取整。把剩下的放到最后一个红包即可
        int ave = money / count;
        int last = money - (ave * count);
        for (int i = 0; i < count; i++) {
            redList.add(ave);
        }
        int size = redList.size();
        redList.set(size - 1, redList.get(size - 1) + last);
        setBalance(getBalance() - money);
        return redList;
    }
    //优化,重载
    public ArrayList<Double> send(int count, double money){
        if(money > getBalance()){
            System.out.println("余额不足，请重新设置红包金额");
            return null;
        }

        ArrayList<Double> redList = new ArrayList<>();
        //红包最小金额设置0.1，最大是总金额的0.6，反正就是比一半多一点
        double min = 0.1;
        double max = money * 0.6;
        double last = money;//最后剩余的
        Random r = new Random();
        for (int i = 0; i < count - 1; i++) {
            double num = r.nextDouble()*(max - min) + min;//0.0 ~ 1.0 -> 0.0 ~ max - min -> min ~ max
            last -= num;
            redList.add(num);
        }
        redList.add(last);
        setBalance(getBalance() - money);
        return redList;
    }

}
