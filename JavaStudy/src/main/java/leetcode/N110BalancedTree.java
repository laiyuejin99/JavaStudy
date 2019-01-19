package leetcode;

public class N110BalancedTree {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftDepth = depthTree(root.left, 0);
        int rightDepth = depthTree(root.right, 0);
        boolean isLeft = isBalanced(root.left);
        boolean isRight = isBalanced(root.right);
        boolean isC = Math.abs(leftDepth - rightDepth) <= 1 ? true : false;
        return isC && isLeft && isRight;
    }

    public int depthTree(TreeNode root, int depth) {
        if (root == null) return depth;
        int leftDepth = depthTree(root.left, depth + 1);
        int rightDepth = depthTree(root.right, depth + 1);
        return Math.max(leftDepth, rightDepth);
    }
}
