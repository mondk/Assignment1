public class IntervalSearch{
	public static void main(String[] args) {
		
		System.out.println(IntervalSearch.intervalContains(5, 11, 3));
		//@ Test
		System.out.println(IntervalSearch.intervalContains(5, 11, 4));
		//@ Test
		System.out.println(IntervalSearch.intervalContains(17, 17, 17));
		//@ Test
		System.out.println(IntervalSearch.intervalContains(17, 17, 5));
		//@ Test
		System.out.println(IntervalSearch.intervalContains(12, 18, 12));
		//@ Test
		System.out.println(IntervalSearch.intervalContains(18, 12, 12));
		//@ Test
		System.out.println(IntervalSearch.intervalContains(18, 24, 12));
		//@ Test
		System.out.println(IntervalSearch.intervalContains(18, 144, 12));
		//@ Test
		System.out.println(IntervalSearch.intervalContains(18, 14403434, 12));
		//@ Test
		System.out.println(IntervalSearch.intervalContains(5, 11, 1));
		//@ Test
		System.out.println(IntervalSearch.intervalContains(1, 5, 1));
	}
	
	public static boolean intervalContains(int g1, int g2, int b) {
		int B=b;
		boolean val = false;
		while(B<=Math.max(g1, g2)) {
			
			if(B>=Math.min(g1, g2)&&B<=Math.max(g1, g2)) {
				val = true;
				break;
			}
			if(B<=1) {
				break;
			}
			
			B*=B;
			
		}
		return val;
	}
} 
