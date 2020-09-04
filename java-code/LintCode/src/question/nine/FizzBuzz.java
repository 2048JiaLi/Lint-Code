package question.nine;

/**
 * @author Li W
 * @version 1.0
 * @date 2020/6/1 16:46
 */

/**
 * Given number n. Print number from 1 to n. But:
 *
 * when number is divided by 3, print "fizz".
 * when number is divided by 5, print "buzz".
 * when number is divided by both 3 and 5, print "fizz buzz".
 * when number can't be divided by either 3 or 5, print the number itself.
 */
import java.util.List;
import java.util.ArrayList;
public class FizzBuzz {
    /**
     * @param n: An integer
     * @return: A list of strings.
     */
    // if条件三元组的使用
    public static List<String> fizzBuzz(int n) {
        // write your code here
        List<String> list = new ArrayList<>();
        for (int i=1;i<=n;i++){
            list.add((i%3==0 && i%5==0)? "fizz buzz": (i%3==0?"fizz":(i%5==0?"buzz":""+i)));
        }
        return list;
    }

    public static void main(String[] args){
        List<String> list = fizzBuzz(15);
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
