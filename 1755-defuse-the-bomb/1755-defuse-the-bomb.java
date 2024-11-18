class Solution {
    public int[] decrypt(int[] code, int k) {
        if (k == 0)
        {
            return new int[code.length];
        }
        int[] res = new int[code.length];
        if(k > 0)
        {
            for(int i = 0; i < code.length; i++)
            {
                for(int j = i + 1; j <= i + k; j++)
                {
                    res[i] += code[j % code.length];
                }
            }
        }
        else
        {
            for(int i = 0; i < code.length; i++)
            {
                int l = Math.abs(k);
                for(int j = i - 1 + code.length; l > 0; j--)
                {
                    res[i] += code[j % code.length];
                    l--;
                }
            }
        }
        return res;       
    }
}