package code01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/02/01/12:51
 * @Description:
 */
public class Phone {
    public Phone(){

    }
    public void call(){
        System.out.println("打电话");
    }
    public void send(String who){
        System.out.println("发短信" + who);
    }
    public void show(){
        System.out.println("显示来电号码");
    }
}
