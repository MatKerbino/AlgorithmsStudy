class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def reverse_k_group(head: ListNode, k: int) -> ListNode:
    """
    Inverte em grupos de k nós. Se no final restarem < k nós, mantém como está.
    - Usa um nó dummy para simplificar operações de cabeça.
    - Para cada grupo:
      1. Verifica se há k nós à frente.
      2. Inverte esses k nós usando inserção pela frente.
      3. Conecta o grupo invertido e avança.
    Tempo: O(n), Espaço: O(1).
    """
    dummy = ListNode(0, head)
    group_prev = dummy

    while True:
        # 1) Checa se há k nós
        kth = group_prev
        for _ in range(k):
            kth = kth.next
            if not kth:
                return dummy.next
        group_next = kth.next  # nó logo após o grupo

        # 2) Inverte o grupo [group_prev.next ... kth]
        prev, curr = kth.next, group_prev.next
        # percorre o grupo, inserindo curr logo após prev
        for _ in range(k):
            tmp = curr.next
            curr.next = prev
            prev = curr
            curr = tmp

        # 3) Ajusta as conexões externas
        tmp = group_prev.next   # novo final do grupo
        group_prev.next = prev  # prev é o novo início do grupo
        group_prev = tmp        # avança group_prev para o fim do grupo

    # nunca chega aqui
    # return dummy.next
