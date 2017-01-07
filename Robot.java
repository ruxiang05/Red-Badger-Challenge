import java.util.ArrayList;



public class Robot {
    private Coordinates position;
    private Orientation orientation;
    private static ArrayList<Coordinates> scents = new ArrayList<>(1);


    public Robot(final int x,final int y, final String orientation){
        position = new Coordinates(x,y);
        setOrientation(orientation);

    }


    private void setOrientation(final String orientation){
        switch (orientation){
            case "N" : this.orientation = Orientation.N;
                break;
            case "E" : this.orientation = Orientation.E;
                break;
            case "S" : this.orientation = Orientation.S;
                break;
            case "W" : this.orientation = Orientation.W;
                break;
        }
    }


    public void turnLeft(){
        switch (orientation){
            case N : orientation = Orientation.W;
                break;
            case E : orientation = Orientation.N;
                break;
            case S : orientation = Orientation.E;
                break;
            case W : orientation = Orientation.S;
                break;
        }
    }


    public void turnRight(){
        switch (orientation){
            case N : orientation = Orientation.E;
                break;
            case E : orientation = Orientation.S;
                break;
            case S : orientation = Orientation.W;
                break;
            case W : orientation = Orientation.N;
                break;
        }
    }

    public Coordinates moveForward(){
        //The reason I chose to make a copy position is to not throw the robot overboard if there's a scent on that future position
        Coordinates futurePosition = new Coordinates(position);
        switch (orientation){
            case N : futurePosition.setY(futurePosition.getY() + 1);
                break;
            case E : futurePosition.setX(futurePosition.getX() + 1);
                break;
            case S : futurePosition.setY(futurePosition.getY() - 1);
                break;
            case W : futurePosition.setX(futurePosition.getX() - 1);
                break;
        }

        //Makes sure the future position is not a scent
        if(!scents.contains(futurePosition)){

            position.set(futurePosition.getX(), futurePosition.getY());
        }

        return position;
    }

    public static void addScent(Robot robot){
        scents.add(robot.position);
    }

    //Checks if robot is on Mars
    public boolean isOnMars(Coordinates bound){
        return (position.getX() <= bound.getX()) && (position.getY() <= bound.getY()) && (position.getX()) >= 0 && (position.getY() >=  0);
    }


    @Override
    public String toString(){
        return position.toString() + " " + orientation;
    }

    private enum Orientation{
        N,
        E,
        S,
        W
    }



}

