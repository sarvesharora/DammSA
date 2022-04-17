package dynamicProgramming;

public class PrintingLCS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abcd";
		String s2 = "abed";
		int n = s1.length();
		int m= s2.length();
		
		lcs(s1, s2, n, m);

	}
	
	public static void lcs(String s1, String s2, int n,int m) {
		
		int dp[][] = new int[n+1][m+1];
		for(int i = 0; i<dp.length; i++) {
			for(int j= 0; j<dp[0].length; j++) {
				if(j==0 || i==0) {
					dp[i][j] = 0;
				}else {
					if(s1.charAt(i-1)==s2.charAt(j-1)) {
						dp[i][j] = dp[i-1][j-1]+1;
					}else {
						dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int i = dp.length-1;
		int j =dp[0].length-1;
		while(i>=1 && j>=1) {
			if(s1.charAt(i-1)==s2.charAt(j-1)) {
				sb.append(s1.charAt(i-1));
				i--;
				j--;
			}else {
				if(dp[i-1][j]>dp[i][j-1]) {
					i--;
				}else {
					j--;
				}
			}
		}
		
		System.out.println(sb.reverse());
		
			
	}

}
