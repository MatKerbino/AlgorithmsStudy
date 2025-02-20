package Nenhum;

class Solution {

    // Método para mover todos os zeros de um array para o final,
    // preservando a ordem relativa dos outros elementos.
    public void moveZeroes(int[] nums) {

        // Utilizamos dois ponteiros:
        // - 'i' representa a posição onde o próximo número diferente de zero deve ser colocado.
        // - 'j' percorre todo o array buscando números diferentes de zero.

        int i = 0, j = 0; 

        // Primeiro loop: desloca os números não zero para o início do array.
        while (j < nums.length) { // Percorre todo o array com 'j'
            if (nums[j] != 0) { // Se o elemento atual não for zero...
                nums[i] = nums[j]; // Copia o valor para a posição 'i'
                i++; // Avança 'i' para a próxima posição disponível
            }
            j++; // Sempre avançamos 'j' para percorrer o array
        }

        // Segundo loop: Preenche o restante do array com zeros.
        while (i < nums.length) { // Agora, 'i' aponta para onde os zeros devem começar
            nums[i] = 0; // Substitui os elementos restantes por zero
            i++; // Avança para a próxima posição
        }
    }
}

/*
Explicações Adicionais:

1. Algoritmo/Técnica Utilizada:
   - Esse código NÃO usa um algoritmo de ordenação (sort).
   - Ele aplica a **Técnica de Dois Ponteiros (Two Pointer Technique)**.
   - Essa abordagem permite mover os elementos sem necessidade de criar uma cópia do array.

2. Estruturas de Dados Utilizadas:
   - **Array (`int[] nums`)**: O único tipo de estrutura de dados usada.  
   - O algoritmo manipula os elementos diretamente dentro do próprio array, sem criar um novo.

3. Complexidade:
   - **Tempo:** O(n) → O array é percorrido no máximo duas vezes.
   - **Espaço:** O(1) → Nenhuma estrutura extra é utilizada, a manipulação é feita in-place.

Essa solução é eficiente e mantém a ordem relativa dos elementos não zero. 
*/
