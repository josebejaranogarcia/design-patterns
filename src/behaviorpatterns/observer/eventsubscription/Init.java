package behaviorpatterns.observer.eventsubscription;

import behaviorpatterns.observer.eventsubscription.listeners.OpenFileListener;

public class Init {

    public static void main(String[] args) {

        Notifier notifier = new Notifier();
        try {
            notifier.openFile("src/behaviorpatterns/observer/eventsubscription/testFile.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
