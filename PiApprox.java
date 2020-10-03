
import java.lang.Math;
import java.util.*;
import java.awt.Point;

public class PiApprox{


	public static Double approximate(ArrayList<Double> distances){
		double insideCount = 0.0;
		for (int i = 0; i < distances.size(); i++){
			if (distances.get(i) < 0.5){
				insideCount++;
			}
		}
		return 4 * (insideCount/distances.size());
	}

	public static Double standardDev(ArrayList<Double> values){
		double mean = average(values);
		double sum = 0.0;
		for (int i = 0; i < values.size(); i++){
			sum += (values.get(i) - mean) * (values.get(i) - mean);
		}
		return Math.sqrt(sum/(values.size()-1));
	}

	public static Double average(ArrayList<Double> values){
		double sum = 0.0;
		for (int i = 0; i < values.size(); i++){
			sum += values.get(i);
		}
		return sum/values.size();
	}

	public static Double distance(double x, double y){
		double xSquare = (x - 0.5) * (x - 0.5);
		double ySquare = (y - 0.5) * (y - 0.5);
		return Math.sqrt(xSquare + ySquare);
	}


	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the Number of games: ");
		double games = in.nextDouble();
		System.out.print("Enter the number of darts per game: ");
		double totalCount = in.nextDouble();
		ArrayList<Double> piValues = new ArrayList<Double>();
		for (int i = 0; i < games; i++){
			ArrayList<Double> distances = new ArrayList<Double>();
			for (int j = 0; j < totalCount; j++){
				double x = Math.random();
				double y = Math.random();
				double dis = distance(x, y);
				distances.add(dis);
			}
			piValues.add(approximate(distances));
		}
		System.out.println(average(piValues));
		System.out.println(standardDev(piValues));
	}
}