package com.cdc.stack;

public class ArrayStack02 {

    private  int maxSize;
    private  int top = -1;
    private int[] stack;

    public ArrayStack02(int maxSize, int[] stack) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull(){
        return top == maxSize-1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    //入栈
    public void push(int value){
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }
    //出栈
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空，无数据");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈,需要从栈顶开始
    public void list(){
        if (isEmpty()){
            System.out.println("栈空，无数据");
            return;
        }
        for (int i=top; i>0;i--){
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }

    }

}
