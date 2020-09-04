package Stack.Problem12;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/3 16:56
 */
public class TestMinStack {
    public static void main(String[] args) {
        MinStack x = new MinStack();
        x.push(1);
        x.pop();
        x.push(2);
        //System.out.println(x.min());
        x.push(3);
        System.out.println(x.min());
        x.push(1);
        System.out.println(x.min());
    }
}
