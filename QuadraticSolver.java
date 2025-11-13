import java.util.Scanner;

public class QuadraticSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read coefficients a, b, and c
        System.out.println("Enter coefficient a:");
        double a = scanner.nextDouble();

        System.out.println("Enter coefficient b:");
        double b = scanner.nextDouble();

        System.out.println("Enter coefficient c:");
        double c = scanner.nextDouble();

        // Check if it's a quadratic equation
        if (a == 0) {
            System.out.println("This is not a quadratic equation.");
        } else {
            // Calculate discriminant
            double discriminant = b * b - 4 * a * c;

            if (discriminant > 0) {
                double r1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double r2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                System.out.println("Two real solutions:");
                System.out.println("x1 = " + r1);
                System.out.println("x2 = " + r2);
            } else if (discriminant == 0) {
                double r = -b / (2 * a);
                System.out.println("One real solution:");
                System.out.println("x = " + r);
            } else {
                System.out.println("No real solutions. The discriminant is negative.");
            }
        }

        scanner.close();
    }
}