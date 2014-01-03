import java.io.*;
import java.util.*;

public class DistinctPowers {

    HashSet<Integer> s = new HashSet<Integer>();
    int[] comp = new int[11];

    void run() throws IOException {
        int sum = 0;
        for (int i = 2; i <= 10; i++) {
            if (i == 4 || i == 8 || i == 9)
                continue;
            int t = i;
            int c = 0;
            while (t <= 100) {
                t *= i;
                c++;
            }
            for (int j = 2; j <= 100; j++) {
                for (int k = 1; k <= c; k++) {
                    s.add(k * j);
                }
            }
            comp[i] = c * 99 - s.size();
            sum += comp[i];
            s.clear();
        }
        System.out.println(99 * 99 - sum);
    }

    public static void main(String[] args) throws IOException {
        DistinctPowers prog = new DistinctPowers();
        prog.run();
    }
}
