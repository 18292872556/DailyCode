package qxcto.code02extends.code02_2cover;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/11/08/22:36
 * @Description:
 */
public class Son extends Father{

    @Override
//    public int method(){
//        System.out.println("儿子重写了父类方法");
//        return 1;
//    }
    public Son method(){
        System.out.println("这是子类类方法");
        return new Son();
    }

    //这个属于重载，所以返回值无所谓，但方法名一定要相同，参数列表一定不同，如果相同就是重写。
    public void method(int num){
        System.out.println("method的重载方法");
    }
}
