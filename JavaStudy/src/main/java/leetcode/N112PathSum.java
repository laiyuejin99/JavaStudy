package leetcode;

public class N112PathSum {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public boolean hasPathSum(TreeNode root, int sum) {
        return helper(root, sum, 0);
    }

    public boolean helper(TreeNode root, int sum, int currentSum) {
        if (root == null || currentSum + root.val > sum) return false;
        currentSum = root.val + currentSum;
        if(root.left==null&&root.right==null&&currentSum==sum) return true;
        return helper(root.left, sum, currentSum) || helper(root.right, sum, currentSum);
    }

}
