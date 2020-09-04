package LinkedList.LC102.linked.list.cycle;

import LinkedList.ListNode;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/16 15:14
 *
 * Given a linked list, determine if it has a cycle in it.
 */
public class CycleList {
    /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {
        // write your code here
        /**
         * 快慢指针
         */
        ListNode slow, fast;
        slow = fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true; // 有环
            }
        }
        return false;
    }
}
