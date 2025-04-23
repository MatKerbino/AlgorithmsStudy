class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def max_depth(root: TreeNode) -> int:
    """
    - Se nó é None, profundidade = 0.
    - Caso contrário, profundidade = 1 + max(profundidade_esquerda, profundidade_direita).
    Tempo: O(n), Espaço: O(h) recursivo (h = altura).
    """
    if root is None:
        return 0
    left_h = max_depth(root.left)
    right_h = max_depth(root.right)
    return 1 + max(left_h, right_h)

# Exemplo:
#    3
#   / \
#  9  20
#     / \
#    15  7
tree = TreeNode(3, TreeNode(9), TreeNode(20, TreeNode(15), TreeNode(7)))
print(max_depth(tree))  # 3
