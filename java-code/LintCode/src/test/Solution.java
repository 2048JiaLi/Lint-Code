package test;

import java.util.Collections;
import java.util.Scanner;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/8/29 10:14
 */
public class Solution {
    public static int get_index(String[] points) {
        int[] x = new int[points.length];
        int[] y = new int[points.length];
        double xmean = 0, ymean = 0;

        for (int i=0; i<points.length; i++) {
            String[] res = points[i].split(",");
            x[i] = Integer.valueOf(res[0]);
            y[i] = Integer.valueOf(res[1]);
            xmean += x[i];
            ymean += y[i];
        }

        xmean /= points.length;
        ymean /= points.length;

        double min = Double.MAX_VALUE;
        int res = -1;
        for (int i =0; i<points.length; i++) {
            double tmp = (x[i] - xmean)*(x[i] - xmean) + (y[i] - ymean)*(y[i] - ymean);
            if (tmp < min) {
                res = i;
                min = tmp;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        String[] tmp = new String[]{"1,1", "2,2", "1,2","1,3"};
        System.out.println(get_index(tmp));

//        String[] tmp;
//        while(scanner.hasNext()){
//            String s = scanner.nextLine();
//        }

    }

    public static String triCoding(int num) {
        StringBuffer res = new StringBuffer();

        while (num/3 != 0) {
            res.append(num%3);
            num = num/3;
        }
        if (num != 0) {
            res.append(num);
        }

        res.reverse();
        return res.toString();
    }

//    public static void main(String[] args) {
//        System.out.println(triCoding(11));
//    }
}
