package process;

public class Main {

    public static void main(String[] args)throws Exception {

        String str1 = "10944128831396601822,300733,2014-04-04 17:00:00,10944128831396601822,,1,index/63*1,0";
        String str2 = "2014-04-25 03:30:00,358882049246993,6877196,328448,115,1";

        System.out.println(JsonUtil.parseString("user_click_sup_d",str1, ","));
        System.out.println(JsonUtil.parseString("mobile_exposure",str2, ","));

    }

}
