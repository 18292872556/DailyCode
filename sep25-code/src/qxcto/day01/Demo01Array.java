package qxcto.day01;
/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/09/21/21:06
 * @Description: 黑马 javaSE P1-
 */
public class Demo01Array {
    public static void main(String[] args) {

        //String类+拼接
        System.out.println(50 + 70 + "str"+ 30 + 70);
        System.out.println("eat" + (40 + 50));//eat90
        byte num1 = 3;
        byte num2 = 4;
//        byte num3 = num1 + num2;
//        byte num4 = num1 / num2;
//        byte num5 = num1 * num2;
//        byte num6 = num1 - num2;
//        byte num7 = num1 % num2;
//        byte = 6 + byte;

        //逻辑运算符可以连续写，判断多个条件
        boolean num8 = 5 < 6 && num1 > 8 && num2 < 9;
        boolean num9 = 5 < 6 && num1 > 8 && num2 < 9 && 7 < 8;
        System.out.println(num8);
//        System.out.println( 5 < 6 <9);

        int[] array1 = new int[3];
        int[] array11;
        array11 = new int[4];

        int[] array2 = new int[]{3,4,5};
        int[] array22;
        array22 = new int[]{3,4,5};

        int[] array3 ={1,2,3};



        //创建并改变数组元素的内存图
        int[] arr1 = new int[3];//只规定长度，动态初始化
        System.out.println(arr1);
        System.out.println(arr1[0]);
        System.out.println(arr1[1]);
        System.out.println(arr1[2]);
        arr1[1] = 10;
        arr1[2] = 20;
        System.out.println(arr1[0]);
        System.out.println(arr1[1]);
        System.out.println(arr1[2]);

        //两个引用指向同一个数组的内存图
        int[] arr2 = new int[]{1, 2, 3, 4};
        System.out.println(arr2[0]);
        System.out.println(arr2[1]);
        System.out.println(arr2[2]);
        System.out.println(arr2[3]);

        int[] arr3 = arr2;
        System.out.println(arr3[0]);
        System.out.println(arr3[1]);
        System.out.println(arr3[2]);
        System.out.println(arr3[3]);


    }
























}
