package question.thirtyFive.ReverseLinkedList;

import java.util.List;

/**
 * @author Li W
 * @version 1.0
 * @date 2020/6/2 15:00
 */
public class reverseLinkedList {
    //Definition for ListNode
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode reverse(ListNode head) {
        // write your code here
        ListNode newhead = ReverseRecursive(head);
        return newhead;
    }

    public static ListNode ReverseRecursive(ListNode node){
        if (node == null || node.next == null){
            return node;
        }
        ListNode tmp = ReverseRecursive(node.next);
        node.next.next = node;
        node.next = null;
        return tmp;
    }

    public static void TraverseList(ListNode head){
        // 从头节点依次遍历输出链表
        ListNode cur = head;
        while (cur != null){
            System.out.print(cur.val);
            cur = cur.next;
        }
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(2);
        head.next = node;
        node.next = new ListNode(3);

        //TraverseList(head);
        head = reverse(head);
        TraverseList(head);
    }

}
