package Stack.LC40.implement.queue.by.two.stack;

import java.util.Stack;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/16 15:04
 *
 * 用两个栈，实现队列的入队、出队、及队顶元素获取功能
 */
public class implement {
    /**
     * 1号栈始终用于入栈；
     * 当遇到pop或top操作时，（1）若2号栈为空，将1号栈所有元素出栈到2号栈，再执行；
     * （2）若2号栈不为空，直接执行
     */

    private Stack<Integer> stackA, stackB;
    public implement() {
        // do intialization if necessary
        stackA = new Stack<>();
        stackB = new Stack<>();
    }

    /*
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) {
        // write your code here
        stackA.add(element);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        if (stackB.isEmpty()) {
            while (!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
        }
        return stackB.pop();
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        return stackB.peek();
    }
}
