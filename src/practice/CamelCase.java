package practice;

import java.util.Scanner;

public class CamelCase {

	public static void main(String[] args) {
		CamelCase cc = new CamelCase();
		Scanner scan = new Scanner(System.in);
		cc.cc(scan.nextLine());
		scan.close();
		
	}
	
	public void cc(String str ){
		char[] arr = str.toCharArray();
		int count = 1;
		int l = arr.length;
		
		for(int i=0; i<l; i++){
			if(arr[i] >= 'A' && arr[i] <= 'Z'){
				count++;
			}
		}
		
		System.out.println(count);
	}

}
