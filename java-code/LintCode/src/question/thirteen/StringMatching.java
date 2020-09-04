package question.thirteen;

/**
 * @author Li W
 * @version 1.0
 * @date 2020/6/1 18:42
 */

// 给一个主串和一个模式串，匹配出模式串在主串中的正确位置，若没有，则返回-1
public class StringMatching {
    /**
     * @param source:
     * @param target:
     * @return: return the index
     */

    // 暴力算法BF  O(n*m)
    public static int BruteForce(String source, String target){
        if (target.length()==0){return 0;}

        boolean flag = false;
        int pos = 0;
        for (int i=0;i<source.length()-target.length()+1;i++){
            int j = i ;
            pos = 0;
            while (source.charAt(j) == target.charAt(pos)){
                j++;   // source串
                pos++; // target串
                if (pos == target.length()){
                    flag = true;
                    break;
                }
            }

            if (flag){
                pos = i;
                break;
            }
        }

        return flag? pos:-1;
    }

    // BM（Boyer-Moore）算法：它借助“坏字符规则”和“好后缀规则”，在每一轮比较时，让模式串尽可能多移动几位，减少无谓的比较。



    public static void main(String[] args){
        String source = "source", target = "rced";
        System.out.println(BruteForce(source,target)); //BF算法
    }
}
