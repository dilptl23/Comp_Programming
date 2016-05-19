import java.util.*;
 
public class Wormholes
{
 
    // p = planets
    public static void bellmanford(int p, int[][] adjMat){
        int[] dist= new int[p];
        for(int g = 0; g < p; g++){
            dist[g] = Integer.MAX_VALUE;
        }
        dist[0] = 0;
        for(int k = 0; k < p - 1; k++){
            for(int i = 0; i< p; i++){
                for(int e = 0; e < p; e++){
                    if (adjMat[i][e] != Integer.MAX_VALUE)
                    {
                        if (dist[e] > dist[i] + adjMat[i][e])
                            dist[e] = dist[i] + adjMat[i][e];
                    }
                }
            }
        }


        //Check if negative edge cycle
        for(int i = 0; i< p; i++){
            for(int e = 0; e < p; e++){
                if (adjMat[i][e] != Integer.MAX_VALUE)
                {
                    if (dist[e] > dist[i] + adjMat[i][e]){
                        System.out.println("UNSAFE AT ANY SPEED");
                        return;
                    }
                }
            }
        }

        for(int d : dist){
            if(d == Integer.MAX_VALUE)
                System.out.print("OUT ");
            else
                System.out.print(d + " ");
        }
        System.out.println("");
        return;
    }
 
    public static void main(String[] arg)
    {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for (int test = 0;test < tests; test++) {
            //# of planets
            int p = sc.nextInt();
            // # of wormholes, lines following
            int w = sc.nextInt();
            int[][] adjMat = new int[p][p];

            //read in wormholes and put them in adjMat
            for (int l = 0;l < w; l++ ) {
                int u = sc.nextInt() - 1;
                int v = sc.nextInt() - 1;
                int s = sc.nextInt();

                adjMat[u][v] = s;

            }

            // put Infinity for anything that is 0 but no edge to itself
            for (int x = 0; x < p; x++) {
                for (int y = 0; y< p; y++) {
                    if(x != y && adjMat[x][y] == 0)
                        adjMat[x][y] = Integer.MAX_VALUE;
                }
                
            }


            bellmanford(p, adjMat);
            

            //printing adjMat
            /*for (int x = 0; x < p; x++) {
                for (int y = 0; y< p; y++) {
                    System.out.print(adjMat[x][y] + " ");
                }
                System.out.println("");
                
            }*/

        }
        
    }
}