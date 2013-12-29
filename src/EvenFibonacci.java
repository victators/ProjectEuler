import java.io.*;
import java.util.*;

public class EvenFibonacci {
    
    void run() throws IOException {
        int curr = 1;
        int prev = 1;
        int sum = 0;
        while (curr < 4000000) {
            if (curr % 2 == 0)
                sum += curr;
            curr = curr + prev;
            prev = curr - prev;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {
        EvenFibonacci prog = new EvenFibonacci();
        prog.run();
    }
}
