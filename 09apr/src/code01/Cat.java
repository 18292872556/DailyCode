package code01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/04/09/10:51
 * @Description:
 */
public class Cat implements Animal{

    @Override
    public void eat() {
        System.out.println("小猫吃鱼");
    }

    @Override
    public void like() {
        System.out.println("小猫喜欢扑蝴蝶");
    }
    void variety(){
        System.out.println("布偶");
    }
}
