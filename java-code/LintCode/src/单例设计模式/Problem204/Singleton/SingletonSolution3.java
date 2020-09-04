package 单例设计模式.Problem204.Singleton;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/6/28 15:57
 */
public class SingletonSolution3 {
    private SingletonSolution3 () {}

    private static final SingletonSolution3 single = new SingletonSolution3();

    public static SingletonSolution3 getInstance() {
        /**
         * 利用静态方法，只创建一次（多线程环境下也会运行的很好，但是LintCode提交并没有提高太多效率）
         *
         *
         */
        return single;
    }

    public static void main(String[] args) {
        SingletonSolution3 A = SingletonSolution3.getInstance();
        SingletonSolution3 B = SingletonSolution3.getInstance();

        System.out.println(A == B);
    }
}
