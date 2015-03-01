package euler.utils;

/**
 * @author james.bogan
 */
public final class NumberUtils {

    public static boolean isOdd(long n) {
        return !isEven(n);
    }

    public static boolean isEven(long n) {
        return n % 2 == 0;
    }

    public static boolean isDivisibleBy(long dividend, long divisor) {
        return dividend % divisor == 0;
    }

    /*
     * Simple prime test (not good for large numbers).
     */
    public static boolean isPrime(long n) {
        if (n < 3) {
            return n > 1;
        } else if (isEven(n) || isDivisibleBy(n, 3)) {
            return false;
        } else {
            double sqrtOfN = Math.floor(Math.sqrt(n));
            for (int i = 5; i <= sqrtOfN; i += 6) {
                if (isDivisibleBy(n, i) || isDivisibleBy(n, i + 2)) {
                    return false;
                }
            }

            return true;
        }
    }

}
