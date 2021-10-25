package behaviorpatterns.observer.eventsubscription;

import behaviorpatterns.observer.eventsubscription.suscribers.Subscriber;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {

    Map<String, List<Subscriber>> subscribedEvents = new HashMap<>();
    List<Subscriber> subscribers;

    public EventManager(String... eventTypes) {
        for (String type : eventTypes)
            this.subscribedEvents.put (type, new ArrayList<>());
    }


    public void subscribe(String eventType, Subscriber subscriber) {
        subscribers = subscribedEvents.get(eventType);
        subscribers.add(subscriber);
    }

    public void unsubscribe(String eventType, Subscriber subscriber) {
        subscribers = subscribedEvents.get(eventType);
        subscribers.remove(subscriber);
    }

    public void notify(String eventType, File file) {
        subscribers = subscribedEvents.get(eventType);
        for (Subscriber listener : subscribers)
            listener.update( file);
    }

}
