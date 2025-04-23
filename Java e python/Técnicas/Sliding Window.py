# -*- coding: utf-8 -*-
# Sliding Window em Python

def max_subarray_sum_fixed(arr, k):
    """
    Encontra a soma máxima de qualquer subarray de tamanho fixo k usando sliding window.
    Complexidade: O(n), pois cada elemento é adicionado e removido da 'janela' exatamente uma vez.
    Espaço: O(1), usando variáveis auxiliares.
    """
    n = len(arr)
    if k > n:
        return None  # não há subarray de tamanho k se k > n

    # 1) Inicializa a janela somando os primeiros k elementos
    window_sum = sum(arr[0:k])
    max_sum = window_sum

    # 2) Move a janela 1 posição para a direita por vez:
    #    - adiciona o novo elemento que entra pela direita (arr[i])
    #    - subtrai o elemento que sai pela esquerda (arr[i - k])
    for i in range(k, n):
        # Expande e contrai a janela em O(1):
        window_sum += arr[i]       # adiciona elemento que entra
        window_sum -= arr[i - k]   # remove elemento que sai
        # Atualiza o máximo encontrado
        if window_sum > max_sum:
            max_sum = window_sum

    return max_sum


def length_of_longest_substring_variable(s):
    """
    Encontra o comprimento da maior substring sem caracteres repetidos.
    Aqui a janela é de tamanho variável: 
    - expandimos pela direita (i) até encontrar repetição;
    - então contraímos pela esquerda (start) até remover a repetição.
    Complexidade: O(n), cada ponteiro (start, i) anda no máximo n passos.
    Espaço: O(min(n, m)), onde m = tamanho do alfabeto, para o mapa de última posição.
    """
    start = 0                # início da janela
    max_len = 0              # resultado
    last_seen = {}           # mapa: caractere -> última posição visto

    # i é o fim da janela (inclusivo)
    for i, ch in enumerate(s):
        if ch in last_seen and last_seen[ch] >= start:
            # se ch está dentro da janela atual, movemos 'start' para a direita
            # logo após a última ocorrência para manter todos únicos
            start = last_seen[ch] + 1

        # atualiza/insere a posição de ch
        last_seen[ch] = i

        # comprimento atual = i - start + 1
        current_len = i - start + 1
        if current_len > max_len:
            max_len = current_len

    return max_len


if __name__ == "__main__":
    # Exemplo de uso:

    arr = [2, 1, 5, 1, 3, 2]
    k = 3
    print(f"Máxima soma de subarray de tamanho {k}:", max_subarray_sum_fixed(arr, k))
    # passo a passo:
    # janela [2,1,5]=8 → depois [1,5,1]=7 → [5,1,3]=9 → [1,3,2]=6 → resultado = 9

    s = "abcabcbb"
    print("Maior substring sem repetidos em 'abcabcbb':", length_of_longest_substring_variable(s))
    # passo a passo:
    # percorre 'a','b','c' → janela cresce até 'abc' (tamanho 3)
    # ao ver novo 'a', move start para 1 → substring 'bca', etc.
    # resultado final = 3
