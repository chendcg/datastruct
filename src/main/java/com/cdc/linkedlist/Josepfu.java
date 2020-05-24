package com.cdc.linkedlist;


/**
 * 约瑟夫环形问题
 */
public class Josepfu {

    public static void main(String[] args) {
        CircleSingleLinkedList csll = new CircleSingleLinkedList();
        //创建环
        csll.addBoy(6);
        csll.showBoy();
        //出列
        csll.countBoy(1,2,6);
    }

}


class CircleSingleLinkedList{

    //创建一个first节点
    private Boy first = null;

    public void addBoy(int nums){
        if (nums <1){
            System.out.println("nums值不正确");
            return;
        }

        Boy curBoy = null;
        for (int i =1; i<= nums; i++){
            Boy boy = new Boy(i);
            if (i ==1){
                first = boy;
                first.setNext(first); //构成环
                curBoy = first;
            }else{
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }

        }
    }

    public void showBoy(){
        if (first == null){
            System.out.println("没有小孩");
            return;
        }
        Boy curBoy = first;
        while(true){
            System.out.printf("小孩的编号%d \n",curBoy.getNo());
            if (curBoy.getNext() == first){
                break;
            }
            curBoy = curBoy.getNext();
        }

    }

    /**
     *
     * @param startNo 从第几个小孩
     * @param countNum 表示数几下
     * @param nums  最初有几个小孩
     */
    //根据用户输入，计算小孩出圈顺序
    public void countBoy(int startNo, int countNum, int nums){
        if (startNo < 1 ||first ==null ||nums <startNo){
            System.out.println("输入参数有误");
            return;
        }
        //创建辅助指针，帮助出列(到达first的前一个，即最后一个)
        Boy helper = first;
        while(true){
            if (helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }

        //移到第startNo个小孩
        for (int j=0; j<startNo-1; j++){
            first = first.getNext();
            helper = helper.getNext();
        }
        //当小孩报数，让first和helper同时移动，循环操作，直到圈中只有一个节点
        while(true){
            if (helper == first)
                break;

            for (int j=0; j<countNum-1;j++){
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("小孩%d出圈\n",first.getNo());
            //first指向的小孩出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩%d\n",helper.getNo());

    }

}




class Boy{
    private  int no;
    private  Boy next;

    public Boy(int no){
        this.no = no;
    }


    public void setNo(int n) {
        this.no = no;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public int getNo() {
        return no;
    }

    public Boy getNext() {
        return next;
    }
}