/**
 * Created by DilanHira on 1/23/16.
 */
import java.util.*;
public class Problem405a {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String nums = sc.nextLine();
        String[] tempNums = nums.split(" ");
        int[] cols = new int[tempNums.length];
        int i = 0;
        for(String num: tempNums){
            cols[i] = Integer.parseInt(num);
            i++;
        }

        for(int j = 0; j < cols.length; j++){
            for(int k = j +1; k < cols.length ; k++){
                if(cols[j] > cols[k]){
                    //System.out.println("Swapping: "+cols[j] + " with " + cols[k]);
                    int temp = cols[k];
                    cols[k] = cols[j];
                    cols[j] = temp;
                }
            }
        }

        for(int c : cols){
            System.out.print(c + " ");
        }
    }
}
