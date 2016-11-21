package practice;

public class EditDistance {

	public static void main(String[] args) {
		EditDistance ed = new EditDistance();
		
		String str1 = "INTENTION";
		String str2 = "EXECUTION";
		
		//System.out.println(ed.fed(str1, str2, str1.length()-1, str2.length()-1));

		ed.fedDyn(str1, str2, str1.length(), str2.length());
		
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
	
	public void fedDyn(String str1, String str2, int m, int n){
		
		int arr[][] = new int[m][n];
		for(int i=0; i<arr.length; i++)
			arr[i][0] = i;
		
		//printArray(arr);
		
		for(int i=0; i<arr[0].length; i++)
			arr[0][i] = i;
		
		//printArray(arr);
		
		for(int i=1; i<m; i++){
			for(int j=1; j<n; j++){
				
				if(str1.charAt(i-1)== str2.charAt(j-1)){
					arr[i][j] = arr[i-1][j-1];
				} else {
					
									//deletion, insertion
					int min = Math.min(1+arr[i-1][j], 1+arr[i][j-1]);
					arr[i][j] = Math.min(min, 1+arr[i-1][j-1]); //substitution
					
				}
				
			}
		}
		
		printArray(arr);
		System.out.println("min distance = " + arr[arr.length-1][arr[0].length-1]);
		
	}
	
	public void printArray(int[][] arr){
		
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[i].length; j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}

}
