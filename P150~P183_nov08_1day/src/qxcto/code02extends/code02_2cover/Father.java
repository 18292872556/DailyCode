package qxcto.code02extends.code02_2cover;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/11/08/22:36
 * @Description:
 */
public class Father {
//    public long method(){
//        System.out.println("父类方法");
//    }
     Father method(){
        System.out.println("这是父类方法");
        return new Father();
    }
}
