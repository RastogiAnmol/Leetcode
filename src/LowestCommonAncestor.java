import TreeNode.Int.TreeNode;

import java.util.*;

public class LowestCommonAncestor {

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            // Stack for tree traversal
            Deque<TreeNode> stack = new ArrayDeque<>();

            // HashMap for parent pointers
            Map<TreeNode, TreeNode> parent = new HashMap<>();

            parent.put(root, null);
            stack.push(root);

            // Iterate until we find both the nodes p and q
            while (!parent.containsKey(p) || !parent.containsKey(q)) {

                TreeNode node = stack.pop();

                // While traversing the tree, keep saving the parent pointers.
                if (node.left != null) {
                    parent.put(node.left, node);
                    stack.push(node.left);
                }
                if (node.right != null) {
                    parent.put(node.right, node);
                    stack.push(node.right);
                }
            }

            // Ancestors set() for node p.
            Set<TreeNode> ancestors = new HashSet<>();

            // Process all ancestors for node p using parent pointers.
            while (p != null) {
                ancestors.add(p);
                p = parent.get(p);
            }

            // The first ancestor of q which appears in
            // p's ancestor set() is their lowest common ancestor.
            while (!ancestors.contains(q))
                q = parent.get(q);
            return q;
        }


    public static void main(String[] args) {
        ConstructTree ct = new ConstructTree();
        TreeNode tree = ct.buildTree(new int[]{8, 4, 9, 2, 10, 5, 11, 1, 12, 6, 13, 3, 14, 7, 15},
                new int[]{8, 9, 4, 10, 11, 5, 2, 12, 13, 6, 14, 15, 7, 3, 1});
        LowestCommonAncestor lca = new LowestCommonAncestor();
        TreeNode first = tree.left.left.right;
        TreeNode second = tree.left.right.right;
        TreeNode ancestor = lca.lowestCommonAncestor(tree, first, second);
    }
}