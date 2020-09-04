package LinkedList.LC1609.middle.linked.list;

import LinkedList.ListNode;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/16 15:31
 *
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 *
 * If there are two middle nodes, return the second middle node.
 */
public class MiddleOfList {
    /**
     * @param head: the head node
     * @return: the middle node
     */
    public ListNode middleNode(ListNode head) {
        // write your code here.
        ListNode slow, fast;
        slow = fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
