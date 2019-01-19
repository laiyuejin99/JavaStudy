package leetcode;

public class N111MiniumDepth {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return helper(root, 1);
    }

    public int helper(TreeNode root, int currentDepth) {
        if (root == null) return Integer.MAX_VALUE;
        if (root.left == null && root.right == null) return currentDepth;
        int leftDepth = helper(root.left, currentDepth + 1);
        int rightDepth = helper(root.right, currentDepth + 1);
        int val = Math.min(leftDepth, rightDepth);
        return val;
    }
}
