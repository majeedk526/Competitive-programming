package sort;

import java.util.Scanner;

public class BubbleSort {

	public static void main(String[] args) {
		
		/*
		 * https://www.hackerearth.com/practice/algorithms/sorting/bubble-sort/tutorial/
		 */
		
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++){
			arr[i] = scan.nextInt();
		}
		
		BubbleSort bsort = new BubbleSort();
		System.out.println(bsort.sort(arr));
		
	}
	
	public int sort(int[] arr){
		int numSwap =0; // number of swaps
		int l = arr.length;
		
		for(int i=0; i<l-1; i++){
			for(int j=0; j<l-i-1; j++){
				if(arr[j]> arr[j+1]){
					//swap(arr,i,j);
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
					numSwap++;
				}
			}
		}
		print(arr);
		return numSwap;
	}
	
	
	public void swap(int arr[], int i, int j){
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j]=tmp;
	}
	
	public void print(int arr[]){
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}

}
