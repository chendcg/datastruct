package com.cdc.BinaryTree;

public class ThreadedBinaryTreeDemo {

    public static void main(String[] args) {
        HeroNode02 root = new HeroNode02(1,"1");
        HeroNode02 node02 = new HeroNode02(2,"3");
        HeroNode02 node03 = new HeroNode02(3,"6");
        HeroNode02 node04 = new HeroNode02(4,"8");
        HeroNode02 node05 = new HeroNode02(5,"10");
        HeroNode02 node06 = new HeroNode02(6,"14");

        root.setLeft(node02);
        root.setRight(node03);
        node02.setLeft(node04);
        node02.setRight(node05);
        node03.setLeft(node06);

        ThreadedBinaryTree tbt = new ThreadedBinaryTree();
        tbt.setRoot( root);
        //中序线索化
        tbt.threadedNodes();

        System.out.println("10号节点前驱："+node05.getLeft());//3
        System.out.println("10号节点后继："+node05.getRight()); //1


    //    线索化二叉树遍历
        System.out.println("使用线索化的方式遍历线索化二叉树");
        tbt.threadedList();  //8,3,10,1,14,6


    }

}


/**
 * 实现了线索化的二叉树
 */

class ThreadedBinaryTree{

    private HeroNode02 root;

    private HeroNode02 pre =null;



    public void threadedNodes(){
        this.threadedNodes(root);
    }

    //二叉树中序线索化的方法
    public void threadedNodes(HeroNode02 node){
        if (node == null){
            return;
        }
        //线索化左子树
        threadedNodes(node.getLeft());
        //线索化当前节点
        if (node.getLeft() ==null){
            //让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            node.setLeftType(1);
        }

        if (pre !=null && pre.getRight() ==null){
            //让前驱节点的
            pre.setRight(node);
            pre.setRightType(1);
        }
        //!!!!一定要加，让当前节点是下一个节点的前驱节点
        pre = node;


        //线索化右子树
        threadedNodes(node.getRight());

    }

    /**
     * 遍历中序线索化二叉树
     */
        public void threadedList(){
            HeroNode02 node = root;
            while(node !=null){
                //循环找到leftType==1的第一个节点
                while(node.getLeftType() ==0){
                    node = node.getLeft();
                }

            //    打印当前节点
                System.out.println(node);

                while(node.getRightType() == 1){
                    node = node.getRight();
                    System.out.println(node);
                }

            //    替换遍历的节点
                node = node.getRight();
            }
        }







    public ThreadedBinaryTree() {

    }
    public ThreadedBinaryTree(HeroNode02 root) {
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

    public void setRoot(HeroNode02 root) {
        this.root = root;
    }

}





/**
 *线索化二叉树
 * 节点
 */

class HeroNode02 extends HeroNode{

    private HeroNode02 left;

    private HeroNode02 right;

    //leftType（rightType）==0标识指向的是左子树（右子树）；
    //                  ==1指向的是前驱节点（后继节点）
    private int leftType;

    private int rightType;


    public HeroNode02(int no, String name) {
        super(no, name);
    }

    @Override
    public HeroNode02 getLeft() {
        return left;
    }

    public void setLeft(HeroNode02 left) {
        this.left = left;
    }

    @Override
    public HeroNode02 getRight() {
        return right;
    }

    public void setRight(HeroNode02 right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}