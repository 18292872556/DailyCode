package Advanced.Day05_异常_线程;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/10/下午3:36
 * @Description:
 */
public class Main {

//题目1：创建一个数组越界异常。
//要求：使用try-catch捕获ArrayIndexOutOfBoundsException。

//题目2：创建一个除0异常。
//要求：使用try-catch捕获ArithmeticException并处理。

//题目3：测试try-catch-finally执行顺序。
//要求：分别在三个代码块输出内容，观察执行结果。

//题目4：验证finally一定执行。
//要求：try中主动抛出异常，观察finally是否执行。

//题目5：使用throw主动抛出异常。
//要求：年龄小于0时手动抛出异常。
    /*更好的异常类型illegalArgumentException*/

//题目6：使用throws声明异常。
//要求：定义方法抛出异常，由调用者处理。

//题目7：编写多个catch捕获不同异常。
//要求：分别处理数组越界和除0异常。

//题目8：调整多个catch顺序。
//要求：验证父类异常不能写在子类异常前面。

//题目9：编写方法测试RuntimeException。
//要求：观察运行时异常是否必须强制处理。

//题目10：编写方法测试Checked异常。
//要求：调用可能产生IOException的方法并处理。

//题目11：创建自定义异常类AgeException。
//要求：继承Exception并添加构造方法。

//题目12：使用AgeException校验年龄。
//要求：年龄不符合要求时抛出自定义异常。

//题目13：模拟用户注册功能。
//要求：用户名为空时抛出自定义注册异常。

//题目14：分析异常调用链。
//要求：main调用工具类方法，工具类方法发生异常，观察JVM打印的调用栈。

//题目15：使用printStackTrace查看异常信息。
//要求：输出异常类型、原因和代码位置。

//题目16：分析Error和Exception区别。
//要求：分别举出属于两者的异常类型。

//题目17：判断异常处理方式。
//要求：区分哪些异常需要try-catch，哪些可以不用。

//题目18：使用finally关闭资源。
//要求：模拟资源对象，在finally中完成关闭操作。

//题目19：使用try-with-resources关闭流。
//要求：创建资源对象并验证自动关闭。

//题目20：综合异常处理。
//要求：模拟登录流程并使用多种异常处理机制。
/*思路：注册用户名异常，用户名为空，用户名重复
 * 登录，用户名不存在异常，密码错误异常*/

//题目21：开启新线程
//要求开启新线程MyThread自定义的，然后调用for循环。main线程也是循环10次打印正在执行哪个线程

    /*代码规范*/
    //if(uname == null || uname.trim().equals(""))
    //可改if(uname == null || uname.trim().equals(""))
    //if (uname == null || uname.isBlank())

    /*System.in 是整个程序的标准输入流，不应该每个方法都随便创建一个 Scanner 并关闭。
    * 尤其不要sc.close();因为关闭 Scanner 会连带关闭：System.in后面的输入就不能用了。*/
}
