import java.io.*;
import java.util.*;

public class Main {
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c;
            while ((c = read()) <= ' ') ;
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long val = 0;
            while (c > ' ') {
                val = val * 10 + c - '0';
                c = read();
            }
            return val * sign;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }

    static int lowerBound(long[] b, long x) {
        int l = 0, r = b.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (b[mid] >= x) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int T = fs.nextInt();

        while (T-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();

            long[] a = new long[n];
            long[] b = new long[m];

            for (int i = 0; i < n; i++) a[i] = fs.nextLong();
            for (int i = 0; i < m; i++) b[i] = fs.nextLong();

            Arrays.sort(b);

            long prev = Long.MIN_VALUE / 4;
            boolean ok = true;

            for (int i = 0; i < n; i++) {
                long best = Long.MAX_VALUE;

                if (a[i] >= prev)
                    best = a[i];

                int idx = lowerBound(b, prev + a[i]);
                if (idx < m)
                    best = Math.min(best, b[idx] - a[i]);

                if (best == Long.MAX_VALUE) {
                    ok = false;
                    break;
                }

                prev = best;
            }

            out.append(ok ? "YES\n" : "NO\n");
        }

        System.out.print(out);
    }
}