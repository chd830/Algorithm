package com.code;

public class SymmetricTree {
    public boolean isSymmetric(SameTree.TreeNode root) {
        if(root == null)
            return true;
        return checkSymmetric(root.left, root.right);
    }
    public boolean checkSymmetric(SameTree.TreeNode left, SameTree.TreeNode right) {
        if(left == null && right == null)
            return true;
        if(left == null || right == null)
            return false;
        if(left.val == right.val)
            return checkSymmetric(left.left, right.right) && checkSymmetric(left.right, right.left);
        return false;
    }
}
