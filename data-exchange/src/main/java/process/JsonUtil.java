package process;

import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class JsonUtil {

    /**
     * @param sourceName
     * @param dataStr
     * @param splitSign:分割符
     * @return
     * @throws Exception
     */
    public static String parseString(String sourceName,String dataStr,String splitSign)throws Exception {

        JSONObject jsonObject = new JSONObject();
        String convert[] = dataStr.split(splitSign);

        //取得 DOM Builder Factory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        //取得 DOM Builder
        DocumentBuilder builder = factory.newDocumentBuilder();

        //加载和解析 the XML document
        Document document = builder.parse(ClassLoader.getSystemResourceAsStream("profiles/config.xml"));

        //取得节点列表
        NodeList nodeList = document.getDocumentElement().getChildNodes();

        //遍历节点取出对应的数据
        for (int i = 0; i < nodeList.getLength(); i++) {

            Node node = nodeList.item(i);
            if (node instanceof Element) {

                String name = node.getAttributes().getNamedItem("name").getNodeValue();
                if(sourceName.trim().equals(name.trim())){
                    NodeList childNodes = node.getChildNodes();
                    for (int j = 0; j < childNodes.getLength(); j++) {
                        Node cNode = childNodes.item(j);

                        if (cNode instanceof Element) {
                            String key = cNode.getNodeName();
                            String value = cNode.getLastChild().getTextContent().trim();
                            jsonObject.put(key,convert[Integer.valueOf(value)]);
                        }
                    }
                }

            }

        }

        return jsonObject.toString();

    }

}
