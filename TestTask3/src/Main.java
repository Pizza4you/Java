import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int factorialOfNumber = scanner.nextInt();
        int result = getSumDigitsFactorial(factorialOfNumber);
        System.out.println(result);
    }
    public static int getSumDigitsFactorial(int factorialOfNumber) {
        int sumOfDigits = 0;
        BigInteger factorial = BigInteger.ONE;

        // calculate the factorial of number
        for (int i = 2; i <= factorialOfNumber; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        String stringFactorial = String.valueOf(factorial);

        // calculate sum of all digits in the number
        for (int i = 0; i < stringFactorial.length(); i++) {
            sumOfDigits += Integer.parseInt(String.valueOf(stringFactorial.charAt(i)));
        }
        return sumOfDigits;
    }
}



