class Solution {

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int numOfNodes = preorder.length;

        // Create the index array for `postorder`
        int[] indexInPostOrder = new int[numOfNodes + 1];
        for (int index = 0; index < numOfNodes; index++) {
            // Store the index of the current element
            indexInPostOrder[postorder[index]] = index;
        }

        return constructTree(0, numOfNodes - 1, 0, preorder, indexInPostOrder);
    }

    // Helper function to construct the tree recursively
    private TreeNode constructTree(
        int preStart,
        int preEnd,
        int postStart,
        int[] preorder,
        int[] indexInPostOrder
    ) {
        // Base case: If there are no nodes to process, return null
        if (preStart > preEnd) return null;

        // Base case: If only one node is left, return that node
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        // The left child root in preorder traversal (next element after root)
        int leftRoot = preorder[preStart + 1];

        // Calculate the number of nodes in the left subtree by searching in postorder
        int numOfNodesInLeft = indexInPostOrder[leftRoot] - postStart + 1;

        TreeNode root = new TreeNode(preorder[preStart]);

        // Recursively construct the left subtree
        root.left = constructTree(
            preStart + 1,
            preStart + numOfNodesInLeft,
            postStart,
            preorder,
            indexInPostOrder
        );

        // Recursively construct the right subtree
        root.right = constructTree(
            preStart + numOfNodesInLeft + 1,
            preEnd,
            postStart + numOfNodesInLeft,
            preorder,
            indexInPostOrder
        );

        return root;
    }
}