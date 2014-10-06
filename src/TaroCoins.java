
public class TaroCoins {

	public static long getNumber(long N){
		long ans = rec(N, 0);
		return ans;
	}
	
	public static long rec(long n, int co){
		if (n == 1) return co+1;
		
		long k = n % 2;
		if (k==1){
			return co*rec(n/2, 1) + rec(n/2, 0);
		}
		else{
			return rec(n/2, co+1);
		}
	}

	public static void main(String[] args) {
		print(TaroCoins.getNumber(1)); // 1
		print(TaroCoins.getNumber(6)); // 3
		print(TaroCoins.getNumber(47)); // 2
		print(TaroCoins.getNumber(256)); // 9
		print(TaroCoins.getNumber(8489289)); // 6853
		print(TaroCoins.getNumber(1000000000)); // 73411
	}
	
	public static void print(Object obj) {
		System.out.println(obj);
	}

}
