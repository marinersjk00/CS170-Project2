import java.util.*;
import java.text.DecimalFormat;

class Main


{
	
	static boolean goodTriangle() {
		
		Random gen = new Random();
		
		double a = gen.nextDouble();
		double pointB = gen.nextDouble();
		
		if(a > pointB) {
			double temp = a;
			a = pointB;
			pointB = temp;
		}
		
		double b = pointB - a;
		
		
		
		double c = 1 - pointB;
		
		double ab = a + b;
		double ac = a + c;
		double bc = b + c;
		
		
		if(ab > c && ac > b && bc > a) return true;
		else return false;
	}
	
	public static void main(String[] args) {
		
		DecimalFormat df = new DecimalFormat("#.###");
		
		
		
		int outercounter = 0;
		
		while(outercounter < 20) {
			int counter = 0;
			int good = 0;
		while(counter < 10000) {
			
			
			
			if(goodTriangle()) good++;
			
			
			counter++;
		}
		
		double prob = (double)good / 10000;
		
		System.out.print("\n" + (outercounter + 1) + ": " + df.format(prob));
		outercounter++;
		
		}
		
	}
}
