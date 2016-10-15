package practice;

public class LongestSubsequence {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long inano;
		long fnano;
		
		LongestSubsequence lss = new LongestSubsequence();
		String str1 = "abcdaf", str2 = "abcca";
		int max = 0;
		
		inano = System.nanoTime();
		max = lss.lcsDynamic(str2.toCharArray(), str1.toCharArray());
		System.out.println("max length dynamic: " + max);
		fnano = System.nanoTime();
		System.out.println("dynamic time = " + ((fnano - inano)));
		
		inano = System.nanoTime();
		max = lss.lcsRecursive(str1.toCharArray(), str2.toCharArray(), 0, 0);
		System.out.println("max length recursive: " + max);
		fnano = System.nanoTime();
		System.out.println("recursive time = " + (fnano - inano));
	}

	
	public int lcsDynamic(char arr1[], char arr2[]){
		
		int l1 = arr1.length, l2 = arr2.length;
		int max = 0; // stores max length of the common subsequence
		
		int[][] seq = new int[arr1.length+1][arr2.length+1];
		
		for(int i=1; i<seq.length; i++){
			for(int j=1; j<seq[i].length; j++){
				
				if(arr1[i-1] == arr2[j-1]){
					seq[i][j] = seq[i-1][j-1] + 1;
					
					if(seq[i][j] > max){max = seq[i][j];}
				
				} else {
					seq[i][j] = Math.max(seq[i-1][j], seq[i][j-1]);
				}
				
			}
			
		}
		
		/**

		// print matrix
		for(int i=0; i<l1+1; i++){
			for(int j=0; j<l2+1; j++){
				System.out.print(seq[i][j] + " ");
			}
			System.out.println("");
		}
		
		
		// print sub sequence
		String ss="";
		int p=l1, s= l2;
		while(p!=0 && s != 0){
			
			if(seq[p][s-1] == seq[p][s]){
				s--;
			} else if(seq[p-1][s] == seq[p][s]){
				p--;
			} else{
				//System.out.print(arr1[s-1]);
				ss += arr1[s-1];
				s--;
				p--;
			}
		}
		System.out.println(new StringBuffer(ss).reverse().toString());**/
		return max;
	}
	
	public int lcsRecursive(char[] str1, char[] str2, int len1, int len2){
		
		if(len1 == str1.length || len2 == str2.length){
			return 0;
		}
		
		if(str1[len1] == str2[len2]){
			return 1 + lcsRecursive(str1, str2, len1+1, len2+1);
		} else {
			
			return Math.max(lcsRecursive(str1, str2, len1+1, len2), lcsRecursive(str1, str2, len1, len2+1));
		}

		
		
	}
	
	

}


