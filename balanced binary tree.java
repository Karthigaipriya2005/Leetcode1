class Solution {
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root)!=-1;
    }

    public int checkHeight(TreeNode node) {
        if (node==null) return 0;

        int lefth = checkHeight(node.left);
        if (lefth == -1) return -1;

        int righth = checkHeight(node.right);
        if (righth == -1) return -1;

        if (Math.abs(lefth-righth)>1) return -1;

        return Math.max(lefth,righth) +1;
    }
}
