package 单例设计模式.Problem204.Singleton;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/6/28 15:32
 *
 * Singleton is a most widely used design pattern.
 * If a class has and only has one instance at every moment,
 * we call this design as singleton.
 * For example, for class Mouse (not a animal mouse), we should design it in singleton.
 *
 * You job is to implement a getInstance method for given class,
 * return the same instance of this class every time you call this method.
 *
 * Example
 *
 * In Java:
 *
 * 	A a = A.getInstance();
 * 	A b = A.getInstance();
 *
 * a should equal to b.
 *
 * Challenge
 * If we call getInstance concurrently, can you make sure your code could run correctly?
 */
public class Singleton {

    /**
     * 第一种方式：将构造方法私有（不允许new创建），然后再定义一个静态实例
     * 当该静态实例为null时，才允许修改
     *
     * @return: The same instance of this class every time
     */
    public static Singleton getInstance() {
        // write your code here
        if (single == null) {
            single = new Singleton();
        }
        return single;
    }

    private Singleton () {
    }

    private static Singleton single;


    public static void main(String[] args) {
        Singleton A = Singleton.getInstance();
        Singleton B = Singleton.getInstance();

        System.out.println(A == B);
    }
}
