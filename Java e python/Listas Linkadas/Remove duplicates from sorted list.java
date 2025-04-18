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
      /*
      // ================================================
      // PRIMEIRA IMPLEMENTAÇÃO (COMENTADA)
      // ================================================
      // Esta implementação busca remover duplicatas de uma lista encadeada que já está ordenada.
      // A ideia é percorrer a lista e, quando encontrar dois nós consecutivos com o mesmo valor,
      // pular o nó duplicado ajustando o ponteiro "next".
      
      // Se a lista estiver vazia, retorna-a imediatamente.
      if (head == null) return head;
      
      // 'ndlist' é usado para construir a nova lista sem duplicatas, iniciando com o primeiro nó.
      ListNode ndlist = head;
      // 'hh' guarda a referência ao início da lista resultante para ser retornada no final.
      ListNode hh = ndlist;
      
      // Percorre a lista enquanto existir um próximo nó.
      while (head.next != null) {
          // Se o valor atual for igual ao valor do próximo nó, temos uma duplicata.
          // Avança para o próximo nó, efetivamente ignorando a duplicata.
          if (head.val == head.next.val) {
              head = head.next;
          } else {
              // Se os valores forem diferentes, conecta o nó atual ao próximo nó único.
              ndlist.next = head.next;
              // Avança o ponteiro da lista resultante para este novo nó.
              ndlist = ndlist.next;
              // Avança o ponteiro de iteração para o próximo nó.
              head = head.next;
          }
      }
      
      // Caso o último nó não tenha sido considerado, verifica e conecta.
      if (ndlist.val != head.val)
          ndlist = head;
      // Garante que o final da nova lista aponte para null, evitando referências a nós duplicados.
      ndlist.next = null; 
      // Retorna o início da lista sem duplicatas.
      return hh;
      */

      // ================================================
      // SEGUNDA IMPLEMENTAÇÃO (ATIVA)
      // ================================================
      // Esta é uma outra abordagem para remover duplicatas de uma lista encadeada já ordenada.
      // A técnica utilizada é a de "varredura linear" (one-pass scan) na lista:
      // percorremos a lista uma única vez, comparando cada nó com o próximo.
      // Quando encontramos dois nós consecutivos com o mesmo valor, ajustamos o ponteiro "next"
      // para pular o nó duplicado.
      // Essa abordagem não utiliza nenhum algoritmo de ordenação, pois assume-se que a lista já está ordenada.
      // A estrutura de dados utilizada é a "lista encadeada" (singly-linked list), onde cada nó possui um valor (val)
      // e uma referência para o próximo nó (next).
      
      // Verifica se a lista não está vazia.
      if (head != null) {
          // 'temp' é o ponteiro usado para iterar sobre a lista.
          ListNode temp = head;
          // Continua enquanto o nó atual e o próximo nó não forem nulos.
          while (temp != null && temp.next != null) {
              // Se o valor do nó atual for igual ao valor do próximo nó, temos uma duplicata.
              // Remove o nó duplicado fazendo com que o nó atual "aponte" para o nó após o próximo.
              if (temp.val == temp.next.val) {
                  temp.next = temp.next.next;
              } else {
                  // Se não for duplicata, avança para o próximo nó.
                  temp = temp.next;
              }
          }
      }
      // Retorna a lista já processada sem duplicatas.
      return head;
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
  1. Um ponteiro ('head' ou 'temp') é usado para percorrer todos os nós da lista original.
  2. Outro ponteiro ('ndlist') é utilizado na primeira implementação para construir a nova lista sem duplicatas.
- A ideia é comparar cada nó com o seu próximo. Se ambos tiverem o mesmo valor, o ponteiro avança ignorando o nó duplicado.
- Quando valores diferentes são encontrados, o nó com valor distinto é ligado à nova lista e os ponteiros avançam.
- Essa abordagem é eficiente, pois percorre a lista apenas uma vez, resultando em uma complexidade de tempo O(n),
onde n é o número de nós na lista.
- Nenhum algoritmo de ordenação (sort) foi utilizado, pois pressupõe-se que a lista já está ordenada.

Estruturas de Dados Utilizadas:
-------------------------------
- **Lista Encadeada (Singly-Linked List):**
A estrutura de dados principal utilizada neste código é a lista encadeada, definida pela classe `ListNode`.
Cada nó da lista contém:
  - Um valor inteiro (`val`).
  - Uma referência para o próximo nó (`next`).
- O uso de ponteiros (variáveis do tipo `ListNode`) é essencial para navegar e modificar a lista encadeada
durante a remoção dos duplicados.

Nota:
-----
Este código não implementa nenhum algoritmo de ordenação (sort), pois pressupõe que a lista já está ordenada.
A remoção de duplicatas aproveita essa ordenação para funcionar corretamente.
*/