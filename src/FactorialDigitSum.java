import java.io.*;
import java.util.*;

public class FactorialDigitSum {

    StringBuffer fact;

    public StringBuffer multiply(StringBuffer f, int i) {
        StringBuffer[] addends = new StringBuffer[2];
        addends[0] = new StringBuffer("");
        addends[1] = new StringBuffer("");
        for (int k = 0; k <= 1; k++) {
            int carry = 0;
            for (int j = f.length() - 1; j >= 0; j--) {
                int d1 = Integer.parseInt(f.substring(j, j + 1));
                int d2 = 0;
                if (k == 0) {
                    d2 = i % 10;
                } else {
                    d2 = i / 10;
                }
                int d = (carry + d1 * d2) % 10;
                carry = (carry + d1 * d2) / 10;
                addends[k].insert(0, d);
            }
            if (carry > 0)
                addends[k].insert(0, carry);
        }
        addends[1].append("0");
        return add(addends[0], addends[1]);
    }

    public StringBuffer add(StringBuffer a1, StringBuffer a2) {
        int s = a2.length() - a1.length();
        int q = 1;
        for (int i = 0; i < s; i++) {
            q *= 10;
        }
        StringBuffer z = new StringBuffer(q + "");
        z.deleteCharAt(0);
        a1.insert(0, z);
        int carry = 0;
        for (int i = a1.length() - 1; i >= 0; i--) {
            int d1 = Integer.parseInt(a1.substring(i, i + 1));
            int d2 = Integer.parseInt(a2.substring(i, i + 1));
            int d = (carry + d1 + d2) % 10;
            carry = (carry + d1 + d2) / 10;
            a2.replace(i, i + 1, d + "");
        }
        if (carry > 0)
            a2.insert(0, carry);
        return a2;
    }

    void trim(StringBuffer f) {
        while (Integer.parseInt(f.substring(f.length() - 1)) == 0) {
            f.deleteCharAt(f.length() - 1);
        }
    }

    void run() throws IOException {
        fact = new StringBuffer("3628800");
        for (int i = 11; i < 100; i++) {
            fact = multiply(fact, i);
            trim(fact);
        }
        int sum = 0;
        for (int i = 0; i < fact.length(); i++) {
            sum += Integer.parseInt(fact.substring(i, i + 1));
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {
        FactorialDigitSum prog = new FactorialDigitSum();
        prog.run();
    }
}
