package practice;

public class CountCharacters {

	public static void main(String[] args) {
	
		System.out.println(Compress("aabcccccaaa"));

	}
	
	public static String Compress(String input){
	
		char[] str = input.toCharArray();
		
		int i=0; // counter
		String ans = ""; // variable to store new string
		
		while(i < str.length){
			int count=1;
			
			int j=i+1;
			
			while(j<str.length && 
					str[i] == str[j] ){
				count++;
				j++;
			}
			
			ans += String.valueOf(str[i]) + count;
			i=j;
			
		}
		
		if(ans.length() < input.length())
			return ans;
		else
			return input;
		
	}

}
