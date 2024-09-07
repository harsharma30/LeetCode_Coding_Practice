/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;
        // Check the current node and all its descendants
        boolean result = dfs(root, head);
        // Check all paths from the left and right children of the root
        result = result || isSubPath(head, root.left);
        result = result || isSubPath(head, root.right);
        return result;
    }

    private boolean dfs(TreeNode node, ListNode head) {
        if (head == null) return true;
        if (node == null) return false;
        boolean result = false;
        if (node.val == head.val) {
            // Continue searching in both left and right subtrees
            result = dfs(node.left, head.next);
            result = result || dfs(node.right, head.next);
        }
        return result;
    }
}