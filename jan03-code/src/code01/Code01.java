package code01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: xuexuezi
 * @Date: 2024/01/03/21:28
 * @Description:
 */
public class Code01 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 34;
        char num3 = '7';
        char num4 = 97;
//--------------------------------------------------
//前置++和后置的区别，||，|两个或运算符区别
        if(num1 < 9 || ++num4 > 97){
            System.out.println(num4);
        } /*b(98) ： 条件1 错，所以 ||或才会判断条件2，++num4先加再使用，98 > 97，if成功*/
        if(num1 < 9 || num4++ <= 98){
            System.out.println(num4 + 0);
        }/*99 : num4先用后加，98 <= 98后再++ ，char类型运算提升为int输出 */
        if(num1 > 9 || num4++ <= 98){
            System.out.println(num4);
        }  /*c(99) :因为|| 中条件1true，已经可以确定结果是true,条件2不执行*/
        if(num1 > 9 | num4++ <= 98){
            System.out.println(num4);
        }//d(100) | 和&都没有短路，已经能出结果也会执行所有条件

//&&,&两个并运算符区别
        if(++num1 > 10 && ++num2 > 34 && ++num3 > '7' ){
            System.out.println(num1 + "," + num2 + "," + num3);
        }//11,35,8 ：其中8是字符格式，&&是可以连续判断多个条件当没有错误的，就无法短路，全执行，++num1先加再用
        if(++num1 < 10 && ++num2 > 34 && ++num3 > '7' ){
            ;
        }else{
            System.out.println(num1 + "," + num2 + "," + num3);
        }//12,35,8 ：条件1错，后续条件不执行
        if(++num1 < 10 & ++num2 > 34 & ++num3 > '7' ){
            ;
        }else{
            System.out.println(num1 + "," + num2 + "," + num3);
        }//13,36,9//条件1 错不影响全部条件都要执行

        if(num1++ > 11 || ++num2 > 34 || ++num3 > '7' ){
            System.out.println(num1 + "," + num2 + "," + num3);
        }//14,36,9 : 条件1先用后加，11 > 11 false,短路，后续条件不执行
        if(num1++ > 12 | ++num2 > 35 | ++num3 > '8' ){
            System.out.println(num1 + "," + num2 + "," + num3);
        }//15，37,:(10) ：条件1 12 > 12先用后加到13 ,错不影响后续执行


        if(num1 < 0 || num1 > 0 && num1++ >= 15){
            System.out.println(num1);
        }//16 :&& 优先级高于||，相当于（false || (true && true)）
        if((num1 < 0 && num1 > 0) && num1++ >= 16){
            ;
        }
        else{
            System.out.println(num1);

        } //16 :(false && true) && 不执行


        //num3 > 7 ? num3 = '*' : num3 = '%';


        num3 = '%';
        System.out.println(num3);//%
        System.out.println(num3 + 0);//37

        num3 = '(';
        switch(num3){
            case '*':
                System.out.println("num3是*");
            case '(':
                System.out.println("num3是(");
            case '$':
                System.out.println("num3是$");
                break;
            case '@':
                System.out.println("num3是@");
                break;
            default:
                System.out.println();
                break;
        }
        //num3是(
        //num3是$
        //: 因为一遇到符合的case就进入，但遇到break才会退出

    }
}
