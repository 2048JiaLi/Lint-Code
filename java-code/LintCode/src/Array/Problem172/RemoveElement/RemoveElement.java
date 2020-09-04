package Array.Problem172.RemoveElement;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/6/21 14:56
 *
 * Given an array and a value, remove all occurrences of that value in place and return the new length.
 *
 * The order of elements can be changed, and the elements after the new length don't matter.
 *
 * Example
 * Example 1:
 * 	Input: [], value = 0
 * 	Output: 0
 *
 *
 * Example 2:
 * 	Input:  [0,4,4,0,0,2,4,4], value = 4
 * 	Output: 4
 *
 * 	Explanation:
 * 	the array after remove is [0,0,0,2]
 */
public class RemoveElement {
    /*
     * @param A: A list of integers
     * @param elem: An integer
     * @return: The new length after remove
     */
    public static int removeElement(int[] A, int elem) {
        // write your code here
        /**
         *从后往前遍历数组，若遇到匹配值，则与size位置交换，size--;
         */
        if (A.length == 0) {return 0;}

        int size = A.length;
        for (int i=size-1; i>=0; i--) {
            if (A[i] == elem) {
                size--;
                A[i] = A[size];
                //swap(A[i],A[size--]);
            }
        }
        return size;
    }



    public static int doublePointRemove(int[] A, int elem) {
        int cur = 0;
        int size = A.length;
        while (cur < size){
            if (A[cur] == elem) {
                A[cur] = A[--size];
            } else {
                cur ++;
            }
        }

        return size;
    }

    public static void main(String[] args) {
        int[] A = {2};
        int size = doublePointRemove(A,4);
        System.out.println("size = " + size);

        for (int i:A){
            System.out.println(i);
        }

    }
}
