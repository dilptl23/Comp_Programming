import java.util.*;
import java.awt.Point;

public class Rubber_Band{

  public static class Peg extends Point{
    public boolean pegged = false;
    public Peg(int x, int y){
      super(x, y);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();


    for(int i = 0; i < tests; i++){
      int ps = sc.nextInt();

      int maxY = Integer.MIN_VALUE;
      int minY = Integer.MAX_VALUE;
      int maxX = Integer.MIN_VALUE;
      int minX = Integer.MAX_VALUE;
      ArrayList<Peg> points = new ArrayList<Peg>();

      for(int j = 0; j < ps; j++){
        int x = sc.nextInt();
        int y = sc.nextInt();
        if(x > maxX)
          maxX = x;
        else if(x < minX)
          minX = x;
        if(y > maxY)
          maxY = y;
        else if(y < minY)
          minY = y;
        points.add(new Peg(x, y));
      }
      int[] allPegs = new int[ps];
      int n = 0;
      for(Peg p : points){

        if(p.x == maxX || p.x == minX || p.y == maxY || p.y == minY){
          p.pegged = true;
          allPegs[n] = 1;
        }
        n++;
      }

      for(int z = 0; z < allPegs.length; z++){
        if(allPegs[z] > 0){
          System.out.print(z + " ");
        }
      }

      System.out.println();

    }


  }
}
