package code02;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/01/27/15:18
 * @Description:
 */
public class Demo01 {
    public static void main(String[] args) {
        Assistant as1 = new Assistant();
        Teacher te1 = new Teacher();

        as1.method();
        te1.method();
        as1.num = 10;
        te1.num = 20;

        Assistant.sNum2 = 30;
        Teacher.method2();
    }
}
