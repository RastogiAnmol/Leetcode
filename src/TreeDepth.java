import TreeNode.String.TreeNode;
import com.sun.source.tree.Tree;

public class TreeDepth {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        TreeDepth depth = new TreeDepth();
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
        int max = depth.maxDepth(f);
        System.out.println("max depth tree is " + max);
    }
}