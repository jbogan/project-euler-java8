package euler.problems;

import java.util.concurrent.Callable;
import java.util.stream.LongStream;

/**
 * The sum of the squares of the first ten natural numbers is,
 *
 *      12 + 22 + ... + 102 = 385
 *
 * The square of the sum of the first ten natural numbers is,
 *
 *      (1 + 2 + ... + 10)2 = 552 = 3025
 *
 * Hence the difference between the sum of the squares of the first ten natural
 * numbers and the square of the sum is 3025 − 385 = 2640.
 *
 * Find the difference between the sum of the squares of the first one hundred
 * natural numbers and the square of the sum.

 * @author james.bogan
 */
public class Problem6 implements Callable<Long> {
    private static final long START = 1;
    private static final long STOP = 100;

    @Override
    public Long call() throws Exception {
        long sumOfSquares =
                LongStream
                        .rangeClosed(START, STOP)
                        .map(x -> x * x)
                        .sum();

        long sums = LongStream.rangeClosed(START, STOP).sum();
        long squareOfSums = sums * sums;

        return squareOfSums - sumOfSquares;
    }
}