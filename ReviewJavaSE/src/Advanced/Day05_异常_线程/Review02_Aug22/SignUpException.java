package Advanced.Day05_异常_线程.Review02_Aug22;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/22/下午2:17
 * @Description:
 * 注册异常
 */
public class SignUpException extends Exception {
    public SignUpException() {}
    public SignUpException(String message) {
        super(message);
    }
}
