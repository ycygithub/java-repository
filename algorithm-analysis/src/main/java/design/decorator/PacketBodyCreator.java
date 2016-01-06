package design.decorator;

/**
 * Created by chongyu on 8/14/14.
 */
public class PacketBodyCreator implements IPacketCreator {
    @Override
    public String handleContent() {
        return "Content of Packet";
    }
}
