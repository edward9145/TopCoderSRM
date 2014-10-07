package srm635;
public class IdentifyingWood {
	public static String check(String s, String t) {
		String yep = "Yep, it's wood.";
		String nope = "Nope.";
		if (s.length() < t.length())
			return nope;
		if(LCS.len(s, t) >= t.length()) 
			return yep;
		return nope;
	}

	public static void main(String[] args) {
		print(IdentifyingWood.check("absdefgh", "asdf"));
		print(IdentifyingWood.check("oxoxoxox","ooxxoo"));
		print(IdentifyingWood.check("oxoxoxox","xxx"));
		
		print(IdentifyingWood.check("qwerty", "qwerty")); // "Yep, it's wood."
		print(IdentifyingWood.check("string", "longstring")); // "Nope."
		print(IdentifyingWood.check("string", "longstring")); // "Nope."
	}

	public static void print(Object obj) {
		System.out.println(obj);
	}
}

class LCS {

    public static int len(String x, String y) {
    	int clen = 0;
        int M = x.length();
        int N = y.length();
        
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
                clen ++;
                i++;
                j++;
            }
            else if (opt[i+1][j] >= opt[i][j+1]) i++;
            else                                 j++;
        }
        System.out.println();

        return clen;
    }

}