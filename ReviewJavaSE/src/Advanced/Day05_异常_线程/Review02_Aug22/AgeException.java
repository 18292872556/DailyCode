package Advanced.Day05_异常_线程.Review02_Aug22;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/22/上午11:14
 * @Description:
 */
public class AgeException extends Exception {
    public AgeException() {

    }
    public AgeException(String message) {
        super(message);
    }

}
