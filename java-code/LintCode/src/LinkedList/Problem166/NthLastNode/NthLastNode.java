package LinkedList.Problem166.NthLastNode;

import LinkedList.ListNode;

import java.util.List;

/**
 * @author Li W
 * @version 1.0
 * @date 2020/6/19 14:34
 */
public class NthLastNode {
    /*
     * @param head: The first node of linked list.
     * @param n: An integer
     * @return: Nth to last node of a singly linked list.
     */

    // 双指针：fast先运行到第n个位置
    // slow从0开始，与fast一切增加，当fast到末尾时，slow就是倒数第n个
    public static ListNode nthToLast(ListNode head, int n) {
        // write your code here
        int pos = 0;
        ListNode fast = head;

        while (fast != null) {
            fast = fast.next;
            pos ++;
            if (pos == n) {break;}
        }

        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        System.out.println(nthToLast(head,1).val);
    }
}
