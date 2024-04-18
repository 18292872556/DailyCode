package qxcto.nov15.p150;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/11/15/23:08
 * @Description: ①计算在-10.8到5.9之间，绝对值大于6或者小于π的整数有多少个？
 */
public class mathTest {
    public static void main(String[] args) {
        //[-10,-6] [-π，π]
        for(double i = Math.ceil(-10.8); i <= Math.floor(5.9); i++){
            if(Math.abs(i) > 6 || Math.abs(i) < Math.PI){
                System.out.println(i);
            }
        }
        System.out.println("----------------------");
        for(double i = (int)-10.8; i <= (int)5.9; i++){//负数取整也是向上取，正数取整也是向上取
            if(Math.abs(i) > 6 || Math.abs(i) < Math.PI){
                System.out.println(i);
            }
        }


    }
}
