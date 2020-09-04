package String.Problem830.StringSort;

import java.util.*;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/9 17:47
 */
public class StringSort {
    /**
     * @param str: the string that needs to be sorted
     * @return: sorted string
     */
    public static String stringSort(String str) {
        // Write your code here
        List<MyCompator> list = new ArrayList<>();
        int[] map = new int[26];
        for (int i=0; i<str.length(); i++) {
            int tmp = str.charAt(i)-'a';
            if (map[tmp]>0) {
                list.get(map[tmp]-1).freq += 1;
            } else {
                list.add(new MyCompator(str.charAt(i),1));
                map[tmp] = list.size();
            }
        }
        list.sort(MyCompator::compareTo);
        char[] res = new char[str.length()];
        int pos = 0;
        for (int i=0; i<list.size(); i++) {
            while (list.get(i).freq > 0) {
                res[pos++] = list.get(i).label;
                list.get(i).freq--;
            }
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        System.out.println(stringSort("bloomberg"));
    }
}

class MyCompator implements Comparable<MyCompator>{
    char label;
    int freq;

    public MyCompator(char label, int freq) {
        this.label = label;
        this.freq = freq;
    }

    @Override
    public int compareTo(MyCompator o) {
        if (o.freq > this.freq) {
            return 1;
        } else if (o.freq < this.freq) {
            return -1;
        } else {
            if (o.label > this.label) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
