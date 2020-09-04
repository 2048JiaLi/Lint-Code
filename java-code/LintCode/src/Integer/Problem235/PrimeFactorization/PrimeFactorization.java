package Integer.Problem235.PrimeFactorization;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/9 16:50
 */
public class PrimeFactorization {
    /**
     * @param num: An integer
     * @return: an integer array
     */
    public static List<Integer> primeFactorization(int num) {
        // write your code here
        List<Integer> resList = new ArrayList<>();

        for (int i=2; i*i<=num; i++) {
            while (num%i == 0) {
                resList.add(i);
                num /= i;
            }
        }

        if (num != 1) {
            resList.add(num);
        }
        return resList;
    }

    public static void main(String[] args) {
        System.out.println(primeFactorization(660));
    }
}
