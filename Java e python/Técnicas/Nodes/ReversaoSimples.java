// definição do nó de lista
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}

public class ReverseLinked {
    /**
     * Reverte uma lista simplesmente ligada.
     * prev acumula a parte invertida, curr percorre a lista.
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;      // parte invertida
        ListNode curr = head;      // percorre a lista

        while (curr != null) {
            ListNode nxt = curr.next; // guarda próximo
            curr.next = prev;         // inverte ponteiro
            // avança ponteiros
            prev = curr;
            curr = nxt;
        }
        // prev agora é o novo head
        return prev;
    }
}
