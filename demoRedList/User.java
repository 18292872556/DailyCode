package qxcto.day09.demoRedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/11/01/11:06
 * @Description: 用户类
 * 属性：姓名，余额
 * 方法：设置，得到 余额。得到姓名
 *
 */
public class User {
    private String name;
    private double money;

    public User() {
        //System.out.println("父类的无参构造");
    }

    public User(String name, double money) {
        //System.out.println("父类的有参构造");
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
    public void show(){
        System.out.println("我是：" + this.name + "，我的余额：" + money);
    }
}
