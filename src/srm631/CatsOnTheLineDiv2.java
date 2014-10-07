package srm631;

public class CatsOnTheLineDiv2 {

	public static String getAnswer(int[] position, int[] count, int time){
		String possible = "Possible";
		String impossible = "Impossible";
		for(int t=0; t<time; t++){
			
		}
		return impossible;
	}
	
	
	public static void main(String[] args) {
		print(CatsOnTheLineDiv2.getAnswer(new int[] {0}, new int[]{7}, 3));    // Possible
		print(CatsOnTheLineDiv2.getAnswer(new int[] {0}, new int[]{8}, 2));		// Impossible
		print(CatsOnTheLineDiv2.getAnswer(new int[] {0, 1}, new int[]{3, 1}, 0));	// Impossible
		print(CatsOnTheLineDiv2.getAnswer(new int[] {5, 0, 2}, new int[] {2, 3, 5},  2));		// Impossible
		print(CatsOnTheLineDiv2.getAnswer(new int[] {5, 1, -10, 7, 12, 2, 10, 20}, new int[] {3, 4, 2, 7, 1, 4, 3, 4}, 6)); // Possible
	}
	
	public static void print(Object obj) {
		System.out.println(obj);
	}

}
