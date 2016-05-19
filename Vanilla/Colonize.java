import java.util.*;
import java.lang.*;
class Node{
	 int x;
	 int y;
	public Node(int x, int y){
		this.x = x;
		this.y = y;
	}
	public String toString(){
		return "(" +x +" , " + y +")";
	}
}
public class Colonize{
	static boolean[][] visited;
	static int[][] planet;
	static int xbound;
	static int ybound;
	
	public static int dfs(int x,int y){
		int result = 0;
		Stack<Node> s = new Stack<Node>();
		s.push(new Node(x,y));
		while(s.empty() == false){
			Node top = s.pop();
			//System.out.println("WORKING ON:  x: "+(top.x) + "  y: "+(top.y));
			//check if node is within bounds and has not been visited. if not, mark as visited and proceed in pushing all neighbors
			if(top.x >= 0 && top.x <= xbound && top.y >=0 && top.y <= ybound && !visited[top.x][top.y]){
				visited[top.x][top.y] = true;
				if(planet[top.x][top.y] == 1){
					//System.out.println("STACK CURRENTLY: "+s);
					
					result++;
					int[] dx = {1,0,-1,0,-1,1,-1,1};
					int[] dy = {0,1,0,-1,1,1,-1,-1};
					for(int i = 0; i < dx.length; i++){
						s.push(new Node(top.x + dx[i], top.y + dy[i]));
						//System.out.println("x: "+(top.x + dx[i]) + "  y: "+(top.y+dy[i]));

					}
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		for(int i = 1; i <= tests; i++){
			int lines = sc.nextInt();
			int chars = sc.nextInt();
			xbound = lines -1;
			ybound = chars -1;
			sc.nextLine();

			//create planet O(n^2) and array of visited
			planet = new int[lines][chars];
			visited = new boolean[lines][chars];
			for(int line = 1; line <= lines; line++){
				String str = sc.nextLine();
				//System.out.println(str);
				for(int land = 1; land <= chars; land++){
					planet[line-1][land-1] = Character.getNumericValue(str.charAt(land-1));
					visited[line-1][land-1] = false;
				}
			}

			//store results
			ArrayList<Integer> results = new ArrayList<Integer>();
			for(int line = 0; line < lines; line++){
				for(int land = 0; land < chars; land++){
					if(visited[line][land] == false){
						results.add(dfs(line, land));
					}
				}
			}

			Collections.sort(results);
			System.out.println(results.get(results.size() - 1));

			
			
			//remember to create an array of visited 
			//dont need to create an ajancey matrix but walk through all neighbors each time

		}
	}
}