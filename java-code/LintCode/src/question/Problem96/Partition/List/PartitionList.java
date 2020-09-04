package question.Problem96.Partition.List;

/**
 * @author Li W
 * @version 1.0
 * @date 2020/6/13 12:59
 *
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example
 * Example 1:
 *
 * Input:  list = null, x = 0
 * Output: null
 * Explanation: The empty list Satisfy the conditions by itself.
 * Example 2:
 *
 * Input:  list = 1->4->3->2->5->2->null, x = 3
 * Output: 1->2->2->4->3->5->null
 * Explanation:  keep the original relative order of the nodes in each of the two partitions.
 */
public class PartitionList {
    /**
     * @param head: The first node of linked list
     * @param x: An integer
     * @return: A ListNode
     */

    // 递归思想： 返回节点
    // 若出现node.val >= x的情况，则往后依次遍历找到第一个比x的位置之前插入node
    public static ListNode partition(ListNode head, int x){
        if (head == null ){ return null; }

        ListNode tmp = partition(head.next,x);

        if (head.val < x || tmp == null || tmp.val >= x){  // tmp == null 的判断必须在tmp.val之前
            head.next = tmp;
            return head;
        }

        ListNode cur = tmp;
        while (cur.next != null){
            if (cur.next.val >= x){break;}
            cur = cur.next;
        }

        head.next = cur.next;
        cur.next = head;
        return tmp;
    }

    public static void main(String[] args){
        //ListNode head = new ListNode(1);
        //ListNode head1 = new ListNode(4);
        //ListNode head2 = new ListNode(3);
        //ListNode head3 = new ListNode(2);
        //ListNode head4 = new ListNode(5);
        //ListNode head5 = new ListNode(2);
        //head.next = head1;
        //head1.next = head2;
        //head2.next = head3;
        //head3.next = head4;
        //head4.next = head5;
        ListNode head = new ListNode(1);

        head = partition(head,0);
        while (head!=null){
            System.out.print(head.val+"\t");
            head = head.next;
        }
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}
