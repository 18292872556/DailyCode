package qxcto.code02extends.code02_4super;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/11/08/23:33
 * @Description:
 */
public class Son extends Father{
    public Son(){
        System.out.println("Son的无参构造");
    }
    public Son(String sex){
        System.out.println("Son的有参构造");
    }
}
