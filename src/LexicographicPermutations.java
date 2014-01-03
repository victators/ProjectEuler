import java.io.*;
import java.util.*;

public class LexicographicPermutations {
    
    int[] facts = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
    ArrayList<Integer> l;
    
    void run() throws IOException {
        l = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++)
            l.add(i);
        int n = 999999;
        StringBuffer s = new StringBuffer("");
        for (int i = 9; i >= 0; i--)
        {
            s.append(l.get(n/facts[i]));
            l.remove(n/facts[i]);
            n %= facts[i];
        }
        System.out.println(s.toString());
    }

    public static void main(String[] args) throws IOException {
        LexicographicPermutations prog = new LexicographicPermutations();
        prog.run();
    }
}

