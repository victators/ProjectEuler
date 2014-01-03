import java.io.*;
import java.util.*;

public class NumberSpiral {
    
    void run() throws IOException {
        long x = 1001;
        System.out.println((4*x*x*x + 3*x*x + 8*x - 9)/6);
    }

    public static void main(String[] args) throws IOException {
        NumberSpiral prog = new NumberSpiral();
        prog.run();
    }
}

