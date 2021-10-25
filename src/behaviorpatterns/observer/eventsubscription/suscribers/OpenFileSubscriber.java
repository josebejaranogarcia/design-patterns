package behaviorpatterns.observer.eventsubscription.suscribers;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class OpenFileSubscriber implements Subscriber {

    @Override
    public void update(File file) {
        try {
            Desktop.getDesktop().open (file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
