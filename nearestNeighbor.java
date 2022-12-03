import java.util.*;
import java.io.*;

//Note for self, 2.0000 == 2 in java

class Main
{
	
	static ArrayList<ArrayList<Double>> parser(String path){
		ArrayList<ArrayList<Double>> parsed = new ArrayList<ArrayList<Double>>();
		try {
		File textFile = new File(path);
		
		Scanner readLine = new Scanner(textFile);
		
		int rowNum = 0;
		
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
	
	static ArrayList<Double> accuracy(ArrayList<ArrayList<Double>> features) {
		
		int correct = 0;
		ArrayList<Double> accus = new ArrayList<Double>();
		for(int i = 1; i < features.get(0).size(); i++) {
			for(int j = 0; j < features.size(); j++) {
				double minDist = 9999999.9;
				double currFeature = features.get(j).get(i);
				int nearest = -1;
				for(int k = 0; k < features.size(); k++) {
					if(k != j) {
						double testFeature = features.get(k).get(i);
						double tempDist = Math.abs(currFeature - testFeature);
						if(tempDist < minDist) {
							minDist = tempDist;
							nearest = k;
						}
					}
				}
				
				if((features.get(j).get(0) == 1.0 && features.get(nearest).get(0) == 1.0) || (features.get(j).get(0) == 2.0 && features.get(nearest).get(0) == 2.0)) {
					correct++;
				}
				
			}
		
			double acc = ((double)correct / features.size());
			accus.add(acc);
			correct = 0;
		}
		
		
		return accus;
		
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to Jordan Kuschner's Nearest Neighbor Classifier!");
		String fileName = "CS170_Small_Data__1.txt";
		ArrayList<ArrayList<Double>> features = parser(fileName);
		ArrayList<Double> accuracies = accuracy(features);
		
		for(int i = 0; i < accuracies.size(); i++) {
			System.out.println("Accuracy of feature " + (i+1) + ": " + accuracies.get(i));
		}
		
		
	}
	
	
}

