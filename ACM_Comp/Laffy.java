import java.util.*;
public class Laffy{

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int tests = sc.nextInt();
	//System.out.println(tests);
	char[] alphab = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	ArrayList<String> alphabet = new ArrayList<String>();
	for(char a : alphab){
		alphabet.add(a+"");
	}
	sc.nextLine();
	for(int i = 0; i < tests; i++){
		String line = sc.nextLine();
		String letters = line.substring(0, line.indexOf(' '));
		int shift = Integer.parseInt(line.substring(line.indexOf(' ') + 1));
		char[] lett = letters.toCharArray();
		int idx = 0;
		for(char c : lett){
			int oldIdx = alphabet.indexOf(c+"");
			int newIdx = (oldIdx + shift) % 26;
			lett[idx] = alphab[newIdx];
			idx++;
		}

		String ans = new String(lett);
		System.out.println(ans);
	}


}
}
