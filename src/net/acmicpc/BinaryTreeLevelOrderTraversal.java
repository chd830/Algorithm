package net.acmicpc;
import java.util.*;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();

        return result;
    }

    public void recur(List<List<Integer>> list, TreeNode root, int height) {
        if(root == null)
            return;
        if(height >= list.size()) {
            list.add(new ArrayList());
        }
        list.get(height).add(root.val);
        recur(list, root.left, height + 1);
        recur(list, root.right, height + 1);
    }
}
