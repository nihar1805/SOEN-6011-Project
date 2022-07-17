import java.util.Scanner;

public class Power_function {

    public static double power(double num, double i) {

        double j;
        double product = 1;

        for (j = 0; j < i; j++) {
            product *= num;
        }
        return product;

    }

    private static double reduce(double num, double counter, double z, double i) {
        while (true) {
            if ((power(i, power(10, counter))) > num) {
                i = i - z;
                break;
            }
            i = i + z;
        }
        return i;
    }

    private static double roundoff(double num) {
        double limit;
        limit = (int) num + 0.5;
        if (num > limit) {
            return ((int) num + 1);
        } else {
            return ((int) num);
        }
    }

    private static double calculate(double num, double p) {
        double i = 0, j, answer, counter = 4, z = 1;
        for (j = 0; j < 16; j++) {
            i = reduce(num, counter, z, i);
            z /= 10;
        }
        p = (p * power(10, counter));
        p = roundoff(p);
        answer = power(i, p);
        return answer;
    }

    public static void main(String[] args) {
        while (true) {
            double num, p, a, b, pi, pf, answer;
            System.out.println("Enter any number: ");
            Scanner input = new Scanner(System.in);
            num = input.nextDouble();

            System.out.println("Enter the power: ");
            p = input.nextDouble();

            pi = (int) p;
            pf = p - pi;

            if (num < 0 && (pf % 1) != 0) {
                double num1 = -1 * num;
                a = calculate(num1, pf);
                b = power(num1, pi);
                answer = a * b;
                System.out.println("Answer: " + answer + "i");
                System.out.println("Correct Answer: " + Math.pow(num, p) + "\n");

            } else if (p < 0) {
                double num2 = 1 / num;
                double pi2 = -1 * pi;
                double pf2 = -1 * pf;
                a = calculate(num2, pf2);
                b = power(num2, pi2);
                answer = a * b;
                System.out.println("Answer: " + answer);
                System.out.println("Correct Answer: " + Math.pow(num, p) + "\n");

            } else {
                a = calculate(num, pf);
                b = power(num, pi);

                answer = a * b;

                System.out.println("Answer: " + answer);
                System.out.println("Correct Answer: " + Math.pow(num, p) + "\n");
            }
        }
    }
}

