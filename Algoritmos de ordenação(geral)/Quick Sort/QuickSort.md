A seguir, apresento uma explicação detalhada do algoritmo **Quicksort**, incluindo um exemplo implementado em Python e um passo a passo do funcionamento.

---

### Visão Geral do Quicksort

Quicksort, também conhecido como *partition-exchange sort*, é um algoritmo de ordenação muito eficiente e geralmente implementado de forma *in-place* (ou seja, sem uso de memória adicional significativa). Foi desenvolvido por Tony Hoare em 1959 e utiliza a estratégia de *divide-and-conquer* para ordenar os elementos de um array.

#### Passos Principais do Quicksort

1. **Selecionar um Pivô:**  
   Escolhe-se um elemento do array que servirá como pivô. Esse elemento pode ser o primeiro, o último, o do meio ou até um elemento escolhido aleatoriamente. A escolha do pivô pode afetar o desempenho do algoritmo, especialmente para arrays já ordenados ou com muitos elementos repetidos.

2. **Particionar o Array:**  
   Reorganiza o array de forma que todos os elementos menores que o pivô fiquem à esquerda e todos os maiores que o pivô fiquem à direita. Elementos iguais ao pivô podem ficar em qualquer lado. Ao final dessa etapa, o pivô estará em sua posição correta na lista ordenada.

3. **Ordenação Recursiva:**  
   Aplica recursivamente o mesmo processo às sublistas (ou partições) à esquerda e à direita do pivô, até que cada sublista contenha zero ou um elemento, estando, assim, ordenada.

#### Complexidade

- **Caso Médio:** O Quicksort possui complexidade média de **O(n log n)**, o que o torna eficiente para a maioria dos casos.
- **Pior Caso:** O pior cenário ocorre quando o pivô escolhido é sempre o menor ou o maior elemento, levando a uma complexidade de **O(n²)**. No entanto, isso é raro se o pivô for escolhido de forma aleatória ou utilizando heurísticas.

#### Vantagens e Desvantagens

- **Vantagens:**  
  - Geralmente mais rápido que outros algoritmos como Merge Sort e Heap Sort em dados aleatórios.
  - Realiza a ordenação *in-place*, economizando memória.

- **Desvantagens:**  
  - Não é estável, ou seja, a ordem relativa de elementos iguais pode não ser preservada.
  - Pode ter desempenho ruim no pior caso, embora isso seja raro.

---

### Exemplo em Python com Comentários Detalhados

```python
def quicksort(arr, low, high):
    # Caso base: Se a sublista tem um ou nenhum elemento, ela já está ordenada.
    if low < high:
        # Executa a partição e obtém o índice do pivô após a reorganização.
        p = partition(arr, low, high)
        # Aplica recursivamente o quicksort na sublista à esquerda do pivô.
        quicksort(arr, low, p - 1)
        # Aplica recursivamente o quicksort na sublista à direita do pivô.
        quicksort(arr, p + 1, high)

def partition(arr, low, high):
    # Seleciona o pivô; aqui escolhemos o último elemento do array como pivô.
    pivot = arr[high]
    # 'i' marca a posição do último elemento que é menor ou igual ao pivô.
    i = low - 1
    # Percorre os elementos do array da posição 'low' até 'high - 1'.
    for j in range(low, high):
        # Se o elemento atual é menor ou igual ao pivô, ele deve ser movido para a parte esquerda.
        if arr[j] <= pivot:
            i += 1  # Incrementa 'i' para apontar a próxima posição de elemento menor.
            # Troca os elementos na posição i e j.
            arr[i], arr[j] = arr[j], arr[i]
    # Após o laço, coloca o pivô na posição correta (após todos os elementos menores ou iguais).
    arr[i + 1], arr[high] = arr[high], arr[i + 1]
    # Retorna o índice do pivô, que agora está na sua posição ordenada.
    return i + 1

# Exemplo de uso do algoritmo Quicksort:
if __name__ == "__main__":
    # Array de exemplo a ser ordenado.
    arr = [10, 7, 8, 9, 1, 5]
    print("Array original:", arr)
    # Chama a função quicksort passando os índices inicial e final do array.
    quicksort(arr, 0, len(arr) - 1)
    print("Array ordenado:", arr)
```

---

### Passo a Passo do Funcionamento com um Exemplo

Vamos utilizar o array `[10, 7, 8, 9, 1, 5]` para demonstrar como o algoritmo funciona.

1. **Chamada Inicial:**  
   `quicksort(arr, 0, 5)`  
   - **Pivô:** O último elemento, `5`, é escolhido como pivô.
   
2. **Primeira Partição:**  
   Chama `partition(arr, 0, 5)`:
   - Inicializa `i = -1`.
   - Itera com `j` de 0 a 4:
     - **j = 0:**  
       - `arr[0] = 10`  
       - 10 > 5, então nada é feito.
     - **j = 1:**  
       - `arr[1] = 7`  
       - 7 > 5, nada é feito.
     - **j = 2:**  
       - `arr[2] = 8`  
       - 8 > 5, nada é feito.
     - **j = 3:**  
       - `arr[3] = 9`  
       - 9 > 5, nada é feito.
     - **j = 4:**  
       - `arr[4] = 1`  
       - 1 ≤ 5, então:
         - Incrementa `i` para 0.
         - Troca `arr[0]` com `arr[4]`.  
           Array passa a ser: `[1, 7, 8, 9, 10, 5]`
   - Após o laço, troca o pivô (`arr[5] = 5`) com `arr[i+1]` (ou seja, `arr[1]`):
     - Array torna-se: `[1, 5, 8, 9, 10, 7]`
   - **Retorno da partição:**  
     - O pivô `5` está agora na posição `1`.
   
