package euler.problems;

import euler.utils.NumberUtils;

import java.util.concurrent.Callable;
import java.util.function.LongSupplier;
import java.util.stream.LongStream;

import static euler.utils.NumberUtils.isDivisbleBy;
import static euler.utils.NumberUtils.isOdd;
import static euler.utils.NumberUtils.isPrime;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 *
 * @author james.bogan
 */
public class Problem3 implements Callable<Long> {
    private static final long NUMBER_TO_TEST = 600_851_475_143L;

    @Override
    public Long call() throws Exception {
        return LongStream
                .range(1, Math.round(Math.sqrt(NUMBER_TO_TEST)))
                .filter(x -> isDivisbleBy(NUMBER_TO_TEST, x) && isPrime(x))
                .max()
                .getAsLong();
    }
}