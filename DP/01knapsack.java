static Boolean isSubsetSum(int N, int arr[], int sum){
        boolean dp[][] = new boolean[N+1][sum+1];
        for(int i = 0; i<dp.length; i++){
            for(int j =0; j<dp[0].length; j++){
                if(j==0){
                    dp[i][j] = true;
                }else if(i==0){
                    dp[i][j] = false;
                }else{
                    if(j>=arr[i-1]){
                        dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        return dp[N][sum];
    }