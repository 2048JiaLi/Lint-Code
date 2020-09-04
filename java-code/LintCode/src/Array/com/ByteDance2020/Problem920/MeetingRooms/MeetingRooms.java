package Array.com.ByteDance2020.Problem920.MeetingRooms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/2 16:00
 *
 * Given an array of meeting time intervals consisting of
 * start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * determine if a person could attend all meetings.
 *
 * Example
 * Example1
 *
 * Input: intervals = [(0,30),(5,10),(15,20)]
 * Output: false
 * Explanation:
 * (0,30), (5,10) and (0,30),(15,20) will conflict
 * Example2
 *
 * Input: intervals = [(5,8),(9,15)]
 * Output: true
 * Explanation:
 * Two times will not conflict
 * Notice
 * (0,8),(8,10) is not conflict at 8
 */
public class MeetingRooms {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    public static boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        if (intervals.isEmpty()) {
            return true;
        }

        intervals.sort(Comparator.comparing(interval -> interval.start));
        boolean flag = true;

        for (int i=1; i<intervals.size(); i++) {
            if (intervals.get(i).start >= intervals.get(i-1).end) {
                continue;
            } else {
                flag = false;
                break;
            }
        }

        return flag;
    }

    public static int partition(List<Interval> intervals, int left, int right) {
        if (left == right) {return right;}

        Interval cur = intervals.get(left);

        while (left < right) {
            // 如果相交，直接return
            while (left < right && compareOf(cur,intervals.get(right))==-1) {
                right--;
            }
            if (compareOf(cur,intervals.get(right))==0 && left != right) {
                return -1;
            }

            if (left == right){
                break;
            }

            intervals.set(right,intervals.get(left));

            while (left < right && compareOf(cur,intervals.get(left))==1) {
                left++;
            }
            intervals.set(left,intervals.get(right));

            if (compareOf(cur,intervals.get(left))==0 && left != right) {
                return -1;
            }
        }

        intervals.set(right,intervals.get(left));
        return right;
    }


    public static boolean quickPartition(List<Interval> intervals) {
        int pos = partition(intervals,0,intervals.size()-1);


        if (pos == -1) {
            return false;
        } else {
            if (pos-1 > 0){
                partition(intervals,0,pos-1);
            }
            if (pos+1 < intervals.size()-1) {
                partition(intervals,pos+1,intervals.size()-1);
            }
        }
        return true;
    }

    public static int compareOf (Interval a, Interval b) {
        // 如果相交，直接false
        if (a.start < b.start) {
            if (a.end > b.start) {return 0;}
            return -1;
        } else if (a.start > b.start)  {
            if (b.end > a.start) {return 0;}
            return 1;
        }
        return 0;
    }


    private static class Interval {
        int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(2,4));
        intervals.add(new Interval(6,7));
        intervals.add(new Interval(7,8));

        quickPartition(intervals);
    }
}
