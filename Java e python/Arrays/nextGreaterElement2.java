class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // ===========================
        // Abordagem 1: HashMap + busca linear com wrap-around
        // Estruturas usadas:
        //   - HashMap<Integer, Integer> map : para mapear cada valor ao seu próximo maior (ou -1)
        //   - int[] ans : array de resposta
        // Algoritmo:
        //   Para cada posição j:
        //     1. Inicializa map.put(nums[j], -1)
        //     2. Varre os elementos à direita de j (de j+1 até end):
        //          se encontra nums[i] > nums[j], atualiza map e sai
        //        se chega ao fim sem encontrar, faz uma segunda varredura do início ao fim:
        //          se encontra nums[p] > nums[j], atualiza map e sai
        //     3. Se não encontrou em nenhuma das passagens, permanece -1
        // Complexidade: O(n²) no pior caso (dois loops aninhados)
        /*
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans[] = new int[nums.length];

        int j = 0;
        boolean inc = false;
        while (j < nums.length){
            map.put(nums[j], -1);  // assume -1 até prova em contrário
            inc = false;
            // 1ª varredura à direita de j
            for (int i = j + 1; i < nums.length; i++){
                if (nums[i] > nums[j]){
                    map.replace(nums[j], nums[i]);  // próximo maior encontrado
                    j++;
                    inc = true;
                    break;
                } else if (i == nums.length - 1){
                    // não achou na 1ª, faz wrap-around
                    for (int p = 0; p < nums.length; p++){
                        if (nums[p] > nums[j]){
                            map.replace(nums[j], nums[p]);
                            j++;
                            inc = true;
                            break;
                        }
                    }
                    break;
                }
            }
            if (!inc) j++;  // se não achou em nenhuma das passagens
        }

        // Constrói o array de resposta a partir do map
        for (int i = 0; i < nums.length; i++){
            ans[i] = map.get(nums[i]);
        }

        return ans;
        */

        // ===========================
        // Abordagem 2: Força bruta modular (puro array)
        // Estruturas usadas:
        //   - int[] ans : array de resposta
        // Algoritmo:
        //   Para cada índice i:
        //     - define ans[i] = -1
        //     - faz até n-1 comparações, calculando j = (i + k) % n
        //       se nums[j] > nums[i], salva ans[i] e interrompe
        // Complexidade: O(n²), sem uso de estruturas extras
        /*
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = -1;  // padrão se não encontrar

            // tenta k = 1 até n-1 posições à frente, com wrap-around
            for (int k = 1; k < n; k++) {
                int j = (i + k) % n;
                if (nums[j] > nums[i]) {
                    ans[i] = nums[j];  // próximo maior encontrado
                    break;
                }
            }
        }
        return ans;
        */

        // ===========================
        // Abordagem 3: Pilha Monótona para solução O(n)
        // Estruturas usadas:
        //   - int[] ans                   : array de resposta, inicializado com -1
        //   - Deque<Integer> stack (LIFO) : armazenamos índices de elementos aguardando seu "next greater"
        // Algoritmo Monotonic Stack:
        //   1. Inicializa ans[i] = -1 para todo i.
        //   2. Percorre i de 0 até 2*n-1 (2 passagens simulando circularidade):
        //        idx = i % n
        //        enquanto a pilha não estiver vazia e nums[idx] > nums[stack.peek()]:
        //          desempilha prevIndex = stack.pop()
        //          ans[prevIndex] = nums[idx]  // encontramos o próximo maior
        //        se i < n: empilha idx (só na primeira passada)
        //   3. Retorna ans
        // Complexidade: O(n), pois cada índice é empilhado e desempilhado no máximo uma vez.
        int n = nums.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        // Inicializa todas as entradas de resposta como -1 (valor padrão)
        for (int i = 0; i < n; i++) {
            ans[i] = -1;
        }
        // Duas passagens para lidar com o array circular
        for (int i = 0; i < 2 * n; i++) {
            int idx = i % n;  // índice real no array
            // Se o valor atual é maior do que o valor dos índices empilhados, atualizamos suas respostas
            while (!stack.isEmpty() && nums[idx] > nums[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = nums[idx];
            }
            // Apenas empilha índices na primeira passagem (i < n)
            if (i < n) {
                stack.push(idx);
            }
        }
        return ans;
    }
}
