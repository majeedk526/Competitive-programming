import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Arrays.*;

/* Program to gneretae prime numbers upto given input n using Sieve method 
* Also verify that your generated numbers are infact prime using prime function()
*/
class PrimeNum
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    int n= 1000;
	    boolean[] isPrime = new boolean[n+1];
	    Arrays.fill(isPrime, true);
	    
	    isPrime[0] = false;
	    isPrime[1] = false;
	    int m =(int) Math.sqrt(n);
	    
	    for(int i=2; i<=m; i++){
	        if(isPrime[i]){
	            for(int k=i*i; k<=n;k+=i)
	                isPrime[k] = false;
	        }
	            
	    }
	    
	    int count=0;
	    int count2 = 0;
	    for(int i=2;i<=n;i++){
	        if(isPrime[i]){
	            System.out.print(i + " ");
	            count++;
	            if(prime(i))
	                count2++;
	        }
	    }
	    System.out.println("");
	    System.out.println(count);
	    System.out.println("count2 : " + count2);
		
	}
	
	public static boolean prime(int n){
	    
	    if(n<=1)    return false;
	    if(n==2)     return true;
	    if(n%2==0)  return false;
	    
	    int m =(int) Math.sqrt(n);
	    
	    for(int i=3; i<=m; i++){
	        if(n%i==0)
	            return false;
	    }
	    return true;
	    
	}
}
