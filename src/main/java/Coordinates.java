/**
 * Created by alebaffa on 02/10/16.
 */
public class Coordinates {

    private int x;
    private int y;
    private int lowerBoundX;
    private int upperBoundX;
    private int lowerBoundY;
    private int upperBoundY;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public int getUpperLeftNeighbour() {
        lowerBoundX = x - 1;
        if (x == 0)
            lowerBoundX = x;
        return lowerBoundX;
    }

    public int getUpperRightNeighbour(Cell[][] grid) {
        upperBoundX = x + 1;
        if (x == grid.length - 1)
            upperBoundX = x;
        return upperBoundX;
    }

    public int getLowerLeftNeighbour() {
        lowerBoundY = y - 1;
        if (y == 0)
            lowerBoundY = y;
        return lowerBoundY;
    }

    public int getLowerRightNeighbour(Cell[][] grid) {
        upperBoundY = y + 1;
        if (y == grid[0].length - 1)
            upperBoundY = y;
        return upperBoundY;
    }
}
