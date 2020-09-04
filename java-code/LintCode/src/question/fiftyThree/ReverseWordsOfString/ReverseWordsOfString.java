package question.fiftyThree.ReverseWordsOfString;

/**
 * @author Li W
 * @version 1.0
 * @date 2020/6/4 15:06
 */

/**
 * Given an input string, reverse the string word by word.
 *
 * Example
 * Example 1:
 * 	Input:  "the sky is blue"
 * 	Output:  "blue is sky the"
 *
 * 	Explanation:
 * 	return a reverse the string word by word.
 *
 * Example 2:
 * 	Input:  "hello world"
 * 	Output:  "world hello"
 *
 * 	Explanation:
 * 	return a reverse the string word by word.
 */
public class ReverseWordsOfString {
    /*
     * @param s: A string
     * @return: A string
     */
    public static String reverseWords(String s) {
        // write your code here
        String res = new String();
        String world = new String();
        int i = s.length()-1;

        while (i>=0){
            char tmp = s.charAt(i--);
            if (tmp != ' '){
                world = tmp + world;
            } else {
                if (!world.isEmpty()){
                    if (res.isEmpty()){
                        res = res + world;
                    } else {
                        res = res + ' ' + world;
                    }
                    world = "";
                }
            }
        }

        return world.isEmpty()? res:res+' '+world;
    }

    public static void main(String[] args){
        String s = "the sky is blue";
        System.out.println(s);
        System.out.println(reverseWords(s));
    }
}
