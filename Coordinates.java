public class Coordinates {

    private int x, y;

    public Coordinates(int x,int y){
        this.x = x;
        this.y = y;
    }

    public Coordinates(Coordinates coordinates){
        this.x = coordinates.x;
        this.y = coordinates.y;
    }


    public void set(int x,int y){
        setX(x);
        setY(y);
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Coordinates)) {
            return false;
        }
        return (x == ((Coordinates) o).x && y == ((Coordinates) o).y);
    }
    @Override
    public String toString(){
        return  x + " " + y;
    }


}
