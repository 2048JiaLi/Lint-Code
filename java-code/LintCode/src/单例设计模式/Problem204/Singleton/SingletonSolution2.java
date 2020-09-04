package 单例设计模式.Problem204.Singleton;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/6/28 15:48
 */
public class SingletonSolution2 {
    /**
     * 解法一只适用于单线程场景（若多线程同时访问 single == null ?， 然后都创建了实例）
     *
     * 该解法是对single 加锁
     *
     * > 注意：加锁是非常耗时的，应尽量避免加锁
     *
     * > 一种改进方法是在加锁前进行一次判断
     */

    private SingletonSolution2() {}

    private static SingletonSolution2 single = null;

    public static SingletonSolution2 getInstance() {

        if (single == null) {
            try {
                synchronized (single) { // 使用synchronized要进行异常处理

                    if (single == null) {
                        single = new SingletonSolution2();
                    }

                }
            } catch (NullPointerException e) {

            }
        }
        return single;
    }

    public static void main(String[] args) {
        SingletonSolution2 A = SingletonSolution2.getInstance();
        SingletonSolution2 B = SingletonSolution2.getInstance();

        System.out.println(A == B);
    }
}
