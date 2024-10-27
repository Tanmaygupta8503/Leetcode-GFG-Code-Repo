class Solution {
    public int countSquares(int[][] input) {
        if(input.length == 0 && input[0].length == 0)
        return 0;
        int dp [][] =new int [input.length][input[0].length];
		int max = 0;
		for(int i = 0 ; i < input.length; i ++)
		{
			for(int  j = 0 ; j < input[0].length ; j ++)
			{
				if(i == 0)
				{
					if(input[i][j] == 1)
						dp[i][j] = 1;
					else
						dp[i][j] = 0;
				}
				if (j == 0) {
					if (input[i][j] == 1)
						dp[i][j] = 1;
					else
						dp[i][j] = 0;
				}
				if(i != 0 && j != 0){
					if(input[i][j] == 1)
					{
						dp[i][j] = 1+Math.min(dp[i-1][j-1] , Math.min(dp[i-1][j] , dp[i][j-1]));
					}
				}
				max = Math.max(max, dp[i][j]);
			}
		}
        int sum = 0;
        for(int arr[] : dp)
        {
            for(int i : arr)
            {
                sum += i;
            }
        }
		return sum;
    }
}