O Insertion Sort é um algoritmo de ordenação simples que constrói a lista ordenada um elemento de cada vez. Ele funciona de forma similar a como você organiza um baralho de cartas em sua mão: você pega uma carta (ou elemento) e a insere na posição correta em relação às cartas que já estão ordenadas.

Como funciona o algoritmo
Sublista Ordenada Inicial:
Começamos considerando que o primeiro elemento da lista já está ordenado.

Iteração a partir do Segundo Elemento:
Percorremos o restante da lista, um elemento por vez. Cada elemento (chamado de chave) será inserido na sublista à sua esquerda, que já está ordenada.

Inserção na Posição Correta:
Para cada elemento, comparamos a chave com os elementos da sublista ordenada (que estão à esquerda). Enquanto os elementos da sublista forem maiores que a chave, eles são deslocados uma posição à direita para abrir espaço para a inserção.

Inserção Efetiva:
Quando encontramos a posição correta (ou chegamos ao início da lista), inserimos a chave nessa posição.

Repetição:
Repetimos o processo até que todos os elementos tenham sido processados, resultando numa lista totalmente ordenada.

Complexidade do Algoritmo
Melhor Caso:
Ocorre quando a lista já está ordenada. Neste caso, cada elemento é comparado apenas uma vez, resultando em complexidade Θ(n).

Pior Caso:
Ocorre quando a lista está ordenada de forma decrescente. Cada elemento precisará ser comparado com todos os elementos já ordenados, resultando em complexidade Θ(n²).

Caso Médio:
Para uma lista com ordem aleatória, a complexidade média é Θ(n²).

Exemplo de Código em Python
```python
Copiar
def insertion_sort(lista):
# Percorre a lista a partir do segundo elemento
for i in range(1, len(lista)):
chave = lista[i]  # Elemento que será inserido na posição correta
j = i - 1        # Índice do elemento imediatamente à esquerda

        # Desloca os elementos da sublista ordenada que são maiores que a 'chave'
        while j >= 0 and lista[j] > chave:
            lista[j + 1] = lista[j]
            j -= 1

        # Insere a 'chave' na posição correta
        lista[j + 1] = chave

    return lista

# Exemplo de uso
if __name__ == "__main__":
lista_exemplo = [12, 11, 13, 5, 6]
print("Lista original:", lista_exemplo)
lista_ordenada = insertion_sort(lista_exemplo)
print("Lista ordenada:", lista_ordenada)
```
Explicação do Código
Loop Principal (for i in range(1, len(lista))):
Começamos a partir do segundo elemento (índice 1) porque consideramos que o primeiro elemento (índice 0) já está ordenado.

Variável chave:
Armazena o valor do elemento atual que queremos inserir na posição correta dentro da sublista ordenada.

Loop Interno (while j >= 0 and lista[j] > chave):
Compara a chave com os elementos da sublista ordenada. Enquanto o elemento à esquerda for maior que a chave, ele é movido uma posição para a direita.

Inserção da chave:
Quando encontramos a posição correta (ou seja, quando não há mais elementos maiores à esquerda), inserimos a chave nessa posição (lista[j + 1] = chave).

Este método é especialmente eficiente para listas pequenas ou para listas que já estão quase ordenadas, pois, nesses casos, o número de movimentações e comparações é significativamente reduzido.