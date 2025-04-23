public class Solution {
    /**
     * Método principal que resolve o problema de "Character Replacement".
     * Objetivo: encontrar o comprimento máximo de uma substring onde podemos,
     * no máximo, substituir k caracteres para que todos os caracteres se tornem iguais.
     *
     * Estruturas de dados principais utilizadas:
     * - int[] freq: vetor de tamanho 26 para contar frequência de cada letra maiúscula (A-Z).
     * - variáveis primitivas para índices e controle de janela.
     *
     * Técnica usada:
     * - Sliding Window (janela deslizante) para percorrer a string de forma eficiente em O(n).
     * - Não há uso de algoritmo de ordenação (sort) aqui; trata-se de um algoritmo guloso
     *   que ajusta dinamicamente o tamanho da janela com base na frequência máxima encontrada.
     */
    public int characterReplacement(String s, int k) {
        // Vetor de frequências: cada posição i corresponde à letra (char) ('A' + i).
        int[] freq = new int[26];
        // maxFreq guarda a contagem da letra mais frequente na janela atual.
        int maxFreq = 0;
        // maxLen guarda o tamanho máximo da substring válida encontrada.
        int maxLen = 0;
        // left aponta para o início (esquerda) da janela.
        int left = 0;

        // Percorremos a string com o ponteiro right (direita da janela).
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            // Incrementa a frequência da letra atual.
            freq[c - 'A']++;
            // Atualiza maxFreq: frequência máxima na janela até agora.
            maxFreq = Math.max(maxFreq, freq[c - 'A']);

            // Se o tamanho da janela menos a letra mais frequente for maior que k,
            // não conseguimos tornar todos os caracteres iguais com k substituições,
            // então movemos o lado esquerdo da janela para a direita (shrinking window).
            while ((right - left + 1) - maxFreq > k) {
                char leftChar = s.charAt(left);
                // Reduz contagem da letra que sai da janela.
                freq[leftChar - 'A']--;
                left++;
            }

            // Atualiza o tamanho máximo da janela válida.
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    /*
     * Bloco de código alternativo (incompleto) comentado no prompt original:
     * Esse bloco inicial tentava usar HashMaps aninhados para controlar contagens
     * e um map auxiliar "count", mas estava incorreto e menos eficiente.
     * Não chega a usar técnicas de ordenação, mas apresenta lógica errônea na atualização.
     */
    /*
    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        HashMap<Character,Integer> count = new HashMap<>();
        for(char c : s.toCharArray()){
            if (!map.containsKey(c)){
                for (char key : map.keySet()){
                    int value = map.get(key) - 1;
                    map.replace(key, value);
                    count.replace(key, value + k);
                }
                count.put(c, 0);
                map.put(c, 1);
            } else {
                int i = map.get(c) + 1;
                map.replace(c, i);
                count.replace(key, value + k);
            }
        }

        for (char key : map.keySet()){
            maxLength = Math.max(maxLength, map.get(key));
        }
        return maxLength;
    }
    */

    /*
     * Segundo bloco de código comentado no prompt original:
     * Implementação de Sliding Window usando HashMap para contagem e variáveis l (left) e r (right).
     * Essa versão demonstra claramente o padrão "janela deslizante":
     *   1. Expande a janela incrementando r e contando frequência.
     *   2. Se a janela não é válida (r-l+1 - maxFreq > k), contrai movendo l.
     *   3. Atualiza o melhor resultado.
     */
    /*
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> charFreqMap = new HashMap<>();
        int maxFreq = 0;
        int maxLen = 0;
        int l = 0;

        for(int r = 0; r < s.length(); r++ ) {
            charFreqMap.put(s.charAt(r), charFreqMap.getOrDefault(s.charAt(r), 0) + 1);
            maxFreq = Math.max(maxFreq, charFreqMap.get(s.charAt(r)));
            int len = r - l + 1;
            if ( len - maxFreq > k ) {
                charFreqMap.put(s.charAt(l), charFreqMap.get(s.charAt(l)) - 1);
                l++;
            }
            if ( len - maxFreq <= k ) {
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
    */

    /**
     * Exemplo didático do padrão Sliding Window (janela deslizante)
     * aplicado ao problema de soma máxima de subarray de tamanho fixo k.
     */
    public int exemploSlidingWindow(int[] nums, int k) {
        // Soma da janela atual.
        int somaWindow = 0;
        // Soma máxima encontrada.
        int maxSoma = Integer.MIN_VALUE;

        // Primeiro, soma os primeiros k elementos para inicializar a janela.
        for (int i = 0; i < k; i++) {
            somaWindow += nums[i];
        }
        maxSoma = somaWindow;

        // Move a janela: para cada passo, subtrai o elemento que sai (i-k)
        // e adiciona o que entra (i), mantendo a soma em O(1) por passo.
        for (int i = k; i < nums.length; i++) {
            somaWindow += nums[i] - nums[i - k];
            // Atualiza a soma máxima se a janela atual for maior.
            maxSoma = Math.max(maxSoma, somaWindow);
        }

        return maxSoma;
    }

    /*
     * Comentário extra sobre Sliding Window:
     * - É uma técnica ótima para problemas de sequência contígua (string, array).
     * - Em vez de recalcular métricas (soma, max, min, contagens) do zero em cada posição,
     *   ajustamos incrementalmente ao expandir/contrair a janela.
     * - Garante complexidade O(n) quando bem aplicada, pois cada elemento entra e sai da
     *   janela no máximo uma vez.
     */
}
