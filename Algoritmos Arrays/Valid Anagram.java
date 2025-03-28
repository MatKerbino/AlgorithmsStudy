class Solution {
    public boolean isAnagram(String s, String t) {
        /*
        // Primeiro método: Usando um mapa (HashMap) para contar a frequência de cada caractere.
                
        // Se as strings têm comprimentos diferentes, elas não podem ser anagramas, então retorna false.
        if (s.length() != t.length()) return false;
                
        // Cria um HashMap para armazenar a contagem de cada caractere na string 's'.
        // A chave é o caractere e o valor é a quantidade de vezes que ele aparece.
        Map<Character, Integer> charset = new HashMap<>();
                
        // Itera sobre cada caractere da string 's'
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i); // Pega o caractere na posição i
            // Atualiza a contagem do caractere no mapa.
            // Se o caractere não estiver no mapa, getOrDefault retorna 0.
            charset.put(c, charset.getOrDefault(c, 0) + 1);
        }
                
        // Itera sobre cada caractere da string 't'
        for (int i = 0; i < t.length(); i++){
            char c = t.charAt(i); // Pega o caractere na posição i
            // Diminui a contagem do caractere no mapa para cada ocorrência em 't'.
            // getOrDefault garante que, se o caractere não estiver presente, o valor será 0.
            charset.put(c, charset.getOrDefault(c, 0) - 1);
            // Se a contagem se tornar negativa, significa que 't' possui mais ocorrências daquele caractere que 's'.
            // Portanto, as strings não são anagramas e retorna false.
            if (charset.get(c) < 0) return false;
        }
                
            // Se todas as contagens se equilibrarem para zero, então 's' e 't' são anagramas.
            return true;
        */

        /*
                Segundo método: Usando ordenação dos arrays de caracteres.
        */

        // Converte as strings 's' e 't' para arrays de caracteres.
        // Essa conversão permite ordenar os caracteres individualmente.
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        // Ordena os arrays de caracteres.
        // O método Arrays.sort() utiliza, para tipos primitivos como char, um algoritmo Dual-Pivot Quicksort,
        // que é uma variação otimizada do Quicksort e apresenta boa performance na prática.
        Arrays.sort(sArr);
        Arrays.sort(tArr);

        // Compara os arrays ordenados.
        // Se os arrays forem iguais (ou seja, os caracteres aparecem nas mesmas quantidades e em ordem),
        // as strings são anagramas. Caso contrário, não são.
        return Arrays.equals(sArr, tArr);
    }
}