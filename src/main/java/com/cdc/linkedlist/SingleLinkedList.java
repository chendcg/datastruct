package com.cdc.linkedlist;

import java.util.Stack;

public class  SingleLinkedList {


    private HeroNode head = new HeroNode(0,"","");

//    添加方法
    public void add(HeroNode node){
        HeroNode temp = head;

        while(true){
            //找到链表尾
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }

    //按照编号添加
    public void addByOrder(HeroNode node){
        HeroNode temp = head;
        boolean flag =false;

        while(true){
            if(temp.next == null)
                break;
            if (temp.next.n > node.n){
                break;
            }else if (temp.next.n == node.n){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            System.out.printf("要添加的节点%d已存在,不能添加\n",node.n);
        }else {
            node.next = temp.next;
            temp.next = node;
        }
    }

    //修改节点
    public void update(HeroNode node){
        if (head.next == null )
            System.out.println("链表为空");

        HeroNode temp = head.next;
        boolean flag = false;
        while (true){
            if (temp == null){
                break;
            }

            if (temp.n == node.n){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.name = node.name;
            temp.nickName = node.nickName;
        }else {
            System.out.printf("没有找到编号为%d的节点\n",node.n);
        }

    }

    //删除节点
    public void delete(int n){
        HeroNode temp = head;
        boolean flag = false;

        while(true){
            if(temp.next == null)
                break;
            if (temp.next.n == n){
                flag = true;
                break;
            }
            temp =temp.next;
        }

        if (flag){
            temp.next = temp.next.next;
        }else {
            System.out.printf("要删除的节点%d不存在",n);
    }
   }


//    遍历
    public void list(){
        //判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        //临时节点
        HeroNode temp = head.next;

        while(true){
            if(temp == null){
                break;
            }
            //打印节点信息
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }

    //获取单链表节点个数，如果带头结点不计入
    public int getLength(){
        if (head == null){
            return 0;
        }
        int length = 0;
        HeroNode temp = head.next;
        while(temp !=null){
            length++;
            temp = temp.next;
        }
        return length;
    }

    //找到倒数第k个节点
    public HeroNode getLastIndexNode(int k){
        if (head.next == null){
            return null;
        }
        int size = getLength();

        //k校验
        if(k<=0||k>size){
            System.out.println("所填节点数不合理");
            return null;
        }

        HeroNode temp = head.next;
        for (int i =0; i<size -k; i++){
            temp = temp.next;
        }
        return temp;
    }

    //反转链表
    public void reverseList(){
        if(head.next == null ||head.next.next == null)
            return;

        HeroNode cur = head.next;
        HeroNode next = null;
        //定义临时新节点
        HeroNode reverseHeadNode = new HeroNode(0,"","");

        while (cur != null){
            next = cur.next;
            cur.next =reverseHeadNode.next;
            reverseHeadNode.next = cur;
            cur = next;
        }
        //将head.next指向reverseHeadNode.next实现链表反转
        head.next = reverseHeadNode.next;
    }


    //逆序打印链表
    public void reversePrint(){
        if (head.next == null){
            return;
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode temp = head.next;

        while(temp != null){
            stack.push(temp);
            temp = temp.next;
        }

        while (stack.size() >0){
            System.out.println(stack.pop());
        }
    }


}


class HeroNode{
    public int n;
    public String name;
    public String nickName;
    public HeroNode next;


    public HeroNode(int n, String name, String nickName) {
        this.n = n;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "n=" + n +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}