package design.observable;

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
