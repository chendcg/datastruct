package com.cdc.linkedlist;

public class SingleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode node01 = new HeroNode(1,"sj","jsy");
        HeroNode node02 = new HeroNode(2,"ljy","yql");
        HeroNode node03 = new HeroNode(3,"wy","zdx");
        HeroNode node04 = new HeroNode(4,"lc","bzt");

        SingleLinkedList sll = new SingleLinkedList();
        //添加
        //sll.add(node01);
        //sll.add(node02);
        //sll.add(node03);
        //sll.add(node04);

        sll.addByOrder(node01);
        sll.addByOrder(node04);
        sll.addByOrder(node03);
        sll.addByOrder(node02);
        //显示
        sll.list();
        //修改节点
       // HeroNode node_04 = new HeroNode(4,"ws","xz");
      //  sll.update(node_04);
      //  删除节点
     //   sll.delete(4);
        //显示
        sll.list();

        System.out.println("链表长度："+sll.getLength());

        //HeroNode lastkNode = sll.getLastIndexNode(2);
        //System.out.println(lastkNode);

        //反转链表
        sll.reverseList();
        sll.list();
        System.out.println("====================");
        //逆序打印
        sll.reversePrint();


    }
}
