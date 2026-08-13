package Advanced.Day05_异常_线程.Review01_Aug12;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/13/下午2:40
 * @Description:
 */
public class RegisterException extends Exception{
    public RegisterException(){}
    public RegisterException(String msg){
        super(msg);
    }
}
