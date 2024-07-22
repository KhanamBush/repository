package toolkit1;


import java.util.Scanner;

public class IncomeTaxCalculator {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter your annual income: $");
    double income = scanner.nextDouble();

    double tax = calculateIncomeTax(income);

    System.out.printf("Your income tax is: $%.2f%n", tax);
  }

  private static double calculateIncomeTax(double income) {
    double tax = 0;

    if (income <= 9875) {
      tax = income * 0.10;
    } else if (income <= 40125) {
      tax = 987.50 + ((income - 9875) * 0.12);
    } else if (income <= 85525) {
      tax = 4617.50 + ((income - 40125) * 0.22);
    } else if (income <= 163300) {
      tax = 14605.50 + ((income - 85525) * 0.24);
    } else if (income <= 207350) {
      tax = 33271.50 + ((income - 163300) * 0.32);
    } else if (income <= 518400) {
      tax = 47367.50 + ((income - 207350) * 0.35);
    } else {
      tax = 156235.00 + ((income - 518400) * 0.37);
    }

    return tax;
  }
}
