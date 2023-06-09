package class03;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: xuexuezi
 * @Date: 2023/06/09/15:38
 * @Description: 找出数组中所有的逆序对，原理：找一个数左侧比他大的有几个
 * 左右组比较相等时，先拷贝走左侧的数，因为右侧的需要与左组后侧的更大数统计逆序对
 */
public class Code03_ReversePair {
    public static int reverPairNumber(int[] arr){
        if(null == arr || arr.length < 2){
            return 0;
        }
        return process(arr, 0, arr.length-1);
    }
    public static int process(int[] arr, int l, int r){
        if(null == arr || arr.length < 2){
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return process(arr, l, mid) +
                process(arr, mid+1, r)+
                merge(arr, l, mid, r);//左右组内部的降序对+归并两组时的降序对
    }
    //既要归并排序升序（所以指针从前往后走，右组比较时，知道左组数越往后越大），中途要统计逆序对（即降序对），
    // 以右组为基准，观察左组有几个比他大。
    public static int merge(int[] arr, int L, int m, int r){
        if(L > m || L > r || m > r){
            throw new RuntimeException("排序坐标错误");
        }
        int p1 = L;
        int p2 = m + 1;
        int mergeSize = 1;
        int ans = 0;//降序对个数
        int[] help = new int[arr.length];
        int i = 0;
        while(p1 <= m && p2 <= r){
            if(arr[p1] > arr[p2]){
                System.out.println("("+arr[p1]+","+arr[p2]+")");
                ans++;
                help[i++] = arr[p2++];
            }
            else{//==时也是先拷贝走左组，留右组这个数与左组后更大的数组成降序对
                help[i++] = arr[p1++];
            }
        }
        //当其中一组越界时，组内都是有序的，组内已经统计过降序对了，不会再产生
        while(p1 <= m){
            help[i++] = arr[p1++];
        }
        while(p2 <= r){
            help[i++] = arr[p2++];
        }
        return ans;
    }
    //-------------------fot test 对数器---------------------------
    //暴力法：找降序对，从前往后遍历数组，每个数挨个向后找比自己小的。or每从后往前，每个数挨个向前找比自己打的
    public static int comparator(int[] arr){
        int ans = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] < arr[i]){
                    ans++;
                    System.out.print("("+arr[j]+","+arr[i]+") ");
                }
            }
            System.out.println();
        }
        return ans;
    }
    public static int[] generateRandomArray(int maxSize, int maxValue){
        int size = (int)(Math.random()*(maxSize + 1));
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = (int)(Math.random()*(maxValue + 1));
        }
        return arr;
    }
    public int[] copyArray(int[] arr){
        int[] arr2 = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            arr2[i] = arr[i];
        }
        return arr2;
    }
    public static boolean isEqual(int[] arr1, int[] arr2){
        if(null == arr1 || null != arr2){
            return false;
        }else if(null != arr1 || null == arr2){
            return false;
        }else if(arr1.length != arr2.length){
            return false;
        }
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
    public static void printArray(int[] arr){
        for(int i: arr){
            System.out.println(i+",");
        }
    }
    public static void main(String[] args){
        //
    }
}
