package review.demo01Sort;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2023/10/15/18:59
 * @Description:
 */
public class Code04_ShellSort {
    public static void shellSort(int[] arr){
        //预估为三层循环，1层循环不同步长，2层通过步长遍历比较预排序，3层排序插入时多次插入交换
        int n = arr.length;
        int step =  n/2;
        while(step > 0) {
            for(int i = 0; i < n; i++){//从后往前跳5步遍历交换0-step-1这组不能再往前看
                for(int j = i; j >= step && arr[j] < arr[j - step]; j -= step){//往前step数看交换，
                    Logarithmic.swap(arr, j, j - step);
                }
            }
            step /= 2;
        }
    }

}
