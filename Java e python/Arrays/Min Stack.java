class MinStack {
    /*
    // Primeira implementação (comentada) utilizando duas pilhas:
    // ----------------------------------------------------------
    // Essa implementação utiliza duas pilhas da biblioteca Java:
    // 1. "stack": Armazena todos os elementos inseridos.
    // 2. "minStack": Mantém, de forma sincronizada, o menor valor até o momento.
    // 
    // Quando um novo valor é inserido (push), o valor é adicionado à pilha "stack".
    // Se a "minStack" estiver vazia ou se o novo valor for menor ou igual ao topo 
    // da "minStack", então esse valor também é inserido na "minStack".
    // 
    // Ao remover um elemento (pop), se o elemento removido for igual ao topo da "minStack",
    // este também é removido de "minStack", garantindo que o topo de "minStack" seja o mínimo
    // dos valores restantes.
    //
    // Essa técnica não envolve nenhum algoritmo de ordenação ("sort"), mas sim o uso
    // de duas pilhas para manter acesso constante (O(1)) ao valor mínimo.
    //
    // Estruturas de dados usadas:
    // - Stack<Integer> para armazenar os valores dos elementos.
    // - Stack<Integer> auxiliar para armazenar os mínimos atuais.
    //
    // public MinStack() {
    //     stack = new Stack<>();
    //     minStack = new Stack<>();
    // }
    // 
    // public void push(int val) {
    //     stack.push(val);
    //     // Se a minStack estiver vazia ou o valor atual for menor ou igual que
    //     // o mínimo atual (topo da minStack), insere-o na minStack.
    //     if (minStack.isEmpty() || val <= minStack.peek()) {
    //         minStack.push(val);
    //     }
    // }
    // 
    // public void pop() {
    //     int removed = stack.pop();
    //     // Se o valor removido for o mesmo que o mínimo atual, remova-o também da minStack.
    //     if (removed == minStack.peek()) {
    //         minStack.pop();
    //     }
    // }
    // 
    // public int top() {
    //     return stack.peek();
    // }
    // 
    // public int getMin() {
    //     return minStack.peek();
    // }
    */

    // Segunda implementação utilizando uma lista encadeada personalizada para representar a pilha.
    // ---------------------------------------------------------------------------------------------
    
    // Definição de uma classe interna estática para representar cada nó da pilha.
    // Cada nó contém:
    // - 'val': o valor armazenado.
    // - 'currentMin': o menor valor da pilha até o ponto em que esse nó foi inserido.
    // - 'next': referência para o próximo nó na pilha (estrutura encadeada).
    private static class Node {
        int val;
        int currentMin;
        Node next;
        
        // Construtor do Node.
        // Recebe o valor, o mínimo atual e o próximo nó.
        Node(int val, int currentMin, Node next) {
            this.val = val;
            this.currentMin = currentMin;
            this.next = next;
        }
    }
    
    // O topo da pilha é representado pelo nó "head".
    private Node head;
    
    // Construtor da classe MinStack.
    // Inicializa a pilha com "head" nulo, ou seja, uma pilha vazia.
    public MinStack() {
        head = null;
    }
    
    // Método para empilhar um novo valor (push).
    // Cria um novo nó que passa a ser o novo topo da pilha.
    // O novo nó armazena:
    // - O valor inserido.
    // - O menor valor entre o valor inserido e o mínimo armazenado no nó anterior (head),
    //   utilizando a função Math.min.
    public void push(int val) {
        if (head == null) {
            // Se a pilha estiver vazia, o próprio valor é o mínimo.
            head = new Node(val, val, null);
        } else {
            // Se a pilha não está vazia, calcula o novo mínimo comparando o valor inserido
            // com o mínimo atual (head.currentMin).
            int currentMin = Math.min(val, head.currentMin);
            // Cria um novo nó, cujo próximo nó será o nó atual "head".
            head = new Node(val, currentMin, head);
        }
    }
    
    // Método para desempilhar (pop) o elemento do topo.
    // A operação é realizada movendo a referência "head" para o próximo nó na pilha.
    public void pop() {
        head = head.next;
    }
    
    // Método que retorna o valor do elemento no topo da pilha.
    public int top() {
        return head.val;
    }
    
    // Método que retorna o menor valor da pilha.
    // Como cada nó armazena o mínimo da pilha até o seu nível, basta acessar 'head.currentMin'.
    public int getMin() {
        return head.currentMin;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
