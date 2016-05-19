import java.util.*;
public class NDigitSum{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();

		for(int t = 0; t < tests; t++){
			int n = sc.nextInt();
			int s = sc.nextInt();
			s = s % (int)(Math.pow(10, 9) + 1);
			int digits[][] = new int[n+1][s+1];

			for(int i = 0; i <= s; i++){
				digits[1][i] = 1;
			}

			for (int x = 2; x <= n; x++  ) {
				for(int y = 1; y <=s; y++){
					digits[x][y] += digits[x][y-1] + digits[x-1][y];
				}
				
			}

			System.out.println(digits[n][s]);
		}
		
	}

}
