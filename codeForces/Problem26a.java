import java.util.*;
import java.lang.Math;

public class Problem26a{

    // returns first 200 primes
    public static HashSet<Integer> getPrimes(){
        HashSet<Integer> primes = new HashSet<Integer>();
        int count = 0;
        for(int p = 2; p < 100000000; p++){
            boolean isPrime = true;
            for(int d = 2; d <= p/2; d++){
                if(p % d == 0){
                    isPrime = false;
                    break;
                }
            }

            if(isPrime){
                primes.add(p);
                count++;
                //System.out.println(p);
            }

            if(count >= 500)
                break;
        }

        return primes;
    }

    public static ArrayList<Integer> getMultiples(int n){
        ArrayList<Integer> multiples = new ArrayList<Integer>();
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                multiples.add(i);
                if(!((n/i) == i))
                    multiples.add(n/i);
            }
        }
        return multiples;
    }

    public static void almostPrimes(int n, HashSet<Integer> primes){
        int count = 0;
        for(int i = 6; i <= n; i++){
            ArrayList<Integer> multiples = getMultiples(i);
            int pc = 0;
            for(Integer m : multiples){
                if(primes.contains(m)){
                    //System.out.println(m);
                    pc++;
                }
                if(pc > 2){
                    break;
                }
            }
            if(pc == 2){
                count++;
                //System.out.println(i);
            }

        }

        System.out.println(count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<Integer> primes = getPrimes();
        almostPrimes(n, primes);
    }
}
