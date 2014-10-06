public class QuadraticLaw {
	public static long getTime(long d) {
		double delta = 4.0 * d + 1.0;
		double root = (-1.0 + Math.sqrt(delta))/2.0;
		return (long)root;
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