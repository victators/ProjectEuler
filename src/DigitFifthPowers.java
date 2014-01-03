import java.io.*;
import java.util.*;

public class DigitFifthPowers {

    int[][] digits = new int[1000000][6];
    int[] fives = { 0, 1, 32, 243, 1024, 3125, 7776, 16807, 32768, 59049 };

    void run() throws IOException {
        int sum = 0;
        int s = 0;
        int t = 0;
        for (int i = 2; i < 1000000; i++) {
            s = 0;
            t = i;
            for (int j = 0; j < 6; j++) {
                digits[i][j] = t / (int) Math.pow(10, 5 - j);
                t %= (int) Math.pow(10, 5 - j);
                s += fives[digits[i][j]];
            }
            if (s == i) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {
        DigitFifthPowers prog = new DigitFifthPowers();
        prog.run();
    }
}
