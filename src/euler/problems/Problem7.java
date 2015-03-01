package euler.problems;

import java.util.concurrent.Callable;
import java.util.function.LongSupplier;
import java.util.stream.LongStream;

import static euler.utils.NumberUtils.isPrime;

/**
 * By listing the first six prime numbers:
 *
 *      2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 *
 * What is the 10,001st prime number?
 *
 * @author james.bogan
 */
public class Problem7 implements Callable<Long> {
    private static final long PRIME_TO_FIND = 10_001;

    @Override
    public Long call() throws Exception {
        return LongStream
                .generate(new PrimeSupplier())
                .limit(PRIME_TO_FIND)
                .max()
                .getAsLong();
    }
}

class PrimeSupplier implements LongSupplier {
    private long nextPrime = 1;
    private boolean first = true;

    @Override
    public long getAsLong() {
        if (!first) {
            nextPrime = findNextPrime(nextPrime);
        } else {
            first = false;
        }

        return nextPrime;
    }

    private long findNextPrime(long start) {
        long numberToCheck = start;
        do {
            numberToCheck++;
            if (isPrime(numberToCheck)) {
                return numberToCheck;
            }
        } while (true);
    }
}