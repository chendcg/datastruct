package com.cdc.queue;



public class ArrayQueue {

    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = -1;
        this.rear = -1;
        this.arr = new int[maxSize];
    }


//    判空
    public boolean isEmpty(){
        return front == rear;
    }
//    判满
    public boolean isFull(){
        return rear == maxSize-1;
    }

//    添加数据
    public void addQueue(int n){
       if(isFull()){
           System.out.println("队列已满。。。");
           return;
       }
       rear++;
       arr[rear] = n;
    }

//    取数据
    public int getQueue(){
        if (isEmpty()){
            System.out.println("队列为空，没有数据");
            throw new RuntimeException("队列为空，没有数据");
        }
        front++;
        return arr[front];
    }

//   显示所有数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空，没有数据");
        }else {
            for (int i=0 ;i<arr.length ; i++){
                System.out.printf("arr[%d]=%d\n",i,arr[i]);
            }
        }

    }

//显示头数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，没有数据");
        }
        return arr[front+1];
    }


}
