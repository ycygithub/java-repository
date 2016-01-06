package bitmap;

public class BitMapSort {

    public static int[] miniBitMapSort(int[] array){

        //取最大值
        int max = array[0];
        for(int i : array){

            if(max < i)
                max = i;

        }

        //组成位图数组
        int[] nArray = new int[max+1];
        for(int item : array){

            nArray[item]++;

        }

        return nArray;

    }

    public static void main(String[] args) {

        int[] array = RandomUtil.getIntArr(10000000, 100000);

        long startTime = System.currentTimeMillis();
        miniBitMapSort(array);
        long endTime = System.currentTimeMillis();
        System.out.println();
        System.out.println((endTime-startTime)+"ms");

    }

}
