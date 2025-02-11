public class MaxSubarray {

    /**
     * Retorna a maior soma encontrada em uma subarray de 'nums'.
     * 
     * O algoritmo de Kadane percorre o array uma única vez, mantendo duas variáveis:
     * - currentSum: a soma da subarray que termina no elemento atual.
     * - maxSum: a maior soma encontrada até o momento.
     *
     * Para cada elemento, decidimos se:
     *   a) Começamos uma nova subarray a partir do elemento atual (ou seja, apenas nums[i]), ou
     *   b) Continuamos a subarray anterior adicionando o elemento atual (currentSum + nums[i]).
     * Essa escolha é feita utilizando Math.max.
     *
     * @param nums O array de inteiros de entrada.
     * @return A soma máxima de qualquer subarray dentro de nums.
     */

    public int maxSubArray(int[] nums) {
        // Inicializamos 'currentSum' e 'maxSum' com o primeiro elemento do array.
        int currentSum = nums[0];
        int maxSum = nums[0];
        
        // Percorremos o array a partir do segundo elemento.
        for (int i = 1; i < nums.length; i++) {
            // Para o elemento atual, temos duas opções:
            // 1. Iniciar uma nova subarray a partir de nums[i].
            // 2. Adicionar nums[i] à subarray corrente (currentSum).
            // Escolhemos a opção que fornecer a maior soma.
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            
            // Atualizamos o maxSum se o currentSum atual for maior que o maxSum encontrado até agora.
            maxSum = Math.max(maxSum, currentSum);
        }
        
        // Ao final do laço, maxSum contém a soma da subarray com o maior valor.
        return maxSum;
    }
    
    // Método main para testar a função com os exemplos fornecidos.
    public static void main(String[] args) {
        MaxSubarray solution = new MaxSubarray();
        
        // Exemplo 1:
        // Input: nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
        // Saída esperada: 6, pois a subarray [4, -1, 2, 1] possui a maior soma.
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Exemplo 1: " + solution.maxSubArray(nums1));  // Output: 6
        
        // Exemplo 2:
        // Input: nums = [1]
        // Saída esperada: 1, pois a única subarray possível é [1].
        int[] nums2 = {1};
        System.out.println("Exemplo 2: " + solution.maxSubArray(nums2));  // Output: 1
        
        // Exemplo 3:
        // Input: nums = [5, 4, -1, 7, 8]
        // Saída esperada: 23, pois a subarray inteira possui a maior soma.
        int[] nums3 = {5, 4, -1, 7, 8};
        System.out.println("Exemplo 3: " + solution.maxSubArray(nums3));  // Output: 23
    }
}