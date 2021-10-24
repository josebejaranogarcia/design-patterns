package creational.singleton.singlethread;

public class SingleThread {

    public static void main(String[] args) {
        System.out.println("If you see the same value, then singleton is working" + "\n");
        Singleton singleton = Singleton.getInstance("True");
        Singleton anotherSingleton = Singleton.getInstance("False");
        System.out.println(singleton.value);
        System.out.println(anotherSingleton.value);
    }
}
