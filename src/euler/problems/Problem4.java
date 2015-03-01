package euler.problems;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.LongStream;

import static euler.utils.NumberUtils.isDivisbleBy;
import static euler.utils.NumberUtils.isPrime;

/**
 * A palindromic number reads the same both ways.
 *
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 *
 * @author james.bogan
 */
public class Problem4 implements Callable<Long> {
    private static final long START = 100;
    private static final long STOP = 1000;

    @Override
    public Long call() throws Exception {
        List<Long> palindromicNumbers = new LinkedList<>();

        // collect all of the palindromic products for 3-digit numbers
        // then return the max from that list
        LongStream
                .range(START, STOP)
                .forEach(
                        x -> LongStream
                                .range(START, STOP)
                                .forEach(y -> {
                                    long product = x * y;
                                    if (isPalindromic(product)) {
                                        palindromicNumbers.add(product);
                                    }
                                })
                );

        return Collections.max(palindromicNumbers);
    }

    private boolean isPalindromic(long n) {
        // check if the string version of the number is a palindrome
        return isPalindrome(Long.toString(n));
    }

    private boolean isPalindrome(String s) {
        // easiest thing to do is reverse the string and compare it
        // to the original
        StringBuilder reversed = new StringBuilder(s);
        reversed.reverse();

        return s.equals(reversed.toString());

    }
}