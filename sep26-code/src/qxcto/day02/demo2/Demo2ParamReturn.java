package qxcto.day02.demo2;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/09/26/21:17
 * @Description:
 */
public class Demo2ParamReturn {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        methodParam(sc);
//
//        //用匿名对象简化写法
//        methodParam(new Scanner(System.in));

        Scanner sc = methodReturn();
        sc.next();

    }
    public static void methodParam(Scanner sc){
        String str = sc.next();
        System.out.println(str);
    }
    public static Scanner methodReturn(){
//        Scanner sc = new Scanner(System.in);
//        return sc;

        //简化写法
        return new Scanner(System.in);
    }
}
