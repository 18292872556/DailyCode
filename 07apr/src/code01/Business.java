package code01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/04/07/18:59
 * @Description: 学业或事业
 */
public class Business {
    String name;//学业或事业名称
    int revenue;//收入
    int time;//每日活动时长

    public Business(){

    }
    public Business(String name, int revenue, int time){
        this.name = name;
        this.revenue = revenue;
        this.time = time;
    }


    void show(){
        System.out.println("当前事业为：" + this.name + ",收入：" + this.revenue + ",每日活动hour:" + time);
    }

}
