import TreeNode.String.TreeNode;
import java.util.LinkedList;
import java.util.List;

public class PreOrderUsingForLoop {
    public List<String> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<String> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        PreOrderUsingForLoop preOrder = new PreOrderUsingForLoop();
        TreeNode f = new TreeNode("F");
        TreeNode b = new TreeNode("B");
        TreeNode g = new TreeNode("G");
        TreeNode a = new TreeNode("A");
        TreeNode d = new TreeNode("D");
        TreeNode i = new TreeNode("I");
        TreeNode c = new TreeNode("C");
        TreeNode e = new TreeNode("E");
        TreeNode h = new TreeNode("H");
        f.left = b;
        f.right = g;
        b.left = a;
        b.right = d;
        g.right = i;
        d.left = c;
        d.right = e;
        i.left = h;
        List<String> lst =  preOrder.preorderTraversal(f);
    }
}
