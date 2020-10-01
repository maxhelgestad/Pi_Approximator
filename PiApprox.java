import java.lang.Math;
import java.util.*;

public class PiApprox{
  
  public static DoublePoint randomPoint(){
    double x = Math.random();
    double y = Math.random();
    DoublePoint point = new DoublePoint(x, y);
    return point;
  }
  
  public static Double approximate(ArrayList<DoublePoint> darts, Double totalCount){
    double insideCount = 0.0;
    for (int i = 0; i < darts.size(); i++){
      if (Math.sqrt((darts.get(i).getY() - 0.5) * (darts.get(i).getY() - 0.5) + 
                    (darts.get(i).getX() - 0.5) * (darts.get(i).getX() - 0.5)) < 0.5){
        insideCount++;
      }
    }
    return 4 * (insideCount/totalCount);
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
  
  
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    System.out.print("Enter the Number of games: ");
    double games = in.nextDouble();
    System.out.print("Enter the number of darts per game: ");
    double totalCount = in.nextDouble();
    ArrayList<Double> piValues= new ArrayList<Double>();
    for (int i = 0; i < games; i++){
      ArrayList<DoublePoint> darts = new ArrayList<DoublePoint>();
      for (int j = 0; j < totalCount; j++){
        DoublePoint point = randomPoint();
        darts.add(point);
      }
      piValues.add(approximate(darts, totalCount));
    }
    System.out.println(average(piValues));
    System.out.println(standardDev(piValues));
  }
}