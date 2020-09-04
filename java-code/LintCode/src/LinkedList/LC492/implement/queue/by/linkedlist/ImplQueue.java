package LinkedList.LC492.implement.queue.by.linkedlist;

import LinkedList.ListNode;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/16 15:35
 *
 * Implement a Queue by linked list. Support the following basic methods:
 *
 * enqueue(item). Put a new item in the queue.
 * dequeue(). Move the first item out of the queue, return it.
 * Example
 * Example 1:
 *
 * Input:
 * enqueue(1)
 * enqueue(2)
 * enqueue(3)
 * dequeue() // return 1
 * enqueue(4)
 * dequeue() // return 2
 * Example 2:
 *
 * Input:
 * enqueue(10)
 * dequeue()// return 10
 */
public class ImplQueue {
    private ListNode head;
    private ListNode tail;

    /*
     * @param item: An integer
     * @return: nothing
     */
    public void enqueue(int item) {
        // write your code here
        if (head == null) {
            head = new ListNode(item);
            tail = head;
        } else {
            tail.next = new ListNode(item);
            tail = tail.next;
        }
    }

    /*
     * @return: An integer
     */
    public int dequeue() {
        // write your code here
        if (head != null) {
            int res = head.val;
            head = head.next;
            return res;
        }
        return Integer.MIN_VALUE;
    }
}
