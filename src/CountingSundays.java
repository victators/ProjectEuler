import java.io.*;
import java.util.*;

public class CountingSundays {

    int[] offset = { 3, 0, 3, 2, 3, 2, 3, 3, 2, 3, 2, 3 };

    void run() throws IOException {
        int init = 2;
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 4 == 0)
                offset[1] = 1;
            for (int j = 0; j < 12; j++) {
                init += offset[j % 12];
                init %= 7;
                if (init == 0) {
                    count++;
                }
            }
            offset[1] = 0;
        }
        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        CountingSundays prog = new CountingSundays();
        prog.run();
    }
}
