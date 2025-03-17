class Solution {
    // Método para remover o n-ésimo nó a partir do final da lista ligada
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Cria um nó fictício (dummy) com valor 0 e o conecta à cabeça da lista.
        // O nó fictício é útil para lidar com casos onde a cabeça precisa ser removida.
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Dois ponteiros, 'f' (fast) e 's' (slow), ambos iniciados no nó fictício.
        ListNode f = dummy, s = dummy;

        // Avança o ponteiro 'f' n+1 posições à frente.
        // Isso garante que, quando 'f' alcançar o final da lista,
        // 's' estará exatamente um nó antes do nó que precisa ser removido.
        for (int i = 0; i <= n; i++){
            f = f.next;
        }

        // Move ambos os ponteiros simultaneamente até que 'f' chegue ao final da lista.
        // A distância entre 'f' e 's' permanece constante, permitindo que 's' pare imediatamente antes do nó a ser removido.
        while (f != null){
            f = f.next;
            s = s.next;
        }

        // Realiza a remoção do nó "pulando" o n-ésimo nó a partir do final.
        // 's.next' é o nó que deve ser removido, e o apontamento é ajustado para 's.next.next'.
        s.next = s.next.next;

        // Retorna a nova cabeça da lista. Note que usamos 'dummy.next' para cobrir o caso em que o primeiro nó foi removido.
        return dummy.next;

        /*
        // --- Outra abordagem comentada que resolve o mesmo problema ---
        // Essa abordagem também utiliza a técnica de dois ponteiros, mas sem o nó fictício em alguns casos.
        
        ListNode fast = head;
        ListNode slow = head;
        
        // Avança o ponteiro 'fast' n posições à frente para criar a distância necessária.
        for (int i = 0; i < n; i++) {
            if (fast == null) {
                return head; // Se a lista for menor que n, retorna a lista original.
            }
            fast = fast.next;
        }

        // Se 'fast' for nulo após o loop, significa que o nó a ser removido é a cabeça.
        if (fast == null) {
            return head.next;
        }

        // Move os ponteiros até que 'fast.next' chegue ao final da lista.
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 'slow.next' é o nó a ser removido.
        slow.next = slow.next.next;

        // Retorna a cabeça da lista modificada.
        return head;
        */
    }
}

/*
Explicação Detalhada via Comentários:

1. Algoritmo e Técnica Utilizada:
   - O código utiliza a técnica de dois ponteiros (fast e slow), um método comum em problemas com listas ligadas.
   - Essa técnica garante que os ponteiros estejam separados por uma distância fixa, permitindo encontrar a posição do nó a ser removido sem 
     precisar calcular o tamanho total da lista.
   - Não foi utilizado nenhum algoritmo de ordenação (sort). A técnica aplicada é exclusivamente para remoção de um nó a partir do final da lista.

2. Estruturas de Dados Utilizadas:
   - **Lista Ligada (Linked List):** A estrutura de dados principal é a lista ligada, onde cada elemento (nó) possui um valor e uma referência para o próximo nó.
   - **Nó Fictício (Dummy Node):** Um nó extra que simplifica a remoção do primeiro nó ou quando a lista possui apenas um elemento.
   - **Ponteiros (Referências):** Dois ponteiros, 'f' (fast) e 's' (slow), que percorrem a lista para identificar o nó que precede o nó a ser removido.

3. Fluxo do Código:
   - Um nó fictício é criado e anexado ao início da lista.
   - Dois ponteiros são posicionados no nó fictício.
   - O ponteiro 'fast' é avançado n+1 passos para criar a diferença necessária.
   - Ambos os ponteiros se movem até que 'fast' alcance o fim da lista.
   - O nó seguinte ao ponteiro 'slow' é removido ajustando a referência.
   - Finalmente, a nova lista (com o nó removido) é retornada, utilizando o nó fictício para evitar casos especiais.
*/