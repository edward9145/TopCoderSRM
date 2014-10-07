package srm635;
public class QuadraticLaw {
//	public static long getTime(long d) {
//		double delta = 4.0 * d + 1.0;
//		double root = (-1.0 + Math.sqrt(delta))/2.0;
//		return (long)root;
//	}
	
//	public static long getTime(long d) {
//		long t = 1;
//		while( (t*t + t) <= d ){
//			t ++;
//		}
//		return t-1;
//	}

	public static long getTime(long d) {
		long t = (long) Math.sqrt(d);
		if( t * (t+1) > d) return t-1;
		return t;
	}

	
	public static void main(String[] args) {
		print(QuadraticLaw.getTime(1)); // 0
		print(QuadraticLaw.getTime(5)); // 1
		print(QuadraticLaw.getTime(7)); // 2
		print(QuadraticLaw.getTime(1482)); // 38
		print(QuadraticLaw.getTime(1000000000000000000L)); // 999999999
		print(QuadraticLaw.getTime(31958809614643170L)); // 178770270
	}

	public static void print(Object obj) {
		System.out.println(obj);
	}
}