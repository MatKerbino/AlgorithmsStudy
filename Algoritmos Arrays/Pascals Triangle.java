```java
class Solution {
    public List<List<Integer>> generate(int numRows) {
        /*
        // ***********************************************************************
        // VERSÃO COMENTADA 1: Implementação alternativa para gerar o Triângulo de Pascal
        // ***********************************************************************
        //
        // Este bloco de código comentado é uma outra implementação para gerar o Triângulo de Pascal.
        // A ideia é construir o triângulo linha por linha, onde cada elemento interno é a soma dos
        // dois elementos diretamente acima dele na linha anterior.
        //
        // Primeiro, verifica-se se numRows é igual a 1. Se for, cria-se uma lista de listas contendo
        // apenas a primeira linha [1] e retorna essa lista:
        //
        // if (numRows == 1) {
        //     List<List<Integer>> result = new ArrayList<>();
        //     result.add(Arrays.asList(1)); 
        //     return result;
        // }
        //
        // Em seguida, inicializa-se a estrutura de dados para armazenar todas as linhas do triângulo.
        // Aqui é usado um ArrayList de List<Integer> para armazenar cada linha individualmente.
        // Duas primeiras linhas já são definidas:
        // - A primeira linha é [1]
        // - A segunda linha é [1, 1]
        //
        // List<List<Integer>> ans = new ArrayList<>(numRows);
        // List<Integer> first = new ArrayList<>(1){{add(1);}};
        // List<Integer> second = new ArrayList<>(2){{add(1);add(1);}};
        // ans.add(first);
        // ans.add(second);
        //
        // A partir da terceira linha (i = 3), utiliza-se um loop while para construir cada linha.
        // A variável 'past' guarda a linha imediatamente anterior para facilitar o cálculo da soma.
        //
        // int i = 3;
        // List<Integer> past = second;
        // while(i <= numRows){
        //     List<Integer> curr = new ArrayList<>();
        //     for (int j = 0; j <= i - 1; j++){
        //         if(j == 0){
        //             curr.add(1); // Primeiro elemento de cada linha é 1
        //         } else if (j == i - 1){
        //             curr.add(1); // Último elemento de cada linha é 1
        //         } else {
        //             // Elementos internos são a soma dos dois elementos acima:
        //             // O elemento à esquerda: past.get(j - 1)
        //             // O elemento à direita: past.get(j)
        //             curr.add(past.get(j - 1) + past.get(j));
        //         }
        //     }
        //     past = curr;     // Atualiza a linha anterior para a próxima iteração
        //     ans.add(curr);   // Adiciona a linha atual à lista de linhas do triângulo
        //     i++;
        // }
        //
        // Retorna o triângulo completo:
        // return ans;
        //
        // ***********************************************************************
        // Observações sobre a implementação:
        // - Estruturas de dados:
        //    * List<List<Integer>>: Utilizada para armazenar todas as linhas do triângulo.
        //    * List<Integer>: Cada linha do triângulo é representada por uma lista de inteiros.
        //    * ArrayList: Implementação utilizada para as listas, pois permite um gerenciamento
        //      dinâmico dos elementos.
        // - Algoritmo:
        //    * A abordagem é baseada em programação dinâmica, onde cada linha é construída
        //      com base na linha anterior.
        // - Algoritmo de ordenação (sort):
        //    * Não foi utilizado nenhum algoritmo de ordenação nesta implementação.
        //
        */

        // ***********************************************************************
        // VERSÃO ATIVA: Implementação para gerar o Triângulo de Pascal
        // ***********************************************************************
        //
        // Nesta versão, o triângulo é construído utilizando dois loops aninhados.
        // O loop externo itera sobre o número de linhas desejado (de 0 a numRows - 1).
        // O loop interno constrói cada linha individualmente.
        //
        // Para cada linha:
        // - O primeiro e o último elemento são sempre 1.
        // - Os elementos internos são calculados como a soma dos dois elementos da linha anterior,
        //   especificamente, o elemento imediatamente acima à esquerda e o elemento imediatamente acima.
        // 
        // A estrutura de dados utilizada é a seguinte:
        // - List<List<Integer>> ans: Armazena todas as linhas do triângulo.
        // - List<Integer> row: Representa uma única linha do triângulo.
        // 
        // Ressalta-se que nesta implementação não há uso de nenhum algoritmo de ordenação (sort).

        List<List<Integer>> ans = new ArrayList<>(); // Cria a lista que armazenará todas as linhas do triângulo
        
        // Loop externo: para cada linha do triângulo
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(); // Cria uma nova lista para a linha atual
            
            // Loop interno: para cada posição na linha atual (índices de 0 até i)
            for (int j = 0; j <= i; j++) {
                // Se for o primeiro (j == 0) ou o último elemento da linha (j == i), insere 1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // Para os demais casos, o valor é a soma de dois números da linha anterior:
                    // - ans.get(i - 1).get(j - 1): elemento à esquerda da posição atual na linha anterior
                    // - ans.get(i - 1).get(j): elemento à direita da posição atual na linha anterior
                    row.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
                }
            }
            
            // Adiciona a linha construída à lista principal de linhas do triângulo
            ans.add(row);
        }

        // Retorna o triângulo completo representado por uma lista de listas de inteiros
        return ans;
    }
}
```