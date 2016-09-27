/**
 * CS152 Lab 4 -- Welcome to Methods.
 * 
 * Implement all the methods described below.
 * 
 * Student name: Dylan Balata
 */
public class MethodPractice {

    /**
     * Returns the product of its arguments.
     * 
     * @param x
     *            First argument
     * @param y
     *            Second argument
     * @return Difference of x and y
     */
    public static int multTwo(int x, int y) {
        int mult = x * y;
        return mult;
    }

    /**
     * Is argument positive?
     * 
     * @param x
     *            Value to check.
     * @return True if x is greater than 0, false otherwise.
     */
    public static boolean isPositive(int x) {
        if (x > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Does the given string contain the letter M (either upper or lower case)?
     * 
     * @param x
     *            String to check
     * @return True if x contains M, false otherwise.
     */
    public static boolean containsM(String x) {
        if (x.contains("M") | x.contains("m")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Where is the location of the letter M (upper or lower case) in the given
     * string?
     * 
     * @param x
     *            String to check
     * @return 0 based location of first occurrence of M in x, -1 if M is not
     *         present.
     */
    public static int mIndex(String x) {
        if (x.contains("M") & x.indexOf("m") == -1) {
            int y = x.indexOf("M");
            return y;
        }
        if (x.contains("m") & x.indexOf("M") == -1) {
            int y = x.indexOf("m");
            return y;
        }
        if (x.contains("M") & x.indexOf("M") < x.indexOf("m")) {
            int y = x.indexOf("M");
            return y;
        }
        if (x.contains("m") & x.indexOf("m") < x.indexOf("M")) {
            int y = x.indexOf("m");
            return y;
        } else {
            return -1;
        }

    }

    /**
     * This method returns a response based on the string input: "Apple" =>
     * "Orange" "Hello" => "Goodbye!" "meat" => "potatoes" "Turing" => "Machine"
     * "Yay!" => "\o/" Any other input should be responded to with:
     * "I don't know what to say."
     * 
     * @param input
     *            The input string
     * @return Corresponding output string.
     */
    public static String respond(String input) {
        if (input.equals("Apple")) {
            return "Orange";
        }
        if (input.equals("Hello")) {
            return "Goodbye!";
        }
        if (input.equals("meat")) {
            return "potatoes";
        }
        if (input.equals("Turing")) {
            return "Machine";
        }
        if (input.equals("Yay!")) {
            return "\\o/";
        } else {
            return "I don't know what to say.";
        }
    }

    /**
     * Average up to five positive numbers. Any non-positive values are not
     * included in the average.
     * 
     * @param a
     *            First value
     * @param b
     *            Second value
     * @param c
     *            Third value
     * @param d
     *            Fourth value
     * @param e
     *            Fifth value
     * @return Average of the positive input values. If none are positive,
     *         returns -1.
     */
    public static double averagePositives(int a, int b, int c, int d, int e) {
        double total = 0;
        double count = 0;
        if (a > 0) {
            total = total + a;
            count = count + 1;
        }
        if (b > 0) {
            total = total + b;
            count = count + 1;
        }
        if (c > 0) {
            total = total + c;
            count = count + 1;
        }
        if (d > 0) {
            total = total + d;
            count = count + 1;
        }
        if (e > 0) {
            total = total + e;
            count = count + 1;
        }
        if (total > 0) {
            double average = total / count;
            return average;
        } else {
            return -1;
        }
    }

    // WRITE A METHOD FROM SCRATCH
    //
    // Write a method called squareEvenDoubleOdd that returns the
    // square of even numbers and returns odd numbers multiplied by
    // two.
    //
    // The method should take a single int argument
    // and return an int
    //
    // Don't forget to use the public static modifiers

    public static int squareEvenDoubleOdd(int a) {
        int c = a % 2;
        if (c == 0) {
            int b = a * a;
            return b;
        } else {
            int b = a * 2;
            return b;
        }
    }

    // WRITE A METHOD FROM SCRATCH
    //
    // Write a method called calculatePayment that takes two
    // arguments, an int meal which is the cost of a meal, and a
    // double tip which represents the tip percentage one would add to
    // the bill.
    // The method must return a double which equals how much should be
    // paid.
    //
    // int meal must be greater than 0
    // double tip must be 0 or greater and .5 or less (no tips over 50%)
    // If either number is invalid, return -1;
    //
    // Don't forget to use the public static modifiers

    public static double calculatePayment(int meal, double tip) {
        if (meal > 0 & tip > 0 & tip <= .5) {
            double payment = meal + meal * tip;
            return payment;
        } else {
            return -1;
        }
    }

    // This code tests your program's completeness.
    public static void main(String[] args) {
        int completeness = 0;

        if (multTwo(2, 3) == 6) {
            completeness++;
        }
        if (multTwo(4, -5) == -20) {
            completeness++;
        }

        if (!isPositive(-3)) {
            completeness++;
        }
        if (isPositive(2)) {
            completeness++;
        }
        if (!isPositive(0)) {
            completeness++;
        }

        if (containsM("man")) {
            completeness++;
        }
        if (!containsM("dog")) {
            completeness++;
        }
        if (containsM("EXCLAIMS!")) {
            completeness++;
        }

        if (mIndex("man") == 0) {
            completeness++;
        }
        if (mIndex("EXCLAIMS!") == 6) {
            completeness++;
        }
        if (mIndex("dog") == -1) {
            completeness++;
        }
        if (mIndex("klmmMmmM") == 2) {
            completeness++;
        }
        if (mIndex("klMMmMMm") == 2) {
            completeness++;
        }

        if (respond("Apple").equals("Orange")) {
            completeness++;
        }
        if (respond("Hello").equals("Goodbye!")) {
            completeness++;
        }
        if (respond("meat").equals("potatoes")) {
            completeness++;
        }
        if (respond("Turing").equals("Machine")) {
            completeness++;
        }
        if (respond("Yay!").equals("\\o/")) {
            completeness++;
        }
        if (respond("xxx").equals("I don't know what to say.")) {
            completeness++;
        }

        if (averagePositives(12, 13, 12, 13, 12) == 12.4) {
            completeness++;
        }
        if (averagePositives(0, 0, 0, 0, 0) == -1) {
            completeness++;
        }
        if (averagePositives(0, 0, 15, 0, -2) == 15) {
            completeness++;
        }
        if (averagePositives(100, -3, 4021, -2, 13) == 1378) {
            completeness++;
        }

        // UNCOMMENT AFTER IMPLEMENTING squareEvenDoubleOdd method
        if (squareEvenDoubleOdd(4) == 16) {
            completeness++;
        }
        if (squareEvenDoubleOdd(0) == 0) {
            completeness++;
        }
        if (squareEvenDoubleOdd(3) == 6) {
            completeness++;
        }

        // UNCOMMENT AFTER IMPLEMENTING calculatePayment
        if (calculatePayment(0, .3) == -1) {
            completeness++;
        }
        if (calculatePayment(10, .2) == 12.0) {
            completeness++;
        }
        if (calculatePayment(100, .6) == -1) {
            completeness++;
        }
        if (calculatePayment(120, .32) == 158.4) {
            completeness++;
        }

        System.out.println("Your program's completeness is currently: "
                + completeness + "/30");
    }

}