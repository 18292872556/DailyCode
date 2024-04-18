package code01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/02/01/12:46
 * @Description:
 */
public class Demo01 {
    public static void main(String[] args) {
        /*输出子类重写的结果*/
//        NewPhone p1 = new NewPhone();
//        p1.show();

        /*输出子类构造时的super情况*/
        Zi zi = new Zi();
        Zi2 zi2 = new Zi2();
        Zi2 zi3 = new Zi2(34);
        Zi2 zi4 = new Zi2("九五班");

    }


}
