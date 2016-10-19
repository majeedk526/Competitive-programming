package practice;

public class Prime {

	public static void main(String[] args) {
		
		new Prime().isPrime(857398);

	}
	
	
	public boolean isPrime(int n){
		
		if(n<=1)
			return false;
		
		if(n==2)
			return true;
		
		if(n%2==0){
			System.out.println("not prime, divisible by " + 2);
			return false;
		}
			
		
		int m = (int) Math.sqrt(n);
		for(int i=3;i<m; i+=2){
			if(n%i==0){
				System.out.println("not prime, divisible by " + i);
				return false;
			}
				
		}
		
		System.out.println("is prime");
		return true;
	}

}
