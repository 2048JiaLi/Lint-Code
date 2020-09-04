package LinkedList.Problem174.RemoveNthNode;

import LinkedList.ListNode;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/6/21 16:07
 *
 * 给定一个链表，删除链表中倒数第n个节点，返回链表的头节点。
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
 * Example
 * Example 1:
 * 	Input: list = 1->2->3->4->5->null， n = 2
 * 	Output: 1->2->3->5->null
 *
 *
 * Example 2:
 * 	Input:  list = 5->4->3->2->1->null, n = 2
 * 	Output: 5->4->3->1->null
 *
 * Challenge
 * Can you do it without getting the length of the linked list?
 *
 * Notice
 * The minimum number of nodes in list is n.
 */
public class RemoveNthNode {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer
     * @return: The head of linked list.
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        int pos = 1;
        ListNode fast = head;
        while (pos <= n+1 && fast != null) {
            fast = fast.next;
            pos++;
        }

        if (fast == null) { // 头节点就是要删除的节点
            return head.next;
        }

        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        if (slow.next != null) { // 若n = 0，不需要删除
            slow.next = slow.next.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node = new ListNode(2);
        head.next = node;
        node.next = new ListNode(4);
        head = removeNthFromEnd(head,0);

        head.traverse();
    }
}
