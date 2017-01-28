package newprac;

import java.util.Scanner;

public class Staircase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		
		StringBuilder builder = new StringBuilder(N*N);
		for(int i=0; i<N; i++){
			
			for(int j=0; j<N-i-1; j++){
				builder.append(" ");
			}
			
			for(int k=i;k>=0;k--)
				builder.append("#");
			
			builder.append("\n");
			
		}
		
		System.out.println(builder.toString());
		
	}

}
