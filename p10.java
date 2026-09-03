public public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // moves 1 step forward
            fast = fast.next.next;     // moves 2 steps forward

            if (slow == fast) {
                return true;          // pointers met, cycle exists
            }
        }

        return false;                  // fast reached the end, no cycle
    }
} p10 {
    
}
