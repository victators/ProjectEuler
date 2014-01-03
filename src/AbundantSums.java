import java.io.*;
import java.util.*;

public class AbundantSums {

    int[] abundant = new int[6965];
    boolean[] check = new boolean[28123];

    boolean[] isPrime;
    int[] divSum = new int[28124];

    public void primeSieve(int N) {
        isPrime = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
            divSum[i] = 1;
        }

        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i; i * j <= N; j++) {
                    isPrime[i * j] = false;
                    divSum[i * j] = 0;
                }
            }
        }
    }

    static int exp(int x, int n) {
        if (n == 0)
            return 1;
        else if (n == 1)
            return x;
        else if (n % 2 == 0)
            return exp(x * x, n / 2);
        else if (n % 2 == 1)
            return x * exp(x * x, (n - 1) / 2);
        else
            return 1;
    }

    void run() throws IOException {
        primeSieve(28123);
        int prod = 1;
        int count = 0;
        for (int j = 3; j < 28123; j++) {
            if (divSum[j] > 0)
                continue;
            prod = 1;
            int t = j;
            for (int i = 2; i <= t; i++) {
                if (isPrime[i]) {
                    int c = 0;
                    int sum = 1;
                    while (t % i == 0) {
                        t /= i;
                        c++;
                        sum += exp(i, c);
                    }
                    prod *= sum;
                }
            }
            prod -= j;
            divSum[j] = prod;
            if (prod > j) {
                check[j] = true;
                abundant[count] = j;
                count++;
            }
        }
        long sum = 0;
        boolean b = true;
        boolean x = false;
        int c = 0;
        for (int i = 1; i <= 28123; i++) {
            b = true;
            x = false;
            for (int j = 0; j < abundant.length; j++) {
                if (i >= abundant[j] && check[i - abundant[j]]) {
                    b = false;
                    x = true;
                }
                if (i < abundant[j])
                    x = true;
                if (x)
                    j = abundant.length;
            }
            if (b) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {
        AbundantSums prog = new AbundantSums();
        prog.run();
    }
}
