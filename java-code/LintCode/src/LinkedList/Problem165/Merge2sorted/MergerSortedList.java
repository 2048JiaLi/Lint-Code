package LinkedList.Problem165.Merge2sorted;

/**
 * @author Li W
 * @version 1.0
 * @date 2020/6/18 16:33
 *
 * Merge two sorted (ascending) linked lists and return it as a new sorted list.
 * The new sorted list should be made by splicing together the nodes of
 * the two lists and sorted in ascending order.
 *
 * Example
 * Example 1:
 * 	Input: list1 = null, list2 = 0->3->3->null
 * 	Output: 0->3->3->null
 *
 *
 * Example 2:
 * 	Input:  list1 =  1->3->8->11->15->null, list2 = 2->null
 * 	Output: 1->2->3->8->11->15->null
 */
public class MergerSortedList {
    /**
     * @param l1: ListNode l1 is the head of the linked list
     * @param l2: ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        // write your code here
        if (l1 == null) {return l2;}

        // 保证l1的头节点是最小的
        if (l2 != null && l2.val < l1.val) {
            ListNode after = l2.next;

            l2.next = l1;
            l1 = l2;
            l2 = after;
        }

        ListNode cur1 = l1;
        while (cur1 != null && l2 != null) {

            if (cur1.next == null) {
                cur1.next = l2;
                break;
            } else {

                if (cur1.val <= l2.val && cur1.next.val >= l2.val) {
                    ListNode after = l2.next;
                    l2.next = cur1.next;
                    cur1.next = l2;

                    l2 = after;
                }
            }

            cur1 = cur1.next;

        }
        return l1;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(19);
        l1.next = new ListNode(23);
        ListNode l2 = new ListNode(7);
        l2.next = new ListNode(9);

        l1 = mergeTwoLists(l1,l2);
        traverse(l1);
    }

    private static void traverse(ListNode list) {
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
        val = x;
        next = null;
        }
    }
}
