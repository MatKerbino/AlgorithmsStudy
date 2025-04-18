package QuickSort;```java
class Solution {
    // Função principal que retorna os k pontos mais próximos da origem.
    // Recebe um array 2D 'points' onde cada elemento é um ponto [x, y]
    // e um inteiro k que indica quantos pontos mais próximos queremos.
    public int[][] kClosest(int[][] points, int k) {
        // Inicializa os ponteiros para o início (left) e fim (right) do array.
        int left = 0, right = points.length - 1;

        // Utiliza o algoritmo Quickselect para posicionar os k pontos mais próximos no início do array.
        while (left <= right) {
            // Realiza a partição do array entre left e right e retorna o índice do pivô.
            int pivotIndex = partition(points, left, right);

            // Se o pivô estiver exatamente na posição k - 1, encontramos os k menores (mais próximos).
            if (pivotIndex == k - 1) {
                break;
                // Se o pivô estiver antes da posição k - 1, precisamos buscar na parte direita.
            } else if (pivotIndex < k - 1) {
                left = pivotIndex + 1;
                // Se o pivô estiver depois da posição k - 1, precisamos buscar na parte esquerda.
            } else {
                right = pivotIndex - 1;
            }
        }

        // Cria um novo array para armazenar os k pontos mais próximos.
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = points[i]; // Os k primeiros pontos já são os mais próximos.
        }

        return result;
    }

    // Método auxiliar que particiona o array de pontos utilizando um pivô escolhido aleatoriamente.
    // Esse método é uma parte fundamental do algoritmo Quickselect.
    private int partition(int[][] points, int left, int right) {
        // Escolhe um índice de pivô aleatório entre left e right.
        int pivotIndex = left + new Random().nextInt(right - left + 1);
        // Armazena o ponto pivô para referência.
        int[] pivotPoint = points[pivotIndex];
        // Move o pivô para o final do intervalo para simplificar a partição.
        swap(points, pivotIndex, right);

        // 'i' marcará a posição onde os pontos menores que o pivô serão colocados.
        int i = left;
        // Percorre todos os pontos do intervalo (exceto o pivô, que está no final).
        for (int j = left; j < right; j++){
            // Se o ponto atual for mais próximo da origem que o pivô...
            if (compare(points[j], pivotPoint) < 0){
                // ...troca-o com o ponto na posição 'i' e incrementa 'i'.
                swap(points, i++, j);
            }
        }
        // Coloca o pivô na sua posição final correta.
        swap(points, i, right);
        // Retorna o índice final do pivô.
        return i;
    }

    // Função de comparação que calcula a distância euclidiana ao quadrado dos pontos à origem.
    // Retorna um valor negativo se point1 estiver mais próximo que point2,
    // zero se  forem iguais e positivo se point1 estiver mais distante.
    private int compare(int[] point1, int[] point2){
        // Calcula a distância ao quadrado para evitar o custo da raiz quadrada.
        return (point1[0] * point1[0] + point1[1] * point1[1]) -
                (point2[0] * point2[0] + point2[1] * point2[1]);
    }

    // Método auxiliar para trocar dois pontos no array.
    private void swap(int[][] points, int i, int j){
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}

/*
Explicação detalhada do algoritmo e estruturas utilizadas:

1. Algoritmo Utilizado:
   - O código utiliza o algoritmo Quickselect, que é uma variação do Quicksort.
   - Objetivo do Quickselect: encontrar o k-ésimo menor elemento (ou, no caso, os k menores elementos) sem ordenar todo o array.
   - Ele funciona particionando o array em torno de um pivô aleatório e reduzindo recursivamente o problema para
     a parte do array que contém os elementos de interesse (nesse caso, os pontos mais próximos).
   - A escolha do pivô de forma aleatória ajuda a evitar o pior caso e melhora o desempenho médio.

2. Técnica de Partição (Partition):
   - Seleciona um pivô aleatório dentro do intervalo [left, right].
   - Reordena os pontos de forma que todos os pontos com distância à origem menor que a do pivô fiquem à esquerda,
     e os que são maiores fiquem à direita.
   - Retorna a posição final do pivô, que indica quantos pontos estão mais próximos da origem que o pivô.

3. Estruturas de Dados Utilizadas:
   - int[][] points: Um array bidimensional que armazena os pontos no plano, onde cada ponto é representado como um array de dois inteiros [x, y].
   - Arrays simples são usados para armazenar e manipular os dados, sem o uso de estruturas de dados complexas.
   - O array 'result' é utilizado para armazenar e retornar os k pontos mais próximos após o particionamento.

4. Considerações sobre Complexidade:
   - Em média, o algoritmo Quickselect tem complexidade O(n), onde n é o número de pontos.
   - No pior caso (raramente, devido à escolha aleatória do pivô), a complexidade pode chegar a O(n²).

Este código é eficiente para encontrar os k pontos mais próximos da origem sem precisar ordenar completamente o array de pontos.
*/
```