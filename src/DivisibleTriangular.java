import java.io.*;
import java.util.*;

public class DivisibleTriangular {

    boolean[] isPrime;

    public void primeSieve(int N) {
        isPrime = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i; i * j <= N; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
    }

    void run() throws IOException {
        primeSieve(20000);
        int prod = 1;
        long n = 1;
        while (prod <= 500) {
            prod = 1;
            long tn1 = n;
            long tn2 = n + 1;
            if (n % 2 == 0) {
                tn1 /= 2;
            } else {
                tn2 /= 2;
            }
            for (int i = 2; i <= tn1; i++) {
                if (isPrime[i]) {
                    int c = 0;
                    while (tn1 % i == 0) {
                        tn1 /= i;
                        c++;
                    }
                    prod *= (c + 1);
                }
            }
            for (int i = 2; i <= tn2; i++) {
                if (isPrime[i]) {
                    int c = 0;
                    while (tn2 % i == 0) {
                        tn2 /= i;
                        c++;
                    }
                    prod *= (c + 1);
                }
            }
            n++;
        }
        System.out.println(n * (n - 1) / 2);
    }

    public static void main(String[] args) throws IOException {
        DivisibleTriangular prog = new DivisibleTriangular();
        prog.run();
    }
}
