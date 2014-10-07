package alg;
/**
 * c[i][j] = 0  (i = 0 或 j = 0)
 * c[i][j] = c[i - 1][j - 1] + 1  (i ,j > 0 和 x[i] == y[i])
 * c[i][j] = max{c[i][j - 1], c[i - 1][j])  (i ,j > 0 和 x[i] <> y[i])
 */

public class LongestCommonSubsequence {

	public static String lcs(String x, String y) {
        int M = x.length();
        int N = y.length();
        StringBuffer lcs = new StringBuffer(M>N?M:N);
        
        // opt[i][j] = length of LCS of x[i..M] and y[j..N]
        int[][] opt = new int[M+1][N+1];

        // compute length of LCS and all subproblems via dynamic programming
        for (int i = M-1; i >= 0; i--) {
            for (int j = N-1; j >= 0; j--) {
                if (x.charAt(i) == y.charAt(j))
                    opt[i][j] = opt[i+1][j+1] + 1;
                else 
                    opt[i][j] = Math.max(opt[i+1][j], opt[i][j+1]);
            }
        }

        // recover LCS itself and print it to standard output
        int i = 0, j = 0;
        while(i < M && j < N) {
            if (x.charAt(i) == y.charAt(j)) {
                System.out.print(x.charAt(i));
                lcs.append(x.charAt(i));
                i++;
                j++;
            }
            else if (opt[i+1][j] >= opt[i][j+1]) i++;
            else                                 j++;
        }
        System.out.println();

        return lcs.toString();
    }
	
	public static void main(String[] args) {
//		String str1 = "adbccadebbca";
//		String str2 = "edabccadece";
		String str1 = "adbba1234as";
		String str2 = "adbbf1234sa";
		String lcs = LongestCommonSubsequence.lcs(str1, str2);
		System.out.println(lcs);
		System.out.println(lcs.length());
	}

}
