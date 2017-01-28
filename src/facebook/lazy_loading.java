package facebook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class lazy_loading {
	
	private static final int minWeight = 50;

	public static void main(String[] args) {
		
		File fin = new File("lazy_loading.txt");
		File fout = new File("lazy_loading_out.txt");
		
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(fout);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Scanner scan = null; 
		
		try {
			scan = new Scanner(fin);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int T = scan.nextInt();
		
		for(int i=1; i<=T; i++){
			
			int N = scan.nextInt();
			int[] weights = new int[N];
			for(int j=0; j< N; j++){
				weights[j] = scan.nextInt();
			}
			
			int numTrip = calcTrip(weights, N);
			writer.println("Case #" + i + ": " +numTrip);
			
			
		}
		
		writer.close();

	}
	
	private static int calcTrip(int[] w, int l){
		
		Arrays.sort(w);
		
		if(l==1)
			return 1;
		
		int i=0, j = l-1;
		int count = 0;
		
		while(i<j){
			
			int item = 0;
			
			int top = w[j--];
			item =1;
			
			while(top*item<minWeight && i<=j){
				i++;
				item++;
			}
			
			count++;
			
		}
		
		
		return count;
	}

}
