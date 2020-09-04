package question.fifthFive.compareStrings;

/**
 * @author Li W
 * @version 1.0
 * @date 2020/6/4 16:23
 */


/**
 * Compare two strings A and B, determine whether A contains all of the characters in B.
 *
 * The characters in string A and B are all Upper Case letters.
 *
 * Example
 * For A = "ABCD", B = "ACD", return true.
 *
 * For A = "ABCD", B = "AABC", return false.
 *
 * Notice
 * The characters of B in A are not necessary continuous or ordered.
 */
public class compareStrings {
    /**
     * @param A: A string
     * @param B: A string
     * @return: if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
        if (B.length() > A.length()){return false;}
        int[] characters = new int[26];
        for (int i=0;i<A.length();i++){
            characters[A.charAt(i)-'A'] += 1;
        }

        for (int i=0;i<B.length();i++){
            characters[B.charAt(i) - 'A'] --;
            if (characters[B.charAt(i) - 'A'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){

    }
}
