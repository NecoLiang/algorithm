package com.atyiche.algorithm.binary_tree;

/**
 * @author liangyt
 * @create 2021-02-24 16:24
 */
public class InvertBinaryTree {
    //先序遍历
    public TreeNode invertTree1(TreeNode root) {
        // 处理基准场景
        if (root == null) return null;

        // 1. 先处理根节点，交换左右子节点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 2. 递归处理左右子树
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    //后序遍历
    public TreeNode invertTree(TreeNode root) {
        if ( root == null ) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(7);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(9);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        TreePrinter.printTreeLevelOrder(treeNode1);
        System.out.println();
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        TreePrinter.printTreeLevelOrder(invertBinaryTree.invertTree(treeNode1));

    }
}
