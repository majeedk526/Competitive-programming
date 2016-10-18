package practice;

import java.util.Scanner;

public class DivisiblePairSum {

	public static void main(String[] args) {
		//System.out.println("Enter line 1");
		Scanner scan = new Scanner(System.in);
		
		
		int n = scan.nextInt();
		int k = scan.nextInt();
		
		int[] arr = new int[n];
		
		//System.out.println("Enter line 2");
		
		for(int i=0 ;i <n; ++i){
			arr[i] = scan.nextInt();
		}
		
		DivisiblePairSum DPS = new DivisiblePairSum();
		int count = DPS.dps(arr, k);
		System.out.println(count);
	}
	
	public int dps(int[] arr, int k){
		
		int count =0;
		int i=1, j=0;
		int l = arr.length;
		
		for(; i< l; i++){
			while(j!=i){
				if((arr[j] + arr[i]) % k == 0 ){
					++count;
				}
				j++;
			}
			j=0;
		}
		
		
		return count;
	}

}
