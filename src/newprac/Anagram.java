package newprac;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import ThirtyDaySeries.CompareTriplets;

public class Anagram {

	public static void main(String[] args) {
		
		File f = new File("input001.txt");
		Scanner scan = null;
		try {
			scan = new Scanner(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}

		List<String> vect = new ArrayList<>();
		while(scan.hasNext()){
			vect.add(scan.next());
		}
		
		
		vect.sort(new Comp());
		List<String> ans = new ArrayList<>(vect.size());
		
		
		
		
		while(vect.size()>0){
		
		//	System.out.println(vect.toString());
		
			String s = vect.get(0);
			String ts = vect.get(0);
			vect.remove(0);
			
			for(int j=0; j< vect.size(); j++){
				String t = vect.get(j);
				if(ts.length() == t.length() && isAnagram(ts, t)){
					s+=  "," + vect.get(j);
					vect.remove(j);
					j--;
				}
			}
			ans.add(s);
			
		}
		
		for(int i=0; i<ans.size(); i++){
			System.out.println(ans.get(i));
		}
	}
	
	private static boolean isAnagram(String str1, String str2){
		
		for(int i=0; i<str1.length(); i++){
			String s = ""+str1.charAt(i);
			if(str2.contains(s)){
				str2.replace(s.charAt(0), '#');
			} else {
				return false;
			}
		}
		
		return true;
	}
	
	
	static class Comp implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			
			if(o1.length()==o2.length())
				return 0;
			else if(o1.length()< o2.length())
				return -1;
			else
				return 1;
		}
		
	}

}
