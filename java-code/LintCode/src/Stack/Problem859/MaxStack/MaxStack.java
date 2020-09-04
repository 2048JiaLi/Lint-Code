package Stack.Problem859.MaxStack;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/4 15:15
 *
 * Design a max stack that supports push, pop, top, peekMax and popMax.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Remove the element on top of the stack and return it.
 * top() -- Get the element on the top.
 * peekMax() -- Retrieve the maximum element in the stack.
 * popMax() -- Retrieve the maximum element in the stack, and remove it.
 * If you find more than one maximum elements, only remove the top-most one.
 * Example
 * Input:
 * push(5)
 * push(1)
 * push(5)
 * top()
 * popMax()
 * top()
 * peekMax()
 * pop()
 * top()
 * Output:
 * 5
 * 5
 * 1
 * 5
 * 1
 * 5
 * Notice
 * -1e7 <= x <= 1e7
 * Number of operations won't exceed 10000.
 * The last four operations won't be called when stack is empty.
 */
public class MaxStack {
    /**
     * 使用父指针，记录上一个入栈元素
     *
     * 需要注意peakMax的情况
     */

    private Stack stack;
    private int size;
    public MaxStack() {
    // do intialization if necessary
        size = 0;
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int x) {
        // write your code here
        if (size == 0) {
            stack = new Stack(x);
        } else {
            Stack tmp = new Stack(x);
            tmp.setNext(stack);
            stack = tmp;
        }
        size++;
    }

    public int pop() {
        // write your code here
        int res = stack.val;
        stack = stack.parent;
        size--;
        return res;
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        return stack.val;
    }

    /*
     * @return: An integer
     */
    public int peekMax() {
        // write your code here
        return stack.maxNum;
    }

    /*
     * @return: An integer
     */
    public int popMax() {
        // write your code here
        if (stack.val == stack.maxNum) {
            return pop();
        }
        Stack tmp = stack;
        while (tmp.parent.val != stack.maxNum) {
            tmp = tmp.parent;
        }
        tmp.parent = tmp.parent.parent;
        size--;

        // 修改tmp至栈顶的最大元素值
        //Stack tmp1 = stack;
        int res = stack.maxNum;
        setMaxOf(tmp.parent,stack);
        return res;
    }

    public void setMaxOf (Stack tmp, Stack stack) {
        if (stack == tmp) {
            return;
        }

        setMaxOf(tmp,stack.parent);
        if (stack.val >= stack.parent.maxNum) {
            stack.maxNum = stack.val;
        } else {
            stack.maxNum = stack.parent.maxNum;
        }
    }

    private class Stack {
        private int val;
        private Stack parent;
        private int maxNum;

        public Stack() {}

        public Stack(int val) {
            this.val = val;
            this.maxNum = val;
        }

        public void setNext(Stack parent) {
            this.parent = parent;

            if (parent.val > maxNum) {
                maxNum = parent.val;
            }
        }
    }

}
