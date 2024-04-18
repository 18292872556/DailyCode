package code01;
import code01.Calss01;
/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/01/27/14:08
 * @Description:
 */
public class Class02 {
    public void method(){

    }
    public void c2method(){
        method();//直接调只能调本类的非静态
        //外部类即便导入，（同一个包下也没有导入的必要）也必须用对象才能调。
        //不像静态方法调用静态，如果是外部类的静态导入一些就可以像本类的一样直接调了
    }

    public static void main(String[] args) {

    }
}
