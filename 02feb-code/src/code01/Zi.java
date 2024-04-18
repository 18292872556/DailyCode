package code01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/02/02/18:34
 * @Description:
 */
public class Zi extends Fu{
    /*Zi(){
        this(123);
    }
    Zi(int num){
        this(1,2);
    }
    Zi(int a, int b){
        this();
    }*/

    int num = 20;
    @Override
    public void method(){
        System.out.println("重写的Zi的method方法");
    }
    void show(){
        int num = 30;
        System.out.println(num);
        System.out.println(this.num);
        System.out.println(super.num);
    }
}
