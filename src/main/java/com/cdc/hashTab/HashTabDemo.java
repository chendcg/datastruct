package com.cdc.hashTab;

import java.util.Scanner;

public class HashTabDemo {

    public static void main(String[] args) {

    HashTab hashTab =new HashTab(6);

    String key;
    Scanner scanner =new Scanner(System.in);
    while(true){
        System.out.print("add: 添加--");
        System.out.print("list: 显示--");
        System.out.print("find: 查找--");
        System.out.print("del: 删除--");
        System.out.println("exit: 退出--");

        key = scanner.next();
        switch (key){
            case "add":
                System.out.println("输入id:");
                int id = scanner.nextInt();
                System.out.println("输入姓名");
                String name = scanner.next();

                Emp emp =new Emp(id,name);
                hashTab.add(emp);
                break;
            case "list":
                hashTab.list();
                break;
            case "find":
                System.out.println("输入待查找的id:");
                int idFind =scanner.nextInt();
                Emp empFind = hashTab.findEmpById(idFind);
                if (empFind !=null){
                    System.out.println(empFind.toString());
                }else {
                    System.out.println("链表中不存在，未找到");
                }

                break;
            case "del":
                System.out.println("输入待查找的id:");
                int idDel =scanner.nextInt();
                hashTab.delete(idDel);
                break;
            case "exit":
                scanner.close();
                System.exit(0);
            default:
                break;
        }

    }
  }
}


class HashTab{

    private EmpLinkedList[] empLinkedListArray;
    private int size;

    public HashTab(int size){

        this.size = size;
        //初始化数组
        empLinkedListArray = new EmpLinkedList[size];
        //初始化链表---重要
        for (int i = 0; i <size ; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    //添加
    public void add(Emp emp){
        int empLinkedListNo = hash(emp.id);
        empLinkedListArray[empLinkedListNo].add(emp);
    }
    //遍历
    public void list(){
        for (int i =0 ;i< size; i++){
            empLinkedListArray[i].list(i);
        }
    }
    //查找
    public Emp findEmpById(int id){
        int empLinkedListNo =hash(id);
        Emp emp = empLinkedListArray[empLinkedListNo].find(id);
        return emp;
    }

    //删除
    public void delete(int id){
        int empLinkedListNo =hash(id);
        empLinkedListArray[empLinkedListNo].deleteEmp(id);
    }


    //取hash值
    public int hash( int id){
        return id%size;
    }

}

/**
 * 链表
 */
class EmpLinkedList {

    public Emp head;

    //添加
    public void add(Emp emp) {
        //第一个添加时
        if (head == null) {
            head = emp;
            return;
        }

        Emp curEmp = head;
        while (true) {

            if (curEmp.id == emp.id && curEmp.name.equals(emp.name)) {
                System.out.println("雇员id相同，姓名相同，重复添加");
                return;
            } else if (curEmp.id == emp.id && !curEmp.name.equals(emp.name)) {
                System.out.println("雇员id相同，姓名不同，添加失败");
                return;
            } else if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }

        //直接挂在最后
        curEmp.next = emp;
    }

    //遍历
    public void list(int no) {
        if (head == null) {
            System.out.println("第" + no + "链表为空");
            return;
        }

        Emp curEmp = head;
        System.out.println("第" + no + "链表信息:");
        while (true) {
            System.out.printf("  雇员的id:%d--name:%s", curEmp.id, curEmp.name);
            System.out.println();
            if (curEmp.next == null)
                break;
            //后移
            curEmp = curEmp.next;
        }

    }

    // 根据id查找
    public Emp find(int id) {
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        Emp curEmp = head;
        while (true) {
            if (curEmp.id == id) {
                break;
            }

            if (curEmp.next == null) { //未找到
                curEmp = null;
                break;
            }

            curEmp = curEmp.next;
        }
        return curEmp;
    }

    //    删除
    public void deleteEmp(int id) {
        if (head == null) {
            System.out.println("链表中不存在");
            return;
        }
        Emp curEmp = head;
        //第一个为删除的
        if (curEmp.id == id) {
            head = curEmp.next;
        }

        while (true) {
            if (curEmp.next == null) {
                break;
            }
            if (curEmp.next.id == id) {
                curEmp.next = curEmp.next.next;
            }
            curEmp = curEmp.next;
        }
    }
}

    /**
     * 雇员
     */
    class Emp{

        public int id;

        public String name;

        public Emp next;

        public Emp(int id, String name) {
            super();
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Emp{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
