// Sliding Window em Java

import java.util.HashMap;
import java.util.Map;

public class SlidingWindow {

    /**
     * Janela de tamanho fixo: soma máxima de subarray de tamanho k
     * Complexidade: O(n), cada elemento entra e sai da janela uma vez.
     * Espaço: O(1).
     */
    public static Integer maxSubarraySumFixed(int[] arr, int k) {
        int n = arr.length;
        if (k > n) {
            return null; // não é possível
        }

        // 1) Soma inicial dos primeiros k elementos
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        int maxSum = windowSum;

        // 2) Slide da janela: adiciona novo elemento, remove o que sai
        for (int i = k; i < n; i++) {
            windowSum += arr[i];        // entra elemento arr[i]
            windowSum -= arr[i - k];    // sai elemento arr[i-k]
            if (windowSum > maxSum) {
                maxSum = windowSum;
            }
        }
        return maxSum;
    }

    /**
     * Janela de tamanho variável: comprimento da maior substring sem caracteres repetidos
     * Complexidade: O(n), cada caractere é processado no máximo duas vezes (entrada/saída da janela).
     * Espaço: O(min(n, m)), m = tamanho do alfabeto.
     */
    public static int lengthOfLongestSubstringVariable(String s) {
        int start = 0;                // início da janela
        int maxLen = 0;               // resultado
        Map<Character, Integer> lastSeen = new HashMap<>();  // caractere -> última posição

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (lastSeen.containsKey(ch) && lastSeen.get(ch) >= start) {
                // se o caractere já está na janela, avançamos start
                start = lastSeen.get(ch) + 1;
            }
            // atualiza a última posição vista de ch
            lastSeen.put(ch, i);

            int currentLen = i - start + 1;  // tamanho atual da janela
            if (currentLen > maxLen) {
                maxLen = currentLen;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        // Exemplo 1: janela fixa
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println("Máxima soma de subarray de tamanho " + k + ": " 
            + maxSubarraySumFixed(arr, k));
        // Explicação:
        // [2,1,5]=8 → [1,5,1]=7 → [5,1,3]=9 → [1,3,2]=6 → resultado 9

        // Exemplo 2: janela variável
        String s = "abcabcbb";
        System.out.println("Maior substring sem repetidos em '" + s + "': " 
            + lengthOfLongestSubstringVariable(s));
        // Explicação:
        // percorre 'a','b','c' → janela 'abc' (tamanho=3)
        // ao ver novo 'a', move start para 1 → janela 'bca', etc. → resultado 3
    }
}
