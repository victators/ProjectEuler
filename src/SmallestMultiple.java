import java.io.*;
import java.util.*;

public class SmallestMultiple {

    public long gcd(long a, long b) {
        if (b == 0)
            return a;
        else
            return (gcd(b, a % b));
    }

    public long lcm(long a, long b) {
        return a * (b / gcd(a, b));
    }

    void run() throws IOException {
        long lcm = 1;
        for (int i = 1; i <= 20; i++) {
            lcm = lcm(i, lcm);
        }
        System.out.println(lcm);
    }

    public static void main(String[] args) throws IOException {
        SmallestMultiple prog = new SmallestMultiple();
        prog.run();
    }
}
