package review01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/03/14/20:43
 * @Description:
 */
public class MainTest2 {
    public static void main(String[] args) {
        char ch = '4';
        switch(ch){
            case 52:
                System.out.println(4);
            case 5:
                System.out.println(5);
                break;
            case '%':
                break;
            case '9':
                System.out.println(9);
            default:
                System.out.println("没有匹配的");
                break;
        }

    }
}
