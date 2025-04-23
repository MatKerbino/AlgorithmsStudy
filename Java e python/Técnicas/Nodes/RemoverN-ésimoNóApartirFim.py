class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def remove_nth_from_end(head: ListNode, n: int) -> ListNode:
    """
    Dois ponteiros + nó dummy:
    - Criamos um nó fictício antes do início para simplificar remoções.
    - Fast avança n+1 passos, depois ambos (slow, fast) avançam até fast == None.
    - Slow estará no nó anterior ao a ser removido.
    Tempo: O(n), Espaço: O(1).
    """
    dummy = ListNode(0, head)
    slow = dummy
    fast = dummy
    # avança fast n+1 posições
    for _ in range(n + 1):
        fast = fast.next
    # avança até fast atingir o fim
    while fast:
        slow = slow.next
        fast = fast.next
    # remove o nó seguinte a slow
    slow.next = slow.next.next
    return dummy.next

# Exemplo:
# 1→2→3→4→5, n=2 → remove o '4'
lst = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))
res = remove_nth_from_end(lst, 2)
# imprime lista resultante
cur = res
while cur:
    print(cur.val, end="→" if cur.next else "")
    cur = cur.next
# saída: 1→2→3→5
