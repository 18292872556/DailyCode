package Advanced.Day05_异常_线程.Review02_Aug22;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/22/上午11:18
 * @Description:
 */
public class RegisterException extends Exception {
    public RegisterException(){

    }
    public RegisterException(String message){
        super(message);
    }
}
