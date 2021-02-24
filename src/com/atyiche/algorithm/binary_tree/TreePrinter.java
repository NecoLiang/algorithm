package com.atyiche.algorithm.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liangyt
 * @create 2021-02-24 14:37
 */
public class TreePrinter {
    // 遍历二叉树1：先序遍历,根-左-右
    public static void printTreePreOrder( TreeNode root ){
        if (root == null) return;
        System.out.print(root.val + "\t");
        printTreePreOrder( root.left );
        printTreePreOrder( root.right );
    }

    // 遍历二叉树2：中序遍历，左-根-右
    public static void printTreeInOrder( TreeNode root ){
        if (root == null) return;
        printTreeInOrder( root.left );
        System.out.print(root.val + "\t");
        printTreeInOrder( root.right );
    }

    // 遍历二叉树3：后序遍历，左-右-根
    public static void printTreePostOrder( TreeNode root ){
        if (root == null) return;
        printTreePostOrder( root.left );
        printTreePostOrder( root.right );
        System.out.print(root.val + "\t");
    }

    //前序中序后序——DFS深度优先搜索
    //层序遍历——BFS广度优先搜索
    public static void printTreeLevelOrder( TreeNode root ) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {

            TreeNode curNode = queue.poll();
            System.out.print(curNode.val + "\t");

            if (curNode.left != null)
                queue.offer(curNode.left);
            if (curNode.right != null)
                queue.offer(curNode.right);
        }

    }

        public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;

        treeNode4.right = treeNode6;
        printTreePreOrder(treeNode1);
        System.out.println();
        printTreeInOrder(treeNode1);
        System.out.println();
        printTreePostOrder(treeNode1);
        System.out.println();
        printTreeLevelOrder(treeNode1);
    }
}
