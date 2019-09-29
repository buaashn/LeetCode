package main.java.common;

public class BinaryTree {

    // 二叉树的根节点
    private TreeNode root=null;

    public BinaryTree(){
    }

    public BinaryTree(TreeNode root){
        this.root = root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    // 测试代码，测试生成左右子孩
    private void initRoot(){
        TreeNode testRoot = new TreeNode("Test");
        TreeNode testLeft = new TreeNode("Left");
        TreeNode testRight = new TreeNode("Right");
        testRoot.setLeftChild(testLeft);
        testRoot.setRightChild(testRight);
    }

    // 还需要实现前中后序

    /**
     * 内部类，二叉树节点
     */
    private class  TreeNode{
        // 节点的数据值，可以改为其他类型，修改String为其他类型即可
        private String value;
        // 左子孩
        private TreeNode leftChild;
        // 右子孩
        private TreeNode rightChild;

        public TreeNode(String value){
            // 给当前节点赋值
            this.value = value;
        }

        // 设置节点值
        public void setValue(String value) {
            this.value = value;
        }

        // 设置左子孩
        public void setLeftChild(TreeNode leftChild) {
            this.leftChild = leftChild;
        }

        // 设置右子孩
        public void setRightChild(TreeNode rightChild) {
            this.rightChild = rightChild;
        }

        // 读取值
        public String getValue() {
            return value;
        }

        // 读取左子孩
        public TreeNode getLeftChild() {
            return leftChild;
        }

        // 读取右子孩
        public TreeNode getRightChild() {
            return rightChild;
        }
    }
}
