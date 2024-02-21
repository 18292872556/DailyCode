package code01;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/02/15/14:34
 * @Description: 群成员
 */
public class Member {
    static int idCount = 0;
    int id;
    double balance;
    public Member(){
        idCount++;
        this.id = idCount;
    }
    public Member(int balance){
        this.balance = balance;
        idCount++;
        this.id = idCount;
    }



    public static int getIdCount() {
        return idCount;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }
    void setBalance(double balance){
        this.balance = balance;
    }

    /*public void receive(ArrayList<Integer> redList){
        int size = redList.size();
        int random = (int)(Math.random() * size);//double范围[0,size) [0,size-1]
        Random r = new Random();
        int random2 = r.nextInt(size);//int范围[0,size)
        this.balance += redList.get(random);
        redList.remove(random);//直接删除这一位，list长度--。
    }*/
    public void receive(ArrayList<Double> redList){
        int size = redList.size();
        int random = (int)(Math.random() * size);//double范围[0,size) [0,size-1]
        Random r = new Random();
        int random2 = r.nextInt(size);//int范围[0,size)
        this.balance += redList.get(random);
        redList.remove(random);//直接删除这一位，list长度--。
    }

    public void show(){
        System.out.println("----------------------");
        System.out.println("群成员的id：" + this.id);
        System.out.printf("余额：" + "%.2f", this.balance);
        System.out.println();
    }
}
