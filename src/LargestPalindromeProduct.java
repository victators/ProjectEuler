import java.io.*;
import java.util.*;

public class LargestPalindromeProduct{

    public boolean threeProduct(int N) {
        for (int i = 100; i <= 999; i++)
        {
            if(N % i == 0)
            {
                if (N/i >= 100 && N/i <= 999)
                {
                    return true;
                }
            }
        }
        return false;
    }

    void run() throws IOException {
        int curr = 0;
        for (int i = 9; i >= 1; i--)
        {
            for (int j = 9; j >= 0; j--)
            {
                for (int k = 9; k >= 0; k--)
                {
                    curr = 100000*i + 10000*j + 1000*k + 100*k + 10*j + i;
                    if(threeProduct(curr))
                    {
                        System.out.println(curr);
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        LargestPalindromeProduct prog = new LargestPalindromeProduct();
        prog.run();
    }
}

