package code01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/01/30/15:16
 * @Description:
 */
public class Demo01 {
    public static void main(String[] args) {
        /*计算在-10.8到5.9之间，绝对值大于6 或者小于2.1 的整数有多少个？*/
//        double left = -10.8;
//        double right = 5.9;
//        int count = 0;
//        for(double i = Math.ceil(left); i <= Math.floor(right); i++){
//            double abs = Math.abs(i);
//            if(abs > 6 || abs < Math.ceil(2.1)){
//                count++;
//                System.out.println(i);
//            }
//        }

        Zi zi = new Zi();
        Fu fu = new Fu();
        Fu fu2 = new Zi();


        System.out.println(zi.num);
        System.out.println(fu.num);
        zi.methodZi();
        zi.methodFu();
        fu.methodFu();
        zi.method();
        fu.method();

        System.out.println(fu2.num);
        fu2.methodFu();
        fu2.method();

    }
}
