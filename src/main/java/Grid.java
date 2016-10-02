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
        grid[coordinates.getX()][coordinates.getY()] = new LiveCell(coordinates);
    }

    public void setDead(Coordinates coordinates) {
        grid[coordinates.getX()][coordinates.getY()] = new DeadCell(coordinates);
    }

    public int countLiveNeighboursOf(Coordinates coordinates) {
        int countLiveCells = 0;
        int x = coordinates.getX();
        int y = coordinates.getY();
        int lowerBoundX = coordinates.getLowerBoundX();
        int upperBoundX = coordinates.getUpperBoundX(grid);
        int lowerBoundY = coordinates.getLowerBoundY();
        int upperBoundY = coordinates.getUpperBoundY(grid);

        for (int i = lowerBoundX; i <= upperBoundX; i++)
            for (int j = lowerBoundY; j <= upperBoundY; j++) {
                if (i == x && j == y)
                    continue;
                if (grid[i][j].isAlive())
                    countLiveCells++;
            }
        return countLiveCells;
    }

    public int countDeadNeighboursOf(Coordinates coordinates) {
        int countDeadCells = 0;
        int x = coordinates.getX();
        int y = coordinates.getY();
        int lowerBoundX = coordinates.getLowerBoundX();
        int upperBoundX = coordinates.getUpperBoundX(grid);
        int lowerBoundY = coordinates.getLowerBoundY();
        int upperBoundY = coordinates.getUpperBoundY(grid);

        for (int i = lowerBoundX; i <= upperBoundX; i++)
            for (int j = lowerBoundY; j <= upperBoundY; j++) {
                if (i == x && j == y)
                    continue;
                if (!grid[i][j].isAlive())
                    countDeadCells++;
            }
        return countDeadCells;
    }
}
