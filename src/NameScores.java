import java.io.*;
import java.util.*;

public class NameScores {

    String[] names = new String[5163];

    int score(String str) {
        StringBuffer s = new StringBuffer(str);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.substring(i, i + 1).hashCode() - 64;
        }
        return sum;
    }

    void run() throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("ns.in"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        StringBuffer s = new StringBuffer(st.nextToken());
        int i = 0;
        int n = 0;
        while (s.indexOf(",", i) != -1) {
            int j = s.indexOf(",", i);
            names[n] = s.substring(i + 1, j - 1);
            i = j + 1;
            n++;
        }
        names[n] = s.substring(i+1, s.length()-1);
        Arrays.sort(names);
        long sum = 0;
        for (int j = 0; j < names.length; j++) {
            sum += (j + 1) * score(names[j]);
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {
        NameScores prog = new NameScores();
        prog.run();
    }
}
