package LinkedList.lc1371.linked.list.component;

import LinkedList.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/29 14:35
 *
 * We are given head, the head node of a linked list containing unique integer values.
 *
 * We are also given the list G, a subset of the values in the linked list.
 *
 * Return the number of connected components in G, where two values are connected
 * if they appear consecutively(the longest) in the linked list.
 *
 * If N is the length of the linked list given by head, 1 \leq N \leq 100001≤N≤10000.
 * The value of each node in the linked list will be in the range[0, N - 1].
 * 1 \leq G.length \leq 100001≤G.length≤10000.
 * G is a subset of all values in the linked list.
 *
 * Example
 * Example 1:
 *
 * Input: head = 0->1->2->3, G = [0, 1, 3]
 * Output: 2
 * Explanation:
 * 0 and 1 are connected, so [0, 1] and [3] are the two connected components.
 * Example 2:
 *
 * Input: head = 0->1->2->3->4, G = [0, 3, 1, 4]
 * Output: 2
 * Explanation:
 * 0 and 1 are connected, 3 and 4 are connected,
 * so [0, 1] and [3, 4] are the two connected components.
 */
public class LinkedListComponents {
    /**
     * @param head: the head
     * @param G: an array
     * @return: the number of connected components in G
     */
    public static int numComponents(ListNode head, int[] G) {
        // Write your code here
        // 记录结果，有多少个是connected components
        int res = 0;

        // G数组中的元素位置，G是无序的子集
        Set<Integer> setG = new HashSet<>();
        for (int i: G) {
            setG.add(i);
        }

        // 遍历链表
        ListNode curNode = head;
        while (curNode != null) {
            if (setG.contains(curNode.val)) {
                while (curNode != null && setG.contains(curNode.val)) {
                    curNode = curNode.next;
                }
                res++;
            } else {
                curNode = curNode.next;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode l1 = new ListNode(1);
        head.next = l1;
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        ListNode l3 = new ListNode(3);
        l2.next = l3;
        ListNode l4 = new ListNode(4);
        l3.next = l4;

        System.out.println(numComponents(head, new int[]{0, 3, 1, 4}));
    }
}
