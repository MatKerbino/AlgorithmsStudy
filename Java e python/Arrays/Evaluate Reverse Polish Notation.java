class Solution {
    public int evalRPN(String[] tokens) {
        // Método principal para avaliar expressão em Notação Polonesa Reversa (RPN)
        // Recebe um array de tokens (operandos e operadores)

        // 1ª versão comentada - implementação detalhada passo a passo
        /*
        // Cria uma pilha para armazenar operandos inteiros
        Stack<Integer> nums = new Stack<>();
        
        // Percorre todos os tokens da expressão
        for (int i = 0; i < tokens.length; i++){
            // Se o token for um operador, realiza operação com os dois últimos valores da pilha
            if (tokens[i].equals("+") || tokens[i].equals("-")  || tokens[i].equals("/")  || tokens[i].equals("*")){
                // Retira o último valor (num1) e o penúltimo (num2) da pilha
                int num1 = nums.pop();
                int num2 = nums.pop();
                
                // Define qual operação será executada e empilha o resultado
                switch (tokens[i]){
                    case "+":
                        // Soma: num2 + num1
                        num1 += num2;
                        nums.push(num1);
                        break;
                    case "-":
                        // Subtração: num2 - num1 (ordem importa)
                        num1 = num2 - num1;
                        nums.push(num1);
                        break;
                    case "*":
                        // Multiplicação: num2 * num1
                        num1 *= num2;
                        nums.push(num1);
                        break;
                    case "/":
                        // Divisão inteira: num2 / num1 (descarta parte fracionária)
                        num1 = num2 / num1;
                        nums.push(num1);
                        break;
                }
            } else {
                // Se não for operador, converte string para inteiro e empilha
                nums.push(Integer.parseInt(tokens[i]));
            }
        }
        // Ao final, o resultado da expressão está no topo da pilha
        return nums.pop();
        */

        // 2ª versão ativa - mais concisa, mas lógica equivalente
        int res = 0;  // Variável para acumular soma final dos valores restantes na pilha
        Stack<Integer> stack = new Stack<>();  // Estrutura de dados Pilha (LIFO)

        // Itera por cada token do array
        for (String token : tokens) {
            // Se o token for "+", desempilha dois valores e empilha a soma
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } 
            // Se o token for "-", desempilha dois valores, faz subtração (ordem reversa) e empilha
            else if (token.equals("-")) {
                int a = stack.pop();  // segundo operando
                int b = stack.pop();  // primeiro operando
                stack.push(b - a);
            } 
            // Se o token for "*", desempilha dois valores, faz multiplicação e empilha
            else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } 
            // Se o token for "/", desempilha dois valores, faz divisão inteira e empilha
            else if (token.equals("/")) {
                int a = stack.pop();  // divisor
                int b = stack.pop();  // dividend
                stack.push(b / a);
            } 
            // Se o token for número, converte para Integer e empilha na pilha
            else {
                stack.push(Integer.valueOf(token));
            }
        }

        // Após processar todos os tokens, pode haver mais de um valor na pilha;
        // soma todos eles para retornar o resultado acumulado
        for (int num : stack) {
            res += num;
        }
        return res;
    }
}

// --------------------------------------------
// Algoritmo/Técnica utilizada:
// - Não há uso de nenhum algoritmo de ordenação (sort), pois o problema é de avaliação de expressão, não de ordenação.
// - Utiliza a técnica de avaliação de expressões em Notação Polonesa Reversa (RPN), que explora a estrutura de dados PILHA para gerenciar operandos e operadores.
// - Complexidade de tempo: O(n), onde n é o número de tokens, pois cada token é processado uma vez.
// - Complexidade de espaço: O(n), pelo uso da pilha para armazenar operandos.

// Estruturas de dados usadas:
// - Stack<Integer>: pilha LIFO (Last-In-First-Out) para armazenar os operandos inteiros durante a avaliação.
// - String[]: array para representar a sequência de tokens da expressão RPN.

// Observação:
// A segunda versão do código faz a mesma coisa que a primeira, mas de forma mais enxuta, usando chamadas diretas de pop e push para algumas operações.
