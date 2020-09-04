package question.Problem544.TopkLargest;

/**
 * @author Li W
 * @version 1.0
 * @date 2020/6/8 19:11
 */

/**
 * Given an integer array, find the top k largest numbers in it.
 *
 * Example
 * Example1
 *
 * Input: [3, 10, 1000, -99, 4, 100] and k = 3
 * Output: [1000, 100, 10]
 * Example2
 *
 * Input: [8, 7, 6, 5, 4, 3, 2, 1] and k = 5
 * Output: [8, 7, 6, 5, 4]
 */
import sort.QuickSort;
import java.util.Arrays;
public class TopkLargest {
    /**
     * @param nums: an integer array
     * @param k: An integer
     * @return: the top k largest numbers in array
     */

    // 数组全部排序， 返回前k
    public static int[] topkGlobalordering(int[] nums, int k) {
        // write your code here
        QuickSort.QuickSort(nums,0,nums.length-1);
        int[] res = new int[k];
        for (int i=nums.length-1,j=0;i>nums.length-1-k;i--){
            res[j++] = nums[i];
        }
        return res;
    }

    //局部排序  --  将前k个冒泡出来
    public static int[] topkPartialordering(int[] nums, int k){
        int[] res = new int[k];
        for (int i=0;i<k;i++){
            for (int j=0;j<nums.length-i-1;j++){
                if (nums[j]>nums[j+1]){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
            res[i] = nums[nums.length-i-1];
        }
        return res;
    }

    //局部不排序，  --- 小顶堆存储k个最大值
    public static int[] topkHeapq(int[] nums, int k){
        int[] res = new int[k];
        for (int i=0; i<nums.length; i++){
            if (i < k){
                res[i] = nums[i];
                siftdown(res,0,i);
            } else {
                if (nums[i] > res[0]){
                    res[0] = nums[i];
                    siftup(res,0);
                }
            }
        }
        return res;
    }

    public static void siftdown(int[] nums, int startpos, int pos){
        int newitem = nums[pos];
        while (pos > startpos){
            int parentpos = (pos-1) >> 1;
            int parent = nums[parentpos];
            if (newitem<parent){
                nums[pos] = parent;
                pos = parentpos;
                continue;
            }
            break;
        }
        nums[pos] = newitem;
    }

    public static void siftup(int[] nums, int pos){
        int endpos = nums.length;
        int startpos = pos;
        int newItem = nums[pos];
        // Bubble up the smaller child until hitting a leaf.
        int childpos = 2*pos + 1;
        while (childpos < endpos){
            //  Set childpos to index of smaller child.
            int rightpos = childpos + 1;
            if (rightpos < endpos && nums[childpos] >= nums[rightpos]){
                childpos = rightpos;
            }
            // # Move the smaller child up.
            nums[pos] = nums[childpos];
            pos = childpos;
            childpos = 2*pos + 1;
        }
        // The leaf at pos is empty now.  Put newitem there, and bubble it up
        // to its final resting place (by sifting its parents down).
        nums[pos] = newItem;
        siftdown(nums,startpos,pos);
    }

    //sui 随机 + 快排 （快排位置=k时，即可结束返回） 该题中LintCode的结果是有序的，所以这个不通过
    public static int[] topkRandomQuick(int[] nums, int k){

        int low = 0, high = nums.length-1;
        nums = randomQuick(nums,0,high,k);
        int[] res = new int[k];
        for (int i=nums.length-1,j=0;i>nums.length-1-k;i--){
            res[j++] = nums[i];
        }
        return res;
    }

    public static int[] randomQuick(int[] nums, int low, int high, int k){
        if (low >= high){return nums;} // low == high

        int pos = QuickSort.partition(nums,low,high);
        int tmp = high-pos;
        if (tmp<k){
            return randomQuick(nums,low,pos-1,k-tmp-1);//求前半部分第k-pos小
        } else {
            return randomQuick(nums,pos+1,high,k);//求后半部分第k大
        }
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,8,9,10,7};
        int k = 5;

        //int[] res = topkGlobalordering(nums,5);
        //int[] res = topkPartialordering(nums,k);
        //int[] res = topkRandomQuick(nums,k);

        int[] res = topkHeapq(nums,k);
        for (int i:res){
            System.out.println(i);
        }
    }
}
