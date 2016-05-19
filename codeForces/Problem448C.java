import java.util.*;
public class Problem448C{

	public static int paint(int x, int y, int[] a){
		int ans = Integer.MAX_VALUE;
		int topL = -1;
		int topR = 0;
		//find min plank and put in ans
		for(int j = x; j <= y; j++){
			if(a[j] < ans){
				ans = a[j];
			}
		}

		//subtract min, essentially paint the bottom horizontally and keep doing it as long as possible
		for(int j = x; j <= y; j++){
			if(a[j] != 0){
				a[j] -= ans;
			}
		}
		
		
		//essentailly finds groups of planks together that can be painted horizontally. topL is the left most plank of this group
		//topR is the right most plank of this group
		for(int j = x; j <= y+1; j++){
			if(j != y+1 && a[j] != 0){
				if(topL == -1)
					topL = j;
				topR = j;
			}
			else if(topL != -1){
				ans += paint(topL, topR, a);
				topL = -1;
			}
		}
		int alt = y - x +1;
		if(ans < alt)
			return ans;
		return alt;
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		//sc.nextLine();
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
		}

		System.out.println(paint(0, n-1, a));
		

	}
}
