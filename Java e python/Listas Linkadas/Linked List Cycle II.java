/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        /*
         * ================================
         * Abordagem usando HashSet (comentada)
         * ================================
         *
         * Set<ListNode> test = new HashSet<>();
         * while (head != null){
         *     // Verifica se o nó atual já foi visitado.
         *     // Se sim, significa que há um ciclo e retornamos o nó onde o ciclo se inicia.
         *     if (test.contains(head)){
         *         return head;
         *     }
         *     // Adiciona o nó atual ao conjunto para futuras comparações.
         *     test.add(head);
         *     // Avança para o próximo nó na lista.
         *     head = head.next;
         * }
         * // Se o laço terminar sem encontrar um ciclo, retorna head (que será null).
         * return head;
         *
         * Nesta abordagem, a estrutura de dados utilizada é um HashSet,
         * que armazena referências para cada nó visitado.
         * O algoritmo realiza uma varredura linear (O(n)), mas pode usar O(n) de memória.
         *
         * ================================
         * Abordagem usando o algoritmo de Floyd ("Tartaruga e Lebre") (comentada)
         * ================================
         *
         * ListNode slow = head, fast = head, temp = head;
         * while (fast != null && fast.next != null) {
         *     // slow avança um nó por vez.
         *     slow = slow.next;
         *     // fast avança dois nós por vez.
         *     fast = fast.next.next;
         *     // Se slow e fast se encontrarem, um ciclo foi detectado.
         *     if (slow == fast) break;
         * }
         * // Se não houver ciclo (fast chegou ao final), retorna null.
         * if (fast == null || fast.next == null) return null;
         * while (temp != slow) {
         *     // Avança os ponteiros um nó por vez até se encontrarem novamente.
         *     temp = temp.next;
         *     slow = slow.next;
         * }
         * // Chamada ao coletor de lixo; não é necessária para a lógica do algoritmo.
         * System.gc();
         * return temp;
         *
         * Nesta abordagem, utiliza-se o algoritmo de Floyd ("Tartaruga e Lebre"),
         * que detecta ciclos usando dois ponteiros com velocidades diferentes.
         * Essa técnica tem complexidade O(n) em tempo e O(1) em espaço.
         *
         * ================================
         * Abordagem ativa (final) usada:
         * ================================
         */

        // Verifica se a lista está vazia ou possui apenas um nó, sem possibilidade de ciclo.
        if (head == null || head.next == null) return null;

        // Inicializa dois ponteiros:
        // 'slow' se move um nó por vez,
        // 'fast' se move dois nós por vez.
        ListNode slow = head, fast = head;

        // Loop para detectar a presença de ciclo.
        while (fast != null && fast.next != null) {
            // Move 'slow' um nó adiante.
            slow = slow.next;
            // Move 'fast' dois nós adiante.
            fast = fast.next.next;

            // Se os ponteiros se encontram, há um ciclo.
            if (slow == fast) {
                // Reinicia 'slow' para o início da lista.
                slow = head;
                // Ambos os ponteiros avançam um nó por vez.
                // O ponto onde se encontram é o início do ciclo.
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; // Retorna o nó onde o ciclo inicia.
            }
        }

        // Se o loop termina sem que um ciclo seja detectado, retorna null.
        return null;
    }
}
