package qxcto.code02extends.code02_3practice;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/11/08/23:07
 * @Description: P160 练习：写类Phone,NewPhone继承Phone
 * Phone类代表老款手机，三个方法：1.打电话 2.发短信 3.来电：显示号码
 * NewPhone类代表新款手机，三个方法：1.打电话 2.发短信 3.来电：显示号码，显示姓名，头像（这是覆盖，重写）
 * 对于已经投入使用的类，尽量不要进行修改。重复利用其中共性内容，添加改动新内容
 */
public class TestPractice {
    public static void main(String[] args) {
        Phone p1 = new Phone();
        NewPhone p2 = new NewPhone();

        p1.show();
        p2.show();

    }

}
