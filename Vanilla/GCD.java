import java.util.*;
class Node{
	int num = 0;
	int minIdx = 0;
	int maxIdx = 0;
	public Node(int n, int x, int y){
		this.num = n;
		this.minIdx = x;
		this.maxIdx = y;
	}

	public String toString(){
		return (this.num + "");
	}
}
public class GCD{
	public static Node[] tree;
	//need to create method for left child

	//TODO: method for right child

	public static int gcd(int a, int b) { return b==0 ? a : gcd(b, a%b); }

	public static int createHelper(int[] elements, int sIdx, int eIdx, int current){
		if(sIdx == eIdx){
			tree[current] = new Node(elements[sIdx], sIdx, eIdx);
			return tree[current].num;
		}
		int mid = (sIdx + eIdx) / 2;
		tree[current] = new Node(gcd(createHelper(elements, sIdx, mid, (2*current+1)), 
			createHelper(elements, mid+1, eIdx, (2*current+2))), sIdx, eIdx);

		return tree[current].num;
	}

	public static void createSegmentTree(int[] elements){
		createHelper(elements, 0, elements.length-1, 0);
	}

	public static int getgcd(int qStart, int qEnd, int nums){
		return getgcdB(0, nums, qStart, qEnd, 0);
	}

	private static int getgcdB(int sIdx, int eIdx, int qStart, int qEnd, int current){
		if(sIdx >= qStart && eIdx <= qEnd){
			return tree[current].num;
		}
		if(qStart > eIdx || sIdx > qEnd){
			return 0;
		}
		int mid = (sIdx + eIdx) / 2;
		return gcd( getgcdB(sIdx, mid, qStart, qEnd, (2*current+1)) , 
			getgcdB(mid + 1, eIdx, qStart, qEnd, (2*current+2)) );
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();

		for(int t = 0; t < tests; t++){
			int n = sc.nextInt();
			int questions = sc.nextInt();

			tree = new Node[n*n];
			int[] elements = new int[n];
			for(int e = 0; e < n; e++){
				elements[e] = sc.nextInt();

			}

			createSegmentTree(elements);
			

			for(int q = 0; q < questions; q++){
				int a = sc.nextInt();
				int b = sc.nextInt();
				System.out.println(getgcd(a, b, elements.length-1));
			}
			
		}
	}
}