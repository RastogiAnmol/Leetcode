import TreeNode.Int.TreeNode;

import java.util.HashMap;
import java.util.List;

public class ConstructTree {
    int postorder_index;
    int[] postorder;
    int[] inorder;
    HashMap<Integer, Integer> inorder_index_map = new HashMap<>();

    public TreeNode helper(int left_index, int right_index) {
        // if there is no elements to construct subtrees
        if (left_index > right_index)
            return null;

        // pick up postorder_index element as a root
        int root_val = postorder[postorder_index];
        TreeNode root = new TreeNode(root_val);

        // root splits inorder list
        // into left and right subtrees
        int index = inorder_index_map.get(root_val);

        // recursion
        this.postorder_index--;
        // build right subtree
        root.right = helper(index + 1, right_index);
        // build left subtree
        root.left = helper(left_index, index - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        // start from the last postorder element
        this.postorder_index = postorder.length - 1;

        // build a hashmap value -> its index
        int idx = 0;
        for (Integer val : inorder)
            this.inorder_index_map.put(val, idx++);
        return helper(0, inorder.length - 1);
    }

    public static void main(String[] args) {
        ConstructTree ct = new ConstructTree();
        ct.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
    }
}
