import java.util.*;
import java.lang.*;

public class Problem116c{
	static class Node{
		int x, depth;
		public Node(int x, int depth){
			this.x = x;
			this.depth = depth;
		}
	}
	static HashMap<Integer, Integer> seniority;
	static HashMap<Integer, ArrayList<Integer>> children; 

	public static int dfs(int x, int deep){
		Stack<Node> s = new Stack<Node>();
		ArrayList<Integer> depths = new ArrayList<Integer>();
		s.push(new Node(x, deep+1));
		while(s.empty() == false){
			Node e = s.pop();
			if(children.get(e.x) == null){
				depths.add(e.depth);
			}
			else{
				//System.out.println("Putting in Children for: " + e.x);
				for(int c : children.get(e.x)){
					s.push(new Node(c, e.depth + 1));
					//System.out.println("Put in " + c+ " at depth: " + (e.depth+1));
				}

				//System.out.println("put in children for: "+x + " Current Depth: " + deep);
			}
			
		}

		int m = 0;
		for(int d : depths){
			if(d > m)
				m = d;
		}
		return m;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numEmps = sc.nextInt();
		seniority = new HashMap<Integer, Integer>();
		children = new HashMap<Integer, ArrayList<Integer>>();
		for(int i = 1; i <= numEmps; i++){
			int boss = sc.nextInt();
			seniority.put(i, boss);
			if(boss != -1){
				if(children.get(boss) == null){
					children.put(boss, new ArrayList<Integer>());
				}
				children.get(boss).add(i);
				
			}
			
		}

		ArrayList<Integer> depth = new ArrayList<Integer>();
		for(int a : seniority.keySet()){
			depth.add(dfs(a, 0));
		}
		int max = 0;
		for(int p : depth){
			//ystem.out.println(p);
			if(p > max)
				max = p;
		}
		System.out.println(max);
		
		/*System.out.println(seniority);
		for(int i : children.keySet()){
			System.out.print(i + ":  ");
			for(int k : children.get(i))
				System.out.print(k + "  ");
			System.out.println("");
		}*/
		
	}
}