package qxcto.day04.demo2;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/09/28/17:01
 * @Description:
 */
public class Person {
    String name;
    String sex;
    boolean power;

    public Person() {
    }

    public Person(String name, String sex, boolean power) {
        this.name = name;
        this.sex = sex;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setPower(boolean power) {
        this.power = power;
    }

    public String getSex() {
        return sex;
    }

    public boolean isPower() {
        return power;
    }
}
