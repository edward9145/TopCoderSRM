import java.util.Arrays;


public class MysticAndCandiesEasy {

	public static int minBoxes(int C, int X, int[] high){
		int N = high.length;
		int ans = N;
		int total = C;
		Arrays.sort(high);
		for(int i=0; i<N; i++){
			if(total - high[i] >= X){
				total -= high[i];
				ans --;
			}
		}
		return ans;
	}
	
	
	public static void main(String[] args) {
		print(minBoxes(10, 10, new int[]{20}));
		print(minBoxes(10, 7, new int[]{3,3,3,3,3}));
		print(minBoxes(100, 63, new int[]{12, 34, 23, 45, 34}));
		print(minBoxes(19, 12, new int[]{12, 9, 15, 1, 6, 4, 9, 10, 10, 10, 14, 14, 1, 1, 12, 10, 9, 2, 3, 6, 1, 7, 3, 4, 10, 3, 14}));
		print(minBoxes(326, 109, new int[]{9, 13, 6, 6, 6, 16, 16, 16, 10, 16, 4, 3, 10, 8, 11, 17, 12, 5, 7, 8, 7, 4, 15, 7, 14, 2, 2, 1, 17, 1, 7, 7, 12, 17, 2, 9, 7, 1, 8, 16, 7, 4, 16, 2, 13, 3, 13, 1, 17, 6}));
	}
	
	public static void print(Object obj) {
		System.out.println(obj);
	}


}
