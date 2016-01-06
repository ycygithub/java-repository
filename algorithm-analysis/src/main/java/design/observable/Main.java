package design.observable;


/**
 * Created by chongyu on 8/14/14.
 */
public class Main {

    public static void main(String[] args){

        Monitored monitored = new Monitored();
        OBone oBone = new OBone();
        OBtwo oBtwo = new OBtwo();

        monitored.addObserver(oBone);
        monitored.addObserver(oBtwo);
        monitored.sendMessage("一条消息");

    }

}
