package code01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/01/14/1:24
 * @Description: this关键字，局部变量，成员变量
 */
public class Demo01 {
    int num1 = 1;

    public void method(){
        int num1 = 2;
        this.num1 = 3;
        System.out.println(num1);
        System.out.println(this.num1);
    }

    public static void main(String[] args) {
        int num1 = 4;
        //System.out.println(this.num1);
        System.out.println(num1);

        new Demo01().method();


    }
}
