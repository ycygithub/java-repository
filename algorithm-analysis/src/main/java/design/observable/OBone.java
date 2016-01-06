package design.observable;

import java.util.Observable;
import java.util.Observer;

public class OBone implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("OBone receive:" + arg);
    }
}
