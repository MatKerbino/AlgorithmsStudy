class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Algoritmo: para cada elemento de nums1, encontra-se sua posição em nums2
        // e faz-se uma varredura linear a partir dessa posição para achar o próximo
        // maior elemento. Utiliza um HashMap para busca de índice em O(1).
        // Complexidade de tempo: O(n2) para preencher o mapa + O(n1 * n2) para as buscas,
        // onde n1 = nums1.length e n2 = nums2.length.
        // Não há técnica de sort/ordenção empregada explicitamente.
        // Estruturas de dados:
        // - int[]: arrays de entrada e de resultado
        // - HashMap<Integer,Integer>: mapeia valor → índice em nums2 para busca rápida

        // Cria o mapa para armazenar valor de nums2 → índice em nums2
        HashMap<Integer, Integer> map = new HashMap<>();

        // Array de saída, com mesmo tamanho de nums1
        int res[] = new int[nums1.length];

        // Preenche o HashMap com cada valor de nums2 e seu índice
        for (int i = 0; i < nums2.length; i++) {
            // map.put(chave, valor): aqui, chave = valor em nums2, valor = índice i
            map.put(nums2[i], i);
        }

        // Variável auxiliar para armazenar o “próximo maior” encontrado; inicia em -1
        // (valor padrão quando nenhum maior é encontrado)
        int ans = -1;

        // Para cada elemento em nums1...
        for (int i = 0; i < nums1.length; i++) {
            // Recupera a posição original de nums1[i] em nums2 via HashMap
            int idx = map.get(nums1[i]);

            // Varre nums2 a partir da posição idx+1 até o fim, buscando o primeiro maior
            for (int j = idx + 1; j < nums2.length; j++) {
                // Se encontrar um valor maior que nums1[i]
                if (nums2[j] > nums1[i]) {
                    // Atualiza ans com este valor (próximo maior)...
                    ans = nums2[j];
                    // ...e interrompe o loop interno
                    break;
                }
                // Caso contrário, continua procurando; ans permanece -1 até achar
            }

            // Armazena em res[i] o valor de ans (ou -1, se nada maior foi achado)
            res[i] = ans;
            // Reseta ans para -1 antes de tratar o próximo elemento de nums1
            ans = -1;
        }

        // Retorna o array de resultados
        return res;
    }
}
