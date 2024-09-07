/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    bool isSubPath(ListNode* head, TreeNode* root) {
        if (!root) return false;
        // Check the current node and all its descendants
        bool result = dfs(root, head);
        // Check all paths from the left and right children of the root
        result |= isSubPath(head, root->left);
        result |= isSubPath(head, root->right);
        return result;
    }

private:
    bool dfs(TreeNode* node, ListNode* head) {
        if (!head) return true;
        if (!node) return false;
        bool result = false;
        if (node->val == head->val) {
            // Continue searching in both left and right subtrees
            result |= dfs(node->left, head->next);
            result |= dfs(node->right, head->next);
        }
        return result;
    }
};