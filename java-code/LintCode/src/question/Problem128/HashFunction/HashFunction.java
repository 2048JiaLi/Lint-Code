package question.Problem128.HashFunction;

/**
 * @author Li W
 * @version 1.0
 * @date 2020/6/16 14:57
 *
 * In data structure Hash, hash function is used to convert a string(or any other type)
 * into an integer smaller than hash size and bigger or equal to zero. The objective of
 * designing a hash function is to "hash" the key as unreasonable as possible.
 * A good hash function can avoid collision as less as possible. A widely used hash function algorithm
 * is using a magic number 33, consider any string as a 33 based big integer like follow:
 *
 * hashcode("abcd") = (ascii(a) * 33^3 + ascii(b) * 33^2 + ascii(c) *33 + ascii(d)) % HASH_SIZE
 *
 *                               = (97* 33^3 + 98 * 33^2 + 99 * 33 +100) % HASH_SIZE
 *
 *                               = 3595978 % HASH_SIZE
 *
 * here HASH_SIZE is the capacity of the hash table
 * (you can assume a hash table is like an array with index 0 ~ HASH_SIZE-1).
 *
 * Given a string as a key and the size of hash table, return the hash value of this key.
 *
 *
 *
 * Example
 * Example 1:
 *
 * Input:  key="abcd", size = 1000
 * Output: 978
 * Explanation: (97*33^3 + 98*33^2 + 99*33 + 100*1)%1000 = 978
 * Example 2:
 *
 * Input:  key="abcd", size = 100
 * Output: 78
 * Explanation: (97*33^3 + 98*33^2 + 99*33 + 100*1)%100 = 78
 * Clarification
 * For this problem, you are not necessary to design your own hash algorithm or
 * consider any collision issue, you just need to implement the algorithm as described.
 */
public class HashFunction {
    /**
     * @param key: A string you should hash
     * @param HASH_SIZE: An integer
     * @return: An integer
     */

    // 分解因式： 将大的指数转换为因式乘积
    // 取模运算的性质
    public static int hashCode(char[] key, int HASH_SIZE) {
        // write your code here
        int offset = 33;
        int result = 0;
        for (int i=0; i<key.length; i++){
            result = (result*offset % HASH_SIZE  + key[i]) % HASH_SIZE;
        }

        return result;
    }

    public static void main(String[] args) {
        char[] key = {'u', 'b', 'u', 'n', 't', 'u'};

        System.out.println(hashCode(key,1007));
    }
}
