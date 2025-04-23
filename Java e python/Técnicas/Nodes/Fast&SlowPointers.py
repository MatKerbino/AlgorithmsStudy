# definição do nó de lista
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def has_cycle(head: ListNode) -> bool:
    """
    Floyd’s Tortoise and Hare:
    - Um ponteiro avança 1 passo (slow), outro avança 2 passos (fast).
    - Se houver ciclo, eles irão se encontrar em algum ponto dentro do ciclo.
    - Caso contrário, fast alcançará o fim (None).
    Tempo: O(n), Espaço: O(1).
    """
    slow = head
    fast = head
    # enquanto for possível avançar fast
    while fast and fast.next:
        slow = slow.next          # avança 1
        fast = fast.next.next     # avança 2
        if slow is fast:
            # encontro indica presença de ciclo
            return True
    return False                   # fast chegou ao fim → sem ciclo


# Exemplo de uso:
# 1 → 2 → 3 → 4 → 2 (volta para o nó de valor 2)
n1 = ListNode(1)
n2 = ListNode(2)
n3 = ListNode(3)
n4 = ListNode(4)
n1.next, n2.next, n3.next, n4.next = n2, n3, n4, n2
print(has_cycle(n1))  # True
