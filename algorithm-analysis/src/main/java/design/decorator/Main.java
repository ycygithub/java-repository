package design.decorator;

/**
 * Created by chongyu on 8/14/14.
 */
public class Main {

    public static void main(String[] args){

        IPacketCreator pc = new PacketHTTPHeaderCreator(new PacketHTMLHeaderCreator(new PacketBodyCreator()));
        System.out.println(pc.handleContent());

    }

}
