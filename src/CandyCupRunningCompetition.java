public class CandyCupRunningCompetition {
	public static int findMaximum(int N, int[] A, int[] B) {
		return 0;
	}

	public static void main(String[] args) {
		print(CandyCupRunningCompetition.findMaximum(3, new int[] { 0, 1 },
				new int[] { 1, 2 })); // 1
		print(CandyCupRunningCompetition.findMaximum(4,
				new int[] { 0, 1, 0, 2 }, new int[] { 1, 3, 2, 3 })); // 10
		print(CandyCupRunningCompetition.findMaximum(5, new int[] {},
				new int[] {})); // 0
		print(CandyCupRunningCompetition.findMaximum(6, new int[] { 1, 1, 2, 0,
				4, 3, 0, 1, 4 }, new int[] { 3, 2, 3, 1, 5, 5, 2, 4, 3 })); // 39
	}

	public static void print(Object obj) {
		System.out.println(obj);
	}
}