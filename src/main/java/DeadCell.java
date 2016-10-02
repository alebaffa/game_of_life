/**
 * Created by alebaffa on 28/09/16.
 */
public class DeadCell implements Cell {
    private Coordinates coordinates = null;

    public DeadCell(int x, int y){
        this.coordinates = new Coordinates(x, y);
    }
    @Override
    public boolean isAlive() {
        return false;
    }

    @Override
    public int getPosX() {
        return coordinates.getX();
    }

    @Override
    public int getPosY() {
        return coordinates.getY();
    }

    @Override
    public Coordinates getCoordinates() {
        return coordinates;
    }
}
