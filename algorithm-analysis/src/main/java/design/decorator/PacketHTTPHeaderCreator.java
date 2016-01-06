package design.decorator;

/**
 * Created by chongyu on 8/14/14.
 */
public class PacketHTTPHeaderCreator extends PacketDecorator{

    public PacketHTTPHeaderCreator(IPacketCreator creator){
        super(creator);
    }

    @Override
    public String handleContent() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Cache-Control:no-cache\n");
        stringBuffer.append("Date:2014-08-14 14:45");
        stringBuffer.append(component.handleContent());
        return stringBuffer.toString();
    }
}
