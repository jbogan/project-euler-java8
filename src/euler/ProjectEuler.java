package euler;

import euler.problems.Problem4;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Class for executing euler.problems.Problem## classes that return long results.
 *
 * Usage:
 *
 *      java euler.ProjectEuler problem-number
 *
 * where problem-number is a valid project euler problem number (e.g. 4)
 *
 * @author james.bogan
 */
public class ProjectEuler {
    public static void main(String[] args) throws Exception {
        int problemNumber;
        if (args.length == 1) {
            ExecutorService executor = null;
            try {
                executor = Executors.newSingleThreadExecutor();
                problemNumber = Integer.valueOf(args[0]);

                // instantiate the problem's object
                Class<?> problemClass = Class.forName("euler.problems.Problem" + problemNumber);
                Callable<Long> problemObject = (Callable<Long>) problemClass.newInstance();

                // submit the job and wait for the result
                Future<Long> problemFuture = executor.submit(problemObject);
                System.out.println("RESULT: " + problemFuture.get());

                executor.shutdown();
            } catch (NumberFormatException e) {
                printUsage();
            } finally {
                if (executor != null) {
                    executor.shutdown();
                }
            }
        } else {
            printUsage();
        }
    }

    private static void printUsage() {
        System.err.println("Usage: java euler.ProjectEuler #");
    }
}
