package creationals.singleton;
/*Singleton Pattern*/

public class Singleton {

    private static Singleton singletonInstance;
    public String value;

    private Singleton(String value) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.value = value;
    }

    public static Singleton getInstance(String value) {
        if (singletonInstance == null)
            singletonInstance = new Singleton(value);
        return singletonInstance;
    }
}