package practice;

import java.util.Scanner;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		
		int[] A = new int[n];
		for(int i=0; i<n; i++){
			A[i] = scan.nextInt();
		}
		
		int[] B = new int[m];
		for(int i=0; i<m; i++){
			B[i] = scan.nextInt();
		}
		
		scan.close();
		
		LongestCommonSubsequence lcss = new LongestCommonSubsequence();
		lcss.lcs(A, B, n, m);
		
	}

	
	public void lcs(int[] arr1, int[] arr2, int n, int m){
		
		int[][] seq = new int[n+1][m+1];
		//Arrays.fill(seq, 0);
		
		
		for(int i=1; i< seq.length; i++){
			for(int j=1; j<seq[i].length; j++){
				if(arr1[i-1] == arr2[j-1]){
					seq[i][j] = seq[i-1][j-1] + 1;
				} else {
					seq[i][j] = Math.max(seq[i][j-1], seq[i-1][j]);
				}
			}
		}
		
	/** uncomment to print array
		for(int i=0; i<seq.length; i++){
			for(int j=0; j<seq[i].length; j++){
				System.out.print(seq[i][j] + " ");
			}
			System.out.println("");
		}**/
		
		int max = seq[n][m];
		int[] ans = new int[max];
		int w=m, h=n;
		for(int k=max-1; k>=0; k--){
			if(seq[h][w-1] == seq[h][w]){
				w--;
				k++;
			} else if(seq[h-1][w] == seq[h][w]){
				h--;
				k++;
			} else {
				ans[k] = arr1[h-1]; 
				h--; w--;
			}
		}
		
		for(int i=0; i<max; i++){
			System.out.print(ans[i] + " ");
		}
		System.out.println("");
	}
}
