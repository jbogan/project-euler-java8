package euler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        int problemNumber = parseOrGetProblemNumber(args);
        runProblem(problemNumber);
    }

    /**
     * Attempts to find the problem number in the program args, otherwise
     * prompts the user for the problem number.
     *
     * @param args
     * @return
     * @throws IOException
     */
    private static int parseOrGetProblemNumber(String[] args) throws IOException {
        if (args.length == 1) {
            try {
                return Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Usage: java euler.ProjectEuler #");
            }
        } else {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                while (true) {
                    System.out.print("Problem #: ");
                    String problemNumberFromUser = reader.readLine();
                    try {
                        return Integer.parseInt(problemNumberFromUser);
                    } catch (NumberFormatException e) {
                        System.err.println("Please enter a valid number");
                    }
                }
            }
        }

        throw new RuntimeException("Unable to parse problem number");
    }

    private static void runProblem(int problemNumber) throws Exception {
        ExecutorService executor = null;
        try {
            executor = Executors.newSingleThreadExecutor();

            // instantiate the problem's object
            Class<?> problemClass = Class.forName("euler.problems.Problem" + problemNumber);
            Callable<Long> problemObject = (Callable<Long>) problemClass.newInstance();

            // submit the job and wait for the result
            Future<Long> problemFuture = executor.submit(problemObject);
            System.out.println("RESULT: " + problemFuture.get());

            executor.shutdown();
        } catch (ClassNotFoundException e) {
            System.err.println("Solution for problem " + problemNumber + " is not implemented; exiting.");
        } finally {
            if (executor != null) {
                executor.shutdown();
            }
        }
    }
}
