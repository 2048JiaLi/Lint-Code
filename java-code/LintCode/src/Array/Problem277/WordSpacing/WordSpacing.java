package Array.Problem277.WordSpacing;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/6 16:21
 *
 * You are given a series of word called words, and two different words wordA and wordB,
 * please find the spacing of the closest wordA and wordB.
 * If no wordA or wordB in words, return −1.
 *
 * Example
 * Input：
 * ["hello","world","say","hello"]
 * "hello"
 * "world"
 * Output：
 * 1
 * Clarification
 * In the example, the spacing between the first "hello" and the first "world" is 11,
 * but the spacing between the first "world" and the second "hello" is 22, the answer should be 11。
 *
 * Notice
 * words contains tt words, each word is of length kk, 1 \le t \le 10^41≤t≤10
 * ​4
 * ​​ , 1 \le k \le 201≤k≤20.
 * wordA and wordB are of length n, mn,m, 1 \le n, m \le 201≤n,m≤20.
 * The words only consist of uppercase or lowercase English character.
 */
public class WordSpacing {
    /**
     * @param words: the words given.
     * @param wordA: the first word you need to find.
     * @param wordB: the second word you need to find.
     * @return: return the spacing of the closest wordA and wordB.
     */
    public static int wordSpacing(List<String> words, String wordA, String wordB) {
        // write your code here.
        int spacing = words.size()+1;
        int word = 0;
        int pos = 0;
        while (pos < words.size()) {
            // 依次向前找，找到第一个单词（A/B）之后，去找下一个（B/A），再找（A/B）
            // 直到pos越界
            String cur_word = words.get(pos);
            if (cur_word.equals(wordA)) {
                // 找写一个wordB，若中间出现wordA则将word移动到该位置
                while (pos < words.size() && ! (cur_word=words.get(pos)).equals(wordB)) {
                    if (cur_word.equals(wordA)) {
                        word = pos;
                    }
                    pos++;
                }
            } else if (cur_word.equals(wordB)) {
                while (pos < words.size() && !(cur_word=words.get(pos)).equals(wordA)) {
                    if (cur_word.equals(wordB)) {
                        word = pos;
                    }
                    pos++;
                }
            } else {
                pos++;
                continue;
            }

            if (pos >= words.size()) {break;}
            else {
                if (pos-word<spacing) {
                    spacing = pos-word;
                }
            }
        }
        return spacing>words.size()?-1:spacing;
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("hello");
        words.add("hello");
        words.add("zzzzz");
        words.add("world");
        words.add("say");
        words.add("world");
        //words.add("hello");

        System.out.println(wordSpacing(words,"hello","world"));
    }
}
