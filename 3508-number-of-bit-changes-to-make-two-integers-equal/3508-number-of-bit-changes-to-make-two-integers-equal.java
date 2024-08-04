class Solution {
    public int minChanges(int n, int k) {
        if(n == k) return 0;
        String num = Integer.toBinaryString(Integer.parseInt(n+""));
        String knum = Integer.toBinaryString(Integer.parseInt(k+""));
        while (num.length() < knum.length()) {
            num = '0' + num;
        }
        while (knum.length() < num.length()) {
            knum = '0' + knum;
        }
        int changes = 0;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) != knum.charAt(i)) {
                if(num.charAt(i) == '1')
                    changes++;
                else return -1;
            }
        }
        return changes == 0 ? -1 : changes; 
    }
}