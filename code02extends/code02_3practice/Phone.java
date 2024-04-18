package qxcto.code02extends.code02_3practice;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/11/08/23:11
 * @Description:
 */
public class Phone {

    public void send(String name, String content){
        System.out.println("发短信给" + name + "，内容：" + content);
    }
    public void call(String name){
        System.out.println("打电话给" + name);
    }
    public void show(){
        System.out.println("显示来电号码");
    }
}
