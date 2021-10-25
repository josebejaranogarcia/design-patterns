package behaviorpatterns.observer.eventsubscription;

import behaviorpatterns.observer.eventsubscription.listeners.OpenFileListener;

import java.io.File;

public class Notifier {

    public EventManager eventManager;
    private File file;

    public Notifier() {
        this.eventManager = new EventManager("open", "save");
        this.eventManager.subscribe("open", new OpenFileListener());
   //     eventManager.listeners.forEach((k,v) -> System.out.println("Key: " + k + ": Value: " + v));

    }

    public void openFile(String filePath) {
        this.file = new File(filePath);
        eventManager.notify("open", file);
    }

    public void saveFile() throws Exception {
        if (this.file != null)  eventManager.notify("save", file);
            throw new Exception("it cant save the document");
    }

}
