package code01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/04/09/9:48
 * @Description:
 */
public class MainTest {
    public static void main(String[] args) {
        // 1.创建一个成员内部类，在其他类中用直接和间接两种方式，访问该内部类及方法。
//        Outer.Inner obj1 = new Outer().new Inner();
//        obj1.method();
//        new Outer().useInner();
        // 2. 在【成员内部类】中，在内部类方法和外部类方法中访问同名的，局部变量，
        // 内部类成员变量，外部类成员变量。对比【局部内部类】访问同名变量的情况。
        //3. 成员内部类：在外部类访问成员内部类成员，在内部类访问外部类成员。
//        Outer out = new Outer();
//        out.visit();
//        Outer.Inner obj2= new Outer().new Inner();
//        obj2.visit();
//
//        out.localInner();
//

        // 6. 使用匿名内部类实现接口（两个抽象方法），并多次调用其中方法
        Animal obj3 = new Cat();
        Animal obj4 = new Dog();
        obj3.eat();
        if(obj4 instanceof Dog){
            obj4 = (Dog)obj4;
        }
        if(obj3 instanceof Cat){
            ((Dog) obj3).variety();//子类特有方法必须还原才可以调用
        }
        obj4.like();

        Animal obj5 = new Animal(){
            @Override
            public void eat(){
                System.out.println("匿名内部类重写eat");
            }
            @Override
            public void like() {
                System.out.println("匿名内部类重写like");
            }
        };
        obj5.like();
        obj5.eat();


    }
}
