import java.util.*;
public class Problem407b{


	public static int solve(int n, int[] r){
		int[] slashes = new int[n+1];
		slashes[1] = 1;
		//not going to use idx 0 for simplicity
		int curRoom = 1;
		int count = 0;
		while(curRoom != (n + 1)){
			count =count % 1000000007;
			//if slashes are even
			if(slashes[curRoom] % 2 == 0){
				curRoom++;
				count++;
			}
			else{
				curRoom = r[curRoom];
				count++;
			}

			if(curRoom == (n+1)){
				return count;
			}
			slashes[curRoom]++;
			//slash at end
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] r = new int[n+1];
		for(int i = 1; i < n+1; i++){
			r[i] = sc.nextInt();
		}

		System.out.println(solve(n, r));


	}
}