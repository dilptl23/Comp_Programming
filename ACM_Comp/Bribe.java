import java.util.*;

public class Bribe{
	
	public static void main(String[] args) {fddddsd
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();

		for(int z = 0; z < tests; z++){
			int a = sc.nextInt();
			int b = sc.nextInt();

			//need to go through a * 3 ints and put them in a a * 4 array
			int[][] bags = new int[a][4];
			for(int i = 0; i < a; i++){
				for(int j = 0; j < 4; j++){
					bags[i][j] = sc.nextInt();
				}
			}

			//will store ta's that we have bribed
			ArrayList<String> bribedTa = new ArrayList<String>();
			//loop through all ta;s
			for(int t = 0; t < b; t++){
				String name = sc.next();
				int happiness = sc.nextInt();
				int[] levels = new int[4];
				for(int i = 0; i < 4; i++){
					levels[i] = sc.nextInt();
				}

				//for each bag check if it makes them happy
				for(int i = 0; i < a; i++){
					int temp = happiness;
					for (int j =0; j<4; j++) {
						temp = temp - (bags[i][j]*levels[j]);
					}
					if(temp <= 0){
						bribedTa.add(name);
						break;
					}
				}
			}

			String[] s = new String[bribedTa.size()];
			s = bribedTa.toArray(s);
			Arrays.sort(s);
			for(String n : s)
				System.out.print(n + " ");
			System.out.println("");

		}
		

		


		/*for(int i = 0; i < a; i++){
			for(int j = 0; j < 4; j++){
				System.out.print(bags[i][j]);
			}
			System.out.println(" ");
		}*/
	}
}