package code02;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/03/01/20:40
 * @Description:
 */
public class Main {
    public static void getPet(Animal animal){
        if(animal instanceof Dog){
            System.out.println("得到的宠物是狗狗");
            Dog dog = (Dog)animal;// ● 向下转型，必须原对象就是Dog类，所以一定先instanceof判断
            dog.door();//还原后才可以调用子类特有的方法
        }else if(animal instanceof Cat){
            System.out.println("得到的宠物是猫猫");
            Cat cat = (Cat)animal;
            cat.catchMice();
        }
    }
    public static void main(String[] args) {
        //向上转型
//        Dog dog1 = new Samoyed();
//        Samoyed sam1 = (Samoyed)dog1;
//        sam1.personality();
/*此处实验，向下转型只能还原，也不能把父类强转成子类。
转的类型必须跟开始的对象类型一致，只有引用不一致*/
//        Dog dog2 = new Dog();
//        Samoyed sam2 = (Samoyed)dog2;
//        sam2.personality();

        //模拟向上转型
        Animal a1 = new Cat();//①向上转型
        Dog a2 = new Dog();
        Animal a3 = a2;//②分两步向上转型
        getPet(a2);//③子类传参给形参是父接口的，也属于向上转型
        getPet(new Dog());//④匿名对象传也可以

        a1.eat();
        a3.eat();//不能调用子类特有方法，如door(),catchMice();


    }
}
