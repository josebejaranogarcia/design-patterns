package behaviorpatterns.observer.eventsubscription;

import behaviorpatterns.observer.eventsubscription.suscribers.Subscriber;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {

    Map<String, List<Subscriber>> eventsSubscribed = new HashMap<>();
    List<Subscriber> subscribers;

    public EventManager(String... eventTypes) {
        for (String type : eventTypes)
            this.eventsSubscribed.put (type, new ArrayList<>());
    }


    public void subscribe(String eventType, Subscriber subscriber) {
        subscribers = eventsSubscribed.get(eventType);
        subscribers.add(subscriber);
    }

    public void unsubscribe(String eventType, Subscriber subscriber) {
        subscribers = eventsSubscribed.get(eventType);
        subscribers.remove(subscriber);
    }

    public void notify(String eventType, File file) {
        subscribers = eventsSubscribed.get(eventType);
        for (Subscriber listener : subscribers)
            listener.update( file);
    }

}
