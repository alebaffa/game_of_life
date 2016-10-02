import java.util.HashMap;
import java.util.Map;

/**
 * Created by alebaffa on 28/09/16.
 */
public class Grid {
    private int rows;
    private int columns;
    private Cell[][] grid;

    public Grid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        grid = new Cell[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                setDead(new Coordinates(i, j));
            }
        }
    }

    public int sizeOfDeadCells() {
        int countDeadCells = 0;
        for (int i = 0; i <= rows - 1; i++) {
            for (int j = 0; j <= columns - 1; j++) {
                if (!grid[i][j].isAlive())
                    countDeadCells++;
            }
        }
        return countDeadCells;
    }

    public void setLive(Coordinates coordinates) {
        grid[coordinates.getPositionX()][coordinates.getPositionY()] = new LiveCell(coordinates);
    }

    public void setDead(Coordinates coordinates) {
        grid[coordinates.getPositionX()][coordinates.getPositionY()] = new DeadCell(coordinates);
    }

    public Map<String, Integer> countLiveAndDeadNeighboursOf(Coordinates coordinates) {
        int countDeadCells = 0;
        int countLiveCells = 0;
        Map<String, Integer> counters = new HashMap<String, Integer>();

        int positionX = coordinates.getPositionX();
        int positionY = coordinates.getPositionY();
        int upperLeftNeighbour = coordinates.getUpperLeftNeighbour();
        int upperRightNeighbour = coordinates.getUpperRightNeighbour(grid);
        int lowerLeftNeighbour = coordinates.getLowerLeftNeighbour();
        int lowerRightNeighbour = coordinates.getLowerRightNeighbour(grid);

        for (int i = upperLeftNeighbour; i <= upperRightNeighbour; i++)
            for (int j = lowerLeftNeighbour; j <= lowerRightNeighbour; j++) {
                if (i == positionX && j == positionY)
                    continue;
                if (!grid[i][j].isAlive())
                    countDeadCells++;
                else
                    countLiveCells++;
            }
            counters.put("live", countLiveCells);
            counters.put("dead", countDeadCells);
        return counters;
    }

    public Cell calculateNextGenerationOf(Cell cell) {
        Map<String, Integer> counters = countLiveAndDeadNeighboursOf(cell.getCoordinates());
        int liveCells = counters.get("live");

        if (liveCells == 2 || liveCells == 3)
            return new LiveCell(cell.getCoordinates());
        if (liveCells < 2)
            return new DeadCell(cell.getCoordinates());
        if (liveCells > 3)
            return new DeadCell(cell.getCoordinates());
        return null;
    }
}
