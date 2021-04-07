import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        //suppose the points are given in a file, each point line (x,y) and the points from the same line separated by ;
        try { BufferedReader fileIn = new BufferedReader(new FileReader("C:\\Users\\Andreea\\Desktop\\Intellij Projects\\UMT\\src\\com\\company\\points.txt"));
            String line = fileIn.readLine();
            ArrayList<Point> points = new ArrayList<>();
            while (line!=null){
                String[] pointsStr = line.split(";");
                for (String point : pointsStr) {
                    String[] coordinates = point.split(",");
                    float x = Float.parseFloat(coordinates[0].substring(1));
                    float y = Float.parseFloat(coordinates[1].substring(0, coordinates[1].length() - 1));
                    points.add(new Point(x, y));            // add each point found in the file in a list
                }
                line = fileIn.readLine();
            }
            int result = nrOfRectangles(points);    //the function that counts the number of rectangles
            System.out.println(result);             //printing the result in the console
            fileIn.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static int nrOfRectangles(ArrayList<Point> points){
        int count=0;    //the number of rectangles found
        int i,j,k;      //the indexes
        for(i =0 ; i<points.size()-1; i++) {   //going through the list of points to find two points that have different coordinates( A(x1,y1),B(x2,y2) )
            for (j = i + 1; j < points.size(); j++) {
                if (points.get(i).getX() != points.get(j).getX() && points.get(i).getY() != points.get(j).getY()) {
                    boolean found1 = false, found2 = false;   //two boolean variables to verify if two points exist in the list
                    for (k = i + 1; k < points.size(); k++) {   //if we found those two points we need to check if the points C(x1,y2),D(x2,y1) exist in the list
                        if (points.get(k).getX() == points.get(j).getX() && points.get(k).getY() == points.get(i).getY())
                            found1 = true;
                        else if (points.get(k).getX() == points.get(i).getX() && points.get(k).getY() == points.get(j).getY())
                            found2 = true;
                        if (found1 && found2) {
                            count++; //if both points C and D exist in the list, increase the count
                            break;   //and stop the search
                        }
                    }
                }
            }
        }
        return count;      //return the number of rectangles found
    }
}
