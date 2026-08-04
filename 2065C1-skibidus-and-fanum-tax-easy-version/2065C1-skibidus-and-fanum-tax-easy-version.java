import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken()); // m = 1

            long[] a = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            long b = Long.parseLong(st.nextToken());

            boolean possible = true;
            long prev = Long.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                long v1 = a[i];
                long v2 = b - a[i];

                long chosen;
                boolean v1ok = v1 >= prev;
                boolean v2ok = v2 >= prev;

                if (v1ok && v2ok) {
                    chosen = Math.min(v1, v2);
                } else if (v1ok) {
                    chosen = v1;
                } else if (v2ok) {
                    chosen = v2;
                } else {
                    possible = false;
                    break;
                }

                prev = chosen;
            }

            sb.append(possible ? "YES" : "NO").append('\n');
        }

        System.out.print(sb);
    }
}