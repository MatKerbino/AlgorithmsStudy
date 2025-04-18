A seguir, uma explicação detalhada do algoritmo Selection Sort, juntamente com um exemplo em Python e um passo a passo do funcionamento.

---

```python
# Função que implementa o algoritmo Selection Sort.
# O Selection Sort é um algoritmo simples de ordenação por comparação que opera "in-place",
# ou seja, ordena o array sem utilizar memória extra (exceto variáveis auxiliares).
def selection_sort(array):
    size = len(array)  # Obtém o tamanho do array.
    
    # Loop externo: cada iteração coloca o menor elemento da parte não ordenada
    # na posição correta, movendo a fronteira entre as partes ordenada e não ordenada.
    for step in range(size):
        # Inicialmente, assume-se que o primeiro elemento da parte não ordenada é o menor.
        min_index = step
        
        # Loop interno: percorre o restante do array (parte não ordenada) para encontrar o elemento mínimo.
        for i in range(step + 1, size):
            if array[i] < array[min_index]:
                # Se encontrar um elemento menor, atualiza o índice do menor elemento.
                min_index = i
        
        # Depois de encontrar o menor elemento, realiza a troca:
        # Troca o elemento na posição 'step' com o menor elemento encontrado (na posição min_index).
        array[step], array[min_index] = array[min_index], array[step]

# Exemplo de uso:
data = [64, 25, 12, 22, 11]
selection_sort(data)
print("Array ordenado em ordem crescente:")
print(data)
```

---

### Explicação Detalhada do Funcionamento

1. **Conceito Básico:**
   - O algoritmo divide o array em duas partes: a parte **ordenada** (inicialmente vazia) e a parte **não ordenada** (inicialmente o array completo).
   - A cada iteração, o menor elemento da parte não ordenada é selecionado e movido para o final da parte ordenada, aumentando essa parte em uma unidade.

2. **Passo a Passo com o Exemplo `[64, 25, 12, 22, 11]`:**

   - **Primeira Iteração (`step = 0`):**
     - **Inicialização:** Assume que o primeiro elemento (64) é o menor. `min_index = 0`.
     - **Busca:** 
       - Compara 25 com 64 → 25 é menor, atualiza `min_index = 1`.
       - Compara 12 com 25 → 12 é menor, atualiza `min_index = 2`.
       - Compara 22 com 12 → 12 continua sendo o menor.
       - Compara 11 com 12 → 11 é menor, atualiza `min_index = 4`.
     - **Troca:** Troca o elemento na posição 0 (64) com o elemento na posição 4 (11).
     - **Array após a iteração:** `[11, 25, 12, 22, 64]`.

   - **Segunda Iteração (`step = 1`):**
     - **Inicialização:** Agora, a parte ordenada é `[11]` e a não ordenada é `[25, 12, 22, 64]`. Assume que o primeiro elemento da parte não ordenada (25) é o menor. `min_index = 1`.
     - **Busca:** 
       - Compara 12 com 25 → 12 é menor, atualiza `min_index = 2`.
       - Compara 22 com 12 → 12 continua sendo o menor.
       - Compara 64 com 12 → 12 continua sendo o menor.
     - **Troca:** Troca o elemento na posição 1 (25) com o elemento na posição 2 (12).
     - **Array após a iteração:** `[11, 12, 25, 22, 64]`.

   - **Terceira Iteração (`step = 2`):**
     - **Inicialização:** Parte ordenada: `[11, 12]`; parte não ordenada: `[25, 22, 64]`. Assume 25 (posição 2) é o menor. `min_index = 2`.
     - **Busca:** 
       - Compara 22 com 25 → 22 é menor, atualiza `min_index = 3`.
       - Compara 64 com 22 → 22 continua sendo o menor.
     - **Troca:** Troca o elemento na posição 2 (25) com o elemento na posição 3 (22).
     - **Array após a iteração:** `[11, 12, 22, 25, 64]`.

   - **Quarta Iteração (`step = 3`):**
     - **Inicialização:** Parte ordenada: `[11, 12, 22]`; parte não ordenada: `[25, 64]`. Assume 25 (posição 3) é o menor. `min_index = 3`.
     - **Busca:** 
       - Compara 64 com 25 → 25 é menor.
     - **Troca:** Como o menor elemento já está na posição correta, o array permanece inalterado.
     - **Array após a iteração:** `[11, 12, 22, 25, 64]`.

   - **Quinta Iteração (`step = 4`):**
     - Neste ponto, apenas o último elemento (64) está na parte não ordenada, que é considerado já ordenado.
     - **Array final:** `[11, 12, 22, 25, 64]`.

3. **Complexidade do Algoritmo:**

   - **Tempo:**
     - O algoritmo possui complexidade **O(n²)**, pois para cada elemento (n iterações) é feito um loop interno que pode percorrer aproximadamente n elementos.
     - Essa complexidade é válida para os piores, melhores e casos médios.
   - **Espaço:**
     - A complexidade de espaço é **O(1)**, já que o algoritmo realiza as trocas "in-place" e utiliza apenas variáveis auxiliares.

4. **Aplicações e Considerações:**

   - **Simplicidade:** Devido à sua implementação simples, o Selection Sort é frequentemente utilizado para ensinar os fundamentos dos algoritmos de ordenação.
   - **Tamanho dos Dados:** Funciona bem para listas pequenas.
   - **Custo de Escrita:** Pode ser útil quando as escritas em memória são custosas, pois o número de trocas é mínimo em comparação com outros algoritmos.

---

Essa é uma explicação completa do algoritmo Selection Sort, incluindo um exemplo em Python e um passo a passo detalhado do seu funcionamento.