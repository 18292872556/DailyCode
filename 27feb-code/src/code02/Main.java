package code02;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/02/27/21:29
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        //判断以下输出
        Fu obj = new Zi();
        obj.method();//20，子类方法。左引用Fu有method方法，右运行子类
        obj.methodFu();//10，父类特有方法。左
        // obj.methodZi();
        System.out.println(obj.num);//10//直接调用，重名变量看左侧引用是谁
        //System.out.println(obj.age);错误写法，变量看左边引用，父类没有，不会向下找

    }
}
