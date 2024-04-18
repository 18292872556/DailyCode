package code01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/02/01/18:20
 * @Description:
 */

public class Zi2 extends Fu2 {
    String id;

    public Zi2() {
        super(50);
        System.out.println("Zi2的无参构造");
    }

    public Zi2(String id) {
        super(60);
        this.id = id;
        System.out.println("Zi2的有参构造, id = " + this.id);
    }

    public Zi2(int age) {
        super(70);
        this.age = age;
        System.out.println("Zi2的有参构造, age = " + this.age);

    }
}

