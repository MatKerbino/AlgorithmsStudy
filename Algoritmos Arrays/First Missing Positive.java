class Solution {
    /*
    // Este método está comentado e representa uma abordagem alternativa para encontrar o primeiro número positivo que falta.
    // Abordagem: Ordenação do array seguido de uma varredura para identificar a lacuna.
    // Algoritmo de ordenação: Usa o Arrays.sort, que em Java normalmente utiliza uma variação do algoritmo Dual-Pivot Quicksort para arrays de primitivos.
    // Estrutura de dados usada: Array simples de inteiros e, comentado, um HashSet (mas ele não é utilizado na versão final deste método).
    
    public int firstMissingPositive(int[] nums) {
        // Ordena o array. A ordenação garante que os números fiquem em ordem crescente.
        Arrays.sort(nums);
        int cc = 1; // cc representa o número positivo esperado a partir de 1.
        // Loop através de todos os elementos do array.
        for (int i = 0; i < nums.length; i++){
            // Se o número atual for menor que 1 (não é positivo) ou se for igual ao número anterior (para evitar duplicatas)
            // a iteração é ignorada.
            if (nums[i] < 1 || i > 0 && nums[i-1] == nums[i]
            //rn.contains(nums[i])  // Esta verificação estava comentada, possivelmente para evitar repetição.
            ){
                continue;
            }
            // Se o número atual é igual ao número positivo esperado, incrementa o esperado.
            if (nums[i] == cc){
                //rn.add(cc); // Código comentado que poderia ter usado o HashSet.
                cc++;
            } else {
                // Se o número atual não corresponde ao esperado, retorna o número esperado, que é o primeiro que falta.
                return cc;
            }
        }
        // Se todos os números positivos de 1 até o tamanho do array estão presentes, o primeiro faltante é (tamanho + 1).
        return cc;
    }
    */

    // Método auxiliar para trocar dois elementos do array
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];    // Armazena temporariamente o valor de nums[i]
        nums[i] = nums[j];     // Atribui o valor de nums[j] para nums[i]
        nums[j] = temp;        // Atribui o valor armazenado em temp (valor original de nums[i]) para nums[j]
    }
    
    // Este método encontra o primeiro número positivo que falta usando o algoritmo de "Cyclic Sort".
    // Abordagem: Coloca cada número positivo no índice correspondente (número x deve estar na posição x-1).
    // Por exemplo, o número 1 deve estar na posição 0, o número 2 na posição 1, e assim por diante.
    // Estrutura de dados usada: Apenas o array de inteiros de entrada é utilizado, sem estruturas adicionais.
    // Técnica de sort: Não utiliza um algoritmo de ordenação tradicional; em vez disso, faz uma ordenação in-loco baseada na ideia de "Cyclic Sort",
    // que é uma técnica eficiente para arrays onde os elementos estão dentro de um intervalo específico (neste caso, de 1 a n).
    
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        // Loop que percorre o array para posicionar cada elemento em sua posição correta
        while (i < nums.length) {
            // O índice correto para o número nums[i] deve ser nums[i] - 1
            int correct = nums[i] - 1;
            // Verifica se o número é positivo, se está dentro do intervalo válido (1 a nums.length) 
            // e se o número atual não está na posição correta (evita trocas desnecessárias ou looping infinito)
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correct]) {
                // Se não estiver na posição correta, troca o elemento atual com o elemento na posição correta
                swap(nums, i, correct);
            } else {
                // Se estiver na posição correta, passa para o próximo índice
                i++;
            }
        }
        
        // Após a "ciclagem", o array deve ter cada número no índice correspondente, se possível.
        // Faz uma nova varredura para identificar o primeiro índice em que o número não corresponde à posição (i+1)
        for (i = 0; i < nums.length; i++) {
            // Se o número no índice i não for igual a i+1, significa que i+1 é o primeiro número faltante.
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // Se todos os números de 1 até nums.length estão no lugar correto, então o primeiro número faltante é nums.length + 1.
        return nums.length + 1;
    }
}