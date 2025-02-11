class Solution {
    public int maxProfit(int[] prices) {
        // pr: variável que armazena o maior lucro (profit) encontrado até o momento.
        // max: variável que guarda o maior preço (de venda) que já encontramos ao iterar o array.
        int pr = 0;
        int max = 0;

        // Itera o array de preços de trás para frente.
        // Dessa forma, garantimos que ao calcular a diferença max - prices[i],
        // max representa o maior preço futuro (melhor dia para vender) em relação ao dia i.
        for (int i = prices.length - 1; i >= 0; i--) {
            // Atualiza o preço máximo encontrado até agora.
            // Se prices[i] for maior que o max atual, atualizamos max.
            max = Math.max(max, prices[i]);

            // Calcula o lucro potencial se comprássemos no dia i e vendêssemos no dia com preço max.
            // Se esse lucro for maior que o lucro armazenado em pr, atualizamos pr.
            pr = Math.max(pr, max - prices[i]);
        }

        // Retorna o maior lucro possível.
        return pr;
    }
}