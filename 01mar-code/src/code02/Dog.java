package code02;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/03/01/20:40
 * @Description:
 */
public class Dog implements Animal{
    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }
    public void door(){
        System.out.println("狗看家");
    }
}
