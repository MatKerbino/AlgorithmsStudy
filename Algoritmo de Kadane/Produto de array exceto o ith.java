class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Cria dois arrays auxiliares:
        // 'left' armazenará os produtos dos elementos à esquerda de cada posição.
        // 'right' armazenará os produtos dos elementos à direita de cada posição.
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        // Array de saída que armazenará o resultado final.
        int[] out = new int[nums.length];

        // Inicializa a primeira posição do array 'left' como 1, pois não há elementos à esquerda do primeiro elemento.
        left[0] = 1;
        // Inicializa a última posição do array 'right' como 1, pois não há elementos à direita do último elemento.
        right[nums.length - 1] = 1;

        // Preenche o array 'left'
        // Para cada posição i (começando de 1),
        // left[i] é o produto de todos os elementos à esquerda de nums[i].
        // Por exemplo, para i = 1, left[1] = nums[0]; para i = 2, left[2] = nums[0] * nums[1]; e assim por diante.
        for (int i = 1; i < nums.length; i++){
            left[i] = left[i - 1] * nums[i - 1];
        }

        // Preenche o array 'right'
        // Para cada posição i (começando do penúltimo elemento e indo para o início),
        // right[i] é o produto de todos os elementos à direita de nums[i].
        // Por exemplo, para i = nums.length - 2, right[i] = nums[nums.length - 1];
        // para i = nums.length - 3, right[i] = nums[nums.length - 2] * nums[nums.length - 1]; e assim por diante.
        for (int i = nums.length - 2; i >= 0; i--){
            right[i] = right[i + 1] * nums[i + 1];
        }

        // Constrói o array de saída 'out'
        // Para cada posição i, o resultado é a multiplicação do produto de todos os elementos à esquerda de i (left[i])
        // com o produto de todos os elementos à direita de i (right[i]).
        for (int i = 0; i < nums.length; i++){
            out[i] = left[i] * right[i];
        }

        // Retorna o array com o produto de todos os elementos, exceto o elemento na posição i para cada i.
        return out;
    }
}
