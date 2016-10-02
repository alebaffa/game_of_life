/**
 * Created by alebaffa on 02/10/16.
 */
public class Coordinates {

    private int positionX;
    private int positionY;

    public Coordinates(int x, int y) {
        this.positionX = x;
        this.positionY = y;
    }

    public int getPositionX(){
        return this.positionX;
    }

    public int getPositionY(){
        return this.positionY;
    }

    public int getUpperLeftNeighbour() {
        if (positionX == 0)
            return positionX;
        else
            return positionX -1;
    }

    public int getUpperRightNeighbour(Cell[][] grid) {
        if (positionX == grid.length - 1)
            return positionX;
        else
            return positionX + 1;
    }

    public int getLowerLeftNeighbour() {
        if (positionY == 0)
            return positionY;
        else
            return positionY - 1;
    }

    public int getLowerRightNeighbour(Cell[][] grid) {
        if (positionY == grid[0].length - 1)
            return positionY;
        else
            return positionY + 1;
    }
}
