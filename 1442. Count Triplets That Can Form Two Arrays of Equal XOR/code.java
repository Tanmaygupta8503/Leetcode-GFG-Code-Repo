// Time Complexity = O(300 * 300 * 300 * (300 + 300)) = (16,20,00,00,000) = O(N ^ 4) this can give TLE
class Solution1 {
    public int countTriplets(int[] arr) {
        int n = arr.length , cnt = 0;
        for(int i = 0 ; i < n ; i ++) {
            for(int j = i + 1 ; j < n ; j ++) {
                for(int k = j ; k < n ; k ++) {
                    int a = 0 , b = 0;
                    for(int l = i ; l < j ; l ++) {
                        a ^= arr[l];
                    }
                    for(int l = j ; l <= k ; l ++) {
                        b ^= arr[l];
                    }
                    if(a == b) cnt ++;
                }
            }
        }
        return cnt;
    }
}


// Time Complexity = O(N^3) 
// approach a1 ^ a2 ^ a3 ^ a4 == 0 then (a1 == a2 ^ a3 ^ a4) and (a1 ^ a2 = a3 ^ a4) and (a1 ^ a2 ^ a3 = a4)
// if a1 ^ a2 ^ a3 ^ a4 == 0 then end - start number of such triplets exists.
class Solution2 {
    public int countTriplets(int[] arr) {
        int n = arr.length , cnt = 0;
        for(int i = 0 ; i < n ; i ++) {
            for(int k = i + 1 ; k < n ; k ++) {
                int a = 0;
                for(int l = i ; l <= k ; l ++) { // xor from i to k
                    a ^= arr[l];
                }
                if(a == 0) cnt += (k - i);
            }
        }
        return cnt;
    }
}

// Time Complexity = O(n ^ 2) 
/*
    approach
    * arr =       {2 , 3 , 1 , 6 , 7}
    * prefixXor = {0 , 2 , 1 , 0 , 6 , 1}
    * where pref[i] == pref[k] then cnt += (k - (i + 1)) 
    * this means that the prefixXor from i + 1 to k is zero  so it is a pair (i + 1 , k) where all elements b/w 
      this range is zero
*/
class Solution3 {
    public int countTriplets(int[] arr) {
        int n = arr.length , cnt = 0;
        int prefixXor[] = new int[arr.length + 1];
        System.arraycopy(arr , 0 , prefixXor , 1 , arr.length);
        prefixXor[0] = 0;
        for(int i = 1 ; i <= n ; i ++) {
            prefixXor[i] ^= prefixXor[i - 1];
        }   
        for(int i = 0 ; i < n + 1 ; i ++) {
            for(int j = i + 1 ; j < n + 1 ; j ++) {
                if(prefixXor[i] == prefixXor[j]) cnt += (j - (i + 1));
            }
        }
        return cnt;
    }
}

// optimization with map
class Solution4 {
    public int countTriplets(int[] arr) {
        int n = arr.length , cnt = 0;
        int prefixXor[] = new int[arr.length + 1];
        System.arraycopy(arr , 0 , prefixXor , 1 , arr.length);
        prefixXor[0] = 0;
        for(int i = 1 ; i <= n ; i ++) {
            prefixXor[i] ^= prefixXor[i - 1];
        }   
        Map<Integer , ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            if (map.containsKey(prefixXor[i])) {
                var list = map.get(prefixXor[i]);
                for (int val : list) {
                    cnt += (i - (val + 1));
                }
                list.add(i);
            } else {
                map.put(prefixXor[i], new ArrayList<>(Arrays.asList(i)));
            }
        }
        return cnt;
    }
}



// more optimization in one loop
class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length , cnt = 0;
        int prefixXor = 0;   
        Map<Integer , ArrayList<Integer>> map = new HashMap<>();
        map.put(0 ,  new ArrayList<>(Arrays.asList(0)));
        for (int i = 1; i <= n; i++) {
            prefixXor ^= arr[i-1];
            if (map.containsKey(prefixXor)) {
                var list = map.get(prefixXor);
                for (int val : list) {
                    cnt += (i - (val + 1));
                }
                list.add(i);
            } else {
                map.put(prefixXor, new ArrayList<>(Arrays.asList(i)));
            }
        }
        return cnt;
    }
}
