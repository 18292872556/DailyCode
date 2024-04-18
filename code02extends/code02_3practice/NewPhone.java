package qxcto.code02extends.code02_3practice;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/11/08/23:11
 * @Description:
 */
public class NewPhone extends Phone{
    @Override
    public void show() {
        super.show();
        System.out.println("显示来电姓名");
        System.out.println("显示来电头像");
    }
}
