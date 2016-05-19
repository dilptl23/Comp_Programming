import java.util.*;

public class Problem267a{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		int count = 0;
		for(int t = 0; t < tests; t++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			count = 0;
			
			while(a != 0 && b != 0){
				//System.out.println("a: " + a + "   b: " + b + "  count: " + count);
				if(b < a){
					int temp = b;
					b = a;
					a = temp;
				}

				int d = b / a;
				count += d;
				b -= (d*a);
			}
			
			System.out.println(count);

		}



	}
}