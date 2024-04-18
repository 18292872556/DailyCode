package code02;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/02/27/21:30
 * @Description:
 */
public class Fu {
    int num = 10;

    void method(){
        System.out.println("父类method");
    }
    void methodFu(){
        System.out.println("父类特有methodFu");
    }

    void showNum(){
        System.out.println(num);
    }
}
