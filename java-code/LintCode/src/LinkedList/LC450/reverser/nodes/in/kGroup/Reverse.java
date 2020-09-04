package LinkedList.LC450.reverser.nodes.in.kGroup;

import LinkedList.ListNode;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/20 15:36
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 *
 * Example
 * Example 1
 *
 * Input:
 * list = 1->2->3->4->5->null
 * k = 2
 * Output:
 * 2->1->4->3->5
 * Example 2
 *
 * Input:
 * list = 1->2->3->4->5->null
 * k = 3
 * Output:
 * 3->2->1->4->5
 */
public class Reverse {

    /**
     * @param head: a ListNode
     * @param k: An integer
     * @return: a ListNode
     *
     * > 详解https://mp.weixin.qq.com/s/YOz66mJchVIEQjA7TBV2cg
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        // write your code here
        if (head == null || head.next == null || k<=1) {return head;}

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode point = dummy;

        while (point != null) {
            // 记录上一个子链表的尾节点
            ListNode last = point;

            int i = 0;
            while (i<k && point!=null){
                point = point.next;
                i++;
            }

            if (i == k && point != null) { // point.next空指针异常
                // 翻转
                ListNode nextGroup = point.next; // 下一个组的头节点

                // 当前链表翻转
                ListNode reversed = resverseList(last.next, nextGroup);

                point = last.next;
                last.next = reversed;
                point.next = nextGroup;
            }
        }
        return dummy.next;
    }

    public static ListNode resverseList(ListNode head, ListNode tail) {
        // 单链表翻转
        if (head == null || head.next == null) {return head;}

        ListNode prev = null;
        while (head!=null && head!=tail) {
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(2);
        head.next = node;
        ListNode tail = new ListNode(3);
        node.next = tail;
        //resverseList(head,tail);
        reverseKGroup(head,2);
    }
}
