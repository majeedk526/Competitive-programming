package numberTheory;

import java.util.Scanner;

public class ModularArithMatic {

	public static void main(String[] args) {
		
		ModularArithMatic m = new ModularArithMatic();
		
		//System.out.println(m.recPower(9, 990));
		//System.out.println(m.GCD(50, 40));
		
		Scanner scan = new Scanner(System.in);
				
		System.out.println(m.solve(scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt()));
	}
	
	
	private int GCD(int a, int b){
		
		if(b==0)
			return a;
		
		return GCD(b,a%b);
		
	}
	
	private int recPower(int x, int n){
		
		if(n==0)
			return 1;
		
		if(n%2==0){
			return recPower(x*x,n/2);
		} else {
			return x*recPower(x*x,(n-1)/2);
		}
		
		
	}
	
	private int solve(int A, int B, int C, int M){
		
		return (int)((Math.pow(A, B)%M)/(C%M))%M;
		
	}

}
