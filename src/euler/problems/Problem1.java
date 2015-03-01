package euler.problems;

import java.util.concurrent.Callable;
import java.util.stream.IntStream;

import static euler.utils.NumberUtils.isDivisibleBy;

/**
 * If we list all the natural numbers below 10 that are
 * multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of
 * these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 *
 * @author james.bogan
 */
public class Problem1 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return IntStream
                .range(0, 1000)
                .filter(x -> isDivisibleBy(x, 3) || isDivisibleBy(x, 5))
                .sum();
    }
}
