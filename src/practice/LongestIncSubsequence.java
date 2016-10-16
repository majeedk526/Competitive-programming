package practice;

import java.util.Arrays;

public class LongestIncSubsequence {

	public static void main(String[] args) {
		int[] arr = {3, 4, -1, 0, 6, 2, 3};
		LongestIncSubsequence liss = new LongestIncSubsequence();
		
		int max = liss.lis(arr);

		System.out.println(max);
		
	}
	
	public int lis(int[] arr){
		
		int i=1;
		int j=0;
		int max = 0;
		
		int seq[] = new int[arr.length];
		Arrays.fill(seq, 1);
		
		while(i != arr.length){
			
			if(arr[j] < arr[i]){
				
				seq[i] = Math.max(seq[i], seq[j] + 1);
				if(max< seq[i]){max = seq[i];}
			}
			j++;
			
			if(j==i){
				j=0;
				i++;
			}
		}
		
		
		return max;
	}

}
