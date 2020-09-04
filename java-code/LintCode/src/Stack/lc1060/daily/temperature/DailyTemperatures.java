package Stack.lc1060.daily.temperature;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/8/1 13:25
 *
 * 给定一个每日temperatures的列表，产生一个列表，对于输入的每天，
 * 告诉我们你要等多少天才能够等到一个更高的温度。
 * 如果没有可能的未来日期，输出0作为替代。
 *
 * 比如，给定列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，
 * 你的输出应该是[1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 样例 1:
 * 	输入:  temperatures = [73, 74, 75, 71, 69, 72, 76, 73]
 * 	输出:  [1, 1, 4, 2, 1, 1, 0, 0]
 *
 * 	解释:
 * 	找到每个数字后面第一个大于自己的数字，输出两者的距离。
 *
 *
 * 样例 2:
 * 	输入: temperatures = [50, 40, 39, 30]
 * 	输出:  [0,0,0,0]
 */
public class DailyTemperatures {
    /**
     * @param temperatures: a list of daily temperatures
     * @return: a list of how many days you would have to wait until a warmer temperature
     */
    public int[] dailyTemperatures(int[] temperatures) {
        // Write your code here
        /**
         * https://mp.weixin.qq.com/s/3kDSOHyd-qOw7apzj0Z9YQ
         * 递减栈 ：栈里只有递减元素
         */
        // 表示栈，记录的是temperatures元素数组的下标
        int[] stack = new int[temperatures.length];
        // 指向栈顶
        int pos = 0;

        for (int i=0; i<temperatures.length; i++) {
            // 栈为空，直接入栈
            if (pos == 0) {
                stack[pos++] = i;
            } else {
                // 栈顶元素在temperatures的下标
                int index = stack[pos-1];
                // 比较当前值与栈顶元素值是否递减关系（当前值小于等于栈顶）
                if (temperatures[i] <= temperatures[index]) {
                    stack[pos++] = i;
                } else {
                    // 出现了更高的温度，则赋值为等待的天数（下标差）
                    while (temperatures[i] > temperatures[index]) {
                        temperatures[index] = i-index;
                        // 出栈
                        pos--;
                        if (pos == 0) {
                            break;
                        }
                        index = stack[pos-1];
                    }
                    // 当前temperatures[i]入栈
                    stack[pos++] = i;
                }
            }
        }

        // 栈不为空
        for (int i=0; i<pos; i++) {
            temperatures[stack[i]] = 0;
        }

        return temperatures;
    }

//    public static void main(String[] args) {
//        int[] res = dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
//        for (int re : res) {
//            System.out.println(re);
//        }
//    }
}
