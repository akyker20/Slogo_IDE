package state;

public class Turtle {

    private static final double DEFAULT_TURTLE_HEADING = 0.0;
    public Pen pen = new Pen();
    private double myHeading;
    private Location myLocation;
    private double myOpacity = 100;
    private boolean turtleShowing = true;
    private int myID;

    public Turtle () {
        this(0);
    }
    public Turtle (int ID) {
        myLocation = new Location(0,0);
        myHeading = DEFAULT_TURTLE_HEADING;
        myID = ID;
    }

    public void showTurtle(){
        turtleShowing = true;
        setOpacity(100);
    }

    public void hideTurtle(){
        turtleShowing = false;
        setOpacity(0);
    }

    public boolean isTurtleShowing(){
        return turtleShowing;
    }

    public void setOpacity(double opacity){
        myOpacity = opacity;
    }

    public double getOpacity(){
        return myOpacity;
    }

    public double getHeading () {
        return myHeading;
    }

    public void setHeading (double myHeading) {
        this.myHeading = myHeading;
    }

    public void move(double amount){
        double heading = 90-myHeading;
        double xDisplacement = roundToHundredths(amount*Math.cos(heading/(180/Math.PI)));
        double yDisplacement = roundToHundredths(amount*Math.sin(heading/(180/Math.PI)));
        myLocation.add(xDisplacement, yDisplacement);
    }

    private double roundToHundredths(double number){
        return Math.round(number*100)/100;
    }

    public void rotate(double amount) {
        setHeading((myHeading+amount)%360);
    }

    public Location getLocation(){
        return myLocation;
    }

    public double getTurtleXLocation(){
        return myLocation.getX();
    }

    public double getTurtleYLocation(){
        return myLocation.getY();
    }

    public void setLocation (Location myLocation) {
        this.myLocation = myLocation;
    }

    public int getID() {
        return myID;
    }


}
