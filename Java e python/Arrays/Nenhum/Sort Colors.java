package Nenhum;

class Solution {
    // Método para ordenar um array contendo apenas os valores 0, 1 e 2.
    // Essa implementação utiliza a solução do problema "Dutch National Flag" (Bandeira Holandesa)
    // para separar os elementos em uma única varredura, garantindo O(n) de tempo e O(1) de espaço extra.
    public void sortColors(int[] nums) {

        /*
        // A implementação abaixo (comentada) utiliza uma variação do algoritmo Bubble Sort.
        // Ela percorre o array várias vezes, trocando elementos adjacentes fora de ordem.
        // Porém, o Bubble Sort tem complexidade O(n^2) e não é eficiente para esse problema.
        for (int i = 0; i < nums.length; i++){
            boolean trocou = false;
            for (int j = 1; j < nums.length - i; j++){
                if (nums[j] < nums[j-1]){
                    int temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                    trocou = true;
                }
            }
            if (!trocou)
                break;
        }
        */

        // Variáveis para controlar as posições dos elementos:
        // 'left' indica a próxima posição para colocar o número 0.
        // 'right' indica a próxima posição para colocar o número 2.
        // 'i' é o índice atual que percorre o array.
        int left = 0, right = nums.length - 1;
        int i = 0;

        // Enquanto 'i' não ultrapassar 'right', processamos os elementos.
        while (i <= right) {
            // Se o elemento atual é 0, precisamos movê-lo para a parte esquerda do array.
            if (nums[i] == 0) {
                // Troca o elemento na posição 'i' com o elemento na posição 'left'.
                int temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;
                // Incrementa 'left' pois a posição já está ocupada por 0.
                left++;
                // Avança 'i' para o próximo elemento, pois o elemento trocado já foi processado.
                i++;
            }
            // Se o elemento atual é 2, deve ser movido para a parte direita do array.
            else if (nums[i] == 2) {
                // Troca o elemento na posição 'i' com o elemento na posição 'right'.
                int temp = nums[right];
                nums[right] = nums[i];
                nums[i] = temp;
                // Decrementa 'right' pois a posição agora contém um 2.
                right--;
                // Não incrementamos 'i' aqui, pois o novo elemento em 'i' pode ser 0 ou 2 e precisa ser reavaliado.
            }
            // Se o elemento atual é 1, ele já está na posição correta.
            else {
                // Apenas avança 'i' para processar o próximo elemento.
                i++;
            }
        }
    }
}

/*
Explicações Adicionais:

1. Algoritmo/Técnica Utilizada:
   - O algoritmo usado é o "Dutch National Flag" (Bandeira Holandesa).
   - Essa técnica utiliza três ponteiros (left, i, right) para particionar o array em três seções:
     * A partir do início até 'left - 1': todos os elementos são 0.
     * Entre 'left' e 'i - 1': todos os elementos são 1.
     * Entre 'right + 1' até o final: todos os elementos são 2.
   - A varredura do array é feita em uma única passagem (O(n)), trocando elementos conforme necessário.

2. Estruturas de Dados Utilizadas:
   - **Array (`int[] nums`)**: 
     * O array de inteiros é a única estrutura de dados utilizada e é modificado "in-place".
     * Não há uso de estruturas adicionais, garantindo O(1) de espaço extra.

3. Observação sobre a abordagem comentada:
   - O trecho comentado utiliza uma versão do Bubble Sort, que tem complexidade O(n^2) e não é adequado para o problema, 
     sendo substituído pela abordagem mais eficiente do Dutch National Flag.
*/
