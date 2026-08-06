import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            int t = scanner.nextInt();

            while (t-- > 0) {
                String s = scanner.next();
                char[] arr = s.toCharArray();
                boolean possible = false;

                // Find a character that is different from the first character and swap them
                for (int i = 1; i < arr.length; i++) {
                    if (arr[i] != arr[0]) {
                        char temp = arr[0];
                        arr[0] = arr[i];
                        arr[i] = temp;
                        possible = true;
                        break;
                    }
                }

                if (possible) {
                    System.out.println("YES");
                    System.out.println(new String(arr));
                } else {
                    System.out.println("NO");
                }
            }
        }

        scanner.close();
    }
}