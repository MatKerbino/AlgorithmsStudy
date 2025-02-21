/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 *
 * Esse trecho define a estrutura de dados "ListNode", que representa um nó de uma lista encadeada simples.
 * Cada nó possui um valor inteiro (val) e uma referência para o próximo nó (next).
 *
 * Não foi usado nenhum algoritmo de ordenação (sort) neste código.
 * O código utiliza uma técnica clássica para encontrar a interseção entre duas listas encadeadas:
 * 1. Calcula o tamanho de cada lista.
 * 2. Alinha os ponteiros das listas avançando o ponteiro da lista maior até que as duas tenham a mesma quantidade de nós restantes.
 * 3. Avança os dois ponteiros em paralelo até encontrar o nó em que ambos apontam para o mesmo objeto.
 *
 * As estruturas de dados utilizadas são:
 * - Lista encadeada (singly-linked list) representada pela classe ListNode.
 * - Variáveis inteiras para armazenar os comprimentos das listas.
 * - Ponteiros (referências) para os nós das listas.
 */

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Calcula o tamanho da lista A usando o método getNodeLength.
        int Alength = getNodeLength(headA);
        // Calcula o tamanho da lista B usando o método getNodeLength.
        int Blength = getNodeLength(headB);

        // Alinha os ponteiros de ambas as listas de forma que tenham a mesma quantidade de nós restantes.
        // Enquanto os comprimentos não forem iguais, avança o ponteiro da lista que possui maior comprimento.
        while (Alength != Blength){
            if (Alength > Blength){
                // Se a lista A é maior, avança o ponteiro headA para o próximo nó
                // e decrementa o comprimento de A, para "descontar" o nó avançado.
                headA = headA.next;
                Alength--;
            } else {
                // Se a lista B é maior, avança o ponteiro headB para o próximo nó
                // e decrementa o comprimento de B.
                headB = headB.next;
                Blength--;
            }
        }
        // Com os ponteiros alinhados, chama o método findIntersection para encontrar o nó de interseção.
        return findIntersection(headA, headB);
    }

    /**
     * Método auxiliar para calcular o "comprimento" da lista a partir de um nó dado.
     * OBSERVAÇÃO: O método conta os nós enquanto current.next != null, ou seja,
     * não conta o último nó. Entretanto, como é aplicado de forma consistente para ambas as listas,
     * a diferença de comprimento é preservada para alinhamento.
     *
     * @param nn Nó inicial da lista.
     * @return Comprimento (número de nós contados, exceto o último, mas consistente para comparação).
     */
    private int getNodeLength(ListNode nn){
        // Inicializa uma variável "current" para percorrer a lista.
        ListNode current = nn;
        int length = 0;
        // Percorre a lista enquanto o próximo nó existir.
        while(current.next != null){
            length++;         // Incrementa o contador para cada nó visitado.
            current = current.next; // Avança para o próximo nó.
        }
        // Retorna o comprimento calculado.
        return length;
    }

    /**
     * Método auxiliar para encontrar o nó de interseção entre duas listas alinhadas.
     * Após alinhar as listas (ou seja, quando ambas possuem a mesma quantidade de nós até o fim),
     * esse método avança simultaneamente em ambas as listas comparando os nós.
     *
     * @param n1 Ponteiro para a lista A alinhada.
     * @param n2 Ponteiro para a lista B alinhada.
     * @return O nó de interseção se existir; caso contrário, retorna null.
     */
    private ListNode findIntersection (ListNode n1, ListNode n2){
        // Enquanto houver um próximo nó na lista (note que, como a contagem não inclui o último,
        // é necessário tratar o último nó após o loop)
        while (n1.next != null){
            // Se os nós atuais não forem iguais (não apontam para o mesmo objeto na memória),
            // avança ambos os ponteiros.
            if (n1 != n2){
                n1 = n1.next;
                n2 = n2.next;
            } else {
                // Se os nós atuais forem iguais, encontramos o ponto de interseção.
                return n1;
            }
        }

        // Verifica se o último nó é o mesmo em ambas as listas.
        if (n1 == n2)
            return n1;
        // Se nenhuma interseção for encontrada, retorna null.
        return null;
    }
}