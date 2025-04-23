# definição do nó de lista
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def reverse_list(head: ListNode) -> ListNode:
    """
    Inverte uma lista simplesmente ligada em O(n) tempo e O(1) espaço adicional.
    - Mantém três ponteiros: prev (nó invertido até agora), curr (nó atual) e nxt.
    - A cada iteração, direciona curr.next para prev, e avança os ponteiros.
    """
    prev = None         # no início, não há parte invertida
    curr = head         # começamos pelo head original

    while curr:
        nxt = curr.next    # salva quem vem em seguida
        curr.next = prev   # inverte o link: aponta para prev
        # avança todos os ponteiros
        prev = curr        
        curr = nxt

    # ao final, prev é o novo head (curr == None)
    return prev

# Exemplo de uso:
# 1→2→3→None  → vira 3→2→1→None
lst = ListNode(1, ListNode(2, ListNode(3)))
res = reverse_list(lst)
# imprime 3→2→1
cur = res
while cur:
    print(cur.val, end="→" if cur.next else "")
    cur = cur.next
