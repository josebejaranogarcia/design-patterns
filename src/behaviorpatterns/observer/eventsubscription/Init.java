package behaviorpatterns.observer.eventsubscription;

import java.io.File;

public class Init {

    static final String PATH="src/behaviorpatterns/observer/eventsubscription/testFile.txt";

    public static void main(String[] args) {

        Notifier notifier = new Notifier();
        notifier.writeFile(new File(PATH));
        notifier.openFile(new File(PATH));
    }
}
