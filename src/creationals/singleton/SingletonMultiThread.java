package creationals.singleton;


/*With double-checked locking (DCL) and lazy initialization
* More information: https://en.wikipedia.org/wiki/Double-checked_locking#Usage_in_Java*/

public final class SingletonMultiThread {
    /*By making our variables volatile, we force the threads to read them from main memory,
    and not from cache, guaranteeing that the value read is always the last value written to them.
    The variable's read and write operations will be atomic. It is essential for double-checked locking */
    private static volatile SingletonMultiThread singletonInstance;

    public String value;

    private SingletonMultiThread(String value) {
        this.value = value;
    }
    /* Given that synchronizing a method decrease performance, the approach taken here,
    double-checked locking (DCL), is typically used to reduce locking overhead when implementing
    "lazy initialization" in a multi-threaded environment, especially as part of the Singleton pattern.
    Lazy initialization avoids initializing a value until the first time it is accessed.*/
    public static SingletonMultiThread getInstance(String value) {

        /* The local variable "localRef" seems unnecessary, but is not.
        The effect of this is that in cases where "singletonInstance" is already initialized
        (almost always), the volatile field is only accessed once
        (due to "return result" instead of "return singletonInstance;"),
        which can improve the method's overall performance by as much as 40 percent.*/
        SingletonMultiThread localRef = singletonInstance;
        if (localRef != null)
            return localRef;

        synchronized (SingletonMultiThread.class) {
            if (singletonInstance == null) {
                singletonInstance = new SingletonMultiThread(value);
                System.out.println(">>> First access");
            }
            return singletonInstance;
        }
    }
}

