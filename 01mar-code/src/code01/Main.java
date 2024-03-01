package code01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/03/01/19:27
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Iaptop c1 = new Iaptop();
        c1.powerOn();
        //多态，4种向上转型。
        //usb1 和 usb3 是一步向上转型和分两步向上转型
        //usb2 和 usb4 是实现类传参给接口，也是向上转型
        USB usb1 = new Mouse();
        Keyboard usb2 = new Keyboard();
        USB usb3 = usb2;

        c1.useDevice(usb1);
        c1.useDevice(usb2);//相当于，形参是double,实参是int。从小范围到大范围传参自动类型转换
        c1.useDevice(usb3);
        c1.useDevice(new Mouse());

        c1.powerOff();
    }
}
