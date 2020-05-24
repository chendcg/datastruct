package com.cdc.search;

/**
 * 插值查找：
 *  对于数据量较大，关键字分布较均匀
 *  不均匀时，不一定比二分查找好
 */

public class InsertValueSearch {

    public static void main(String[] args) {

        //{1,2,3....100}
        //int[] arr =new int[100];
        //for (int i=0; i<100; i++){
        //    arr[i] = i;
        //}

        int[] arr = {1,2,5,8,810,56,78};

        int index = insertValueSearch(arr, 0, arr.length - 1, 8);
        System.out.println("插值索引查找角标："+index);

        int index02 = BinarySearch.binarySearch(arr, 0, arr.length - 1, 8);
        System.out.println("二分索引查找角标："+index02);

    }

    public static int insertValueSearch(int[] arr, int left ,int right,int findVal){
        System.out.println("search times......");
        //注意：
        // findVal <arr[left] || findVal >arr[right]必须要，否则mid会越界
        if (left >right || findVal <arr[left] || findVal >arr[right]){
            return -1;
        }

        //mid:自适应中间值
        int mid = left +(right -left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        //向右查找
        if (findVal > midVal){
            return insertValueSearch(arr, mid+1, right, findVal);
        }else if (findVal < midVal){
            return insertValueSearch(arr,left,mid+1,findVal);
        }else {
            return mid;
        }

    }

}
