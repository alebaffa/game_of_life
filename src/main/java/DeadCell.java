/**
 * Created by alebaffa on 28/09/16.
 */
public class DeadCell implements Cell {
    private Coordinates coordinates = null;

    public DeadCell(Coordinates coordinates){
        this.coordinates = coordinates;
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