3. **Divisão e Recursão:**  
   - Agora, o array está dividido em:
     - Subarray à esquerda do pivô: `[1]` (índices 0 a 0)
     - Subarray à direita do pivô: `[8, 9, 10, 7]` (índices 2 a 5)
   - **Recursão à esquerda:**  
     - Chama `quicksort(arr, 0, 0)`.  
       Como contém apenas um elemento, retorna imediatamente.
   - **Recursão à direita:**  
     - Chama `quicksort(arr, 2, 5)`.

4. **Ordenando o Subarray `[8, 9, 10, 7]`:**  
   - **Pivô:** Agora, `arr[5] = 7` é escolhido como pivô.
   - Chama `partition(arr, 2, 5)`:
     - Inicializa `i = 1`.
     - Itera com `j` de 2 a 4:
       - **j = 2:**  
         - `arr[2] = 8`  
         - 8 > 7, nada é feito.
       - **j = 3:**  
         - `arr[3] = 9`  
         - 9 > 7, nada é feito.
       - **j = 4:**  
         - `arr[4] = 10`  
         - 10 > 7, nada é feito.
     - Troca o pivô (`arr[5] = 7`) com `arr[i+1]` (ou seja, `arr[2]`):
       - Array passa a ser: `[1, 5, 7, 9, 10, 8]`
     - **Retorno da partição:**  
       - O pivô `7` está agora na posição `2`.
   - Agora, divide o subarray em:
     - Subarray à esquerda de `7`: (índices 2 a 1) – vazio.
     - Subarray à direita de `7`: `[9, 10, 8]` (índices 3 a 5)
   - Recursões:
     - `quicksort(arr, 2, 1)` retorna imediatamente.
     - Chama `quicksort(arr, 3, 5)` para ordenar `[9, 10, 8]`.

5. **Ordenando o Subarray `[9, 10, 8]`:**  
   - **Pivô:** Escolhe `arr[5] = 8` como pivô.
   - Chama `partition(arr, 3, 5)`:
     - Inicializa `i = 2`.
     - Itera com `j` de 3 a 4:
       - **j = 3:**  
         - `arr[3] = 9`  
         - 9 > 8, nada é feito.
       - **j = 4:**  
         - `arr[4] = 10`  
         - 10 > 8, nada é feito.
     - Troca o pivô (`arr[5] = 8`) com `arr[i+1]` (ou seja, `arr[3]`):
       - Array torna-se: `[1, 5, 7, 8, 10, 9]`
     - **Retorno da partição:**  
       - O pivô `8` está agora na posição `3`.
   - Divide o subarray em:
     - Subarray à esquerda de `8`: (índices 3 a 2) – vazio.
     - Subarray à direita de `8`: `[10, 9]` (índices 4 a 5)
   - Recursões:
     - `quicksort(arr, 3, 2)` retorna imediatamente.
     - Chama `quicksort(arr, 4, 5)` para ordenar `[10, 9]`.

6. **Ordenando o Subarray `[10, 9]`:**  
   - **Pivô:** O pivô é `arr[5] = 9`.
   - Chama `partition(arr, 4, 5)`:
     - Inicializa `i = 3`.
     - Itera com `j = 4`:
       - **j = 4:**  
         - `arr[4] = 10`  
         - 10 > 9, nada é feito.
     - Troca o pivô (`arr[5] = 9`) com `arr[i+1]` (ou seja, `arr[4]`):
       - Array passa a ser: `[1, 5, 7, 8, 9, 10]`
     - **Retorno da partição:**  
       - O pivô `9` está agora na posição `4`.
   - Divide em subarrays:
     - `quicksort(arr, 4, 3)` e `quicksort(arr, 5, 5)` retornam imediatamente (subarrays vazios ou com um único elemento).

7. **Resultado Final:**  
   Ao término de todas as recursões, o array está ordenado:  
   `[1, 5, 7, 8, 9, 10]`

---

### Resumo

- **Divisão:** O array é dividido em subarrays com base na posição do pivô.
- **Conquista:** Cada subarray é ordenado recursivamente.
- **Combinação:** Não há um passo de "combinação" explícito, pois o array é ordenado *in-place* conforme os pivôs são posicionados corretamente.

Esta abordagem de **divide-and-conquer** e o uso de partição são o que torna o Quicksort um algoritmo eficiente e muito utilizado para ordenação, apesar de sua vulnerabilidade ao pior caso, que pode ser minimizada com uma escolha adequada do pivô.

---

Com essa explicação, temos uma visão completa do funcionamento do Quicksort, tanto teórica quanto praticamente, com um exemplo detalhado em Python.