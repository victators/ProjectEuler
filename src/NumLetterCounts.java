import java.io.*;
import java.util.*;

public class NumLetterCounts {

    int[] letters;

    void run() throws IOException {
        letters = new int[1001];
        int[] init = { 3, 3, 5, 4, 4, 3, 5, 5, 4, 6, 6, 8, 8, 7, 7, 9, 8, 8, 3,
                6, 6, 5, 5, 5, 7, 6, 6 };
        for (int i = 0; i < 9; i++) {
            letters[i + 1] = init[i];
        }
        for (int i = 9; i < 18; i++) {
            letters[i + 2] = init[i];
        }
        for (int i = 18; i < 27; i++) {
            letters[10 * (i - 17)] = init[i];
        }
        for (int i = 21; i < 100; i++) {
            if (i % 10 == 0)
                continue;
            letters[i] = letters[(i / 10) * 10] + letters[i % 10];
        }
        for (int i = 100; i < 1000; i++) {
            if (i % 100 == 0) {
                letters[i] = letters[i / 100] + 7;
                continue;
            }
            letters[i] = letters[i / 100] + 10 + letters[i % 100];
        }
        letters[1000] = 11;
        int sum = 0;
        for (int i = 1; i < letters.length; i++) {
            sum += letters[i];
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {
        NumLetterCounts prog = new NumLetterCounts();
        prog.run();
    }
}
