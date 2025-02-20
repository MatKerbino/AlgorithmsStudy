// A seguir, temos uma única classe "Solution" que contém várias implementações do problema
// "Majority Element" (Elemento Majoritário), onde se busca identificar o elemento que aparece
// mais de n/2 vezes em um array. Este arquivo contém todo o código exatamente como no prompt,
// sem remoção de nenhuma parte, e comentários foram adicionados explicando cada seção e técnica.

class Solution {
    public int majorityElement(int[] nums) {
        /*
        // =======================================================================
        // IMPLEMENTAÇÃO 1: Usando HashMap para contagem de ocorrências
        // =======================================================================
        // Nesta abordagem, usamos um HashMap para armazenar cada número (chave) e
        // sua respectiva frequência (valor). O algoritmo percorre o array e, para cada
        // elemento, verifica se ele já existe no HashMap:
        //    - Se existir, incrementa o contador.
        //    - Caso contrário, adiciona o elemento com valor 1.
        // Após preencher o HashMap, percorremos suas chaves para encontrar o número com a
        // maior contagem e o retornamos.
        //
        // Estrutura de dados utilizada:
        //    - HashMap<Integer, Integer>: para mapear cada elemento à sua frequência.
        //
        // Complexidade:
        //    - Tempo: O(n), pois percorre o array e depois as chaves do HashMap.
        //    - Espaço: O(n), para armazenar até n elementos no HashMap.
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            if (count.containsKey(nums[i])){
                int temp = count.get(nums[i]) + 1;
                count.replace(nums[i],temp);
            } else {
                count.put(nums[i], 1);
            }
        }

        int res = 0, cc = 0;
        for (int k : count.keySet()){
            if (cc < count.get(k)){
                res = k;
                cc = count.get(k);
            }
        }
        return res;

        // =======================================================================
        // IMPLEMENTAÇÃO 2: Algoritmo de Boyer-Moore Voting com bloco estático
        // =======================================================================
        // Esta implementação também utiliza o Algoritmo de Boyer-Moore Voting, que encontra
        // o elemento majoritário em O(n) tempo e O(1) espaço. Aqui, há um bloco estático
        // que executa a função "majorityElement" 500 vezes com um array vazio, possivelmente
        // para fins de teste ou aquecimento.
        //
        // Estrutura de dados utilizada:
        //    - Variáveis primitivas (int) para contagem e armazenamento do candidato.
        class Solution {
            static {
                // Executa a função 500 vezes com um array vazio
                for (int i = 0; i < 500; i++) {
                    majorityElement(new int[] {});
                }
            }

            public static int majorityElement(int[] nums) {
                int count = 0;
                int element = 0;

                // Percorre cada número no array e ajusta o contador:
                //    - Se o contador for 0, define o número atual como candidato.
                //    - Se o número for igual ao candidato, incrementa o contador;
                //      caso contrário, decrementa.
                for (int num : nums) {
                    if (count == 0) {
                        element = num;
                        count++;
                    } else if (element == num) {
                        count++;
                    } else {
                        count--;
                    }
                }
                return element;
            }
        }
        */

        // =======================================================================
        // IMPLEMENTAÇÃO 3: Algoritmo de Boyer-Moore Voting (Implementação ativa)
        // =======================================================================
        // Esta é a implementação efetiva que será executada. O Algoritmo de Boyer-Moore
        // Voting é usado para identificar o elemento majoritário com eficiência.
        //
        // Passos do algoritmo:
        // 1. Inicializa o candidato (mc) como o primeiro elemento do array e o contador como 1.
        // 2. Percorre o array:
        //      - Se o elemento atual for igual ao candidato, incrementa o contador.
        //      - Se for diferente, decrementa o contador.
        //      - Se o contador chegar a 0, define o elemento atual como novo candidato
        //        e reinicia o contador para 1.
        // 3. Ao final da iteração, o candidato armazenado é retornado.
        //
        // Estrutura de dados utilizada:
        //    - Variáveis primitivas (int) para armazenar o candidato (mc) e o contador.
        int mc = nums[0];   // Candidato inicial para o elemento majoritário
        int count = 1;      // Contador de "votos" para o candidato

        // Itera sobre cada elemento do array 'nums'
        for (int i : nums) {
            if (i == mc) {
                // Se o elemento atual é igual ao candidato, incrementa o contador
                count++;
            } else {
                // Se o elemento atual é diferente, decrementa o contador
                count--;
                // Se o contador chega a zero, define o elemento atual como novo candidato
                if (count == 0) {
                    mc = i;
                    count++; // Reinicia o contador para o novo candidato
                }
            }
        }
        // Retorna o candidato, que será o elemento majoritário
        return mc;
    }
}
