 
public class NumberCheck {
	public static void main(String[] args) {
		String n = "01000000008";
		System.out.println(check(n));
		
	}
	public static boolean check(String number) {
		// Nye strenge defineres
		String new_x = "";
		String reverse = "";
		
		// Vender strengen med tal om, for 
		for (int j= number.length()-1; j >= 0; j--) {
			reverse = reverse+number.charAt(j);
		}
		
		for (int i = 0; i < reverse.length(); i ++) {
			// Hvis index er lige, gøres intet, og tallet på index tilføjes den nye streng
			if (i%2 == 0) {
				new_x = new_x + reverse.charAt(i);
			
			// Hvis index er ulige ganges tallet med 2, dog hvis dette er højere end 10, findes
			// modulus 10 der bliver adderet med 1, og dette tal tilføes så den nye streng.
			}else if (i%2 == 1) {
				int y = 2 * Integer.parseInt(String.valueOf(reverse.charAt(i))); 
				if (y >= 10) {
					y = y%10 + 1;
				}
				new_x = new_x + y;
			}
		}
		
		int cross_sum = 0;
		// Kryds summen af det nye tal findes
		for (int i = 0; i < new_x.length(); i++) {
			cross_sum += Integer.parseInt(String.valueOf(new_x.charAt(i)));
		}
		// Tjek om hvor kryds summen har modulue 10 = 0
		if (cross_sum %10 == 0) 
			return true;
		else 
			return false;
	}
}
