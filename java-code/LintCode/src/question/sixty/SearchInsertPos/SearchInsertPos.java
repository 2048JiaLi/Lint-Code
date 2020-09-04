package question.sixty.SearchInsertPos;

/**
 * @author Li W
 * @version 1.0
 * @date 2020/6/5 16:00
 *
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You may assume NO duplicates in the array.
 *
 * Example
 * [1,3,5,6], 5 → 2
 *
 * [1,3,5,6], 2 → 1
 *
 * [1,3,5,6], 7 → 4
 *
 * [1,3,5,6], 0 → 0
 */
public class SearchInsertPos {
    /**
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: An integer
     */
    public static int searchInsert(int[] A, int target) {
        // write your code here
        int left = 0, right = A.length-1;
        int res = 0;
        while (left<=right){
            int mid = (left+right)/2;
            if (A[mid]>target){
                right = mid-1;
                res = mid;
            } else if (A[mid]<target){
                left = mid+1;
                res = left;
            } else {
                return mid;
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[] A = {1,3,5,6};
        System.out.println(searchInsert(A,0));
    }
}
