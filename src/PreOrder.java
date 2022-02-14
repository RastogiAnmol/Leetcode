import TreeNode.String.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class PreOrder {
    public List<String> preorderTraversal(TreeNode root) {
        List<String> list = new ArrayList<String>();
        preorderTraversal(root, list);
        return list;
    }

    public void preorderTraversal(TreeNode root, List<String> list){
        if(root != null){
            list.add(root.val);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }
    public static void main(String[] args) {
        PreOrder preOrder = new PreOrder();
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

