package creationals.singleton;

public class MultiThread {

    public static void main(String[] args) {
        System.out.println("If you see the same value, then singleton is working" + "\n");
        Thread threadTrue = new Thread(new ThreadTrue());
        Thread threadFalse = new Thread(new ThreadFalse());
        Thread threadFalse2 = new Thread(new ThreadFalse());
        threadTrue.start();
        threadFalse.start();
        threadFalse2.start();
    }

    static class ThreadTrue implements Runnable {
        @Override
        public void run() {
            SingletonMultiThread singleton = SingletonMultiThread.getInstance("True");
            System.out.println(singleton.value);
        }
    }

    static class ThreadFalse implements Runnable {
        @Override
        public void run() {
            SingletonMultiThread singleton = SingletonMultiThread.getInstance("False");
            System.out.println(singleton.value);
        }
    }
}