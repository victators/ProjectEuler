import java.io.*;
import java.util.*;

public class SelfPowers {

    static long mod = 10000000000L;

    static long exp(long x, long n) {
        x %= mod;
//        if (x == 0) {
//            x -= Long.MIN_VALUE % mod;
//            x -= Long.MIN_VALUE % mod;
//            System.out.print("penis");
//        }
        if (n == 0)
            return 1;
        else if (n == 1)
            return x % mod;
        else if (n % 2 == 0) {
            return exp(x * x % mod, n / 2) % mod;
        } else if (n % 2 == 1)
            return x * exp(x * x % mod, (n - 1) / 2) % mod;
        else
            return 1;
    }

    void run() throws IOException {
        long sum = 0;
        for (int i = 1; i < 1000; i++) {
            if (i%10 == 0 && i > 10)
                continue;
            System.out.print(i + " ");
            sum += exp(i, i);
            System.out.println();
            sum %= mod;
            if (sum < 0)
                sum += mod;
//            System.out.println(i + " " + sum);
        }
        System.out.println(exp(336, 336));
        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {
        SelfPowers prog = new SelfPowers();
        prog.run();
    }
}
