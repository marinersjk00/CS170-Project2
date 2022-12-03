import java.util.*;
import java.io.*;


class Main
{
	
	static ArrayList<ArrayList<Double>> parser(String path){
		ArrayList<ArrayList<Double>> parsed = new ArrayList<ArrayList<Double>>();
		try {
		File textFile = new File(path);
		
		Scanner readLine = new Scanner(textFile);
		
		int rowNum = 0;
		int colNum = 0;
		
		while(readLine.hasNextLine()) {
			String currLine = readLine.nextLine();
			Scanner readVals = new Scanner(currLine);
			ArrayList<Double> thisLine = new ArrayList<>();
			parsed.add(thisLine);
			while(readVals.hasNextDouble()) {
				parsed.get(rowNum).add(readVals.nextDouble());
			}
			
			rowNum++;
			readVals.close();
			
		}
		readLine.close();
		
		
	}catch(FileNotFoundException e) {
		System.out.print("Error!");
		e.printStackTrace();
	}
		
		return parsed;
	
}
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to Jordan Kuschner's Nearest Neighbor Classifier!");
		String fileName = "CS170_Small_Data__1.txt";
		ArrayList<ArrayList<Double>> features = parser(fileName);
		
		for(int i = 0; i < 10; i++) {
			System.out.print((i + 1) + ": ");
			for(int j = 0; j < features.get(i).size(); j++) {
				System.out.print(features.get(i).get(j) + "  ");
			}
			System.out.println();
		}
		
	}
	
	
}

