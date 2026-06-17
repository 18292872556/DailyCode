package Advanced.Day03_List_Set.first_Jun17;
import java.util.Comparator;
/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/06/17/下午7:58
 * @Description:
 */
public class MyData implements Comparator<MyData>{
    int data;
    String name;

    public MyData(int data, String name) {
        this.data = data;
        this.name = name;
    }
    public MyData(){

    }

    public void method(){
        System.out.println("MyData的方法");
    }
    @Override
    public int compare(MyData o1, MyData o2) {

        return o2.data - o1.data;//怎么实现的降序？只需要记忆，返回负数就是o1,o2的顺序
        //这里如果o2大，返回正数，排序就是o2,o1。就是降序
    }

    public String toString(){
        return "MyData{ data=" + data + ", name=" + name + "}";
    }
}
