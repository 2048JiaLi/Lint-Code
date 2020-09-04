package LinkedList.lc756.multiply.two.number;

import LinkedList.ListNode;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/8/26 12:30
 */
public class MultiplyTwoNumbers {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the product list of l1 and l2
     */
    public long multiplyLists(ListNode l1, ListNode l2) {
        // write your code here
        return traverse(l1) * traverse(l2);
    }

    public long traverse(ListNode node) {
        /* 获得链表node表示的数 */
        long num = 0;
        while (node != null) {
            num *= 10;
            num += node.val;
            node = node.next;
        }
        return num;
    }

}
