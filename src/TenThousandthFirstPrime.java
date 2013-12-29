import java.io.*;
import java.util.*;

public class TenThousandthFirstPrime {
    private int num = 200000;
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
        primeSieve(num);
        int count = 0;
        int i = 0;
        while (count < 10001)
        {
            if (isPrime[i])
            {
                count++;
            }
            i++;
        }
        System.out.println(i-1);
    }

    public static void main(String[] args) throws IOException {
        TenThousandthFirstPrime prog = new TenThousandthFirstPrime();
        prog.run();
    }
}
