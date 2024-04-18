package qxcto.day09.demoRedList;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/11/01/11:16
 * @Description: 群主类，负责发红包
 */
public class Manager extends Member{
    public Manager(){
        //此处隐含赠送一个super();
       // System.out.println("子类的无参构造");
    }
    public Manager(String name, int money){
        super(name, money);
       // System.out.println("子类的有参构造");

    }

    //总共发多少份，总共发多少钱，群主总余额多少
    public ArrayList<Double> send(double count, double sendMoney){

        double totalMoney = this.getMoney();
        if(sendMoney > totalMoney){
            System.out.println("余额不足！");
            return null;
        }
        System.out.println("发"+ count +"个红包，总金额 ："+ sendMoney);
        double send = sendMoney;
        ArrayList<Double> redList = new ArrayList<>();
        //这里想模拟真实发红包环境，假设每份红包的一个最小值，给集合全部填上
        //在每个红包的基础金额上把剩下的余额随机生成，填入即可
        //1. 把要发的金额的1/3平均分到每个红包里
        double avg = (sendMoney / 3) / count;//每份的最小值
        for (int i = 0; i < count; i++) {
            redList.add(avg);
        }
        //System.out.println(redList);
        //sendMoney -= avg * count;
        sendMoney -= sendMoney / 3;
        int i = 0;
        while(sendMoney > 0){//随机的塞
            if(i == redList.size() - 1){
                //因为有精度损失，剩余减下来的的sendmoney是少于实际剩余钱数的
                // 所以统一一下已经填入的所有红包的金额，把剩余的钱全放入随机一个红包里
                int sum = 0;
                for (int i1 = 0; i1 < redList.size(); i1++) {//减去所有红包内金额总和
                    sum += redList.get(i1);
                }
                send -= sum;
                int max = (int)(Math.random() * (redList.size()));//整数，[0,size-1]
                redList.set(max, send + redList.get(max));
                break;
            }
            //生成一个[0,sengMoney/3)的数填入。此处问题在于，若每次都按这个范围来。
            // sendMoney也是一直减小，永远都排不完。所以把最后一个红包填入剩余所有余额
//            double maxMoney = sendMoney / 3;//以免直接填随机数后续sendMoney一直在变
            double random = Math.random() * (send / count);//改变已经填入的红包值，这样写永远第一个红包最大
            redList.set(i, random + redList.get(i));
            i++;//单独写因为我不确定上一句哪个i最后执行
            sendMoney -= random;
        }
        this.setMoney((int)(this.getMoney() - sendMoney));
        return redList;//问题在于count越多，损失的越多。count30时，总额从100变为87

    }
}
