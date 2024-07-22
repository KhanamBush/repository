package toolkit1;


import java.util.Scanner;

public class MonthlySavingGoalCalculator {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter your desired savings amount: $");
    double desiredSavings = scanner.nextDouble();

    System.out.print("Enter the number of months you want to reach your goal: ");
    int months = scanner.nextInt();

    double monthlySavings = calculateMonthlySavings(desiredSavings, months);

    System.out.printf("You need to save $%.2f per month to reach your goal of $%.2f in %d months.%n", monthlySavings, desiredSavings, months);
  }

  private static double calculateMonthlySavings(double desiredSavings, int months) {
    return desiredSavings / months;
  }
}
