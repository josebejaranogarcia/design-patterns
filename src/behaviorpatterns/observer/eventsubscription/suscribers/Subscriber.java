package behaviorpatterns.observer.eventsubscription.suscribers;

import java.io.File;

public interface Subscriber {
    void update(File file);
}
