import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        double amount;
        double rate;
        int years;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter the intital deposit amount: ");
        amount = keyboard.nextDouble();
        keyboard.nextLine();

        System.out.println("Enter the rate (in decimal form):");
        rate = keyboard.nextDouble();
        keyboard.nextLine();

        System.out.println("Enter the amount of years until withdrawl:");
        years = keyboard.nextInt();
        keyboard.nextLine();

        System.out.println("\nIterative Output");
        System.out.println("-----------------");
        System.out.printf("Your investment will be $%.2f after %d year(s) at a rate of %.1f%%",
                iterativeInterestCalc(amount, rate, years), years, rate * 100);

        System.out.println("\n\nRecursive Output");
        System.out.println("-----------------");
        System.out.printf("Your investment will be $%.2f after %d year(s) at a rate of %.1f%%",
                recursiveInterestCalc(amount, rate, years), years, rate * 100);

        keyboard.close();
    }

    public static double iterativeInterestCalc(double amount, double rate, int years) {
        for (int i = 0; i < years; i++) {
            amount += amount * rate;
        }

        return amount;
    }

    public static double recursiveInterestCalc(double amount, double rate, int years) {
        if (years == 0) {
            return amount;
        }

        double newBalance = amount + amount * rate;

        return recursiveInterestCalc(newBalance, rate, years - 1);
    }
}