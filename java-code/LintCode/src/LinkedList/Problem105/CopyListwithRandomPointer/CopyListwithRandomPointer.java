package LinkedList.Problem105.CopyListwithRandomPointer;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/7 16:39
 */
public class CopyListwithRandomPointer {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public static RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        /**
         * 注意，该方法修改了原head链表的值
         */
        if (head == null) {
            return null;
        }
        RandomListNode newHead = new RandomListNode(head.label);
        int count = 0;
        head.label = count;

        // 第一遍遍历，依次建立next
        RandomListNode newtmp = newHead;
        RandomListNode oldtmp = head;
        while (oldtmp.next != null) {
            oldtmp = oldtmp.next;
            newtmp.next = new RandomListNode(oldtmp.label);
            newtmp = newtmp.next;

            oldtmp.label = count+1;
            count++;
        }

        // 第二遍遍历，建立random指针，根据count计数
        newtmp = newHead;
        oldtmp = head;
        while (oldtmp != null) {
            if (oldtmp.random == null) {newtmp.random = null;}
            else {
                int random = oldtmp.random.label;
                RandomListNode tmp;
                if (random >= oldtmp.label) {
                    tmp = newtmp;
                    for (int i=oldtmp.label; i<random; i++) {
                        tmp = tmp.next;
                    }
                } else {
                    tmp = newHead;
                    for (int i=0; i<random; i++) {
                        tmp = tmp.next;
                    }
                }

                newtmp.random = tmp;
            }

            newtmp = newtmp.next;
            oldtmp = oldtmp.next;
        }

        return newHead;
    }



}

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
}
