import java.io.*;
import java.util.*;

public class LongestCollatz {

    int[] chainz;

    void twoPowers(int[] c) {
        int n = 0;
        int s = 1;
        while (s < 1000000) {
            c[s] = n;
            s *= 2;
            n++;
        }
    }
    
    long function (long n) {
        if (n % 2 == 0)
            return n / 2;
        else
            return 3 * n + 1;
    }

    void run() throws IOException {
        chainz = new int[1000001];
        for (int i = 0; i < chainz.length; i++) {
            chainz[i] = -1;
        }
        ArrayList<Long> temp = new ArrayList<Long>();
        twoPowers(chainz);
        for (int i = 1; i < chainz.length; i++) {
            if (chainz[i] != -1) {
                continue;
            }
            int count = 0;
            long n = i;
            temp.add(n);
            while (n > 1) {
                if (function(n) <= 1000000 && chainz[(int) function(n)] != -1) {
                    count += chainz[(int) function(n)] + 1;
                    for (int j = 0; j < temp.size(); j++) {
                        if (temp.get(j) > 1000000) {
                            continue;
                        }
                        chainz[Integer.parseInt(temp.get(j).toString())] = count - j;
                    }
                    break;
                } else {
                    n = function(n);
                    temp.add(n);
                    count++;
                }
            }
            temp.clear();
        }
        int max = 0;
        int ind = 0;
        for (int i = 1; i < chainz.length; i++) {
            if (chainz[i] > max) {
                max = chainz[i];
                ind = i;
            }
        }
        System.out.println(ind);
    }

    public static void main(String[] args) throws IOException {
        LongestCollatz prog = new LongestCollatz();
        prog.run();
    }
}
