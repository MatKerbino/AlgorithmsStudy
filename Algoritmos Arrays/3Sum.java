class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
        // Declaração da lista que armazenará todas as tripletas encontradas.
        List<List<Integer>> ans = new ArrayList<>();
        // Ordena o array usando o método Arrays.sort. Para arrays de primitivos, o Java utiliza uma variante do QuickSort (dual-pivot quicksort).
        Arrays.sort(nums);
        int i = 0, n = nums.length;
        // Percorre o array, considerando cada elemento como o primeiro elemento de uma possível tripleta
        while (i < n){
            // Se não for o primeiro elemento e o atual for igual ao anterior, pula para evitar duplicatas.
            if (i >= 1 && nums[i] == nums[i - 1]){
                i++;
                continue;
            }
            // O target é o negativo do elemento atual, pois queremos que a soma dos três elementos seja zero.
            int target = -nums[i];
            // Chama a função twoSum para encontrar pares que somam ao target, começando na posição i+1.
            List<List<Integer>> pairs = twoSum(nums, i+1, target);
            // Para cada par encontrado, cria uma tripleta adicionando o elemento nums[i].
            for(List<Integer> pair : pairs){
                List<Integer> triplet = new ArrayList<>();
                triplet.add(nums[i]);
                triplet.add(pair.get(0));
                triplet.add(pair.get(1));
                ans.add(triplet);
            }
            i++;
        }
        // Retorna a lista de tripletas.
        return ans;
    }

    // Função auxiliar que encontra todos os pares no array (a partir de "start") cuja soma é igual ao target.
    private List<List<Integer>> twoSum(int[] nums, int start, int target){
        int f = start, s = nums.length - 1;
        int end = nums.length - 1;

        List<List<Integer>> pairs = new ArrayList<>();
        // Aplica a técnica de dois ponteiros para encontrar os pares
        while (f < s){
            // Se o elemento atual é igual ao anterior (para f), pula para evitar duplicatas.
            if (f - 1 >= start && nums[f] == nums[f - 1]){
                f++;
                continue;
            }
            // Se o elemento no ponteiro s é igual ao próximo (para s), pula para evitar duplicatas.
            if (s + 1 <= end && nums[s] == nums[s + 1]){
                s--;
                continue;
            }
            // Se a soma dos elementos dos ponteiros é menor que o target, move o ponteiro da esquerda para a direita.
            if (nums[s] + nums[f] < target){
                f++;
            } 
            // Se a soma for maior que o target, move o ponteiro da direita para a esquerda.
            else if (nums[s] + nums[f] > target) {
                s--;
            }
            else {
                // Se a soma for exatamente igual ao target, adiciona o par encontrado à lista de pares.
                List<Integer> pair = new ArrayList<>();
                pair.add(nums[f]);
                pair.add(nums[s]);
                pairs.add(pair);
                // Move ambos os ponteiros para continuar a busca.
                f++;
            }
        }
        return pairs;
    }
        */
        // ----------------------------------------------------------
        // Abaixo segue uma implementação alternativa do mesmo algoritmo,
        // que utiliza a técnica de dois ponteiros de forma integrada.
        // ----------------------------------------------------------
        
        // Calcula o tamanho do array.
        int n = nums.length;
        // Ordena o array. O Arrays.sort usa dual-pivot quicksort para arrays de primitivos.
        Arrays.sort(nums);

        // Lista para armazenar as tripletas únicas que somam zero.
        List<List<Integer>> retArr = new ArrayList<>();

        // Percorre o array, considerando cada elemento (até n-2) como o primeiro elemento da tripleta.
        // A condição nums[i] <= 0 garante que o primeiro número não seja positivo, já que
        // se fosse, não haveria como encontrar dois números positivos que somem zero.
        for(int i = 0; i < n - 2 && nums[i] <= 0; i++){
            // Se o elemento atual for o mesmo que o anterior, pula para evitar duplicatas.
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            // Chama a função twoSum para encontrar os outros dois números que, junto com nums[i],
            // resultem em zero. O target é -nums[i].
            twoSum(-nums[i], i + 1, n - 1, nums, retArr);
        }

        // Retorna a lista final de tripletas encontradas.
        return retArr;
    }

    // Função auxiliar twoSum que utiliza dois ponteiros para encontrar pares de números
    // que somados resultam no valor do target.
    // Ao contrário da versão anterior, esta função adiciona os pares (juntamente com o número base)
    // diretamente na lista retArr, evitando a necessidade de uma lista intermediária.
    private void twoSum (int target, int start, int end, int[] nums, List<List<Integer>> retArr){
        while(start < end){
            // Se a soma dos números dos ponteiros for menor que o target, move o ponteiro da esquerda para a direita.
            if(nums[start] + nums[end] < target){
                start++;
            } 
            // Se for maior, move o ponteiro da direita para a esquerda.
            else if (nums[start] + nums[end] > target) {
                end--;
            } 
            else {
                // Se a soma for exatamente igual ao target, uma tripleta válida é encontrada.
                // A tripleta consiste de -target (que é o número base usado para gerar o target),
                // nums[start] e nums[end].
                List<Integer> arr = new ArrayList<>();
                arr.add(-target);
                arr.add(nums[start]);
                arr.add(nums[end]);
                retArr.add(arr);
                // Move ambos os ponteiros para evitar duplicatas e continuar a busca.
                start++;
                end--;

                // Enquanto o novo valor apontado por start for igual ao anterior, continua avançando.
                while(start < end && nums[start] == nums[start - 1]){
                    start++;
                }

                // Enquanto o novo valor apontado por end for igual ao próximo, continua retrocedendo.
                while(end > start && nums[end] == nums[end + 1]){
                    end--;
                }
            }
        }
    }
}
