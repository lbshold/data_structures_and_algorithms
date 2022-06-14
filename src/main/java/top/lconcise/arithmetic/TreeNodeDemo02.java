package top.lconcise.arithmetic;

import javax.xml.soap.Node;

/**
 * @author: liusj
 * @date: 2022/5/23
 */
public class TreeNodeDemo02 {

    public static void main(String[] args) {
        TreeNode treeNode13 = new TreeNode(13);

        TreeNode treeNode10 = new TreeNode(10);
        TreeNode treeNode16 = new TreeNode(16);
        treeNode13.setLeft(treeNode10);
        treeNode13.setRight(treeNode16);

        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode11 = new TreeNode(11);
        treeNode10.setLeft(treeNode9);
        treeNode10.setRight(treeNode11);
        TreeNode treeNode14 = new TreeNode(14);
        treeNode16.setLeft(treeNode14);

        TreeNode treeNode = find(treeNode13, 11);
        System.out.println(treeNode.val);

        insert(treeNode13, 17);
        TreeNodeDemo01.inOrder(treeNode13);
    }

    /**
     * 二叉查找树，查找 (不考虑数据重复)
     *
     * @param treeNode
     * @param data
     * @return
     */
    public static TreeNode find(TreeNode treeNode, int data) {
        TreeNode p = treeNode;
        while (p != null) {
            if (data < p.val) {
                p = p.left;
            } else if (data > p.val) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    /**
     * 二叉查找树，插入 (不考虑数据重复)
     *
     * @param treeNode
     * @param data
     */
    public static void insert(TreeNode treeNode, int data) {
        if (treeNode == null) {
            treeNode = new TreeNode(data);
            return;
        }
        TreeNode p = treeNode;
        while (p != null) {
            if (data < p.val) {
                if (p.left == null) {
                    p.left = new TreeNode(data);
                    return;
                }
                p = p.left;
            } else {
                if (p.right == null) {
                    p.right = new TreeNode(data);
                    return;
                }
                p = p.right;
            }
        }
    }

    /**
     * 二叉查找树，删除 (不考虑数据重复)
     *
     * @param treeNode
     * @param data
     */
    public static void delete(TreeNode treeNode, int data) {
        TreeNode p = treeNode;
        TreeNode pp = null;
        while (p != null && p.val != data) {
            pp = p;
            if (data > p.val) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        if (p == null) return;

        if (p.left != null && p.right != null) {
            TreeNode minP = p.right;
            TreeNode minPP = p;
            while(minP.left!=null){
                minPP = minP;
                minP = minP.left;
            }
            p.val = minP.val;
            p = minP;
            pp = minPP;
        }

        TreeNode child;
        if(p.left!=null){
            child = p.left;
        }else if(p.right !=null){
            child = p.right;
        }else {
            child = null;
        }

        if(pp ==null){
            treeNode = child;
        } else if(pp.left == p){
            pp.left =child;
        }else {
            pp.right = child;
        }
    }
}

