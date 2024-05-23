class Solution {
    public int[] closestPrimes(int left, int right) {
        var list = sieve();
        int min = Integer.MAX_VALUE;
        int first = -1;
        int second = -1;
        for(int i = 1 ; i < list.size() ; i ++) {
            if(list.get(i) >= left && list.get(i) <= right && list.get(i - 1) >= left && list.get(i - 1) <= right) {
                if(list.get(i) - list.get(i - 1) < min) {
                    first = list.get(i);
                    second = list.get(i - 1);
                    min = list.get(i) - list.get(i - 1);
                }
            }
        }
        return new int[]{second , first};
    }
    public List<Integer> sieve() {
        boolean[] primes = new boolean[1000_001];
        Arrays.fill(primes, true);
        primes[0] = false; // 0 is not a prime number
        primes[1] = false; // 1 is not a prime number
        for (int i = 2; i * i < primes.length; i++) {
            if (primes[i]) {
                for (int j = i * i; j < primes.length; j += i) {
                    primes[j] = false;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                list.add(i);
            }
        }
        return list;
    }
}