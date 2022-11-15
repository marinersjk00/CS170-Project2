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
		/*
		 * Source for Triangle Property
		 * https://byjus.com/maths/properties-of-triangle/#:~:text=The%20sum%20of%20the%20length,three%20sides%20of%20a%20triangle.
		 */
		
		if(ab > c && ac > b && bc > a) return true;
		else return false;
	}
	
	public static void main(String[] args) {
		
		/*
		 * Source for decimal formatting
		 * https://www.baeldung.com/java-round-decimal-number
		 * 
		 */
		DecimalFormat df = new DecimalFormat("#.###");
		
		
		
		int outercounter = 0;
		double overall = 0;
		
		while(outercounter < 10000) { //10000 simulations per program execution
			int counter = 0;
			int good = 0;
		while(counter < 10000) { //each simulation runs 10,000 times
			
			
			
			if(goodTriangle()) good++;
			
			
			counter++;
		}
		
		double prob = (double)good / 10000;
		overall = overall + prob;
		
		outercounter++;
		
		}
		
		System.out.print("Overall Probability of Getting Good Triangle: " + df.format((overall / 10000)));
		
	}
}
