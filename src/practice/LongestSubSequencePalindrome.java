package practice;

import java.util.Scanner;

public class LongestSubSequencePalindrome {

	public static void main(String[] args) {
		
		//eeegeeksforskeeggeeks
		
		LongestSubSequencePalindrome lsp = new LongestSubSequencePalindrome();
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		scan.close();
		
		StringBuilder sb = new StringBuilder(str);
		int ml1=0, ml2=0;
		int tl1=0, tl2=0;
		
		for(int i=0; i<str.length()-1; i++){
			tl1 = lsp.lcspDynamic(sb.substring(0, i+1).toCharArray());
			tl2 = lsp.lcspDynamic(sb.substring(i+1, str.length()).toCharArray());
			
			if(tl1 * tl2 > ml1*ml2) {ml1 = tl1; ml2 = tl2;}
	}
		
		System.out.println(ml1 * ml2);
		//lsp.findPalindrome("agbdba".toCharArray());
	}
	
	
	int lcspDynamic(char arr[]){
		int len = arr.length;
		int k=2; // length of subsequences
		
		int seq[][] = new int[len][len];
		
		for(int i=0; i<len; i++){
			seq[i][i] = 1;
		}
		
		while(k <= len){
			int i=0, j = i+k-1;
			
			while(j<len){
				
				if(arr[i] == arr[j]){
					seq[i][j] = seq[i+1][j-1] + 2;
					i++;
					j++;
				} else {
					seq[i][j] = Math.max(seq[i][j-1], seq[i+1][j]);
					i++;
					j++;
				}
				
			}
			k++;
		}
		//int h=0,w = arr.length-1;
		//int length = seq[h][w];
		
		
		// print matrix
		for(int i=0; i<len; i++){
			for(int j=0; j<len; j++){
				System.out.print(seq[i][j] + " ");
			}
			System.out.println("");
		}
		
		
		// print palindrome string
		char parr[] = new char[arr.length];
		int h=0,w = arr.length-1;
		int length = seq[h][w];
		while(h != w){
			
			if(w-1<0){break;}
			
			if(seq[h][w-1] == seq[h][w]){
				w--;
			} else if(seq[h+1][w] == seq[h][w]){
				h++;
			} else {
				parr[h] = arr[h];
				parr[w] = arr[w];
				w--;
				h++;
			}	
		}
		
		parr[h] = arr[h];
		String pstr = "";
		
		for(int i=0; i<arr.length; i++){
			if(parr[i] != '\0'){
				pstr += parr[i];
			}
		}
		
		System.out.println(pstr);
		return length;
	}

}
