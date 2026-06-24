package Advanced.Day02_Collection_泛型.Review01_Jun10;

/**
 * Created with IntelliJ IDEA 2024.1.4.
 * jdk 17.0.12
 *
 * @Authur: xuexuezi
 * @Date: 2026/06/10/下午7:34
 * @Description:
 */
public class MyClass<E>{
    private E num;

    public E getNum(){
        return this.num;
    }
    public void setNUm(E num){
        this.num = num;
    }
}
