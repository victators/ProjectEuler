import java.io.*;
import java.util.*;

public class MaxPathSumII {

    int[][] tree;
    int[][] dp;

    int sum(int row, int col) {
        if (row >= tree.length) {
            return 0;
        }
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        int ho = 0;
        ho = Math.max(ho, sum(row + 1, col));
        ho = Math.max(ho, sum(row + 1, col + 1));
        dp[row][col] = ho + tree[row][col];
        return dp[row][col];
    }

    void run() throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("mps2.in"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        tree = new int[n][n];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            for (int j = 0; j <= i; j++) {
                tree[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        System.out.print(sum(0, 0));
    }

    public static void main(String[] args) throws IOException {
        MaxPathSumII prog = new MaxPathSumII();
        prog.run();
    }
}
