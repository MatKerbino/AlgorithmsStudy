/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *
 * Este código implementa uma solução recursiva para inverter uma lista ligada simples.
 * 
 * NÃO foi utilizado nenhum algoritmo de ordenação (sort) neste código.
 * A técnica aplicada é a recursão para inverter a direção dos ponteiros dos nós.
 * 
 * As principais estruturas de dados usadas são:
 * - Lista Ligada Simples: onde cada nó contém um valor e um ponteiro para o próximo nó.
 * - Variável auxiliar "newHead": para armazenar a nova cabeça da lista invertida.
 */

class Solution {
    // Variável de instância que guarda a nova cabeça da lista invertida.
    private ListNode newHead;
    
    // Método público que inicia o processo de inversão da lista ligada.
    public ListNode reverseList(ListNode head) {
        // Se a lista estiver vazia, retorna imediatamente.
        if (head == null) return head;
        
        // Chama o método auxiliar recursivo "reverse" para iniciar a inversão.
        // O método retorna o último nó processado.
        ListNode last = reverse(head);
        
        // Após a recursão, o ponteiro "next" do último nó precisa ser definido como null,
        // para indicar o final da lista invertida.
        last.next = null;s
        
        // Atualiza a referência "head" para apontar para a nova cabeça da lista invertida,
        // que foi definida durante o processo recursivo.
        head = newHead;

        // Retorna a lista invertida.
        return head;
    }

    // Método auxiliar recursivo que realiza a inversão dos nós da lista.
    private ListNode reverse(ListNode node) {
        // Caso base: se o nó atual é o último nó (seu campo next é null)
        if(node.next == null) {
            // Define este nó como a nova cabeça da lista invertida.
            newHead = node;
            // Retorna o nó atual para a chamada recursiva anterior.
            return node; 
        } else {
            // Chamada recursiva: processa o próximo nó na lista.
            ListNode last = reverse(node.next);
            // Após a chamada recursiva, o nó retornado ("last") é o nó que estava 
            // imediatamente após o nó atual na ordem original, mas que já foi invertido.
            // Redireciona o ponteiro "next" do nó retornado para apontar para o nó atual,
            // efetivamente invertendo o link entre eles.
            last.next = node;
            // Retorna o nó atual para que o nível superior da recursão possa realizar a inversão.
            return node;
        }
    }
}
