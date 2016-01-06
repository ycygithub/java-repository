package bitmap;

import java.util.Arrays;

public class ArraysSort {

    public static void main(String[] args) {

        int[] array = RandomUtil.getIntArr(10000000, 100000);

        long startTime2 = System.currentTimeMillis();
        Arrays.sort(array);
        long endTime2 = System.currentTimeMillis();
        System.out.println((endTime2-startTime2)+"ms");

    }

}
