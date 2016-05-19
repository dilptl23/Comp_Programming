//http://codeforces.com/problemset/problem/505/A
import java.util.*;
import java.lang.StringBuilder;
public class Problem505a{
	public static boolean checkRest(StringBuilder word, int left, int right){
		right--;
		while(left <= right){
			if(! (word.charAt(left) == word.charAt(right))){
				return false;
			}
			left++;
			right--;
		}

		return true;
	}

	public static void palendrome(String word){
		int left = 0;
		int right = word.length() - 1;
		StringBuilder worda = new StringBuilder(word);
		StringBuilder wordb = new StringBuilder(word);
		while( left <= right){
			//System.out.println("Left: "+word.charAt(left) + "  Right: " + word.charAt(right));
			//System.out.println(word);
			if(!(word.charAt(left) == word.charAt(right) )){
				worda.insert(right+1, word.charAt(left));
				wordb.insert(left, word.charAt(right));
				//System.out.println(worda);
				//System.out.println(wordb);
				
				if(checkRest(worda, left, right+2)){
					//System.out.println("workinga");
					System.out.println(worda);
					return;
				}
				else if(checkRest(wordb, 0, wordb.length())){
					System.out.println(wordb);
					return;
				}
				else{
					System.out.println("NA");
					return;
				}

				
			}
			left++;
			right--;
			
		}
		//already a palendrome
		System.out.println(word.substring(0,right+1) + word.charAt(right+1) + word.substring(right+1,word.length()));
		return;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//start from ends, if ends arent the same add letter to one side check if not palin add letter to other and check
		//if ends cross over, left > right, enter any letter at position right + 1. If left crosses right and not palindrome return NA
		//jplj - inside if left doesnt equal right add left letter to position right + 1, check. else return NA
		while(sc.hasNextLine()){
			String word = sc.nextLine();
			palendrome(word);
		}	
		


		

	}
}