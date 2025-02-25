```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;              // Valor armazenado no nó
 *     ListNode next;        // Referência para o próximo nó da lista
 *     ListNode(int x) {
 *         val = x;          // Inicializa o valor do nó com x
 *         next = null;      // Inicializa o próximo nó como nulo
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        /*
        // Esta seção de código comentada utiliza uma estrutura de dados do tipo Set (HashSet)
        // para armazenar os nós já visitados. A ideia é que se em algum momento o nó atual
        // já estiver presente no conjunto, significa que há um ciclo.
        
        Set<ListNode> check = new HashSet<>();
        
        while (head != null){
            // Se o nó já foi visitado, retorna true indicando que existe um ciclo
            if (check.contains(head)){
                return true;
            }
            // Adiciona o nó atual no conjunto
            check.add(head);
            // Avança para o próximo nó
            head = head.next;
        }
        
        // Se o fim da lista for alcançado (null), não há ciclo
        return false;
        */

        // Verifica casos triviais: se a lista estiver vazia ou tiver apenas um nó, não pode haver ciclo.
        if (head == null || head.next == null)
            return false;

        // Implementação do algoritmo de Floyd para detecção de ciclo, também conhecido como "tortoise and hare".
        // Neste algoritmo, usamos dois ponteiros que percorrem a lista em velocidades diferentes.
        ListNode slow = head, fast = head;
        // Enquanto o ponteiro rápido (fast) e o seu próximo nó não forem nulos, continue a iteração.
        while(fast != null && fast.next != null){
            // O ponteiro lento (slow) avança um nó por vez.
            slow = slow.next;
            // O ponteiro rápido (fast) avança dois nós por vez.
            fast = fast.next.next;
            // Se em algum momento ambos os ponteiros se encontrarem, significa que existe um ciclo na lista.
            if (slow == fast){
                return true;
            }
        }
        // Se o laço terminar, significa que o ponteiro rápido alcançou o final da lista, portanto não há ciclo.
        return false;
    }
}

/*
Explicação adicional:

1. Algoritmo/Técnica de Sort:
   - Neste código NÃO foi utilizado nenhum algoritmo ou técnica de ordenação (sort).
   - O código implementa uma solução para detectar ciclos em uma lista ligada.

2. Algoritmo utilizado:
   - A implementação ativa utiliza o "Algoritmo de Floyd para detecção de ciclo" (Floyd's Cycle-Finding Algorithm),
     também conhecido como "Tartaruga e Lebre" (Tortoise and Hare).
   - A ideia é usar dois ponteiros, onde um (slow) se move uma posição por vez e o outro (fast) se move duas posições.
   - Se houver um ciclo na lista, eventualmente os dois ponteiros se encontrarão dentro do ciclo.

3. Estruturas de dados usadas:
   - Na parte comentada do código, foi utilizada a estrutura HashSet para armazenar referências dos nós visitados.
     Isso permite a verificação rápida se um nó já foi visitado, mas tem custo de memória adicional.
   - Na implementação ativa (Floyd's Algorithm), apenas referências aos nós (variáveis do tipo ListNode) são usadas,
     o que é mais eficiente em termos de espaço, já que não é necessário armazenar todos os nós visitados.
*/
```