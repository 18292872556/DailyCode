package Advanced.Day02_Collection_泛型.Review01_Jun10;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/06/11/下午5:22
 * @Description:
 */
public interface MyInterface1<E>{
    //public static final E num = null;
    public abstract void add(E e);
    E getE();
}
