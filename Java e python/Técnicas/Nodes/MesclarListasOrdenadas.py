class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def merge_two_lists(l1: ListNode, l2: ListNode) -> ListNode:
    """
    - Usa um dummy para facilitar a construção da lista resultante.
    - Percorre ambas as listas, anexando sempre o menor nó atual.
    Tempo: O(n+m), Espaço: O(1) (além da saída).
    """
    dummy = ListNode()
    tail = dummy

    # enquanto ambas não vazias:
    while l1 and l2:
        if l1.val < l2.val:
            tail.next = l1
            l1 = l1.next
        else:
            tail.next = l2
            l2 = l2.next
        tail = tail.next

    # anexa o restante de l1 ou l2
    tail.next = l1 or l2
    return dummy.next

# Exemplo:
# l1 = 1→2→4, l2 = 1→3→4 → resultado 1→1→2→3→4→4
a = ListNode(1, ListNode(2, ListNode(4)))
b = ListNode(1, ListNode(3, ListNode(4)))
res = merge_two_lists(a, b)
while res:
    print(res.val, end="→" if res.next else "")
    res = res.next
