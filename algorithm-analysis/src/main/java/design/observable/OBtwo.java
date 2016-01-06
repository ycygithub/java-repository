package design.observable;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by chongyu on 8/14/14.
 */
public class OBtwo implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("OBtwo receive:" + arg);
    }
}
