import java.util.*;

public class Problem320b{
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int tests = sc.nextInt();

	int n = 0;
	int q = 0;
	boolean[][] master = new boolean[101][101];
	int[] x = new int[101];
	int[] y = new int[101];
	for (int i = 0; i < tests; i++ ) {
		int type = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		if(type == 2){
			if(master[a][b])
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		else{
			n++;
			x[n] = a;
			y[n] = b;
			for (int d = 0; d<n; d++) {
				master[n][d] = x[d] < x[n] && x[n] < y[d] || x[d] < y[n] && y[n] < y[d];
				master[d][n] = x[n] < x[d] && x[d] < y[n] || x[n] < y[d] && y[d] < y[n];

			}
			for(int k = 1; k <= n; k++){
				for (int z = 1;z <= n; z++ ){
					for(int j = 1; j <= n; j++){
						if(master[z][k] && master[k][j])
							master[z][j] = true;
					}
				}
			}
		}
	}
}


}
