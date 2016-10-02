/**
 * Created by alebaffa on 28/09/16.
 */
public class LiveCell implements Cell {
    private Coordinates coordinates = null;

    public LiveCell(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
    @Override
    public boolean isAlive() {
        return true;
    }

    @Override
    public Coordinates getCoordinates() {
        return coordinates;
    }
}
