package code01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/02/01/12:51
 * @Description:
 */
public class NewPhone extends Phone{
    public NewPhone(){

    }
    @Override
    public void show(){
        super.show();
        System.out.println("显示来电人");
        System.out.println("显示来电人头像");
    }
}
