class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def invert_tree(root: TreeNode) -> TreeNode:
    """
    Inverte (espelha) recursivamente a árvore:
    - Troca subárvores esquerda/direita em cada nó.
    - Percorre toda a árvore em DFS.
    Tempo: O(n), Espaço: O(h) por recursão.
    """
    if root is None:
        return None

    # troca filhos
    root.left, root.right = root.right, root.left

    # inverte recursivamente
    invert_tree(root.left)
    invert_tree(root.right)

    return root

# Exemplo:
#     4
#    / \
#   2   7
#  / \  /
# 1  3 6
tree = TreeNode(4,
        TreeNode(2, TreeNode(1), TreeNode(3)),
        TreeNode(7, TreeNode(6), None))
inv = invert_tree(tree)
# agora inv é:
#     4
#    / \
#   7   2
#    \  / \
#    None1 3
