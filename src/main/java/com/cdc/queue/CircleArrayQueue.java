package com.cdc.queue;

/**
 * 环形队列
 * 队列满的条件：  （rear+1）%maxSize =front
 * 队列空的条件  rear = front
 * 队列元素个数：   (rear+maxSize-front)%maxSize
 */

public class CircleArrayQueue {

    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = 0;
        this.rear = 0;
        this.arr = new int[maxSize];
    }


//    判空
    public boolean isEmpty(){
        return front == rear;
    }
//    判满
    public boolean isFull(){
        return (rear+1)%maxSize == front;
    }

//    添加数据
    public void addQueue(int n){
       if(isFull()){
           System.out.println("队列已满。。。");
           return;
       }
       arr[rear] = n;
       rear = (rear+1)% maxSize;
    }

//    取数据
    public int getQueue(){
        if (isEmpty()){
            System.out.println("队列为空，没有数据");
            throw new RuntimeException("队列为空，没有数据");
        }

        int value = arr[front];
        front = (front+1)% maxSize;
        return value;
    }

//   显示所有数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空，没有数据");
            return;
        }else {

            for (int i=front ;i<front +size() ; i++){
                System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
            }
        }

    }

//显示头数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，没有数据");
        }
        return arr[front];
    }

//    求出当前队列有效数据的个数
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }


}
