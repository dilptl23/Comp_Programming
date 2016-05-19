import java.util.*;
import java.lang.*;



public class Problem60b{
	static int[] dz = { -1, 1, 0, 0, 0, 0 };
	static int[] dx = { 0, 0, -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 0, 0, -1, 1 };
	static int k;
	static int n;
	static int m;

	public static int bfs(boolean visited[][][], int startx, int starty){
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(0, startx, starty));
		int c = 0;
		while (!q.isEmpty()) {   
			Node p = q.poll();
			int z = p.k;
			int x = p.x; 
			int y = p.y;
			if (0<=z&&z<k&&0<=x&&x<n&&0<=y&&y<m&&visited[z][x][y]) {
				visited[z][x][y]=false;
				c++;
				for(int i = 0; i < 6; ++i){
					q.offer(new Node(z+dz[i],x+dx[i],y+dy[i]));
				}
			}
		}
		return c;

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt(); 
		n = sc.nextInt(); 
		m = sc.nextInt();
		boolean visited[][][] = new boolean[k][n][m];
		for (int t = 0; t < k; ++t) {
			for (int i = 0; i < n; ++i) {
				char[] cs = sc.next().toCharArray();
				for (int j = 0; j < m; ++j) {
					visited[t][i][j] = cs[j] == '.';
				}
			}
		}


		System.out.println(bfs(visited, sc.nextInt() - 1, sc.nextInt() -1));
		
		
		

	}


}

class Node{
	int k;
	int x;
	int y;
	String path = "";
	public Node(int k, int x, int y){
		this.x = x;
		this.y = y;
		this.k = k;
	}
	public String toString(){
		return "(" +x +" , " + y +")";
	}
}