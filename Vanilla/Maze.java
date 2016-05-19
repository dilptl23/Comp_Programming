import java.util.*;
import java.lang.*;

class Node{
	 int x;
	 int y;
	 String path = "";
	public Node(int x, int y){
		this.x = x;
		this.y = y;
	}
	public String toString(){
		return "(" +x +" , " + y +")";
	}
}
public class Maze{
	static int[] dx = {1,0,0,-1};
	static int[] dy = {0,-1,1,0};
	static String[] dir = {"D","L","R","U"};
	static String[][] paths;
	static Node start;
	static Node end;
	static int xbound;
	static int ybound;

	public static String bfs(String[][] maze){
		Queue<Node> queue = new LinkedList<Node>();
		ArrayList<String> pathsFound = new ArrayList<String>();
		//2 means visited. Not going to use visited array
		//put start in queue
		maze[start.x][start.y] = "2";
		paths[start.x][start.y] = "";
		queue.offer(start);

		while(!queue.isEmpty()){
			Node v = queue.poll();
			for(int d = 0; d < 4; d++){
				int x = v.x + dx[d];
				int y = v.y + dy[d];
				if(x >= 0 && x < xbound && y >= 0 && y < ybound && !maze[x][y].equals("2") && !maze[x][y].equals("#")){
					//
					paths[x][y] = paths[v.x][v.y] + dir[d];
					//System.out.println("Went From: " + v + "  to  " + x + " , " + y + "  Current Path to x, y: " + paths[x][y]);
					//System.out.println(queue);
					
					if((maze[x][y]).equals("e")){
						pathsFound.add(paths[x][y]);
						// have to NOT make e = 2 bc then other paths will not be seen

					}
					else{
						Node p = new Node(x, y);
						maze[x][y] = "2";
						queue.offer(p);
					}
					
				}
			}
		}
		if(pathsFound.size() == 0)
			return ":(";
		else{
			String min = pathsFound.get(0);
			for(int y = 0; y < pathsFound.size(); y++){
				//System.out.println(pathsFound.get(y));
				if((pathsFound.get(y)).length() <= min.length() && (pathsFound.get(y)).compareTo(min) < 0){
					min = pathsFound.get(y);
				}
			}
			return min;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		for(int i = 1; i <= tests; i++){
			int lines = sc.nextInt();
			int chars = sc.nextInt();
			xbound = lines;
			ybound = chars;
			String[][] maze = new String[lines][chars];
			paths = new String[lines][chars];
			int startx = 0;
			int starty = 0;
			sc.nextLine();
			for(int k = 0; k < lines; k++){
				String str = sc.nextLine();
				for(int j = 0; j < chars; j++){
					maze[k][j] = "" + str.charAt(j);
					if(maze[k][j].equals("s")){
						start = new Node(k,j);
					}
					else if(maze[k][j].equals("e")){
						end = new Node(k, j);
					}
				}
			}

			System.out.println(bfs(maze));
			// System.out.println(start);

			//prints out maze
			// for(int x = 0; x < maze.length; x++){
			// 	for(int y = 0; y < maze[x].length; y++){
			// 		System.out.print(maze[x][y]);
			// 	}
			// 	System.out.println("");
			// }
		}
	}
}