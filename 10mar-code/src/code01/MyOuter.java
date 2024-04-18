package code01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/03/10/16:38
 * @Description:
 */
public class MyOuter {
    public void methodOut(){
        int num = 10;
        //num = 30;
        int num2;
        num2 = 40;
        class Inner{
            public void inner(){
                System.out.println(num);
                System.out.println(num2);
            }
        }
    }
}
