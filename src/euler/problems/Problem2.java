package euler.problems;

import java.util.concurrent.Callable;
import java.util.function.LongSupplier;
import java.util.stream.LongStream;

import static euler.utils.NumberUtils.isEven;

/**
 * Each new term in the Fibonacci sequence is generated by adding the
 * previous two terms. By starting with 1 and 2, the first 10 terms will be:
 *
 *      1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 *
 * By considering the terms in the Fibonacci sequence whose values do not
 * exceed four million, find the sum of the even-valued terms.
 *
 * @author james.bogan
 */
public class Problem2 implements Callable<Long> {
    @Override
    public Long call() throws Exception {
        return LongStream
                .generate(new FibonacciNumbersSupplier())
                .limit(80)
                .sorted()
                .filter(x -> (x <= 4_000_000) && isEven(x))
                .sum();
    }
}

class FibonacciNumbersSupplier implements LongSupplier {
    private boolean firstCall = true;
    private boolean secondCall = true;

    private long a = 0;
    private long b = 1;

    @Override
    public long getAsLong() {
        if (firstCall) {
            firstCall = false;
            return a;
        } else if (secondCall) {
            secondCall = false;
            return b;
        } else {
            long next = a + b;
            a = b;
            b = next;

            return next;
        }
    }
}
