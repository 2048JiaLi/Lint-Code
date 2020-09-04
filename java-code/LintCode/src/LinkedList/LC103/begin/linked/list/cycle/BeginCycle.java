package LinkedList.LC103.begin.linked.list.cycle;

import LinkedList.ListNode;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/16 15:19
 *
 * Given a linked list, return the node where the cycle begins.
 *
 * If there is no cycle, return null.
 */
public class BeginCycle {
    /**
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins. if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {
        // write your code here
        /**
         * 快慢指针
         */
        if(head == null || head.next == null) {return null;}
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) { // 有环，开始判断环的起点位置
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }
        return null;
    }
}
