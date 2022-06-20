import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        System.out.print("Enter the number  of parenthesis: ");

        Scanner scanner = new Scanner(System.in);
        int numberOfParenthesis = scanner.nextInt();

        int result = getNumberOfParenthesis(numberOfParenthesis);
        System.out.println("Sum of correct bracket expressions: " + result);
    }
    public static int getNumberOfParenthesis(int numberOfParenthesis) {
        int minNumber = 0; // to avoid "magic value"
        int firstNumberOfParenthesisSeries = 1; // to avoid "magic value" v.2.0

        int sumOfCorrectParenthesisExpressions = 0;

        // this is in case of entered number is 0
        if (numberOfParenthesis == minNumber) {
            return firstNumberOfParenthesisSeries;
        }

        //recursively find sum of parenthesis
        for (int i = 0; i < numberOfParenthesis; i++) {
            sumOfCorrectParenthesisExpressions += getNumberOfParenthesis(i) * getNumberOfParenthesis((numberOfParenthesis - 1) - i);
        }
        return sumOfCorrectParenthesisExpressions;
    }
}
