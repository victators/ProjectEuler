import java.io.*;
import java.util.*;

public class PowerDigitSum {

    int[] digits;

    public void timesTwo(int[] d) {
        int carry = 0;
        for (int i = 0; i < d.length; i++) {
            if (d[i] == -1 && carry == 0) {
                return;
            }
            if (d[i] == -1) {
                d[i] = carry;
                return;
            }
            int digit = d[i];
            d[i] = carry + (2 * d[i]) % 10;
            carry = (2 * digit) / 10;
        }
    }

    void run() throws IOException {
        digits = new int[(int) (1000 * Math.log(2) / Math.log(10)) + 1];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = -1;
        }
        digits[0] = 1;
        for (int i = 0; i < 1000; i++) {
            timesTwo(digits);
        }
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum += digits[i];
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {
        PowerDigitSum prog = new PowerDigitSum();
        prog.run();
    }
}
