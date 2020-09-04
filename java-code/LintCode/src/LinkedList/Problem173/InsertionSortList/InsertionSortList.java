package LinkedList.Problem173.InsertionSortList;

import LinkedList.ListNode;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/6/21 15:24
 *
 * 使用插入排序，对链表进行排序
 *
 * Example 1:
 * 	Input: 0->null
 * 	Output: 0->null
 *
 *
 * Example 2:
 * 	Input:  1->3->2->0->null
 * 	Output :0->1->2->3->null
 */

public class InsertionSortList {
    /**
     * @param head: The first node of linked list.
     * @return: The head of linked list.
     */
    public static ListNode insertionSortList(ListNode head) {
        // write your code here
        if (head == null) {return head;}

        ListNode cur = head.next;
        head.next = null;
        while (cur != null) {
            ListNode node = new ListNode(cur.val);
            head = insertNode(head,node);
            cur = cur.next;
        }
        return head;
    }

    public static ListNode insertNode(ListNode head, ListNode node) {
        ListNode cur = head;

        if (node.val <= head.val) {
            head = node;
            head.next = cur;
            return head;
        }

        while (cur.next != null) {
            if (cur.next.val >= node.val ) {
                node.next = cur.next;
                cur.next = node;
                return head;
            } else {
                cur = cur.next;
            }
        }
        cur.next = node;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node = new ListNode(2);
        head.next = node;
        node.next = new ListNode(4);

        head = insertionSortList(head);
        head.traverse();
    }
}
