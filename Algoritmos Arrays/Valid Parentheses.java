class Solution {
    public boolean isValid(String s) {
        /*
        // ---------------------------------------------------------------
        // PRIMEIRA IMPLEMENTAÇÃO (Comentada, porém preservada como no prompt)
        // ---------------------------------------------------------------
        // Cria uma pilha para armazenar os parênteses de abertura encontrados
        Stack<Character> stack = new Stack<>();
        // Converte a String de entrada em um array de caracteres e itera sobre cada caractere
        for (char a : s.toCharArray()){
            // Se o caractere for um parêntese de abertura ('(', '{' ou '['), empilha-o
            if (a == '(' || a == '{' || a == '['){
                stack.push(a);
            } else {
                // Se o caractere for um parêntese de fechamento, verifica conforme seu tipo
                switch(a){
                    case ')': 
                        // Se a pilha estiver vazia ou o topo da pilha não for o correspondente '(', retorna falso
                        if (stack.isEmpty() || stack.pop() != '(') return false;
                        break;
                    case ']': 
                        // Se a pilha estiver vazia ou o topo da pilha não for o correspondente '[', retorna falso
                        if (stack.isEmpty() || stack.pop() != '[') return false;
                        break;
                    case '}': 
                        // Se a pilha estiver vazia ou o topo da pilha não for o correspondente '{', retorna falso
                        if (stack.isEmpty() || stack.pop() != '{') return false;
                        break;
                }
            }
        }
        // Se a pilha não estiver vazia após o processamento, significa que há aberturas sem fechamento
        if (!stack.isEmpty()) return false;
        // Se todas as aberturas foram devidamente fechadas, retorna verdadeiro
        return true;
        */

        // ---------------------------------------------------------------
        // SEGUNDA IMPLEMENTAÇÃO (Ativa) – Versão otimizada
        // ---------------------------------------------------------------
        
        // Cria uma pilha para armazenar os caracteres que devem ser encontrados posteriormente
        // para fechar os parênteses de abertura correspondentes.
        Stack<Character> stack = new Stack();
        
        // Converte a String de entrada para um array de caracteres e itera sobre cada caractere
        for (char ch : s.toCharArray()) {
            // Utiliza um switch para tratar os tipos de parênteses
            switch (ch) {
                // Caso o caractere seja '(':
                // Empilha o caractere de fechamento esperado: ')'
                case '(':  
                    stack.push(')');
                    break;
                // Caso o caractere seja '{':
                // Empilha o caractere de fechamento esperado: '}'
                case '{': 
                    stack.push('}');
                    break;
                // Caso o caractere seja '[':
                // Empilha o caractere de fechamento esperado: ']'
                case '[': 
                    stack.push(']');
                    break;
                // Se o caractere não for de abertura, supõe-se que seja um caractere de fechamento
                default: 
                    // Verifica se a pilha está vazia ou se o caractere de fechamento atual não é igual
                    // ao esperado (que está no topo da pilha). Se algum destes casos for verdadeiro, a
                    // sequência de parênteses não é válida.
                    if (stack.isEmpty() || ch != stack.pop()) {
                        return false;
                    }
            }
        }
        // Se a pilha estiver vazia ao final do laço, todos os parênteses foram fechados corretamente.
        // Caso contrário, existem aberturas sem seus fechamentos correspondentes.
        return stack.isEmpty();
    }
}
