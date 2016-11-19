package practice;

public class EditDistance {

	public static void main(String[] args) {
		EditDistance ed = new EditDistance();
		
		String str1 = "INTENTION";
		String str2 = "EXECUTION";
		
		System.out.println(ed.fed(str1, str2, str1.length()-1, str2.length()-1));

	}
	
	public int fed(String str1, String str2, int m, int n){
		
		if(m==-1 && n>=0) {return n+1;}
		if(n==-1 && m>=0) {return m+1;}
		if(n==-1 && m==-1) {return 0;}
		
		if(str1.charAt(m) == str2.charAt(n))
			return fed(str1, str2, m-1, n-1);
		
		int min = Math.min(1 + fed(str1, str2, m-1,n), 1+fed(str1, str2, m, n-1));
		return Math.min(min, 1+ fed(str1, str2,m-1,n-1));
		
	}

}
