package process;

import org.json.JSONException;
import org.json.JSONObject;

public class IMapperProcessImpl implements IMapperProcess {

    private String id;
    private String json;

    @Override
    public void init(String key, String value) {

        JSONObject jsonObject = new JSONObject();
        String convert[] = value.split(",");
        this.setId(convert[0]);

        try {
            jsonObject.put("deal_id", convert[1]);
            jsonObject.put("create_time", convert[2]);
            jsonObject.put("cookies_id", convert[3]);
            jsonObject.put("device_id", convert[4]);
            jsonObject.put("ju_version", convert[5]);
            jsonObject.put("page_stats_w", convert[6]);
            jsonObject.put("c_type", convert[7]);
            setJson(jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public static void main(String[] args) {

        IMapperProcessImpl iMapperProcess = new IMapperProcessImpl();
        iMapperProcess.init("001","10944128831396601822,300733,2014-04-04 17:00:00,10944128831396601822,,1,index/63*1,0");

        System.out.println(iMapperProcess.getId());
        System.out.println(iMapperProcess.getJson());

    }

}
