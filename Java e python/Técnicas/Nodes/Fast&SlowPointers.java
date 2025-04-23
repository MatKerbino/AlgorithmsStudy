// definição do nó de lista
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}

public class TechniquesLinked {

    /**
     * Detecta ciclo usando Floyd’s Tortoise and Hare.
     * Slow avança 1, fast avança 2. Se se encontrarem, há ciclo.
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;           // avança 1
            fast = fast.next.next;      // avança 2
            if (slow == fast) {
                return true;            // encontro
            }
        }
        return false;                   // fast chegou ao fim
    }

    // exemplo de uso em um método main...
}
