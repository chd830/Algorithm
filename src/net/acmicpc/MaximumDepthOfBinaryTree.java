package net.acmicpc;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        System.out.println("left: "+count(root.left, 0));
        System.out.println("right: "+count(root.right, 0));
        return Math.max(count(root.left,  0), count(root.right, 0)) + 1 ;
    }

    public int count(TreeNode t, int count) {
        if (t == null)
            return count;
        else {
            return Math.max(count(t.left, count + 1), count(t.right, count + 1));
        }
    }
}
