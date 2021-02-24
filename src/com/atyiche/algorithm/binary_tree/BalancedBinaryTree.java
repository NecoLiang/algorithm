package com.atyiche.algorithm.binary_tree;

import java.util.concurrent.BlockingDeque;

/**
 * @author liangyt
 * @create 2021-02-24 17:35
 */
public class BalancedBinaryTree {
    public boolean isBalanced1(TreeNode root) {
        if ( root == null ) return true;
        return Math.abs( height(root.left) - height(root.right) ) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }
    // 定义一个height方法，用于计算树的高度
    public int height(TreeNode root){
        if ( root == null ) return 0;
        return Math.max( height(root.left), height(root.right) ) + 1;
    }

    //后序遍历
    public boolean isBalanced(TreeNode root) {
        return balancedHeight(root) > -1;
    }
    // 定义一个height方法
    public int balancedHeight(TreeNode root){
        if ( root == null ) return 0;
        int leftHeight = balancedHeight(root.left);
        int rightHeight = balancedHeight(root.right);
        // 如果子树不平衡，直接返回-1
        if ( leftHeight == -1 || rightHeight == -1 || Math.abs( leftHeight - rightHeight ) > 1)
            return -1;
        // 如果平衡，高度就是左右子树高度最大值，再加1
        return Math.max( leftHeight, rightHeight ) + 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(17);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;

        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
        System.out.println(balancedBinaryTree.isBalanced(treeNode1));

    }
}
