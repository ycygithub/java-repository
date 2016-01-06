package bitmap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomUtil {

    public static int[] getIntArr(int range,int number){

        int[] intRandom = new int[number];
        Random rd = new Random();

        //生成数据集，用来保存随即生成数，并用于判断
        List rList = new ArrayList();

        while(rList.size() < number) {

            int num = rd.nextInt(range);

            if(!rList.contains(num)) {
                rList.add(num);
            }

        }

        /*给数值赋值*/
        for(int i = 0;i <rList.size();i++) {
            intRandom[i] = (Integer)(rList.get(i));
        }

        return intRandom;

    }

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        getIntArr(10000,10);
        long endTime = System.currentTimeMillis();
        System.out.println((endTime-startTime)+"ms");

    }

}
