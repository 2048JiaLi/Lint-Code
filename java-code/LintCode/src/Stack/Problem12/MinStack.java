package Stack.Problem12;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/3 16:30
 *
 * Implement a stack with following functions:
 *
 * push(val) push val into the stack
 * pop() pop the top element and return it
 * min() return the smallest number in the stack
 * All above should be in O(1) cost.
 *
 * Example
 * Example 1:
 *
 * Input:
 *   push(1)
 *   pop()
 *   push(2)
 *   push(3)
 *   min()
 *   push(1)
 *   min()
 * Output:
 *   1
 *   2
 *   1
 * Example 2:
 *
 * Input:
 *   push(1)
 *   min()
 *   push(2)
 *   min()
 *   push(3)
 *   min()
 * Output:
 *   1
 *   1
 *   1
 * Notice
 * min() will never be called when there is no number in the stack.
 */
public class MinStack {
    /**
     * 不用考虑空指针问题
     */
    //private static int size = 0;
    private Stack stack = null;

    public MinStack() {
        // do intialization if necessary
    }

    private class Stack {
        int val;
        Stack parent;
        int min; // 记录，当前所有栈中最小元

        public Stack() {}

        public Stack(int val, Stack parent) {
            this.val = val;
            this.parent = parent;
        }
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        if (stack == null) {
            stack = new Stack(number,null);
            stack.min = number;
        } else {
            Stack tmp = new Stack(number,this.stack);
            if (number < this.stack.min) {
                tmp.min = number;
            } else {
                tmp.min = this.stack.min;
            }
            this.stack = tmp;
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        int res = this.stack.val;
        this.stack = this.stack.parent;
        return res;
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return this.stack.min;
    }

}
