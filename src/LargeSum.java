import java.io.*;
import java.util.*;

public class LargeSum {
    StringBuffer[] s;

    void add(StringBuffer[] sb, int i) {
        int carry = 0;
        for (int j = sb[i + 1].length() - 1; j >= 0; j--) {
            int d1 = Integer.parseInt(sb[i].substring(j, j + 1));
            int d2 = Integer.parseInt(sb[i + 1].substring(j, j + 1));
            int d = (carry + d1 + d2) % 10;
            carry = (carry + d1 + d2) / 10;
            sb[i + 1].replace(j, j + 1, d + "");
        }
    }

    void run() throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("lgsum.in"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        s = new StringBuffer[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            s[i] = new StringBuffer(st.nextToken());
            s[i].insert(0, "00");
        }
        for (int i = 0; i < n - 1; i++) {
            add(s, i);
        }
        System.out.println(s[n - 1].substring(0, 10));
    }

    public static void main(String[] args) throws IOException {
        LargeSum prog = new LargeSum();
        prog.run();
    }
}
