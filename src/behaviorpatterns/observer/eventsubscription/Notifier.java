package behaviorpatterns.observer.eventsubscription;

import behaviorpatterns.observer.eventsubscription.suscribers.OpenFileSubscriber;
import behaviorpatterns.observer.eventsubscription.suscribers.SaveFileSubscriber;

import java.io.File;

public class Notifier {

    private EventManager eventManager;

    public Notifier() {
        eventManager = new EventManager("open", "write");
        eventManager.subscribe("open", new OpenFileSubscriber());
        eventManager.subscribe("write", new SaveFileSubscriber());
    }

    public void openFile(File file) { eventManager.notify("open", file); }
    public void writeFile(File file)  {
        eventManager.notify("write", file);
    }

}
