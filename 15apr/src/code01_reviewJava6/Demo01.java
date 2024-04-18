package code01_reviewJava6;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/04/15/18:45
 * @Description:
 * 1. 创建一个成员内部类，在其他类中用直接和间接两种方式，访问该内部类及方法。
 */
public class Demo01 {
    int num = 10;
    Demo01(){

    }
    Demo01(int num){
        this.num = num;
    }
    void method(){
        System.out.println("外部类方法method调用");
        System.out.println("num = " + num);
    }

    class Inner{//内部类构造方法和普通类一样的，不写默认送无参构造，写了有参就不送。
        Inner(){

        }
        Inner(int num){
            this.num = num;
        }
        int num = 20;
        void method(){
            System.out.println("内部类方法method调用");
            System.out.println("num = " + num);

        }

        
    }
}
