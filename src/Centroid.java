import java.util.ArrayList;

public class Centroid {

    private double x;
    private int id;
    private ArrayList<Point> pointsAssigned;
    public Centroid(int id, int x){
        this.id = id;
        this.x = x;
        this.pointsAssigned = new ArrayList<>();
    }

    public void assignPoint(Point newPoint){
        this.pointsAssigned.add(newPoint);
    }

    public void setX(double x){
        this.x = x;
    }

    public int getId() {
        return id;
    }

    public double getX() {
        return x;
    }

    public ArrayList<Point> getPointsAssigned(){
        return this.pointsAssigned;
    }

    public void removePoint(Point point){
        pointsAssigned.remove(point);
    }
}
