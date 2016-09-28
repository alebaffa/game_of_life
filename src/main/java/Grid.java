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

        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i == x && j == y)
                    continue;
                if (grid[i][j].isAlive())
                    countLiveCells++;
            }
        }
        return countLiveCells;
    }
}
