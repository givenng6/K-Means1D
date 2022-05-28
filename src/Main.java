import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args){
        // The x values of the points...
        int[] centroidPosition = {5, 12, 17};
        double[] pointsPosition = {1, 6, 11, 14, 15, 19, 21};

        ArrayList<Point> points = new ArrayList<>();
        ArrayList<Centroid> centroids = new ArrayList<>();

        for(int i = 0; i < pointsPosition.length; i++){
            points.add(new Point(i, pointsPosition[i]));
        }

        for(int i = 0; i < centroidPosition.length; i++){
            centroids.add(new Centroid(i, centroidPosition[i]));
        }

        int[] pointsCluster = new int[points.size()];

        while(true){
            Iterate(points, centroids);
            Average(centroids);
            int[] oldCluster = Arrays.copyOf(pointsCluster, pointsCluster.length);

            for(int i = 0; i < points.size(); i++){
                pointsCluster[i] = points.get(i).getCurrCentroid().getId();
            }

            if(Arrays.equals(oldCluster, pointsCluster)){
                break;
            }
        }

        KMeans(points, centroids);
    }

    public static void Iterate(ArrayList<Point> points, ArrayList<Centroid> centroids){
        for(Point point: points){
            // Finding the closet centroid for every point...
            for(Centroid centroid: centroids){
                double distance = point.distance(centroid.getX());
                if(point.getCurrCentroid() == null){
                    point.addCentroid(centroid);
                    centroid.assignPoint(point);
                }else{
                    if(point.getDistance() > distance){
                        Centroid old = point.getCurrCentroid();
                        old.removePoint(point);
                        point.addCentroid(centroid);
                        centroid.assignPoint(point);
                    }
                }
            }
        }
    }

    public static void Average(ArrayList<Centroid> centroids){
        // Recalculating the X-Value of the centroid...
        // The new value should be the average of the points in the centroid...
        for(Centroid centroid: centroids){
            ArrayList<Point> list = centroid.getPointsAssigned();
            if(list.size() > 0){
                double value = 0;
                for(Point point: list){
                    value = value +  point.getX();
                }
                // updating the position of the centroid...
                centroid.setX(value / list.size());
            }
        }
    }

    public static void KMeans(ArrayList<Point> points, ArrayList<Centroid> centroids){
        // The solution
        for(Point point: points){
            System.out.println("Point ID: " + point.getId() + " Is classified under " + point.getCurrCentroid().getId());
        }

        for(Centroid centroid: centroids){
            System.out.println("Centroid ID: " + centroid.getId() + " new location " + centroid.getX());
        }
    }
}
