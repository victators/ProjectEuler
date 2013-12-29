import java.io.*;
import java.util.*;

public class ThousandFibonacci {

    void run() throws IOException {
        double curr = Math.log10(144);
        double prev = Math.log10(89);
        int n = 12;
        double adj = 0;
        while (curr + adj < 999999) {
            curr = 2 * curr - prev;
            prev = (curr + prev) / 2;
            n++;
            adj = 0.00001515479 * n;
        }
        System.out.println(n);

        // math op
        System.out.println((int) Math.ceil((999999 + Math.log10(Math.sqrt(5)))
                / Math.log10(1.618033988749894848204586834365)));
    }

    public static void main(String[] args) throws IOException {
        ThousandFibonacci prog = new ThousandFibonacci();
        prog.run();
    }
}
