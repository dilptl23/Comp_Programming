import java.util.*;

public class Problem448d{

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int r = sc.nextInt();
    int c = sc.nextInt();
    int x = sc.nextInt();
    int[] duplicates = new int[r*c + 1];
    ArrayList<Integer> nums = new ArrayList<Integer>();
    for(int i = 1; i <= r; i++){
      for(int j = 1; j <= c; j++){
        nums.add(i*j);
      }
    }

    Collections.sort(nums);
    System.out.println(nums.get(x-1));
}
}
