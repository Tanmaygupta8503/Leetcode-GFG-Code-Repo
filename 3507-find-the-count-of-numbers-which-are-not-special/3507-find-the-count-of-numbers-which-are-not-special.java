class Solution {
    private static List<Integer> sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for (int p = 2; p <= n; p++) {
            if (isPrime[p]) {
                primes.add(p);
            }
        }
        return primes;
    }

    public int nonSpecialCount(int l, int r) {
        int upperLimit = (int) Math.sqrt(r) + 1;
        List<Integer> primes = sieve(upperLimit);
        Set<Integer> specialNumbers = new HashSet<>();
        for (int prime : primes) {
            int special = prime * prime;
            if (l <= special && special <= r) {
                specialNumbers.add(special);
            }
        }
        int totalCount = r - l + 1;
        int specialCount = specialNumbers.size();
        int nonSpecialCount = totalCount - specialCount;
        return nonSpecialCount;
    }
}