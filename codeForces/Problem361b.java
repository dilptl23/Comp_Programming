import java.util.*;

public class Problem361b{

	public static int gdc(int a, int b){
		if(b == 0)
			return a;
		else{
			return gdc(b, a % b);
		}
	}

	public static void printArray(int[] arr){
		for(int s = 0; s < arr.length; s++){
			System.out.print(arr[s] + " ");
		}
		System.out.println("");
		System.exit(0);
	}

	public static int perm2(int[] a, int n, int k) {

        if (n == 1) {
        	if (isBeaut(a, k)) {
        		printArray(a);
        	}
        }
        for (int i = 0; i < n; i++) {
            swap(a, i, n-1);
            perm2(a, n-1, k);
            swap(a, i, n-1);
        }

        return -1;
    }  

    public static boolean isBeaut(int[] a, int k){
    	int count = 0;
    	for(int i = 0; i < a.length; i++){
    		if(gdc(a[i], i+1) > 1){
    			//System.out.println("IS BEAUT: num = " + a[i] + "  i = "+ (i+1) + " GDC = " + gdc(a[i], i+1));
    			count++;
    		}
    	}

    	if(count == k)
    		return true;
    	return false;
    }


	//Source: http://introcs.cs.princeton.edu/java/23recursion/Permutations.java.html
	public static void swap(int[] a, int i, int j) {
        int c = a[i];
        a[i] = a[j];
        a[j] = c;
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		if(k == 0){
			System.out.print(n + " ");
			for (int i =1; i<n ;i++) {
				System.out.print(i + " ");
			}
		}
		else if(k==n){
			System.out.print("-1");
		}
		else{
			for(int j = 1; j < n - k; j++){
				System.out.print((j+1) + " ");
			}
			System.out.print("1 ");
			for(int i = n-k+1; i<=n; i++){
				System.out.print(i + " ");
			}
			System.out.println("");
		}

		//create array using n
		/*int[] arr = new int[n];
		for(int i = 0; i < n; i++){
			arr[i] = i+1;
		}
		int[] t = {1,2,3};
		int result = perm2(arr, n, k);
		if(result == -1){
			System.out.println(result);
		}*/
		//print array
		// for(int s = 0; s < arr.length; s++){
		// 	System.out.print(arr[s] + " ");
		// }
		

	}
}