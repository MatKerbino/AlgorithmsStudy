/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;                        // Valor armazenado no nó
 *     ListNode next;                  // Referência para o próximo nó na lista
 *     ListNode() {}                   // Construtor padrão
 *     ListNode(int val) { this.val = val; }  // Construtor que inicializa o nó com um valor
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; } // Construtor que inicializa o nó com um valor e um próximo nó
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Se a lista estiver vazia, retorna a própria lista (nula)
        if (head == null) return head;
        
        // 'ndlist' será usado para construir a nova lista sem duplicatas.
        // Inicialmente, aponta para o primeiro nó da lista original.
        ListNode ndlist = head;
        // 'hh' guarda a referência para o início da nova lista que será retornada.
        ListNode hh = ndlist;
        
        // Loop para percorrer a lista enquanto houver um próximo nó
        while (head.next != null) {
            // Se o valor do nó atual for igual ao valor do próximo nó,
            // significa que é uma duplicata, e o ponteiro 'head' é avançado para o próximo nó.
            if (head.val == head.next.val) {
                head = head.next;
            } else {
                // Se os valores forem diferentes, significa que não é duplicata.
                // Atualiza o ponteiro 'ndlist' para apontar para esse próximo nó único.
                ndlist.next = head.next;
                // Avança o ponteiro 'ndlist' para o nó que acabou de ser adicionado à nova lista.
                ndlist = ndlist.next;
                // Avança o ponteiro 'head' para continuar a verificação a partir do próximo nó.
                head = head.next;
            }
        }

        // Após o loop, é feita uma verificação extra:
        // Se o último nó considerado em 'ndlist' tiver valor diferente do atual 'head', 
        // atualiza 'ndlist' para 'head'. Essa verificação é redundante em alguns casos,
        // mas garante que o último nó único seja considerado.
        if (ndlist.val != head.val)
            ndlist = head;
        
        // Garante que o final da nova lista não aponte para nenhum nó,
        // evitando possíveis referências a nós duplicados.
        ndlist.next = null; 
        // Retorna o início da lista sem duplicatas.
        return hh;
    }
}

/*
Explicação Geral:
-------------
Este código tem como objetivo remover elementos duplicados de uma lista encadeada já ordenada.
Por se tratar de uma lista ordenada, todos os elementos duplicados estarão consecutivos, o que
facilita a remoção.

Algoritmo e Técnica Utilizada:
------------------------------
- O algoritmo utilizado aqui é baseado na técnica de dois ponteiros:
    1. Um ponteiro ('head') é usado para percorrer todos os nós da lista original.
    2. Outro ponteiro ('ndlist') é usado para construir a nova lista sem duplicatas.
- A ideia é comparar cada nó com o seu próximo. Se ambos tiverem o mesmo valor, o ponteiro
  'head' avança, ignorando o nó duplicado.
- Quando valores diferentes são encontrados, o nó com valor distinto é ligado à nova lista
  através do ponteiro 'ndlist', e ambos os ponteiros avançam.
- Essa abordagem é eficiente, pois percorre a lista apenas uma vez, resultando em uma
  complexidade de tempo O(n), onde n é o número de nós na lista.

Estruturas de Dados Utilizadas:
-------------------------------
- **Lista Encadeada (Singly-Linked List):**
  A estrutura de dados principal utilizada neste código é a lista encadeada, definida pela classe
  `ListNode`. Cada nó da lista contém:
    - Um valor inteiro (`val`).
    - Uma referência para o próximo nó (`next`).
- O uso de ponteiros (variáveis do tipo `ListNode`) é essencial para navegar e modificar
  a lista encadeada durante a remoção dos duplicados.
  
Nota:
-----
Este código não implementa nenhum algoritmo de ordenação (sort), pois pressupõe que a lista
já está ordenada. A remoção de duplicatas aproveita essa ordenação para funcionar corretamente.
*/
