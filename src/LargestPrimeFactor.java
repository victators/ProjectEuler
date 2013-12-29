import java.io.*;
import java.util.*;

public class LargestPrimeFactor {
    private long num = 600851475143L;
    private int lim;
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
        int lim = (int) Math.sqrt(num);
        int big = 0;
        primeSieve(lim);
        for (int i = 3; i < lim; i += 2) {
            if (num % i == 0 && isPrime[i])
                big = i;
        }
        System.out.println(big);
    }

    public static void main(String[] args) throws IOException {
        LargestPrimeFactor prog = new LargestPrimeFactor();
        prog.run();
    }
}
