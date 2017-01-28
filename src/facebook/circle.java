package facebook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class circle {

	private static final double maxDist = 50;
	
	public static void main(String[] args) {
		
		//double a =  Math.toDegrees(Math.atan2(50-50, 0-50));
	//	System.out.println(a);
		
		File f = new File("progress_pie.txt");
		File opf = new File("progress_pie_op.txt");
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(opf);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Scanner scan = null;
		try {
			scan = new Scanner(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int T = scan.nextInt();
		
		for(int i=0; i<T; i++){
			
			int p = scan.nextInt();
			int x = scan.nextInt();
			int y = scan.nextInt();
			
			//System.out.println(findColor(p,x,y));
			writer.println("Case #" + (i+1) + ": " + findColor(p,x,y) + "\n");
			
			
		}
		
		writer.close();
		
		
	}
	
	private static String findColor(int p, int x, int y){
		
		String color = "white";
		
		int angle = (int) (p/100.0 * 360);
		
		double dist = Math.sqrt((x-50)*(x-50) + (y-50)*(y-50));
		if(dist < maxDist){
			color = "black";
		} else {
			return color; // white
		}
		
		double angle2 = Math.toDegrees(Math.atan2(x-50, y-50)); 
		if(angle2 < 0)
			angle2 += 360.0;
		
		if(angle2< angle)
			color = "black";
		else
			color = "white";
		
		return color;
	}

}
