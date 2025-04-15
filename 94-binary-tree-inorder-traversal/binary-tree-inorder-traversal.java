import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    private void dfs(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        
        dfs(root.left, ans);
        ans.add(root.val);
        dfs(root.right, ans);
        
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }
}
