package String.Problem255.MultiStringSearch;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/11 14:31
 */
public class MultiStringSearch {
    /**
     * @param sourceString: a string
     * @param targetStrings: a string array
     * @return: Returns a bool array indicating whether each string in targetStrings is a substring of the sourceString
     */
    public boolean[] whetherStringsAreSubstrings(String sourceString, String[] targetStrings) {
        // write your code here
        /**
         * 这里直接使用了api中的String.indexOf方法判断是否为子字符串
         */
        boolean[] res = new boolean[targetStrings.length];
        for (int i = 0; i < targetStrings.length; i++) {
            if (sourceString.indexOf(targetStrings[i])!=-1) {
                res[i] = true;
            } else {
                res[i] = false;
            }
        }
        return res;
    }
}
