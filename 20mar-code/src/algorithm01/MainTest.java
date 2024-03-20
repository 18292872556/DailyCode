package algorithm01;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 雪雪子
 * @Date: 2024/03/20/20:52
 * @Description: 统一int升序
 */
public class MainTest {


    public static void main(String[] args) {
        int testTime = 100;//测试次数
        int maxSize = 10;
        int maxValue = 100;
        int i = 0;
        for (i = 0; i < testTime; i++) {
            int[] arr = generatedRandomArray(maxSize, maxValue);
            int[] arr1 = copyArray(arr);
            int[] arr2 = copyArray(arr);
            sort(arr1);
            // ●此处用不同的排序排arr2，然后与系统排序的结果比较，相同则排序正确
            //Code01_BubbleSort.bubbleSort(arr2);
            //Code02_SelectSort.selectSort(arr2);
            Code03_InsertSort.insertSort(arr2);
            // ●
            if(!isEqual(arr1, arr2)){
                System.out.println("排序第" + i + "次错误");
                System.out.println("原数组为：");
                printArray(arr);
                break;
            }
        }
        System.out.println(i == testTime ? "nice!" : "fuck");
        //因为没有输出，所以跑一次看看
        int[] arr = generatedRandomArray(maxSize, maxValue);
        printArray(arr);
        //Code01_BubbleSort.bubbleSort(arr);
        //Code02_SelectSort.selectSort(arr);
        Code03_InsertSort.insertSort(arr);

        printArray(arr);


    }
    /*for test 对数器--------------------------------------------*/
    public static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
    //系统排序
    public static void sort(int[] arr){
        Arrays.sort(arr);
    }
    public static void printArray(int[] arr){
        //系统打印
        //Arrays.toString(arr);
        //自定义
        System.out.print("【");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if(i != arr.length - 1){
                System.out.print("、");
            }
        }
        System.out.println("】");
    }
    //生成一个长度随机，内容随机的数组
    public static int[] generatedRandomArray(int maxSize, int maxValue){
        int length = (int)(Math.random() * (maxSize + 1));
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * (maxValue + 1));
        }
        return arr;
    }
    //复制数组
    public static int[] copyArray(int[] arr){
        int[] copy = new int[arr.length];
        for (int i = 0; i < copy.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }
    //比较数组内容是否一样
    public static boolean isEqual(int[] arr1, int[] arr2){
        if(arr1 == null && arr2 == null){
            return true;
        }
        if(arr1 == null && arr2 != null){
            return false;
        }
        if(arr1 != null && arr2 == null){
            return false;
        }
        if(arr1.length != arr2.length){
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }


}
