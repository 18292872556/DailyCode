package Advanced.Day05_异常_线程.Review01_Aug12;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/08/12/下午6:32
 * @Description:
 */
public class AgeException extends Exception {
    public AgeException() {

    }

    public AgeException(String message) {
        super(message);
    }
}
