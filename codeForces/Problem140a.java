import java.util.*;

public class Problem140a{

  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      double n = sc.nextDouble();
      double table = sc.nextDouble();
      double plate = sc.nextDouble();

      double a = Math.sin(Math.PI / n);
      double b = (table * a) / (1+a);
      if(plate > table){
        System.out.println("NO");
      }
      else{
        if(n == 1){
          if(plate <= table){
            System.out.println("YES");
          }
          else{
            System.out.println("NO");
          }
        }
        else if((b + (1e-7))> plate){
          //System.out.println(b);
          //System.out.println(n);
          System.out.println("YES");
        }
        else
          System.out.println("NO");
      }
      //System.out.println(b);
      //System.out.println(n);

  }
}
