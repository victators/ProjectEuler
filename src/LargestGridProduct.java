import java.io.*;
import java.util.*;

public class LargestGridProduct {

    public int[][] grid;

    private void replaceZeroes(int[][] gr) {
        for (int i = 0; i < gr.length; i++) {
            for (int j = 0; j < gr[i].length; j++) {
                if (gr[i][j] == 0) {
                    gr[i][j] = -1;
                }
            }
        }
    }

    void run() throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("lgp.in"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        grid = new int[x][y];
        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(f.readLine());
            for (int j = 0; j < y; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        replaceZeroes(grid);
        int max = 1;
        int curr;

        // east
        for (int i = 0; i < x; i++) {
            curr = 1;
            for (int j = 0; j < 4; j++) {
                curr *= grid[i][j];
            }
            for (int j = 4; j < y; j++) {
                curr = curr * grid[i][j] / grid[i][j - 4];
                if (curr > max) {
                    max = curr;
                }
            }
        }

        // south
        for (int j = 0; j < y; j++) {
            curr = 1;
            for (int i = 0; i < 4; i++) {
                curr *= grid[i][j];
            }
            for (int i = 4; i < y; i++) {
                curr = curr * grid[i][j] / grid[i - 4][j];
                if (curr > max) {
                    max = curr;
                }
            }
        }

        // southeast
        for (int j = -y + 4; j <= y - 4; j++) {
            curr = 1;
            for (int i = 0; i < 4; i++) {
                if (j < 0)
                    curr *= grid[i - j][i];
                else
                    curr *= grid[i][j + i];
            }
            int j1 = Math.abs(j);
            if (j1 == y - 4) {
                if (curr > max) {
                    max = curr;
                }
                continue;
            }
            for (int i = 0; i < y - 4 - j1; i++) {
                if (j < 0) {
                    curr = (curr / grid[j1 + i][i]) * grid[j1 + i + 4][i + 4];
                } else
                    curr = (curr / grid[i][j + i]) * grid[i + 4][j + i + 4];
                if (curr > max) {
                    max = curr;
                }
            }
        }

        // southwest
        for (int j = -y + 4; j <= y - 4; j++) {
            curr = 1;
            for (int i = 0; i < 4; i++) {
                if (j < 0)
                    curr *= grid[i - j][y - i - 1];
                else
                    curr *= grid[i][y - i - j - 1];
            }
            int j1 = Math.abs(j);
            if (j1 == y - 4) {
                if (curr > max) {
                    max = curr;
                }
                continue;
            }
            for (int i = 0; i < y - 4 - j1; i++) {
                if (j < 0) {
                    curr = (curr / grid[j1 + i][y - i - 1])
                            * grid[j1 + i + 4][y - i - 5];
                } else
                    curr = (curr / grid[i][y - j - i - 1])
                            * grid[i + 4][y - i - j - 5];
                if (curr > max) {
                    max = curr;
                }
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) throws IOException {
        LargestGridProduct prog = new LargestGridProduct();
        prog.run();
    }
}
