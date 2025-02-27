    /**
 * Definition for singly-linked list.
 * Esta classe define a estrutura de um nó em uma lista encadeada simples.
 * Cada nó possui um valor inteiro (val) e uma referência para o próximo nó (next).
 *
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {} // Construtor padrão
 *     ListNode(int val) { this.val = val; } // Construtor que define apenas o valor
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; } // Construtor que define o valor e o próximo nó
 * }
 */

 class Solution {
    // =====================================================
    // IMPLEMENTAÇÃO RECURSIVA PARA INVERTER A LISTA ENCADEADA
    // =====================================================
    /*
    // Variável global para armazenar a nova cabeça (primeiro nó) da lista invertida.
    private ListNode newHead;
    
    // Método que inverte a lista encadeada de forma recursiva.
    public ListNode reverseList(ListNode head) {
        // Verifica se a lista está vazia; se sim, retorna null.
        if (head == null) return head;
        
        // Inicia o processo recursivo para inverter a lista.
        // O método reverse retorna o último nó processado da chamada recursiva.
        ListNode last = reverse(head);
        
        // Após a recursão, o ponteiro "next" do último nó (que era originalmente o primeiro nó) 
        // deve ser definido como null para marcar o fim da lista invertida.
        last.next = null;
        
        // Atualiza a referência da cabeça para o novo início da lista (armazenado em newHead).
        head = newHead;

        // Retorna a nova cabeça da lista invertida.
        return head;
    }

    // Método auxiliar recursivo que inverte a lista a partir do nó atual.
    private ListNode reverse(ListNode node) {
        // Caso base: se o próximo nó é null, significa que este é o último nó da lista original.
        if (node.next == null) {
            // Define o último nó como a nova cabeça da lista invertida.
            newHead = node;
            // Retorna o nó para iniciar a "reconexão" dos ponteiros durante a volta da recursão.
            return node; 
        } else {
            // Chamada recursiva para inverter o restante da lista a partir do próximo nó.
            ListNode last = reverse(node.next);
            // Ajusta o ponteiro do nó retornado para apontar para o nó atual, invertendo assim a ligação.
            last.next = node;
            // Retorna o nó atual para que ele possa ser ligado corretamente pelo nó anterior na recursão.
            return node;
        }
    }
    */

    // =====================================================
    // IMPLEMENTAÇÃO ITERATIVA PARA INVERTER A LISTA ENCADEADA
    // =====================================================
    public ListNode reverseList(ListNode head) {
        // 'curr' representa o nó atual que está sendo processado, iniciando pela cabeça da lista.
        ListNode curr = head;
        // 'prev' representa o nó anterior ao nó atual. Inicialmente, é null pois o novo fim da lista apontará para null.
        ListNode prev = null;
        // 'next' é usado para armazenar temporariamente o próximo nó antes de alterar os ponteiros.
        ListNode next;
        
        // Enquanto houver nós para processar (ou seja, enquanto 'curr' não for null)...
        while (curr != null) {
            // Armazena o próximo nó de 'curr' para não perder a referência após inverter o ponteiro.
            next = curr.next;
            // Inverte o ponteiro do nó atual: agora 'curr' aponta para 'prev' em vez do próximo nó original.
            curr.next = prev;

            // Avança os ponteiros para a próxima iteração:
            // 'prev' agora se torna o nó atual, pois ele já foi processado.
            prev = curr;
            // 'curr' avança para o próximo nó que foi salvo anteriormente.
            curr = next;
        }
        // Ao final do loop, 'prev' apontará para o novo início da lista invertida.
        return prev;
    }
    
    // =====================================================
    // NOTAS SOBRE O ALGORITMO E AS ESTRUTURAS DE DADOS UTILIZADAS
    // =====================================================
    // 1. Algoritmo utilizado:
    //    - Não foi utilizado nenhum algoritmo de ordenação (sort) neste código.
    //    - O código implementa o algoritmo de reversão (inversão) de uma lista encadeada.
    //    - Na implementação recursiva, a reversão é feita através de chamadas recursivas que "desfazem" a ordem original.
    //    - Na implementação iterativa, a reversão é feita utilizando três ponteiros (prev, curr, next) para inverter os
    //      ponteiros de cada nó enquanto a lista é percorrida.
    //
    // 2. Estruturas de dados utilizadas:
    //    - A principal estrutura de dados utilizada é a lista encadeada simples (singly linked list).
    //    - A classe ListNode define os nós da lista, contendo um valor inteiro e um ponteiro para o próximo nó.
}
