package toolkit1;


import java.util.Scanner;
import java.text.NumberFormat;

public class Mortgage {
    public static void main(String[] args) {
        Scanner stdin = new Scanner ( System.in );
		
        // Principal
        System.out.print("Principal:");
        int principal = stdin.nextInt();
                
        // Interest rate
        System.out.print("Annual Interest Rate: ");
        float annualInterest = stdin.nextFloat();
        float monthlyInterest = annualInterest / 100 / 12;
                
        // Period (max = 30)
        System.out.print("Period (Years): ");
        byte years = stdin.nextByte();
        int numberOfPayments = years * 12;
                
        stdin.close();

        // Calculate the monthly payment
        double mathPower = Math.pow(1 + monthlyInterest, numberOfPayments);

        double monthlyPayment = principal * (monthlyInterest * mathPower / (mathPower - 1));

        String monthlyPaymentFormatted = NumberFormat.getCurrencyInstance().format(monthlyPayment);

        // Print the result
        System.out.print("Your montly payment is: " + monthlyPaymentFormatted);
    }
}
