package euler.problems;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.LongStream;

import static euler.utils.NumberUtils.isDivisbleBy;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 *
 * @author james.bogan
 */
public class Problem5 implements Callable<Long> {
    @Override
    public Long call() throws Exception {
        return LongStream
                .range(20, 100_000_000_000L)
                .filter(x -> isDivisibleByOneTo20(x))
                .findFirst()
                .getAsLong();
    }

    /*
     * We don't need to test below 11 because if the number is divisible
     * by 20/18/16/14/12, it is divisible by 10/9/8/7/6 respectively and
     * the remaining numbers (5, 4, 3, 2, 1) are divisors of already
     * tested numbers.
     */
    private boolean isDivisibleByOneTo20(long n) {
        return isDivisbleBy(n, 20)
                && isDivisbleBy(n, 19)
                && isDivisbleBy(n, 18)
                && isDivisbleBy(n, 17)
                && isDivisbleBy(n, 16)
                && isDivisbleBy(n, 15)
                && isDivisbleBy(n, 14)
                && isDivisbleBy(n, 13)
                && isDivisbleBy(n, 12)
                && isDivisbleBy(n, 11);
    }
}