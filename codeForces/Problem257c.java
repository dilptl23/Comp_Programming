import java.util.*;
import java.awt.Point;

public class Problem257c{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    ArrayList<Point> points = new ArrayList<Point>();
    ArrayList<Point> pquad1 = new ArrayList<Point>();
    ArrayList<Point> pquad2 = new ArrayList<Point>();
    ArrayList<Point> pquad3 = new ArrayList<Point>();
    ArrayList<Point> pquad4 = new ArrayList<Point>();
    //takes in points and creates arraylist
    for(int i = 0; i < t; i++){
      int x = sc.nextInt();
      int y = sc.nextInt();
      points.add(new Point(x, y));
    }

    //need to find min of left quadrent while also checking if they are in
    //          each quadrent
    boolean q1;
    boolean q4;
    boolean q3;
    boolean q2;
    boolean clockwise;
    int[] in = new int[4];
    //
    for(Point p : points){
      int x = p.x;
      int y = p.y;
      //Quad4: x >= 0 && y <= 0
      if(x >= 0 && y <= 0){
        pquad4.add(p);
        q4 = true;
        in[3] = 1;
      }
      else if(x >= 0 && y > 0){
        pquad1.add(p);
        q1 = true;
        in[0] = 1;
      }
      else if(x < 0 && y >= 0){
        pquad2.add(p);
        q2 = true;
        in[1] = 1;
      }
      else{
        pquad3.add(p);
        q3 = true;
        in[2] = 1;
      }

    }

    for(int o : in)
      System.out.println(o);

  }
}
