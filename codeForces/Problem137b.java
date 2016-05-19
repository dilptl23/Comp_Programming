import java.util.*;

public class Problem137b{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] perm = new int[n];
        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            if(x <= n){
                perm[x - 1] = 1;
            }

        }

        int count = 0;
        for(int p : perm){
            if(p == 0){
                count++;
            }
        }

        System.out.println(count);
    }

}
