import java.io.*;
import java.util.*;

public class SpecialPythag {
    int a;
    int b; 
    int c;
    
    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return (gcd(b, a % b));
    }
    
    void run() throws IOException {
        for (int m = 1; m <= 32; m++)
        {
            for (int n = 1; n < m; n++)
            {
                if((m - n) %2 == 1 && gcd(m,n) == 1)
                {
                    a = m*m - n*n;
                    b = 2*m*n;
                    c = m*m + n*n;
                    if (1000%(a+b+c) == 0)
                    {
                        int k = 1000/(a+b+c);
                        System.out.println(a*b*c*k*k*k);
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        SpecialPythag prog = new SpecialPythag();
        prog.run();
    }
}
