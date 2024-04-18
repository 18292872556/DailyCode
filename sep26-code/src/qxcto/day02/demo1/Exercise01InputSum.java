package qxcto.day02.demo1;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/09/26/20:23
 * @Description: 练习一：输入两个int数字，并且求出和值
 * 思考，能不能只new一个Scanner，接收两个值
 */
public class Exercise01InputSum {
    public static void main(String[] args) {
       inputSum();

    }
    public static int inputSum(){
        Scanner sc = new Scanner(System.in);
        System.out.println("输入两个整数");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        System.out.println("总和" + num1 + num2);
        return num1 + num2;
    }


}
