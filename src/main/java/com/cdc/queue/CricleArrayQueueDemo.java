package com.cdc.queue;

import java.util.Scanner;

public class CricleArrayQueueDemo {

    public static void main(String[] args) {

        CircleArrayQueue queue = new CircleArrayQueue(4);
        char key =' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while(loop){
            System.out.print("s(show)查看队列数据；");
            System.out.print("a(add)添加队列数据；");
            System.out.print("g(get)获取队列数据；");
            System.out.print("h(head)查看队列头部数据；");
            System.out.println("e(exit)退出程序；");

            key = scanner.next().charAt(0);

            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数：");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try{
                        int res = queue.getQueue();
                        System.out.println("取出的数据是："+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        int head = queue.headQueue();
                        System.out.println("取出的头数据是："+head);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");


    }
}
