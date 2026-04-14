class Solution {
    private int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        gain(root);
        return maxSum;
    }
    public int gain(TreeNode node){
        if (node==null) return 0;

        int leftGain = Math.max(0, gain(node.left));
        int rightGain = Math.max(0, gain(node.right));

        maxSum = Math.max(maxSum, leftGain+node.val+rightGain);

        return node.val+Math.max(leftGain, rightGain);
    }
}
