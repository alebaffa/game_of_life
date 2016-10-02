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
                grid[i][j] = new DeadCell(i, j);
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

    public void setLive(Cell cell) {
        grid[cell.getPosX()][cell.getPosY()] = cell;
    }

    public int countLiveNeighboursOf(Cell cell) {
        int countLiveCells = 0;
        int x = cell.getPosX();
        int y = cell.getPosY();
        int lowerBoundX = x - 1;
        int upperBoundX = x + 1;
        int lowerBoundY = y - 1;
        int upperBoundY = y + 1;
        if (x == 0)
            lowerBoundX = x;
        if (x == grid.length - 1)
            upperBoundX = x;

        if (y == 0)
            lowerBoundY = y;
        if (y == grid[0].length - 1)
            upperBoundY = y;

        for (int i = lowerBoundX; i <= upperBoundX; i++) {
            for (int j = lowerBoundY; j <= upperBoundY; j++) {
                if (i == x && j == y)
                    continue;
                if (grid[i][j].isAlive())
                    countLiveCells++;
            }
        }
        return countLiveCells;
    }

    public int countDeadNeighboursOf(Cell cell) {
        int countDeadCells = 0;
        int x = cell.getPosX();
        int y = cell.getPosY();
        int lowerBoundX = x - 1;
        int upperBoundX = x + 1;
        int lowerBoundY = y - 1;
        int upperBoundY = y + 1;
        if (x == 0)
            lowerBoundX = x;
        if (x == grid.length - 1)
            upperBoundX = x;

        if (y == 0)
            lowerBoundY = y;
        if (y == grid[0].length - 1)
            upperBoundY = y;

        for (int i = lowerBoundX; i <= upperBoundX; i++) {
            for (int j = lowerBoundY; j <= upperBoundY; j++) {
                if (i == x && j == y)
                    continue;
                if (!grid[i][j].isAlive())
                    countDeadCells++;
            }
        }
        return countDeadCells;
    }
}
