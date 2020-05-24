package com.cdc.BinaryTree;

public class BinaryTreeDemo {



    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        //创建节点
        HeroNode root = new HeroNode(1,"bb");
        HeroNode hn02 = new HeroNode(2,"aa");
        HeroNode hn03 = new HeroNode(3,"cc");
        HeroNode hn04 = new HeroNode(4,"dd");
        //新增节点5
        HeroNode hn05 = new HeroNode(5,"dd");

        //设置根节点
        bt.setRoot(root);
        //构建书=树
        root.setLeft(hn02);
        root.setRight(hn03);
        hn03.setRight(hn04);
        hn03.setLeft(hn05);

        //遍历
        System.out.println("前序遍历");  // 1,2,3,4   --1,2,3,5,4
        bt.preOrder();

        System.out.println("中序遍历");  //2,1,3,4    --2,1,5,3,4
        bt.infixOrder();

        System.out.println("后序遍历");  //2,4,3,1   --2,5,4,3,1
        bt.postOrder();

        int no=5;
        HeroNode resNode =null;
        System.out.println("前序查找");
        resNode =bt.preOrderSearch(no);
        if (resNode !=null){
            System.out.printf("找到了，信息为no=%d，name=%s",resNode.getNo(),resNode.getName());
            System.out.println();
        }else {
            System.out.println("没有找到");
        }

        System.out.println("中序查找");
        resNode =bt.infixOrderSearch(no);
        if (resNode !=null){
            System.out.printf("找到了，信息为no=%d，name=%s",resNode.getNo(),resNode.getName());
            System.out.println();
        }else {
            System.out.println("没有找到");
        }

        System.out.println("后序查找");
        resNode =bt.postOrderSearch(no);
        if (resNode !=null){
            System.out.printf("找到了，信息为no=%d，name=%s",resNode.getNo(),resNode.getName());
        }else {
            System.out.println("没有找到");
        }

        System.out.println("删除前：");
        bt.preOrder();
        bt.delNode(4);
        System.out.println("删除后：");
        bt.preOrder();

    }



}

/**
 * 二叉树类
 */

class BinaryTree{
    private HeroNode root;

    public BinaryTree() {

    }
    public BinaryTree(HeroNode root) {
        this.root = root;
    }

    /**
     * 遍历输出  调用节点的遍历方法
     */

    //前序遍历
    public void preOrder(){
        if (this.root !=null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空");
        }
    }


    //中序遍历
    public void infixOrder(){
        if (this.root !=null){
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空");
        }
    }

    //后序遍历
    public void postOrder(){
        if (this.root !=null){
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空");
        }
    }

    /**
     * 遍历查找
     * @param no
     * @return
     */
    //前序查找
    public HeroNode preOrderSearch(int no){
        if (root !=null){
            return root.preOrdersearch(no);
        }else {
            return null;
        }

    }

    //中序查找
    public HeroNode infixOrderSearch(int no){
        if (root !=null){
            return root.infixOrderSearch(no);
        }else {
            return null;
        }

    }

    //后序查找
    public HeroNode postOrderSearch(int no){
        if (root !=null){
            return root.postOrderSearch(no);
        }else {
            return null;
        }

    }

    /**
     * 删除节点
     * @return
     */
    public void delNode(int no){
        if (root !=null){
            if (root.getNo() == no){
                root = null;
            }else {
                //递归删除
                root.delNode(no);
            }

        }else {
            System.out.println("空树，无法删除");
        }
    }



    public HeroNode getRoot() {
        return root;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }
}


/**
 *
 * 节点
 */

class HeroNode{

    private int no;

    private String name;

    private HeroNode left;

    private HeroNode right;

    public HeroNode(int no, String name){
        this.name =name;
        this.no = no;
    }

    //前序遍历
    public void preOrder(){
        System.out.println(this);

        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right !=null){
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder(){
        if (this.left !=null){
            this.left.infixOrder();
        }
        System.out.println(this);

        if (this.right !=null){
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void postOrder(){
        if (this.left !=null){
            this.left.postOrder();
        }
        if (this.right !=null){
            this.right.postOrder();
        }
        System.out.println(this);
    }


    //前序查找
    public HeroNode preOrdersearch(int no){
        if (this.no ==no){
            return this;
        }
        //递归左子树
        HeroNode resNode =null;
        if (this.left !=null){
            resNode = this.left.preOrdersearch(no);
        }
        if (resNode !=null){
            return resNode;
        }
        //递归右子树
        if (this.right !=null){
            resNode = this.right.preOrdersearch(no);
        }
        return resNode;

    }

    //中序查找
    public HeroNode infixOrderSearch(int no){
        HeroNode resNode = null;
        if (this.left !=null){
            resNode =this.left.infixOrderSearch(no);
        }
        if (resNode !=null){
            return resNode;
        }

        if (this.no ==no){
            return this;
        }

        if (this.right !=null){
            resNode =this.right.infixOrderSearch(no);
        }
        return resNode;
    }


    //后序查找
    public HeroNode postOrderSearch(int no){
        HeroNode resNode =null;
        if (this.left !=null){
            resNode =this.left.postOrderSearch(no);
        }
        if (resNode !=null){
            return resNode;
        }
        //右子树
        if (this.right !=null){
            resNode =this.right.infixOrderSearch(no);
        }
        if (resNode !=null){
            return resNode;
        }
        //如果左右子树都没找到
        if (this.no ==no){
            return this;
        }else {
            return resNode;
        }

    }

    /**
     * 递归删除节点   （如果叶子节点直接删除，如果非叶子节点，将其与其子树删除）
     * @return
     */
    public void delNode(int no){
        //判断左节点
        if (this.left !=null && this.left.no == no){
            this.left =null;
            return;
        }
        //判断右节点
        if (this.right !=null && this.right.no == no){
            this.right =null;
            return;
        }
        //    左子树递归删除
        if (this.left !=null){
            this.left.delNode(no);
        }
        //    右子树递归删除
        if (this.left !=null){
            this.right.delNode(no);
        }

    }



    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}