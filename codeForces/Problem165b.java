import java.util.*;

public class Problem165b{

	public static boolean check(int n, int k, int v){
		int i = 0;
		int lines = 1;
		while(lines != 0){
			lines = v / (int)(Math.pow(k, i));
			n -= lines;
			if(n<=0)
				return true;
			i++;
			if(i > 9999999)
				return false;
		}
		return false;
	}

	public static void times(int n, int k){
		int lo = 1;
		int hi = n;
		if(hi == lo){
			System.out.println(hi);
			return;
		}
		
		while(hi >= lo){
			int mid = lo + (hi - lo) / 2;
			if(check(n, k, mid)){
				hi = mid;
			}
			else if(check(n, k, lo)){
				System.out.println(lo);
					return;
			}
			else if(!check(n, k, hi-1)){
				System.out.println(hi);
				return;
			}
			else
				lo = mid;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		times(n, k);


	}
}