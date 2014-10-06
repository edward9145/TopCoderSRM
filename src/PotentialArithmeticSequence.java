import java.util.Arrays;

public class PotentialArithmeticSequence {
	public static int numberOfSubsequences(int[] d) {
		int num = 0;
		for(int i=0; i<d.length; i++){
			for(int j=i+1; j<=d.length; j++){
				int[] dSub = Arrays.copyOfRange(d, i, j);
				boolean v = valid(dSub);
				if(v) num ++;
				printsub(dSub, v);
			}
		}
		return num;
	}

	private static void printsub(int[] dSub, boolean v) {
		for(int i=0; i<dSub.length; i++){
			System.out.print(dSub[i] + " ");
		}
		System.out.println(" " + v);
	}

	private static boolean valid(int[] dSub) {
		if(dSub.length <= 1) return true;
		int max = 0;
		int maxIdx = -1;
		for(int i=0; i<dSub.length; i++){
			if(dSub[i] > max){
				maxIdx = i;
				max = dSub[i];
			}
		}
		if(maxIdx == -1) return false;
		
		if(dSub[maxIdx-1]!=0 || dSub[maxIdx+1]!=0) return false;
		int[] left = Arrays.copyOfRange(dSub, 0, maxIdx);
		int[] right = Arrays.copyOfRange(dSub, maxIdx+1, dSub.length);
		
		return valid(left) && valid(right);
	}

	private static int sufZero(int num) {
		int countZero = 0;
		while(num % 2 == 0){
			num /= 2;
			countZero ++;
		}
		return countZero;
	}

	public static void main(String[] args) {
		print(PotentialArithmeticSequence.numberOfSubsequences(new int[] { 0,
				1, 0, 2, 0, 1, 0 })); // 28
		print(PotentialArithmeticSequence.numberOfSubsequences(new int[] { 0,
				0, 0, 0, 0, 0, 0 })); // 7
		print(PotentialArithmeticSequence.numberOfSubsequences(new int[] { 0,
				0, 0, 0, 1, 1, 1 })); // 8
		print(PotentialArithmeticSequence.numberOfSubsequences(new int[] { 0,
				100, 0, 2, 0 })); // 11
		print(PotentialArithmeticSequence.numberOfSubsequences(new int[] { 1,
				11, 3, 0, 1, 0, 1, 0, 1, 0, 1, 0, 3, 0, 2, 0, 0, 0, 0, 1, 2, 3,
				20 })); // 49
	}

	public static void print(Object obj) {
		System.out.println(obj);
	}
}