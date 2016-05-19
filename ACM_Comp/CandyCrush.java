import java.util.*;

public class CandyCrush{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		for(int z = 0; z < tests; z++){
			//need xyz array
			int changes = 0;
			int[] xyz = new int[3];
			int[] abc = new int[3];
			for(int i = 0; i < 3; i++){
				xyz[i] = sc.nextInt();
			}
			for(int i = 0; i < 3; i++){
				abc[i] = sc.nextInt();
			}

			for(int i = 0; i < 3; i++){
				int target = xyz[i];
				int current = abc[i];

				while(target != current){
					if((target < current) && (current % 2==0)){
						current /= 2;
						changes++;
					}
					else{
						current++;
						changes++;
					}
				}

			}

			System.out.println(changes);

		}
	}
}