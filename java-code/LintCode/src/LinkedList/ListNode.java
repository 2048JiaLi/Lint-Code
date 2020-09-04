package LinkedList;

/**
 * @author Li W
 * @version 1.0
 * @date 2020/6/19 14:35
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
        next = null;
    }

    public void traverse() {
        ListNode list = this;
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }
}
