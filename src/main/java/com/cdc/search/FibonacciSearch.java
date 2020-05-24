package com.cdc.search;


import java.util.Arrays;

/**
 * 斐波那契查找算法
 */

public class FibonacciSearch {

    public static int MAX=20;

    public static void main(String[] args) {
        int[] arr = {1,2,5,8,10,56,78};

        int index = fibSearch(arr, 10);
        System.out.println("索引下标："+ index);


    }

    /**
     *  构造斐波那契数列
     * @return
     */
    public static int[] fib(){
        int[] f = new int[MAX];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2;i < MAX; i++){
            f[i] = f[i-1] + f[i-2];
        }
        return f;
    }

    /**
     *     斐波那契查找算法
     * @param arr
     * @param findVal
     * @return
     */
    public static int fibSearch(int[] arr, int findVal){
        int low = 0;
        int high =arr.length - 1;
        int mid =0;

        int f[] = fib();

        int k =0;
        while(high > f[k]-1){
            k++;
        }

        int[] temp = Arrays.copyOf(arr, f[k]);
        for (int i=high+1; i < temp.length; i++){
            temp[i] = arr[high];
        }

    //   开始迭代查找
        while(low <= high){
            mid = low + f[k-1] -1;

            if (findVal < temp[mid]){
                high = mid -1;
                //全部元素(f[k])=前面元素(f[k-1])+后面元素（f[k-2]）
                k--;
            }else if(findVal >temp[mid]){
                low =mid + 1;
                k -= 2;
            }else{
                //返回较小的数
                return mid <= high? mid:high;
            }
        }
        //未找到
        return -1;
    }

}
