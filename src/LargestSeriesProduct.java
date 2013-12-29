import java.io.*;
import java.util.*;

public class LargestSeriesProduct {
    StringBuffer s = new StringBuffer(
            "731671765313306249192251196744265747423553491949349698352031277450"
                    + "6326239578318016984801869478851843858615607891129494954595017379"
                    + "5833195285320880551112540698747158523863050715693290963295227443"
                    + "0435576689664895044524452316173185640309871112172238311362229893"
                    + "4233803081353362766142828064444866452387493035890729629049156044"
                    + "0772390713810515859307960866701724271218839987979087922749219016"
                    + "9972088809377665727333001053367881220235421809751254540594752243"
                    + "5258490771167055601360483958644670632441572215539753697817977846"
                    + "1740649551492908625693219784686224828397224137565705605749026140"
                    + "7972968652414535100474821663704844031998900088952434506585412275"
                    + "8866688116427171479924442928230863465674813919123162824586178664"
                    + "5835912456652947654568284891288314260769004224219022671055626321"
                    + "1111093705442175069416589604080719840385096245544436298123098787"
                    + "9927244284909188845801561660979191338754992005240636899125607176"
                    + "0605886116467109405077541002256983155200055935729725716362695618"
                    + "82670428252483600823257530420752963450");

    private void removeZeroes(StringBuffer s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                s.deleteCharAt(i);
            }
        }
    }

    void run() throws IOException {
        removeZeroes(s);
        int curr = 1;
        for (int i = 0; i < 5; i++) {
            curr *= Integer.parseInt(s.substring(i, i + 1));
        }
        int max = curr;
        for (int i = 5; i < 1000; i++) {
            int prev = Integer.parseInt(s.substring(i - 5, i - 4));
            int next = Integer.parseInt(s.substring(i, i + 1));
            if (prev == 0 || next == 0)
                continue;
            curr = curr * next / prev;
            if (curr > max)
                max = curr;
            System.out.println(max);
        }
        System.out.println(max);
    }

    public static void main(String[] args) throws IOException {
        LargestSeriesProduct prog = new LargestSeriesProduct();
        prog.run();
    }
}
