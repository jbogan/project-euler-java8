package euler.problems;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Callable;
import java.util.stream.LongStream;

import static euler.utils.NumberUtils.isPrime;

/**
 * Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.
 *
 * The 50-digit numbers are stored in the files/problem13.txt file.
 *
 * @author james.bogan
 */
public class Problem13 implements Callable<Long> {
    @Override
    public Long call() throws Exception {
        BigDecimal sum =
                Files
                    .lines(Paths.get("files/problem13.txt"))
                    .map(line -> new BigDecimal(line))
                    .reduce(BigDecimal.ZERO, (x, y) -> x.add(y));

        // return a number, which is actually the first 10 digits
        return Long.valueOf(sum.toString().substring(0, 10));

    }
}

