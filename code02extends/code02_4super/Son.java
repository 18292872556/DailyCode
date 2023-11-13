package qxcto.code02extends.code02_4super;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/11/08/23:33
 * @Description: 本类的构造方法中，访问本类的另一个构造方法，但不可以自己调自己，
 * 调用自己的另一个构造方法也必须是构造方法中的第一句，也就是唯一一个，
 * 类似super()也是只能被子类的构造方法调用，只有一句还是第一句
 */
public class Son extends Father{
    //其实构造方法两个参数不同也属于重载
    public Son(){
        //super();不写的话就隐含赠送这一句
        //this();//不可以自己调用自己
        System.out.println("Son的无参构造");

    }
    public Son(String name){
        //super(name);//只有子类构造方法，才能调用父类构造方法，并且调用构造方法必须要在第一句，也就是只可以有一句
        this();//写了以后也不再赠送super();

        System.out.println("Son的有参构造");
    }
}
