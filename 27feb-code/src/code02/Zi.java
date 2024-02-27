package code02;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/02/27/21:30
 * @Description:
 */
public class Zi extends Fu{
    int num = 20;
    int age = 16;
    void method(){
        System.out.println("子类method");
    }
    void methodZi(){
        System.out.println("子类特有methodZi");
    }
    void showNum(){
        System.out.println(num);
    }
}
