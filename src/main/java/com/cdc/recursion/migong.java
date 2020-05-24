package com.cdc.recursion;




public class migong {

    public static void main(String[] args) {
        int[][] mg = new int[8][7];

        //设置墙
        for (int i = 0; i < 8; i++) {
            mg[i][0] = mg[i][6] = 1;
        }

        for (int j = 0; j < 7; j++) {
            mg[0][j] = mg[7][j] = 1;
        }
        mg[3][1] = mg[3][2] = 1;

        //打印
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(mg[i][j] + " ");
            }
            System.out.println();
        }

        setWay(mg,1,1);
        System.out.println("----------------");
        //后 打印
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(mg[i][j] + " ");
            }
            System.out.println();
        }
    }



    /**
     * 获取线路，2表示走通，3表示不通
     * 预定策略:下-右-上-左
     *
     * @param mg 迷宫
     * @param i  初始位置横坐标
     * @param j  初始位置纵坐标
     */
    public static boolean setWay(int[][] mg, int i, int j) {
        if (mg[6][5] == 2) {
            return true;
        } else {
            if (mg[i][j] == 0) {
                mg[i][j] = 2;
                if (setWay(mg, i + 1, j)) {
                    return true;
                } else if (setWay(mg, i, j + 1)) {
                    return true;
                } else if (setWay(mg, i - 1, j)) {
                    return true;
                } else if (setWay(mg, i, j - 1)) {
                    return true;
                } else {
                    mg[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
