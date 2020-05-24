package com.cdc.linkedlist;

public class DoubleLinkedList {

    private HeroNode2 head = new HeroNode2(0,"","");

    //    遍历
    public void list(){
        //判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        //临时节点
        HeroNode2 temp = head.next;

        while(true){
            if(temp == null){
                break;
            }
            //打印节点信息
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }

    //    添加方法，加到双向链表最后
    public void add(HeroNode2 node){
        HeroNode2 temp = head;

        while(true){
            //找到链表尾
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        //形成双向链表
        temp.next = node;
        node.pre = temp;
    }

    //按照编号添加
    public void addByOrder(HeroNode2 node){
        HeroNode2 temp = head;
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
            if (temp.next != null) {
                node.next = temp.next;
                temp.next.pre = node;
            }
            temp.next = node;
            node.pre = temp;

        }
    }

    //修改节点
    public void update(HeroNode2 node){
        if (head.next == null )
            System.out.println("链表为空");

        HeroNode2 temp = head.next;
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

    //从双向链表删除节点
    public void delete(int n){
        if (head.next == null){
            System.out.println("链表为空，无法删除");
            return;
        }

        HeroNode2 temp = head.next;
        boolean flag = false;
        while(true){
            if(temp == null)
                break;
            if (temp.n == n){
                flag = true;
                break;
            }
            temp =temp.next;
        }

        if (flag){
            temp.pre.next = temp.next;
            //这里有问题，如果temp是最后一个节点，则temp.next为空
            //如果是最后一个节点，不执行，否则空指针异常
            if (temp.next !=null){
                temp.next.pre =temp.pre;
            }

        }else {
            System.out.printf("要删除的节点%d不存在",n);
        }
    }



}

class HeroNode2{
    public int n;
    public String name;
    public String nickName;
    public HeroNode2 next;
    public HeroNode2 pre;


    public HeroNode2(int n, String name, String nickName) {
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

