import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            int t = scanner.nextInt();

            while (t-- > 0) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();

                int minVal = Math.min(x, y);
                int maxVal = Math.max(x, y);

                System.out.println(minVal + " " + maxVal);
            }
        }

        scanner.close();
    }
}