class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def inorder_morris(root: TreeNode) -> list[int]:
    """
    - Constrói links temporários (threads) para voltar ao pai sem pilha.
    - Tempo: O(n), Espaço: O(1) extra.
    """
    res = []
    curr = root
    while curr:
        if curr.left is None:
            # visita e vai para direita
            res.append(curr.val)
            curr = curr.right
        else:
            # acha o predecessor (máx da subárvore esquerda)
            pred = curr.left
            while pred.right and pred.right is not curr:
                pred = pred.right
            if pred.right is None:
                # faz o thread para voltar
                pred.right = curr
                curr = curr.left
            else:
                # thread existente: remove, visita, vai para direita
                pred.right = None
                res.append(curr.val)
                curr = curr.right
    return res

# Exemplo:
#    1
#     \
#      2
#     /
#    3
root = TreeNode(1, None, TreeNode(2, TreeNode(3), None))
print(inorder_morris(root))  # [1,3,2]
