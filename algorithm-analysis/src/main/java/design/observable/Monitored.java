package design.observable;

import java.util.Observable;

/**
 * Created by chongyu on 8/14/14.
 */
public class Monitored extends Observable {

    public void sendMessage(String message){
        this.setChanged();
        this.notifyObservers(message);
    }

}
