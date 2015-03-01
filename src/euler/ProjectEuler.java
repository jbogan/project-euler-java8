package euler;

import euler.problems.Problem1;
import euler.problems.Problem2;
import euler.problems.Problem3;
import euler.problems.Problem4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author james.bogan
 */
public class ProjectEuler {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        System.out.println("RESULT: " + executor.submit(new Problem4()).get());
        executor.shutdown();
    }
}
