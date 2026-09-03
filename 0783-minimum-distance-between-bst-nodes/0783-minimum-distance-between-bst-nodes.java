/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int minDiff = Integer.MAX_VALUE;
    private TreeNode prev = null;
    public int minDiffInBST(TreeNode root) {
        if(root==null){
            return -1;

        }
        inOrder(root);
        return minDiff;
        
    }
    private void inOrder(TreeNode current) {
        if (current == null) {
            return;
        }

        inOrder(current.left);

        if (prev != null) {
            minDiff = Math.min(minDiff, current.val - prev.val);
        }
        prev = current;
        inOrder(current.right);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna