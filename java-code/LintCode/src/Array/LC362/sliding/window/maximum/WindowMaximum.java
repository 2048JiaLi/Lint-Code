package Array.LC362.sliding.window.maximum;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/21 10:51
 *
 * 给出一个可能包含重复的整数数组，和一个大小为 k 的滑动窗口,
 * 从左到右在数组中滑动这个窗口，找到数组中每个窗口内的最大值。
 *
 *
 * 输入:
 * [1,2,7,7,8]
 * 3
 * 输出:
 * [7,7,8]
 */
public class WindowMaximum {
    /**
     * @param nums: A list of integers.
     * @param k: An integer
     * @return: The maximum number inside the window at each moving.
     */
    public static List<Integer> maxSlidingWindow(int[] nums, int k) {
        //有点坑，题目里都说了数组不为空，且 k > 0。但是看了一下，测试用例里面还是有nums = [], k = 0，所以只好加上这个判断
        List<Integer> res = new ArrayList<>();

        //双端队列，在遍历nums数组过程中，在队列尾部添加，头部执行删除操作
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            //在尾部添加元素，并保证左边元素都比尾部大
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            //在头部移除元素
            if (deque.getFirst() == i - k) {    // 该队列元素大于k个，将头部移除
                deque.removeFirst();
            }
            //输出结果
            if (i >= k - 1) {
                res.add(nums[deque.getFirst()]);
            }
        }
        return res;
    }

    /*public static List<Integer> maxSlid(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();

        int[] queue = new int[k];
        int start = -1, end = 0;

        for (int i = 0; i < nums.length; i++) {
            //binarySearch()
        }
        return null;
    }

    public static int binarySearch(int[] queue, int start, int end, int num) {
        // 在以start为起点，end为终点（循环取模）的有序数组中，查找num插入的位置
        if (num < queue[end]) {
            return queue.length; //
        }

        int left = start, right = end;
        while (start < end) {
            int mid = (left+right)/2;
            if (queue[mid] > num) {
                start = mid+1;
            } else if (queue[mid] < num) {
                end = mid-1;
            } else {
                while (mid>=0 && queue[mid] == num) {
                    mid--;
                }
                return mid+1;
            }
        }
        return end;
    }*/

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(maxSlidingWindow(nums,3));
    }
}
