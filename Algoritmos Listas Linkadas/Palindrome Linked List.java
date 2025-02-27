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

/*
    ////////////////////////////////////////////////////////////////////////////////
    // Código comentado - Primeira abordagem (comentada no prompt)
    ////////////////////////////////////////////////////////////////////////////////
    
    // A classe Solution possui um método para verificar se uma lista encadeada é um palíndromo.
    // Essa abordagem busca o tamanho da lista, determina o ponto de reversão e então compara as metades.
    // A estratégia é inverter parte da lista para comparar os valores.
    // Importante: não foi utilizado nenhum algoritmo de ordenação (sort) aqui. 
    //       Trata-se apenas de manipulação de ponteiros para encontrar o meio, inverter a lista e comparar.
    
    class Solution {
        public boolean isPalindrome(ListNode head) {
            // Obtém o tamanho total da lista e divide por 2 para determinar a quantidade de nós a comparar.
            int n = findLength(head);
            if (head.next == null) {
                // Lista com apenas um nó é automaticamente um palíndromo.
                return true;
            }
            // Determina o ponto de início da reversão.
            // Se a lista tem tamanho par, reversePoint é n/2.
            // Se a lista tem tamanho ímpar, o nó central é ignorado, por isso adicionamos 1.
            int reversePoint = n / 2;
            if (n % 2 == 1) {
                reversePoint = (n / 2) + 1;
            }
            
            // Encontra o nó a partir do qual começará a reversão.
            ListNode head2 = findNodeAtPosition(head, reversePoint);
            // Encontra o nó imediatamente anterior ao ponto de reversão.
            ListNode prev = findNodeAtPosition(head, reversePoint - 1);
            
            // Inverte a sublista a partir de head2 até o final, conectando-a ao nó anterior (prev).
            reverse(head2, prev);
            
            // Inicializa dois ponteiros para comparar: 
            // 'first' aponta para o início da lista original,
            // 'second' aponta para o início da segunda metade invertida.
            ListNode first = head;
            ListNode second = prev.next;
            
            // Compara os nós da primeira metade com os da segunda metade invertida.
            while (first != null && second != null) {
                if (first.val != second.val) {
                    // Se algum par de nós não for igual, a lista não é um palíndromo.
                    return false;
                }
                first = first.next;
                second = second.next;
            }
            
            // Se todas as comparações forem bem-sucedidas, a lista é um palíndromo.
            return true;
        }
        
        // Função auxiliar para encontrar o tamanho da lista.
        int findLength(ListNode head) {
            int length = 0;
            ListNode curr = head;
            while (curr != null) {
                length++;
                curr = curr.next;
            }
            return length;
        }
        
        // Função auxiliar para encontrar o nó na posição 'pos'.
        // A contagem começa do início da lista.
        ListNode findNodeAtPosition(ListNode head, int pos) {
            int count = 0;
            ListNode curr = head;
            while (count < pos) {
                count++;
                curr = curr.next;
            }
            return curr;
        }
        
        // Função para reverter uma sublista da lista encadeada.
        // 'head' é o início da sublista a ser invertida.
        // 'prev' é o nó imediatamente anterior à sublista, onde a nova conexão será feita.
        void reverse(ListNode head, ListNode prev) {
            ListNode a = head;       // 'a' começa no início da sublista
            ListNode b = head.next;    // 'b' é o nó seguinte a 'a'
            
            // Enquanto houver nós para inverter, faz a inversão dos ponteiros.
            while (a != null && b != null) {
                ListNode temp = b.next; // Guarda o próximo nó de 'b'
                b.next = a;             // Inverte o ponteiro de 'b' para apontar para 'a'
                a = b;                  // Move 'a' para frente
                b = temp;               // Move 'b' para frente
            }
            // Conecta o nó anterior (prev) ao novo início da sublista invertida.
            prev.next = a;
            // Garante que o antigo início da sublista (agora fim) aponte para null.
            head.next = null;
        }
    }
*/

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
    // Método para verificar se uma lista encadeada é um palíndromo.
    // Utiliza a técnica de "dois ponteiros" (slow and fast) para encontrar o meio da lista,
    // e depois inverte a segunda metade para compará-la com a primeira.
    public boolean isPalindrome(ListNode head) {
        // Se a lista tem apenas um nó, ela é um palíndromo por definição.
        if (head.next == null) return true; 

        // Inicializa dois ponteiros: 'slow' avança um nó por iteração, 'fast' avança dois.
        // Quando 'fast' alcançar o final, 'slow' estará na metade da lista.
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;         // Move 'slow' um passo à frente
            fast = fast.next.next;    // Move 'fast' dois passos à frente
        }
        // Nesse ponto, 'slow' marca o início da segunda metade da lista.
        
        // Inverte a segunda metade da lista a partir de 'slow'.
        // O método reverseList retorna o novo início da lista invertida (último nó da lista original).
        ListNode rp = reverseList(slow);
        // 'lp' aponta para o início da primeira metade da lista original.
        ListNode lp = head;

        // Compara os nós da primeira metade (lp) com os nós da segunda metade invertida (rp).
        // Se em qualquer momento os valores forem diferentes, a lista não é um palíndromo.
        while (rp != null) {
            if (rp.val != lp.val) return false;
            rp = rp.next;  // Avança no lado reverso (segunda metade)
            lp = lp.next;  // Avança no lado original (primeira metade)
        }
        
        // Se todas as comparações foram iguais, a lista é um palíndromo.
        return true;
    }

    // Função para reverter uma lista encadeada.
    // Esta função utiliza iteração para inverter os ponteiros dos nós.
    // Não foi utilizada nenhuma técnica de ordenação (sort) neste algoritmo.
    // O algoritmo é clássico para reversão de lista encadeada, com complexidade O(n) e espaço O(1).
    private ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head, next;
        // Itera enquanto houver nós para processar.
        while (curr != null) {
            next = curr.next;   // Salva o próximo nó
            curr.next = prev;   // Inverte o ponteiro do nó atual para apontar para o nó anterior
            
            // Avança os ponteiros: 'prev' se torna o nó atual, e 'curr' avança para o próximo nó
            prev = curr;
            curr = next;
        }
        // Quando a iteração termina, 'prev' é o novo cabeçalho da lista invertida.
        return prev;
    }
}

/*
    ////////////////////////////////////////////////////////////////////////////////
    // Explicação Geral sobre os Algoritmos e Estruturas de Dados Usadas
    ////////////////////////////////////////////////////////////////////////////////
    
    // Algoritmo Utilizado:
    // -------------------
    // Para o método isPalindrome na segunda abordagem, o algoritmo utilizado é o "dois ponteiros"
    // (slow e fast) para encontrar o meio da lista. Essa técnica permite identificar o ponto
    // médio da lista encadeada de forma eficiente, em uma única passagem (O(n)).
    //
    // Em seguida, é utilizada a técnica clássica de inversão de lista encadeada para inverter
    // a segunda metade da lista. A inversão é feita iterativamente, o que garante complexidade O(n)
    // e uso de espaço constante O(1). 
    //
    // Nota: Nenhum algoritmo de ordenação (sort) foi utilizado nesse código, pois o objetivo
    //       é verificar se a lista é um palíndromo, e não ordenar os elementos.
    
    // Estruturas de Dados Utilizadas:
    // -------------------------------
    // A única estrutura de dados utilizada é a lista encadeada (singly-linked list), implementada
    // através da classe ListNode. Cada nó da lista contém um valor inteiro (val) e um ponteiro
    // (next) que referencia o próximo nó na lista.
*/
