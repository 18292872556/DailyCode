package code01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/04/07/18:58
 * @Description:  // 1.成员变量中使用自定义类对象并输出信息。（注意输出对象的名字等）
 */
public class Person {//例如人有一份事业或学业
    String name;
    boolean sex;
    Business thing;
    Fu object;
    Person(){

    }
    Person(String name, boolean sex, Business thing, Fu object){
        this.name = name;
        this.sex = sex;
        this.thing = thing;
        this.object = object;
    }
    void show(){
        System.out.println("姓名：" + this.name + "性别：" + this.sex +
                "主业：" + this.thing);
        if(this.thing != null){
            this.thing.show();
        }
        System.out.println("接口类型的成员变量为：" + this.object);
        if(this.object != null){
            this.object.method();
        }
    }

    void method01(Fu obj){
        //多态写法，因为Fu为接口，所以obj一定是该接口的实现类
        System.out.println("method01 接口作为参数");
        obj.method();
    }
    Fu method02(){
        System.out.println("method02 接口作为返回值");
        //4 中return写法任选一种
        Fu obj1 = new Zi();
        return new Zi();
//        Fu obj2 = new Fu(){
//            @Override
//            public void method() {
//                System.out.println("匿名内部类实现接口");
//            }
//        };
//
//        return obj2;
//        return new Fu(){
//            @Override
//            public void method() {
//                System.out.println("匿名对象匿名内部类实现接口");
//            }
//        };
    }

    //getter setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public Business getThing() {
        return thing;
    }

    public void setThing(Business thing) {
        this.thing = thing;
    }

    public Fu getObject() {
        return object;
    }

    public void setObject(Fu object) {
        this.object = object;
    }
}
