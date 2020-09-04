package question.Problem156.MergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import sort.QuickSort;

/**
 * @author Li W
 * @version 1.0
 * @date 2020/6/17 15:06
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example
 * Example 1:
 *
 * Input: [(1,3)]
 * Output: [(1,3)]
 * Example 2:
 *
 * Input:  [(1,3),(2,6),(8,10),(15,18)]
 * Output: [(1,6),(8,10),(15,18)]
 * Challenge
 * O(n log n) time and O(1) extra space.
 */
public class MergeInterval {
    /**
     * @param intervals: interval list.
     * @return: A new interval list.
     */
    public static List<Interval> merge(List<Interval> intervals) {
        // write your code here
        if (intervals.size() <= 1) {return intervals;}
        //Collections.sort(intervals);

        // Comparator.comparing底层实现的就是compareTo方法
        intervals.sort(Comparator.comparing(i->i.start)); // i -> i.start  lambda表达式语法

        int pos = 1;
        while (pos < intervals.size()) {
            int curLow = intervals.get(pos).start, curHigh = intervals.get(pos).end;
            int preLow = intervals.get(pos-1).start, preHigh = intervals.get(pos-1).end;

            if (curLow <= preHigh) {
                // 需要合并
                intervals.get(pos-1).start = Math.min(preLow,curLow);
                intervals.get(pos-1).end = Math.max(preHigh,curHigh);
                intervals.remove(pos);
            } else {
                pos++;
            }
        }
        return intervals;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(15,18));

        //intervals.add(new Interval(2,6));
        //intervals.add(new Interval(8,10));
        intervals = merge(intervals);
        for (int i=0; i<intervals.size(); i++) {
            System.out.println(intervals.get(i).start +" "+ intervals.get(i).end);
        }
    }

    private static class Interval implements Comparable<Interval>{
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        // 覆盖compareTo方法从而使用Collections.sort排序
        @Override
        public int compareTo(Interval o) {
            if (o.start > this.start) {
                return -1;
            } else if (o.start < this.start) {
                return 1;
            }
            return 0;
        }
    }
}
