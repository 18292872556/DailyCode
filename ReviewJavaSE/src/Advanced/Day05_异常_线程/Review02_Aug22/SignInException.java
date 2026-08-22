package Advanced.Day05_异常_线程.Review02_Aug22;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/22/下午2:20
 * @Description:
 * 登录异常
 */
public class SignInException extends Exception {
    public SignInException() {
    }
    public SignInException(String message) {
        super(message);
    }
}
