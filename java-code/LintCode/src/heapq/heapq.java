package heapq;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Li W
 * @version 1.0
 * @date 2020/6/9 14:04
 *
 * python heapq
 *
 * Heaps are arrays for which a[k] <= a[2*k+1] and a[k] <= a[2*k+2] for
 * all k, counting elements from 0.  For the sake of comparison,
 * non-existing elements are considered to be infinite.  The interesting
 * property of a heap is that a[0] is always its smallest element.
 *
 *PS: heapq并不是小顶堆（右子树大于左子树），它只是满足a[k] <= a[2*k+1] and a[k] <= a[2*k+2] for
 * all k
 *
 * Usage:
 *
 * List<Integer> heap = new LinkedList<>()      # creates an empty heap
 * heappush(heap, item)                         # pushes a new item on the heap
 * item = heappop(heap)                         # pops the smallest item from the heap
 * item = heap.get(0)                           # smallest item on the heap without popping it
 * heapify(x)                                   # transforms stack into a heap, in-place, in linear time
 * item = heapreplace(heap, item)               # pops and returns smallest item, and adds
 *                                              # new item; the heap size is unchanged
 */
public class heapq {
    //private Stack<Integer> heap;
    public static void heappush(List<Integer> heap, int item){
        heap.add(item);
        siftdown(heap,0,heap.size()-1);
    }

    public static Integer heappop(List<Integer> heap){
        int lastElement = heap.get(heap.size()-1);
        heap.remove(heap.size()-1);
        if (!heap.isEmpty()){
            int returnItem = heap.get(0);
            heap.set(0,lastElement);
            siftup(heap,0);
            return returnItem;
        }
        return lastElement;
    }

    public static Integer heapreplace(List<Integer> heap, int item){
        /**Pop and return the current smallest value, and add the new item.
         *
         * This is more efficient than heappop() followed by heappush(), and can be
         * more appropriate when using a fixed-size heap.  Note that the value
         * returned may be larger than item!  That constrains reasonable uses of
         * this routine unless written as part of a conditional replacement:
         *
         *     if item > heap[0]:
         *         item = heapreplace(heap, item)
         */
        int returnItem = heap.get(0);
        heap.set(0,item);
        siftup(heap,0);
        return returnItem;
    }

    public static Integer heappushpop(List<Integer> heap, int item){
        // Fast version of a heappush followed by a heappop.
        if (!heap.isEmpty() && heap.get(0)<item){
            int tmp = item;
            item = heap.get(0);
            heap.set(0,tmp);
            siftup(heap,0);
        }
        return item; //已替换为heap[0]
    }

    public static void heapify(List<Integer> heap){
        /**Transform stack into a heap, in-place, in O(len(x)) time.
         *
         * Transform bottom-up.  The largest index there's any point to looking at
         * is the largest with a child index in-range, so must have 2*i + 1 < n,
         * or i < (n-1)/2.  If n is even = 2*j, this is (2*j-1)/2 = j-1/2 so
         * j-1 is the largest, which is n//2 - 1.  If n is odd = 2*j+1, this is
         * (2*j+1-1)/2 = j so j-1 is the largest, and that's again n//2-1.
         */
        int i = heap.size() / 2; //整数除法
        while (i>=0){
            siftup(heap,i--);
        }
    }

    /**
     * @param heap is a heap at all indices >= startpos, except possibly for pos.
     * @param startpos
     * @param pos is the index of a leaf with a possibly out-of-order value.
     */
    public static void siftdown(List<Integer> heap, int startpos, int pos){
        int newitem = heap.get(pos);

        // Follow the path to the root, moving parents down until finding a place
        // newitem fits.
        while (pos > startpos){
            int parentpos = (pos-1) >> 1;
            int parent = heap.get(parentpos);
            if (newitem<parent){
                heap.set(pos,parent);
                pos = parentpos;
                continue;
            }
            break;
        }
        heap.set(pos,newitem);
    }

    public static void siftup(List<Integer> heap, int pos){
        int endpos = heap.size();
        int startpos = pos;
        int newItem = heap.get(pos);
        // Bubble up the smaller child until hitting a leaf.
        int childpos = 2*pos + 1;
        while (childpos < endpos){
            //  Set childpos to index of smaller child.
            int rightpos = childpos + 1;
            if (rightpos < endpos && heap.get(childpos)>= heap.get(rightpos)){
                childpos = rightpos;
            }
            // # Move the smaller child up.
            heap.set(pos,heap.get(childpos));
            pos = childpos;
            childpos = 2*pos + 1;
        }
        // The leaf at pos is empty now.  Put newitem there, and bubble it up
        // to its final resting place (by sifting its parents down).
        heap.set(pos,newItem);
        siftdown(heap,startpos,pos);
    }

    public static void main(String[] args){
        List<Integer> heap = new LinkedList<>();
        int[] nums = {10,20,1,3,4,7,5,11,21};

        for (int i=0;i<nums.length;i++){
            //heappush(heap,nums[i]);
            heap.add(nums[i]);
        }
        heapify(heap);  //转换成一个heap

        System.out.print(heap+" ");
        while (!heap.isEmpty()){
            System.out.print(heappop(heap)+" ");
        }
    }
}
