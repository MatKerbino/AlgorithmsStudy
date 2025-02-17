// A classe Solution contém dois métodos: encode e decode.
// O método encode transforma uma lista de strings em uma única string,
// escapando os caracteres especiais que podem conflitar com o delimitador.
// O método decode reconstrói a lista original a partir da string codificada.

class Solution {

    // Método para codificar uma lista de strings em uma única string.
    // Ele percorre cada string e cada caractere, escapando os caracteres
    // especiais que conflitam com o delimitador usado (o ponto e vírgula ';').
    public String encode(List<String> strs) {
        // Utiliza um StringBuilder para construir a string de forma eficiente.
        StringBuilder sb = new StringBuilder();

        // Para cada string na lista...
        for (String s : strs) {
            int i = 0;
            // Percorre cada caractere da string.
            while (i < s.length()) {
                // Se o caractere é um ponto e vírgula ';', que é usado como delimitador,
                // ele precisa ser escapado para evitar confusão durante a decodificação.
                if (s.charAt(i) == ';') {
                    // Escapa o ';' adicionando "/;" à string codificada.
                    sb.append("/;");
                }
                // Se o caractere é uma barra '/', ele também é um caractere especial
                // e precisa ser escapado.
                else if (s.charAt(i) == '/') {
                    // Escapa a '/' adicionando "//" à string codificada.
                    sb.append("//");
                }
                // Para qualquer outro caractere, apenas adiciona-o normalmente.
                else {
                    sb.append(s.charAt(i));
                }
                // Incrementa o índice para processar o próximo caractere.
                i++;
            }
            // Após processar todos os caracteres de uma string,
            // adiciona um ponto e vírgula ';' como delimitador para indicar o final da string.
            sb.append(";");
        }
        // Retorna a string completa codificada.
        return sb.toString();
    }

    // Método para decodificar uma string codificada de volta para a lista de strings original.
    public List<String> decode(String str) {
        // Cria uma lista (ArrayList) para armazenar as strings decodificadas.
        List<String> l1 = new ArrayList<>();
        // Utiliza um StringBuilder para reconstruir cada string durante a decodificação.
        StringBuilder sb = new StringBuilder();
        int i = 0;
        // Percorre toda a string codificada.
        while (i < str.length()) {
            // Se encontra uma barra '/', isso indica que o próximo caractere foi escapado.
            if (str.charAt(i) == '/') {
                // Adiciona o caractere seguinte sem interpretá-lo (ele era um caractere especial escapado).
                sb.append(str.charAt(i + 1));
                // Avança dois caracteres: o '/' e o caractere escapado.
                i += 2;
            }
            // Se o caractere atual não é o delimitador ';', adiciona-o à string em construção.
            else if (str.charAt(i) != ';') {
                sb.append(str.charAt(i));
                i++;
            }
            // Se o caractere atual é ';', significa que uma string completa foi construída.
            else {
                // Adiciona a string formada ao final da lista.
                l1.add(sb.toString());
                // Reseta o StringBuilder para reconstruir a próxima string.
                sb.setLength(0);
                // Avança o índice para o próximo caractere após o delimitador.
                i++;
            }
        }
        // Retorna a lista com todas as strings decodificadas.
        return l1;
    }
}

/*
Explicações Adicionais:

1. Algoritmo/Técnica de "Sort":
   - Não foi utilizado nenhum algoritmo de ordenação (sort) neste código.
   - A abordagem é puramente de varredura linear, processando cada caractere da string uma única vez.

2. Estruturas de Dados Utilizadas:
   - List<String> (geralmente implementada como ArrayList):
     * Usada para armazenar a lista original de strings e a lista decodificada.
   - StringBuilder:
     * Utilizado para construir a string codificada e para reconstruir cada string durante a decodificação.
     * Permite operações eficientes de concatenação de strings.

3. Complexidade:
   - Ambos os métodos, encode e decode, realizam uma única varredura linear através dos dados de entrada.
   - Portanto, a complexidade de tempo é O(n), onde n é o número total de caracteres processados.
*/
