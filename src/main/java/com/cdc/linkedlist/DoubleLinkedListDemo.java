package com.cdc.linkedlist;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {

        HeroNode2 node01 = new HeroNode2(1,"sj","jsy");
        HeroNode2 node02 = new HeroNode2(2,"ljy","yql");
        HeroNode2 node03 = new HeroNode2(3,"wy","zdx");
        HeroNode2 node04 = new HeroNode2(4,"lc","bzt");

       DoubleLinkedList dll =new DoubleLinkedList();

       //dll.add(node01);
       //dll.add(node02);
       //dll.add(node03);
       //dll.add(node04);

        dll.addByOrder(node02);
        dll.addByOrder(node01);
        dll.addByOrder(node04);
        dll.addByOrder(node03);
       dll.list();

       //修改
        HeroNode2 node05 = new HeroNode2(4,"gss","ryl");
        dll.update(node05);
        System.out.println("修改后");
        dll.list();


        //删除
        dll.delete(3);
        System.out.println("删除后");
        dll.list();
    }
}
