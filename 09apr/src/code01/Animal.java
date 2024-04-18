package code01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/04/09/10:51
 * @Description:
 */
public interface Animal {
    void eat();
    void like();
    default void show(){
        System.out.println("默认方法");
    }
}
