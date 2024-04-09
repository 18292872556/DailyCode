package code01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/04/09/10:52
 * @Description:
 */
public class Dog implements Animal{


    @Override
    public void eat() {
        System.out.println("小狗吃骨头");
    }

    @Override
    public void like() {
        System.out.println("小狗喜欢人类");
    }
    void variety(){
        System.out.println("边牧");
    }
}
