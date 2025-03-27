class Solution {
    public int longestConsecutive(int[] nums) {
        /*
        // ================================================================
        // Abordagem utilizando HashSet para identificar a sequência consecutiva
        // ================================================================
        // Esta abordagem utiliza um conjunto (HashSet) para eliminar duplicatas e
        // permitir buscas eficientes (O(1)) para verificar se um número existe.
        
        // Cria um HashSet para armazenar os números do array.
        Set<Integer> set = new HashSet<>();
        // Itera por cada número em 'nums' e o adiciona ao conjunto.
        for (int num : nums){
            set.add(num);
        }
        
        // 'ans' armazena o comprimento máximo da sequência encontrada.
        int ans = 0;
        // Itera por cada número presente no conjunto.
        for (int num : set) {
            // Se o número imediatamente anterior (num - 1) não está no conjunto,
            // então 'num' pode ser o início de uma nova sequência consecutiva.
            if(!set.contains(num - 1)){
                // Inicializa o comprimento da sequência como 1 (contando o próprio 'num').
                int length = 1;
                // Enquanto o conjunto contiver o próximo número consecutivo (num + length),
                // incrementa o comprimento da sequência.
                while (set.contains(num + length)){
                    length++;
                }
                // Atualiza 'ans' se o comprimento atual for maior que o máximo já encontrado.
                ans = Math.max(ans, length);
            }
        }
        // Retorna o comprimento da sequência consecutiva mais longa encontrada.
        return ans;
        */

        // ================================================================
        // Abordagem utilizando ordenação (sort) para identificar a sequência
        // ================================================================
        
        // Armazena o tamanho do array.
        int n = nums.length;
        // Se o array estiver vazio, retorna 0, pois não há números para formar uma sequência.
        if(n == 0) return 0;
        
        // Ordena o array 'nums'.
        // O método Arrays.sort utiliza o algoritmo Dual-Pivot Quicksort para arrays de tipos primitivos em Java.
        // Esse algoritmo é eficiente na prática, com complexidade média de O(n log n).
        Arrays.sort(nums);
        
        // Inicializa 'max' para armazenar o comprimento máximo da sequência e 'count' para contar
        // a sequência consecutiva atual.
        int max = 1, count = 1;
        
        // Itera pelo array começando do segundo elemento (índice 1)
        for(int i = 1; i < n; i++){
            // Se o número atual não for igual ao anterior (evitando duplicatas)
            if(nums[i-1] != nums[i]){
                // Se o número atual é exatamente 1 a mais que o anterior, está em sequência.
                if(nums[i-1] + 1 == nums[i]){
                    count++;  // Incrementa o contador da sequência.
                } else {
                    // Se a sequência foi interrompida, atualiza 'max' se o contador atual for maior.
                    max = Math.max(max, count);
                    // Reinicia o contador para começar uma nova sequência.
                    count = 1;
                }
            }
            // Caso os números sejam duplicados, a iteração apenas ignora o valor repetido.
        }
        // Após a iteração, atualiza 'max' para o último valor da sequência, se necessário.
        max = Math.max(max, count);
        
        // Retorna o comprimento da sequência consecutiva mais longa encontrada.
        return max;
    }
}
