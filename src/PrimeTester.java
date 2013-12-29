public class PrimeTester {
    static boolean[] isPrime;

    public static void PrimeTester(int N) {
        isPrime = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i; i * j <= N; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
    }

    public static void main(String args[]) {
        PrimeTester(10101);
        System.out.println(isPrime[10101]);
    }
}
