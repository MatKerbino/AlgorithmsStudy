class Solution {
    public int maxProduct(int[] nums) {
        // Inicializa as variáveis max e min com o primeiro elemento do array.
        // max: guarda o maior produto de uma subarray que termina na posição atual.
        // min: guarda o menor produto de uma subarray que termina na posição atual.
        int max = nums[0];
        int min = nums[0];
        // res: armazena o resultado final, ou seja, o maior produto encontrado até agora.
        int res = nums[0];

        // Percorre o array a partir do segundo elemento (índice 1)
        for (int i = 1; i < nums.length; i++){
            // Se o número atual for não negativo (zero ou positivo)
            if (nums[i] >= 0){
                // O novo max pode ser o próprio número ou o produto dele com o max anterior.
                // Por exemplo, se nums[i] = 3 e max = 2, então 3*2 = 6 pode ser maior que 3.
                max = Math.max(nums[i], nums[i] * max);
                // O novo min pode ser o próprio número ou o produto dele com o min anterior.
                // Isso é importante porque o min pode ser um número negativo e influenciar
                // positivamente no futuro quando multiplicado por um número negativo.
                min = Math.min(nums[i], nums[i] * min);
            } else {
                // Se o número atual for negativo, ao multiplicar,
                // o maior produto pode se tornar o menor e vice-versa.
                // Usamos uma variável temporária para armazenar o max atual antes de atualizá-lo.
                int temp = max;
                // Para um número negativo, o novo max é o maior entre:
                // - O próprio número (reinicia a subarray) e
                // - O produto do número negativo com o min anterior (que pode ser negativo e, assim,
                //   transformar-se em um valor positivo grande)
                max = Math.max(nums[i], min * nums[i]);
                // O novo min é o menor entre:
                // - O próprio número e
                // - O produto do número negativo com o max anterior (armazenado em temp)
                min = Math.min(nums[i], temp * nums[i]);
            }
            // Atualiza o resultado final se o novo max for maior que o resultado atual.
            res = Math.max(res, max);
        }

        // Retorna o maior produto encontrado em alguma subarray do array.
        return res;
    }
}