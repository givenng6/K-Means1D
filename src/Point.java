public class Point {

    private int id;
    private double x;
    private Centroid currCentroid;
    public Point(int id, double x){
        this.id = id;
        this.x = x;
        this.currCentroid = null;
    }

    public int getId() {
        return id;
    }

    public double getX() {
        return x;
    }

    public Centroid getCurrCentroid(){
        return currCentroid;
    }

    public double getDistance(){
        return distance(currCentroid.getX());
    }

    public double distance(double centroidX){
        return Math.abs(centroidX - this.x);
    }

    public void addCentroid(Centroid centroid){
        this.currCentroid = centroid;
    }


}
