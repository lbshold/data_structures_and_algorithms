package top.lconcise.arithmetic;

import lombok.Data;

/**
 * @author: liusj
 * @date: 2022/5/17
 */
@Data
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Demo {

    public static void main(String[] args) {
        TreeNode node08 = new TreeNode(8);
        TreeNode node09 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);

        TreeNode node04 = new TreeNode(4, node08, node09);
        TreeNode node05 = new TreeNode(5, node10, null);
        TreeNode node06 = new TreeNode(6);
        TreeNode node07 = new TreeNode(7);

        TreeNode node02 = new TreeNode(2, node04, node05);
        TreeNode node03 = new TreeNode(3, node06, node07);

        TreeNode root01 = new TreeNode(1, node02, node03);

//        preOrder(root01);
        System.out.println();
        inOrder(root01);
        System.out.println();
        postOrder(root01);
        System.out.println();
    }

    // 二叉树的前序遍历
    public static void preOrder(TreeNode treeNode) {
        if (treeNode == null) return;
        System.out.print(treeNode.val + " ");
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }

    // 二叉树的中序遍历
    public static void inOrder(TreeNode treeNode) {
        if (treeNode == null) return;
        inOrder(treeNode.left);
        System.out.print(treeNode.val + " ");
        inOrder(treeNode.right);
    }

    public static void postOrder(TreeNode treeNode) {
        if (treeNode == null) return;
        postOrder(treeNode.left);
        postOrder(treeNode.right);
        System.out.print(treeNode.val + " ");
    }
}
