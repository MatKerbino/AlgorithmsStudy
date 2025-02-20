class Solution {
    public void rotate(int[] nums, int k) {
        // ============================
        // Abordagem 1: Método de Reversão (Funciona)
        // ============================
        // Essa abordagem inverte o array inteiro e depois inverte as duas partes para reposicionar os elementos.
        // Tempo: O(n) | Espaço: O(1)
        int n = nums.length;
        k %= n;  // Ajusta k para o caso de k >= n
        reverse(nums, 0, n - 1);    // Passo 1: inverte o array inteiro
        reverse(nums, 0, k - 1);    // Passo 2: inverte os primeiros k elementos
        reverse(nums, k, n - 1);    // Passo 3: inverte o restante do array

        // ============================
        // Abordagem 2: Utilizando Array Auxiliar (Funciona)
        // ============================
        // Essa abordagem copia os últimos k elementos para o início de um array auxiliar e,
        // em seguida, os demais elementos. Depois, copia de volta para o array original.
        // Tempo: O(n) | Espaço: O(n)
        /*
        int len = nums.length;
        k = k % len;  // Ajusta k
        int[] nAux = new int[len];
        int j = 0;

        // Copia os últimos k elementos para o início do array auxiliar
        for (int i = len - k; i < len; i++) {
            nAux[j] = nums[i];
            j++;
        }

        // Copia os elementos restantes para o array auxiliar
        for (int i = 0; i < len - k; i++) {
            nAux[j] = nums[i];
            j++;
        }

        // Copia os elementos do array auxiliar de volta para o array original
        for (int i = 0; i < len; i++) {
            nums[i] = nAux[i];
        }
        */

        // ============================
        // Abordagem 3: Rotação Um a Um (Ineficiente para grandes entradas)
        // ============================
        // Essa abordagem realiza k rotações, deslocando os elementos uma posição para a direita a cada iteração.
        // Embora funcione para arrays pequenos, sua complexidade O(n * k) a torna impraticável para valores grandes.
        /*
        int nLast = nums.length - 1;
        int kk = k % nums.length;  // Ajusta k
        for (int i = 0; i < kk; i++){
            int term = nums[nLast];   // Salva o último elemento
            // Desloca os elementos uma posição para a direita
            for (int j = nLast - 1; j >= 0; j--){
                nums[j + 1] = nums[j];
            }
            nums[0] = term;  // Coloca o último elemento na posição 0
        }
        */

        // ============================
        // Abordagem 4: Tentativa com Cálculo Incorreto e Sobrescrita (Não Funciona)
        // ============================
        // Essa abordagem tenta copiar parte dos elementos para um array auxiliar e depois realizar deslocamentos,
        // porém o cálculo dos índices e a sobrescrita de elementos (zerando partes do array) comprometem a solução.
        /*
        int t = nums.length < k ? k - nums.length : k;
        int[] rot = new int[t];
        int it = t - 1;
        int ind = nums.length - t - 1;

        if (nums.length == 1 || k == 0){
            // Não é necessário fazer nada
        } else {
            // Copia os últimos t elementos para o array auxiliar e zera as posições correspondentes
            for (int i = nums.length - 1; i > ind; i--){
                rot[it--] = nums[i];
                nums[i] = 0;
            }
            // Desloca os elementos restantes para a direita k vezes (lógica problemática)
            for (int j = 0; j < k; j++){
                for (int i = nums.length - 2; i >= 0; i--){
                    nums[i + 1] = nums[i];
                }
            }
            // Restaura os elementos do array auxiliar no início do array original
            for (int i = 0; i < rot.length; i++){
                nums[i] = rot[i];
            }
        }
        */
    }

    // Método auxiliar utilizado na Abordagem 1 (Método de Reversão)
    void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
