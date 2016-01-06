package design.decorator;

/**
 * Created by chongyu on 8/14/14.
 */
public abstract class PacketDecorator implements IPacketCreator {

    IPacketCreator component;
    public PacketDecorator(IPacketCreator creator){
        component = creator;
    }

}
