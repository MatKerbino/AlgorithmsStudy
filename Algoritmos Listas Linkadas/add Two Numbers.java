// Classe que representa a solução do problema de somar dois números representados por listas ligadas.
class Solution {

    // Método que recebe duas listas ligadas (l1 e l2) onde cada nó contém um dígito, 
    // e retorna uma nova lista ligada representando a soma desses números.
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Cria um nó cabeça (dummy node) para facilitar a manipulação da lista resultante.
        ListNode head = new ListNode();
        // "track" é usado para manter a referência do início da lista resultante,
        // pois "head" irá se mover durante a iteração.
        ListNode track = head;
        
        // Variável que guarda o "vai um" (carry) durante a soma dos dígitos.
        int carry = 0;
        
        // Loop enquanto ambos l1 e l2 tiverem nós (dígitos) a serem somados.
        while (l1 != null && l2 != null) {
            // Soma os valores dos nós atuais de l1 e l2.
            int num = l1.val + l2.val;
            
            // Cria um novo nó com o dígito resultante da soma atual mais o carry.
            // O operador módulo (%) garante que seja considerado apenas o dígito das unidades.
            head.next = new ListNode((num + carry) % 10);
            
            // Atualiza o carry para a próxima iteração, considerando a soma atual.
            // O operador de divisão (/) retorna o valor que deve ser transportado.
            carry = (num + carry) / 10;
            
            // Avança para o próximo nó na lista resultante.
            head = head.next;
            // Avança para os próximos nós de l1 e l2.
            l1 = l1.next;
            l2 = l2.next;
        }
        
        // Se ainda restam nós em l1, continua a soma com o carry.
        if (l1 != null) {
            while (l1 != null) {
                head.next = new ListNode((l1.val + carry) % 10);
                carry = (l1.val + carry) / 10;
                head = head.next;
                l1 = l1.next;
            }
        }
        
        // Se ainda restam nós em l2, continua a soma com o carry.
        if (l2 != null) {
            while (l2 != null) {
                head.next = new ListNode((l2.val + carry) % 10);
                carry = (l2.val + carry) / 10;
                head = head.next;
                l2 = l2.next;
            }
        }
        
        // Se após processar ambas as listas ainda há um carry (por exemplo, 1),
        // adiciona um novo nó com esse valor.
        if (carry > 0) {
            head.next = new ListNode(carry);
        }
        
        // Retorna a lista resultante, pulando o nó dummy inicial.
        return track.next;
    }
}

/*
Explicação adicional:

1. Algoritmo utilizado:
   - O algoritmo utilizado aqui é uma abordagem iterativa para somar dois números representados por listas ligadas.
   - Não há uso de algoritmos de ordenação (sort) neste código. Trata-se apenas de uma soma dígito a dígito com o gerenciamento de carry.
   - A técnica consiste em percorrer ambas as listas simultaneamente, somando os dígitos correspondentes e propagando o carry para a próxima soma.

2. Estruturas de dados usadas:
   - Lista ligada (ListNode): Cada nó da lista contém um dígito do número.
   - Variáveis auxiliares:
     * "head" para construir a lista resultante.
     * "track" para manter a referência ao início da lista resultante.
     * "carry" para armazenar o valor que deve ser transportado para a próxima soma, se a soma dos dígitos exceder 9.
*/
