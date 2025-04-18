/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

 class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        /*
        // Esta é uma implementação alternativa (comentada) para mesclar duas listas encadeadas já ordenadas.
        // É importante notar que essa abordagem utiliza a técnica de "merge", similar à etapa de mesclagem do algoritmo Merge Sort,
        // onde dois arrays ou listas já ordenados são combinados em uma única lista ordenada.
        
        // Se uma das listas for nula, retorna a outra lista, pois não há nada para mesclar.
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        // Escolhe o primeiro nó ("brick") da lista resultante comparando os valores dos nós iniciais de list1 e list2.
        // Se list1.val for maior ou igual a list2.val, escolhe list2, caso contrário, escolhe list1.
        ListNode brick = list1.val >= list2.val ? list2 : list1;
        // Define 'head' como o início da lista mesclada.
        ListNode head = brick; 

        // Avança o ponteiro da lista de onde foi retirado o nó escolhido.
        if (brick == list1){
            list1 = list1.next;
        } else {
            list2 = list2.next;
        }

        // Enquanto ambas as listas possuírem nós, compara os valores e anexa o nó de menor valor à lista mesclada.
        while (list1 != null && list2 != null){
            if (list1.val >= list2.val){
                brick.next = list2;
                list2 = list2.next;
                brick = brick.next;
            } else {
                brick.next = list1;
                list1 = list1.next;
                brick = brick.next;
            }
        }

        // Após sair do loop, uma das listas pode não ter sido totalmente percorrida.
        // Anexa o restante da lista que ainda possui nós à lista mesclada.
        if (list1 == null){
            brick.next = list2;
        } else if (list2 == null){
            brick.next = list1;
        } else {
            return head;
        }

        return head;
        */

        // A seguir, uma segunda implementação para mesclar duas listas encadeadas ordenadas.
        // Esta implementação também utiliza a técnica de merge, similar à utilizada na etapa de mesclagem do Merge Sort.
        // Aqui, são usados dois ponteiros:
        //    - fp (first pointer) para iterar sobre 'list1'
        //    - sp (second pointer) para iterar sobre 'list2'
        // A estrutura de dados utilizada é uma lista encadeada, onde cada elemento é um nó (ListNode) que contém um valor (val)
        // e uma referência para o próximo nó (next).

        // Inicializa os ponteiros para as duas listas e uma variável auxiliar para armazenar o nó a ser copiado.
        ListNode fp = list1, sp = list2, nodeToBeCopied = null; 
        // 'head' representará o início da lista mesclada resultante, e 'tail' sempre apontará para o último nó da lista mesclada.
        ListNode head = null, tail = null;

        // Loop principal que continua enquanto houver pelo menos um nó disponível em qualquer uma das listas.
        while (fp != null || sp != null){
            // Se ambos os ponteiros não forem nulos, compara os valores dos nós apontados por fp e sp.
            if (fp != null && sp != null){
                if (fp.val <= sp.val){
                    // Se o valor de fp for menor ou igual, seleciona o nó de fp para ser copiado.
                    nodeToBeCopied = fp;
                    // Avança o ponteiro fp para o próximo nó da lista1.
                    fp = fp.next;
                }
                else {
                    // Caso contrário, seleciona o nó de sp para ser copiado.
                    nodeToBeCopied = sp;
                    // Avança o ponteiro sp para o próximo nó da lista2.
                    sp = sp.next;
                }
            } else if (fp != null){
                // Se apenas fp não for nulo, seleciona o nó de fp.
                nodeToBeCopied = fp; 
                fp = fp.next; 
            }
            else {
                // Se apenas sp não for nulo, seleciona o nó de sp.
                nodeToBeCopied = sp;
                sp = sp.next;
            }

            // Chama a função auxiliar 'insertAtEnd' para inserir o valor do nó selecionado no final da lista mesclada.
            // Esta função cria um novo nó com o valor e o adiciona ao final da lista.
            tail = insertAtEnd(tail, nodeToBeCopied.val);
            // Se 'head' ainda não foi definido, significa que este é o primeiro nó inserido na lista mesclada,
            // então 'head' é atualizado para apontar para 'tail'.
            if (head == null) {
                head = tail;
            }
        }
        // Retorna o início da lista mesclada.
        return head;
    }

    // Função auxiliar para inserir um novo nó no final da lista mesclada.
    private ListNode insertAtEnd(ListNode tail, int val){
        // Cria um novo nó com o valor fornecido.
        ListNode nodeToBeInserted = new ListNode(val);
        // Se a lista não estiver vazia (tail não for nulo), anexa o novo nó após o nó atualmente no final da lista.
        if (tail != null){
            tail.next = nodeToBeInserted; 
        }
        // Retorna o novo nó, que passa a ser o novo 'tail' da lista.
        return nodeToBeInserted;
    }
}
