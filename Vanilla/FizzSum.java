import java.util.*;

public class FizzSum{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLong()){
			long first = sc.nextLong();
			long last = sc.nextLong();
			//check if backwards
			if(last < first){
				long temp = first;
				first = last;
				last = temp;
				
			}

			long output = 0;
			for(long i = first; i <= last; i++){
				if(i % 3 == 0 && i % 5 == 0)
					output += i*i;
				else if(i % 3 == 0)
					output += i + 3;
				else if(i % 5 == 0)
					output += i +5;
			}


			System.out.println(output);
		}

		sc.close();
		
	}
}