package design.observable;

import java.util.Observable;

public class Monitored extends Observable {

    public void sendMessage(String message){
        this.setChanged();
        this.notifyObservers(message);
    }

}
