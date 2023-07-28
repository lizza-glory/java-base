/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-02-10
 */
public class Test1 {

    public static void main(String[] args){
        for (int i = 0; i < 4; i++) {
        }
    }

    abstract class A {
        public A[] get() {
            A[] a = new B[2];
            return a;
        }
    }

    class B extends A {
        public A[] get() {
            return super.get();
        }
    }
}
