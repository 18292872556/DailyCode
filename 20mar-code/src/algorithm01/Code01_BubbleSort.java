package algorithm01;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/03/20/21:42
 * @Description:
 */
public class Code01_BubbleSort {
    public static void bubbleSort(int[] arr){
        if(arr == null || arr.length <= 1){
            return;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            for(int j = 1; j <= i; j++){
                if(arr[j - 1] > arr[j]){
                    MainTest.swap(arr, j-1, j);
                }
            }
        }
    }

}
