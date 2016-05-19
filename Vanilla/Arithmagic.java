import java.util.*;
public class Arithmagic{

	public static void print(int[] nums){
		for(int i : nums)
			System.out.print(i + " ");
		System.out.println("");

	}

	public static boolean solve(int[] nums, int idx, long current, long ans){
		if(current < 0){
			return false;
		}
		if(idx >= nums.length){
			if(current == ans){
				return true;
			}
			else{
				return false;
			}
		}
		
		return solve(nums,idx+1, current + nums[idx], ans) 
				|| solve(nums, idx+1, current * nums[idx], ans) 
				|| solve(nums,idx+1, current - nums[idx], ans);
	}



	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		for(int i = 1; i <= tests; i++){
			int n = sc.nextInt(); 
			int[] temp = new int[n];
			for(int k = 0; k < n; k++){
				temp[k] = sc.nextInt();
			}

			long ans = sc.nextLong();
			boolean p = solve(temp, 1, temp[0], ans);
			if(p)
				System.out.println("PASS");
			else
				System.out.println("FAIL");
			
			

		}

	}
}