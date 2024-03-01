package code01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/03/01/19:28
 * @Description:
 */
public class Iaptop {
    public void powerOn(){
        System.out.println("打开笔记本");
    }

    public void useDevice(USB usb){
        usb.open();
        //因为多态，引用为接口，对象为实现类。不可以调用实现类特有的方法。
        // 复习：对于成员方法，编译看左，运行看右
        //所以想要调用子类特有方法，进行还原，即向下转型后调用即可
        if(usb instanceof Mouse){
            Mouse mouse = (Mouse)usb;
            mouse.click();
        }else if(usb instanceof Keyboard){//注意：不可以直接else，必须加if判断，因为不能确定接口只有这两个实现类
            Keyboard keyboard = (Keyboard)usb;
            keyboard.type();
        }
        usb.close();
//        System.out.println("使用设备");
    }

    public void powerOff(){
        System.out.println("关闭笔记本");
    }
}
