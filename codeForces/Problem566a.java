import java.util.*;

public class Problem566a{

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();
    String[] realNames = new String[n];
    String[] nickNames = new String[n];
    for (int i = 0; i<n; i++ ) {
      realNames[i] = sc.nextLine();
    }
    for (int i = 0; i <n;i++ ) {
      nickNames[i] = sc.nextLine();
    }

    for(String a : nickNames){
      System.out.println(a);
    }
  }
}
