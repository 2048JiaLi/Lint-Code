package 单例设计模式.Problem204.Singleton;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/6/28 16:15
 */
public class SingletonSolution4 {
    /**
     * 需要的时候才创建
     */

    public static SingletonSolution4 getInstance() {
        return PrivSingleton.single;
    }

    public static void main(String[] args) {
        SingletonSolution4 A = SingletonSolution4.getInstance();
        SingletonSolution4 B = SingletonSolution4.getInstance();

        System.out.println(A == B);
    }

    private static class PrivSingleton { // 静态内部类，只有在使用的时候才加载
        static final SingletonSolution4 single = new SingletonSolution4();
    }
}



