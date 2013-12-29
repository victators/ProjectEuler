import java.io.*;
import java.util.*;

public class AmicableSum {

    boolean[] isPrime;
    boolean[] amicable = new boolean[10001];
    int[] divSum = new int[10001];

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
        primeSieve(10000);
        int prod = 1;
        for (int j = 3; j < 10000; j++) {
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
            if (j > prod) {
                if (divSum[prod] == j) {
                    amicable[j] = true;
                    amicable[prod] = true;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < amicable.length; i++) {
            if (amicable[i]) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {
        AmicableSum prog = new AmicableSum();
        prog.run();
    }
}
