package Stack.Problem859.MaxStack;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/4 15:41
 */
public class testMax {
    public static void main(String[] args) {
        MaxStack stack = new MaxStack();
        stack.push(5);
        stack.push(1);
        stack.push(5);
        stack.top();
        stack.popMax();
        stack.top();
        stack.peekMax();
        stack.pop();
        stack.top();
    }
}
