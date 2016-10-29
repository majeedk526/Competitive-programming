package practice;

public class ManachersAlgorithm {

	public static void main(String[] args) {
		ManachersAlgorithm ma = new ManachersAlgorithm();
		String input = "ABABAB";
		ma.pss(input.toCharArray());

	}
	
	public void pss(char[] arr){
		
		char[] nArr = new char[2*arr.length + 1];
		int[] lseq = new int[nArr.length];
		
		
		// process string to bring into form "$#char#char#@"
		nArr[0] = '$';
		System.out.print(nArr[0]);
		for(int i=1,s=0; i<nArr.length-1; i++){
			if(i%2!=0)
				nArr[i] = '#';
			else
				nArr[i] = arr[s++];
			
			System.out.print(nArr[i]);
		}
		nArr[nArr.length-1] = '@';
		System.out.print(nArr[nArr.length-1]);
		
		int l=0, R=0,mirror=0, c=1;
		int max=0;
		
		for(int i=2; i<nArr.length-1; i++){
			
			mirror = 2*c-i;

			
			if(i<R)
				lseq[i] = Math.min(R-i, lseq[mirror]);
			
			while(nArr[i + 1 + lseq[i]] == nArr[i- (1 + lseq[i])])
				lseq[i]++;
			
			if(lseq[i] > max){max=lseq[i];}
			
			if(i+lseq[i] > R){
				c=i;
				R= i + lseq[i];
			}
		
		}
		
		System.out.println("\nmax palindrome length : " + max);
		
		
	}

}
