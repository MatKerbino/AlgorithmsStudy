class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}

public class TechniquesLinked {

    /**
     * Remove o n-ésimo nó a partir do fim usando dummy e dois ponteiros.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        // avança fast n+1 vezes
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        // avança até fast == null
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // desconecta o nó alvo
        slow.next = slow.next.next;
        return dummy.next;
    }
}
