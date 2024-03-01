package code02;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/03/01/20:39
 * @Description:
 */
public class Cat implements Animal{

    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }
    public void catchMice(){
        System.out.println("猫抓老鼠");
    }
}
