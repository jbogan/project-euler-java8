package euler.problems;

import java.util.concurrent.Callable;
import java.util.stream.LongStream;

import static euler.utils.NumberUtils.isPrime;

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 *
 * @author james.bogan
 */
public class Problem10 implements Callable<Long> {
    @Override
    public Long call() throws Exception {
        return LongStream
                .range(2, 2_000_000)
                .filter(x -> isPrime(x))
                .sum();
    }
}

