import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class SelfPowers {

    static int[] pows = { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512 };
    static long mod = 10000000000L;

    static StringBuffer baseConv(int num, int b) {
        StringBuffer bintext = new StringBuffer("");
        int bits = (int) Math.floor((Math.log(num) / Math.log(b)) + 1);
        int currentnum = num;
        for (int i = 0; i < bits; i++) {
            bintext.insert(0, currentnum % b);
            currentnum = (int) Math.floor(currentnum / b);
        }
        return bintext;
    }

    static long mult(long a, long b) {
        while (b < 0)
            b += mod;
        if (a > 1000000000L && b > 1000000000L) {
            long a1 = a % 1000000000;
            long b1 = b % 1000000000;
            long a2 = a - a1;
            long b2 = b - b1;
            return (b2 * a1 % mod + a2 * b1 % mod + a1 * b1 % mod) % mod;
        } else
            return a * b % mod;
    }

    static long exp2(long x, long n) {
        x %= mod;
        long a1 = x / 100000;
        long a2 = x % 100000;
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x % mod;
        } else {
            return exp2((2 * a1 * a2 * 100000 + a2 * a2) % mod, n / 2) % mod;
        }

    }

    static long exp(long x, long n) {
        StringBuffer b = baseConv((int) n, 2);
        long prod = 1;
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) == '1') {
                prod = mult(prod, exp2(x, pows[b.length() - 1 - i]));
            }
        }
        return prod;
    }

    void run() throws IOException {
        long sum = 0;
        for (int i = 1; i < 1000; i++) {
            if (i % 10 == 0 && i > 10)
                continue;
            sum += exp(i, i);
            sum %= mod;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {
        SelfPowers prog = new SelfPowers();
        prog.run();
    }
}
