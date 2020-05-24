package com.cdc.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,2,5,8,8,8,810,56,78};
        //当数据有多个相同时，只能查找一个
        int index = binarySearch(arr,0,arr.length-1,8);
        System.out.println("索引下标："+index);

        //支持查找相同数值
        List<Integer> indexList =binarySearch2(arr,0,arr.length-1,8);
        System.out.println("indexList:"+indexList);

    }

    /**
     *
     * @param arr  有序数组
     * @param left 左索引
     * @param right 右索引
     * @param findVal  待索引数
     * @return
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal){

        System.out.println("search times......");

        //未找到退出
        if (left >right) {
            return -1;
        }

        int mid = (left+right)/2;
        int midVal = arr[mid];
        //在mid的右边
        if (findVal > midVal){
            return binarySearch(arr, mid+1, right, findVal);
        }else if (findVal < midVal){
            //左边
            return binarySearch(arr, left, mid-1, findVal);
        }else {
            //返回下标
            return mid;
        }

    }

    /**
     * 当数组有多个相同的数据时
     * 返回一个List
     */
    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal){

        //未找到退出
        if (left >right) {
            return new ArrayList<Integer>();
        }

        int mid = (left+right)/2;
        int midVal = arr[mid];
        //在mid的右边
        if (findVal > midVal){
            return binarySearch2(arr, mid+1, right, findVal);
        }else if (findVal < midVal){
            //左边
            return binarySearch2(arr, left, mid-1, findVal);
        }else {

            List<Integer> indexList = new ArrayList<>();
            //左移添加相同数的下标
            int temp = mid - 1;
            while(true){
                if (temp <0 || arr[temp] != findVal){
                    break;
                }
                indexList.add(temp);
                temp--;
            }
            indexList.add(mid);
            //右移，添加下标
            temp =mid+1;
            while(true){
                if (temp > arr.length-1|| arr[temp] != findVal){
                    break;
                }
                indexList.add(temp);
                temp++;
            }
            return indexList;
        }

    }

}
