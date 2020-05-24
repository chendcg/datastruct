package com.cdc.recursion;

/**
 * 八皇后
 */

public class Queue8 {


    private static int MAX =8;
    private static int count =0;
    private static int[] array=new int[MAX];

    public static void main(String[] args) {

        Queue8 queue8 =new Queue8();
        queue8.check(0);
        System.out.printf("一共%d种解法",count);
    }

    /**
     *
     * @param n  第n+1个皇后的放置
     */
    public static void check(int n){
        if (n == MAX) {
            print();
            return;
        }
        //每一个皇后都循环8次
        for (int i =0; i<8; i++){
            System.out.println("n:"+n+",i:"+i);
            array[n] =i;
            if (judge(n)){  //判断当前皇后是否满足条件，继续下一个皇后放置
                check(n+1);
            }
        // 不满足，继续循环，将皇后后移一位
        }
    }

    //判断皇后放置的是否正确
    public static boolean judge(int n){
        for (int i=0; i<n; i++){
            // Math.abs(n-i)==Math.abs(array[n]-array[i])  ---判断是否在同一斜线上
            if (array[i] == array[n] || Math.abs(n-i)==Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }


    public static void print(){
        count++;
        for (int i =0; i<array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
