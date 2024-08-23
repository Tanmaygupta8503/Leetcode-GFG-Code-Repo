class Solve {
    int[] findTwoElementMath(int arr[], int k) {
        // code here
        long sum = 0 , square_sum = 0;
        for(int i : arr) {
            sum += (long)i;
            square_sum += (long)i * (long)i;
        }
        long n = arr.length;
        long og_sum = (n * (n + 1L)) / 2L; //original sum from 1 to n
        long diff = sum - og_sum; // {x - y}
        long og_square_sum = (n * (n + 1L) * (2 * n + 1L)) / 6L; // original sum from 1 ^ 1 to n ^ n
        long square_diff = square_sum - og_square_sum; // {x^2 - y^2} 
        long sum_of_xy = square_diff / diff; // {x^2 - y^2} / {x + y} = {x + y}
        long x = (sum_of_xy + diff) / 2L; // {x + y} + {x + y} / 2 = x
        long y = sum_of_xy - x; // {x + y} - x = y
        return new int[]{(int)x , (int)y};
    }
    int[] findTwoElementBitManipulation(int arr[], int k) {
        int n = arr.length;
        int xor = 0; 
        for(int i = 0 ; i < n ; i ++){
            xor ^= arr[i];
            xor ^= (i + 1);
        }
        // xor = x ^ y
        int highest = Integer.highestOneBit(xor); // highest one bit in xor {last bit} 
        int x = 0, y = 0;
        // segregate them in one group and two group
        // {1 , 2 , 3 , 4 , 4} and from {1 , 2 , 3 , 4 , 5}
        for(int i = 0 ; i < n ; i ++) {
            if((highest & arr[i]) != 0) {
                x ^= arr[i];
            } else {
                y ^= arr[i];
            }
            if((highest & (i + 1)) != 0) {
                x ^= (i + 1);
            } else {
                y ^= (i + 1);
            }
        }
        int cnt = 0;
        for(int i : arr) {
            if(i == x) {
                cnt ++;
            }
        }
        if(cnt == 2){ // if count of x is 2 then it is repeating
            return new int[]{x, y};
        } else {
            return new int[]{y, x}; // else y is repeating
        }
    }
}
