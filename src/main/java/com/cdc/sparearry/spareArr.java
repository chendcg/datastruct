package com.cdc.sparearry;


/**
 * 原始数组与稀疏矩阵之间的转换
 */
public class spareArr {

    public static void main(String[] args) {

        //1.原始矩阵
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[3][4] = 1;

        System.out.println("原始矩阵");
        for (int[] row : chessArr) {
            for(int item : row){
                System.out.printf("%d\t",item);
            }
            System.out.println();
        }

        System.out.println("================");
       int[][] spareArr = chessArr2SpareArr(chessArr);

        System.out.println("稀疏矩阵");
        for (int i =0; i<spareArr.length;i++){
            System.out.printf("%d\t%d\t%d\n",spareArr[i][0],spareArr[i][1],spareArr[i][2]);
        }

        System.out.println("===============");
       int[][] chessArr02 = spareArr2ChessArr(spareArr);

        System.out.println("原始矩阵");
        for (int[] row : chessArr02) {
            for(int item : row){
                System.out.printf("%d\t",item);
            }
            System.out.println();
        }
    }

    private static int[][] spareArr2ChessArr(int[][] spareArr) {
        int[][] chessArr = new int[spareArr[0][0]][spareArr[0][1]];
        for (int i=1; i<spareArr.length; i++){
            chessArr[spareArr[i][0]][spareArr[i][1]] =spareArr[i][2];
        }
        return chessArr;
    }


    //    原始矩阵转为稀疏矩阵
    public static int[][] chessArr2SpareArr(int[][] chessArr){

        //    2.遍历矩阵,创建稀疏矩阵
        int sum = 0;
        for (int i=0 ; i<chessArr.length; i++){
            for (int j=0; j<chessArr[0].length; j++){
                if(chessArr[i][j] != 0){
                    sum++;
                }
            }
        }
  //      System.out.println("sum="+sum);

        int[][] spareArr = new int[sum+1][3];

        spareArr[0][0] = chessArr.length;
        spareArr[0][1] = chessArr[0].length;
        spareArr[0][2] = sum;

        //3.遍历给稀疏矩阵赋值
        int count = 0;
        for (int i=0 ; i<chessArr.length; i++){
            for (int j=0; j<chessArr[0].length; j++){
                if(chessArr[i][j] != 0){
                    count++;
                    spareArr[count][0] = i;
                    spareArr[count][1] = j;
                    spareArr[count][2] = chessArr[i][j];
                }
            }
        }

        return spareArr;
    }


}
