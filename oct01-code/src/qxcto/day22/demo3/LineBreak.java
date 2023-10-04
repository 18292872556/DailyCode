package qxcto.day22.demo3;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/10/01/20:37
 * @Description:
 */
public class LineBreak {
    public static void main(String[] args) {
        System.out.print("不换行");
        System.out.print("第一种换行方式\n");
        System.out.print("第二种换行方式"+"\n");

        System.out.printf("%s","不换行");
        System.out.printf("%s\n","第三种" );
        System.out.printf("%s%n","第四种");
        System.out.printf("%s","第五种"+"\n");

        System.out.println("第六种");

    }
}
