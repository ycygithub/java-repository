package design.decorator;

public abstract class PacketDecorator implements IPacketCreator {

    IPacketCreator component;
    public PacketDecorator(IPacketCreator creator){
        component = creator;
    }

}
