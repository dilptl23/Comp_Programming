import java.util.*;

public class Problem189a{

	public static int solution(int remaining, int[] lengths, HashMap<Integer, Integer> saved){
		if(remaining == 0)
			return 0;
		else if(remaining < 0)
			return Integer.MIN_VALUE;
		else if(saved.containsKey(remaining))
			return saved.get(remaining);
		else{
			int a = 1 + solution(remaining - lengths[0], lengths, saved);
			int b = 1 + solution(remaining - lengths[1], lengths, saved);
			int c = 1 + solution(remaining - lengths[2], lengths, saved);
			int max = Math.max(a, Math.max(b, c));
			saved.put(remaining, max);
			return max;
		}
	}



	// public static int solution(int remaining, int[] lengths, int ans){
	// 	int x;
	// 	if(remaining >= lengths[0]){
	// 		x = solution(remaining - lengths[0], lengths, ans+1);
	// 		if(x == -1){
	// 			x = solution(remaining - lengths[1], lengths, ans+1);
	// 			if(x == -1){
	// 				return solution(remaining - lengths[2], lengths, ans+1);
	// 			}
	// 			else
	// 				return x;

	// 		}
	// 		else
	// 			return x;
	// 	}
	// 	else{
	// 		if(ans != 0)
	// 			return -1;
	// 		else
	// 			return ans;
	// 	}
	// }


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] lengths = new int[3];
		for(int i = 0; i < 3; i++){
			lengths[i] = sc.nextInt();
		}
		Arrays.sort(lengths);
		System.out.println(solution(n, lengths, new HashMap<Integer, Integer>()));		

	}
}