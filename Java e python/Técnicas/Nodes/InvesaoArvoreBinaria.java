class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}

public class InvertTree {
    /**
     * Espelha a árvore trocando filhos recursivamente.
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        // troca subárvores
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        // inverte recursivamente
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
