package design.decorator;

/**
 * Created by chongyu on 8/14/14.
 */
public class PacketHTMLHeaderCreator extends PacketDecorator {

    public PacketHTMLHeaderCreator(IPacketCreator creator){
        super(creator);
    }

    @Override
    public String handleContent() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<html>");
        stringBuffer.append("<body>");
        stringBuffer.append(component.handleContent());
        stringBuffer.append("</body>");
        stringBuffer.append("</html>");
        return stringBuffer.toString();
    }
}