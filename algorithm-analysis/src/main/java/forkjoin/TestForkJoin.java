package forkjoin;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by chongyu on 8/14/14.
 */
public class TestForkJoin {

    @Test
    public void runCalculator() throws Exception{
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Future<Integer> results = forkJoinPool.submit(new Calculator(0, 10000));

        assertEquals(new Integer(49995000), results.get());
    }

    @Test
    public void runSortTask() throws InterruptedException {
        int SIZE = 100;
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Random rnd = new Random();
        long[] array = new long[SIZE];
        for (int i = 0; i < SIZE; i++) {
            array[i] = rnd.nextInt();
        }
        forkJoinPool.submit(new SortTask(array));

        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1000, TimeUnit.SECONDS);

        for (int i = 1; i < SIZE; i++) {
            assertTrue(array[i - 1] < array[i]);
        }
    }

}
