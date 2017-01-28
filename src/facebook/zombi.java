package facebook;

import java.util.Scanner;

public class zombi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		
		for(int i=0; i<T; i++){
			
			int H = scan.nextInt();
			int S = scan.nextInt();
			
			scan.next(); // go to new line
			double p = 0.0;
			for(int j=0; j<S; j++){
				String s = scan.next();
				p*= getProb(s, H);
			}
			
			System.out.println(p);
			
		}

	}
	
	private static double getProb(String s, int H){
	
		double p = 0.0;
		
		String[] ss = s.split("d");
		
		int sides = Integer.parseInt(ss[0]);
		int Z = 0;
		int times;
		String[] sss = ss[1].split("-");
		
		if(sss.length > 1){
			Z = Integer.parseInt(sss[1]);
		}
		
		times = Integer.parseInt(sss[0]);
		
		
		
		
		int max = sides*times;
		int min = times-Z;
		
		int count = 0;
		if(min < H){
			count++;
			min++;
		}
		
		p = (((double)max)-H)/max;
		
		return p;
	}

}
