import java.util.Arrays;

class Solution {
    private boolean[] isPrime = new boolean[1000001];

    public Solution() {
        sieveOfEratosthenes();
    }

    private void sieveOfEratosthenes() {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= 1000000; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 1000000; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    public int[] closestPrimes(int left, int right) {
        right = Math.min(right, 1000000);
        int prev = -1, first = -1, second = -1;
        int minDiff = Integer.MAX_VALUE;

        for (int i = left; i <= right; i++) {
            if (isPrime[i]) {
                if (prev != -1 && (i - prev) < minDiff) {
                    minDiff = i - prev;
                    first = prev;
                    second = i;
                }
                prev = i;
            }
        }

        return (first != -1 && second != -1) ? new int[]{first, second} : new int[]{-1, -1};
    }
}