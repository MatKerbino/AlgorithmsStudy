/*
class Solution {
    // Método que agrupa anagramas, ou seja, palavras que possuem os mesmos caracteres
    public List<List<String>> groupAnagrams(String[] strs) {
        // Cria um HashMap onde a chave é uma String (a forma "normalizada" da palavra) 
        // e o valor é uma lista de strings que são anagramas entre si.
        Map<String, List<String>> hmap = new HashMap<>();

        // Itera por cada palavra no array de entrada
        for (String word : strs){
            // Converte a palavra em um array de caracteres
            char[] letters = word.toCharArray();
            // Ordena os caracteres em ordem lexicográfica.
            // Este é um algoritmo de ordenação interno do Java (geralmente uma variação de TimSort)
            Arrays.sort(letters);
            // Converte o array de caracteres ordenado de volta para uma String,
            // que servirá como a "chave" para identificar anagramas.
            String key = String.valueOf(letters);
            // Se a chave ainda não existir no mapa, cria uma nova entrada com uma lista vazia.
            if (!hmap.containsKey(key)){
                hmap.put(key, new ArrayList<>());
            } 
            // Adiciona a palavra original na lista correspondente à chave.
            hmap.get(key).add(word);
        }

        // Alternativamente, o código comentado abaixo itera sobre as chaves do mapa e
        // adiciona cada lista de anagramas em uma lista de listas que será retornada.
        // List<List<String>> ans = new ArrayList<>();
        // for(String key : hmap.keySet()){ans.add(hmap.get(key));}
        // return ans;
        
        // Retorna todas as listas de anagramas presentes no mapa como uma nova ArrayList.
        return new ArrayList<>(hmap.values());
    }
}
*/

class Solution {
    // Este método também agrupa anagramas, porém utilizando uma abordagem levemente diferente.
    public List<List<String>> groupAnagrams(String[] strs) {
        // Retorna uma instância anônima de AbstractList, permitindo uma inicialização "preguiçosa"
        // dos dados e comportando-se como uma lista comum.
        return new java.util.AbstractList<List<String>> (){

            // Declaração dos atributos que serão usados para armazenar o mapa de anagramas
            // e a lista final de grupos de anagramas.
            Map<String, List<String>> map;
            List<List<String>> list;

            // Método privado que inicializa o mapa e a lista com os grupos de anagramas.
            private void init(){
                 // Inicializa o HashMap que relaciona a chave "normalizada" da palavra com seus anagramas.
                 map = new HashMap();
                 // Percorre cada string do array de entrada
                 for(String str : strs){
                    // A seguir, o código usa uma técnica de "contagem" para criar uma chave
                    // que representa a frequência de cada letra na string.
                    // A linha comentada abaixo representa uma alternativa com um array de char,
                    // mas a versão ativa utiliza um array de inteiros para contagem.
                    // char[] arr = new char[26];
                    // for(char c : str.toCharArray()){
                    //     arr[c - 'a']++;
                    // }
                    
                    // Cria um array de inteiros com 26 posições, cada uma representando uma letra do alfabeto
                    int[] arr = new int[26];
                    // Para cada caractere da string, incrementa a contagem na posição correspondente.
                    for(char c : str.toCharArray()){
                        arr[c - 'a']++;
                    }
                    // Usa um StringBuilder para reconstruir uma string "normalizada".
                    // Essa string será igual para todas as palavras que são anagramas entre si.
                    // Em vez de ordenar os caracteres, aqui é feita uma "contagem" que é convertida numa string ordenada.
                    StringBuilder sb = new StringBuilder();
                    // Itera sobre cada posição do array que representa cada letra (de 'a' a 'z').
                    for(int i = 0; i < 26; i++){
                        int count = arr[i];
                        // Enquanto houver contagens para essa letra, adiciona a letra ao StringBuilder.
                        // Isso equivale a "ordenar" as letras, já que percorremos o array de forma fixa.
                        while (count > 0) {
                            sb.append((char) (i + 'a'));
                            count--;
                        }
                    }
                    // Converte o StringBuilder em uma String que serve como chave no mapa.
                    String key = sb.toString();
                    // Obtém a lista de anagramas já existente para essa chave ou cria uma nova se ainda não existir.
                    List<String> list = map.getOrDefault(key, new ArrayList());
                    // Adiciona a string atual à lista de anagramas.
                    list.add(str);
                    // Atualiza o mapa com a lista atualizada para essa chave.
                    map.put(key, list);
                }
                // Inicializa a lista final de anagramas com os valores (listas) do mapa.
                list = new ArrayList(map.values());
            }

            // Implementação do método size() da AbstractList.
            // Verifica se a lista foi inicializada; se não, chama o método init().
            @Override
            public int size(){
                if(list == null){
                    init();
                }
                // Retorna o número de grupos de anagramas.
                return list.size();
            }

            // Implementação do método get() da AbstractList.
            // Retorna a lista de anagramas correspondente ao índice solicitado.
            @Override
            public List<String> get(int index){
                return list.get(index);
            }
        };
    }
}
