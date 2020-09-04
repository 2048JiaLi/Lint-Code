package String.Problem250.SpecialPalindromeString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/12 15:24
 */
public class Test {
    public static void main(String[] args) {
        List<String> ambigram = new ArrayList<>();
        ambigram.add("at");
        ambigram.add("by");
        ambigram.add("yh");
        ambigram.add("hn");ambigram.add("mw");
        ambigram.add("ww");

        String word="hob";

        SpecialPalindrome sp = new SpecialPalindrome();

        System.out.println(sp.ispalindrome(ambigram, word));
    }
}
