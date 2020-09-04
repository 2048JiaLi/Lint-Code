package LinkedList.Problem167.AddTwoNumber;

import LinkedList.ListNode;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/6/19 14:57
 *
 * You have two numbers represented by a linked list,
 * where each node contains a single digit.
 * The digits are stored in reverse order,
 * such that the 1's digit is at the head of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list.
 *
 * Example
 * Example 1:
 *
 * Input: 7->1->6->null, 5->9->2->null
 * Output: 2->1->9->null
 * Explanation: 617 + 295 = 912, 912 to list:  2->1->9->null
 * Example 2:
 *
 * Input:  3->1->5->null, 5->9->2->null
 * Output: 8->0->8->null
 * Explanation: 513 + 295 = 808, 808 to list: 8->0->8->null
 */
public class AddTwoNumber {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2
     */
    public static ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode head = new ListNode(0), cur = head;
        int carry = 0;
        while (l1 != null || l2 != null){
            int tmp = fun(l1,l2) + carry;

            //cur.val = (tmp + carry) % 10 ;
            cur.next = new ListNode((tmp)%10);
            cur = cur.next;
            carry = tmp / 10;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry != 0) {
            cur.next = new ListNode(carry);
        }

        return head.next;
    }

    private static int fun(ListNode node1, ListNode node2) {
        if (node1 == null) {return node2.val;}
        if (node2 == null) {return node1.val;}
        return node1.val+node2.val;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        //l2.next = new ListNode(9);

        addLists(l1,l2).traverse();
    }
}
