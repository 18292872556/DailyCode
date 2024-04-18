package qxcto.code02extends.code02_4super;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/11/08/23:33
 * @Description:
 */
public class Father {
    //如果不写构造方法，但系统会赠送一个无参构造，如下，默认的，不会显示出来
//    public Father(){
//
//    }

    //自己但凡写一个构造方法，都不会赠送了
    public Father(){
        System.out.println("Father无参构造器");
    }
    public Father(String name){
        System.out.println("Father有参构造");
    }



}
