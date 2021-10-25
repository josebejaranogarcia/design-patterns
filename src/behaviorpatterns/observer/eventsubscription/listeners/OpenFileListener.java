package behaviorpatterns.observer.eventsubscription.listeners;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class OpenFileListener implements MyEventListener{

    @Override
    public void update(File file) {
        try {
            System.out.println("im here 2");
            System.out.println(file.getName());
            Desktop.getDesktop().open (file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
