from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def level_order(root: TreeNode) -> list[list[int]]:
    """
    - Usa uma fila FIFO.
    - Em cada nível, processa todos os nós atualmente na fila.
    Tempo: O(n), Espaço: O(n).
    """
    if not root:
        return []
    result = []
    queue = deque([root])
    while queue:
        level_size = len(queue)
        level = []
        for _ in range(level_size):
            node = queue.popleft()
            level.append(node.val)
            if node.left: queue.append(node.left)
            if node.right: queue.append(node.right)
        result.append(level)
    return result

# Exemplo:
#    3
#   / \
#  9  20
#     / \
#    15  7
print(level_order(tree))
# saída: [[3], [9,20], [15,7]]
