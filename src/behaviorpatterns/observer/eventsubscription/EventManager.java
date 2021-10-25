package behaviorpatterns.observer.eventsubscription;

import behaviorpatterns.observer.eventsubscription.listeners.MyEventListener;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {

    Map<String, List<MyEventListener>> listeners = new HashMap<>();
    List<MyEventListener> listenerSubscribed;

    public EventManager(String... eventTypes) {
        for (String type : eventTypes)
            this.listeners.put (type, new ArrayList<>());
    }


    public void subscribe(String eventType, MyEventListener eventListener) {
        listenerSubscribed = listeners.get(eventType);
        listenerSubscribed.add(eventListener);
    }

    public void unsubscribe(String eventType, MyEventListener eventListener) {
        listenerSubscribed = listeners.get(eventType);
        listenerSubscribed.remove(eventListener);
    }

    public void notify(String eventType, File file) {
        listenerSubscribed = listeners.get(eventType);
        for (MyEventListener listener : listenerSubscribed)
            listener.update( file);
    }

}
