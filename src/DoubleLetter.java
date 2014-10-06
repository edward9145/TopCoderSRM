public class DoubleLetter {
	public static String ableToSolve(String S) {
		return "Posi";
	}

	public static void main(String[] args) {
		print(DoubleLetter.ableToSolve("aabccb")); // "Possible"
		print(DoubleLetter.ableToSolve("aabccbb")); // "Impossible"
		print(DoubleLetter.ableToSolve("abcddcba")); // "Possible"
		print(DoubleLetter.ableToSolve("abab")); // "Impossible"
		print(DoubleLetter.ableToSolve("aaaaaaaaaa")); // "Possible"
		print(DoubleLetter.ableToSolve("aababbabbaba")); // "Impossible"
		print(DoubleLetter.ableToSolve("zzxzxxzxxzzx")); // "Possible"
	}

	public static void print(Object obj) {
		System.out.println(obj);
	}
}