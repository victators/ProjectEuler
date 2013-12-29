import java.io.*;
import java.util.*;

public class PrimeSummation {

    private int num = 2000000;
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
        long sum = 0;
        primeSieve(num);
        for (int i = 2; i <= num; i++) {
            if (isPrime[i]) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {
        PrimeSummation prog = new PrimeSummation();
        prog.run();
    }
}
