package String;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/11 14:37
 */
public class KMP {
    private String pat;
    private int[][] dfa;
    public KMP(String pat) {
        // 根据模式串构造DFA
        this.pat = pat;
        int M = pat.length(), R = 256;

    }
}
