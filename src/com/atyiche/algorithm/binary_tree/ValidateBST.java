package com.atyiche.algorithm.binary_tree;

import java.util.ArrayList;

/**
 * @author liangyt
 * @create 2021-02-24 18:11
 */
public class ValidateBST {
    public boolean isValidBST1(TreeNode root) {
        if ( root == null ) return true;
        return validator(root.left, null, root.val)
                && validator(root.right, root.val, null);
    }
    // 定义一个辅助校验器
    public boolean validator(TreeNode root, Integer lowerBound, Integer upperBound){
        if ( root == null ) return true;
        // 1. 如果超出了下界，返回false
        if (lowerBound != null && root.val <= lowerBound) {
            return false;
        }
        // 2. 如果超出了上界，返回false
        if (upperBound != null && root.val >= upperBound) {
            return false;
        }
        // 接下来递归判断左右子树，返回结果
        return validator(root.left, lowerBound, root.val)
                && validator(root.right, root.val, upperBound);
    }

    public boolean isValidBST(TreeNode root) {
        inOrderArray = new ArrayList<>();
        // 中序遍历，得到升序数组
        inOrder(root);
        // 遍历数组，判断是否升序
        for ( int i = 0; i < inOrderArray.size(); i++ ){
            if (i > 0 && inOrderArray.get(i) <= inOrderArray.get(i-1))
                return false;
        }
        return true;
    }
    private ArrayList<Integer> inOrderArray;
    // 中序遍历得到升序数组
    public void inOrder(TreeNode root){
        if ( root == null ) return;
        inOrder(root.left);
        inOrderArray.add(root.val);
        inOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(6);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;

        ValidateBST validateBST = new ValidateBST();
        System.out.println(validateBST.isValidBST(treeNode1));
    }
}
