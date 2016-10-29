package practice;

public class RabinKarpSubstring {

	public static void main(String[] args) {

		
		

	}
	
	public void ss(char[] arr){
		
	}
	
	
	public int hash(char[] newChars, char[] prevChars, int prevHash){
		
		final int prime = 101;
		
		int hashVal=0;
		
		if(prevChars != null){
			prevHash -= (int)prevChars[0];
			prevHash /= (int)prime;
			prevHash = prevHash + ((int)newChars[newChars.length-1])*(int)Math.pow(prime, prevChars.length-1);
			hashVal = prevHash;
		} else {
			
			for(int i=0; i<newChars.length; i++){
				hashVal += (int)newChars[i]* (int) Math.pow(prime, i);
			}
			
		}
		
		return hashVal;
	}

}
