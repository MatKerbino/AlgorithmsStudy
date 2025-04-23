class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}

public class ReverseLinked {

    /**
     * Inverte nós em grupos de k.
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode groupPrev = dummy;

        while (true) {
            // 1) verifica k nós à frente
            ListNode kth = groupPrev;
            for (int i = 0; i < k; i++) {
                kth = kth.next;
                if (kth == null) {
                    return dummy.next;
                }
            }
            ListNode groupNext = kth.next;

            // 2) inverte o grupo
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;
            for (int i = 0; i < k; i++) {
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }

            // 3) reconecta
            ListNode tmp = groupPrev.next;
            groupPrev.next = prev;
            groupPrev = tmp;
        }
    }
}
