import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by alebaffa on 28/09/16.
 */
public class TheCellShould {
    @Test
    public void have_zero_live_neighbours_when_the_only_live() {
        // Given
        Grid grid = new Grid(4, 5);

        // When
        Cell cell = new LiveCell(2, 2);
        grid.setLive(cell);

        // Then
        assertThat(grid.countLiveNeighboursOf(cell), is(0));
    }

    @Test
    public void have_3_live_neighbours_when_in_middle() {
        // Given
        Grid grid = new Grid(3, 3);

        // When
        Cell firstLiveCell = new LiveCell(0, 0);
        Cell secondLiveCell = new LiveCell(0, 1);
        Cell thirdLiveCell = new LiveCell(0, 2);
        grid.setLive(firstLiveCell);
        grid.setLive(secondLiveCell);
        grid.setLive(thirdLiveCell);

        // Then
        assertThat(grid.countLiveNeighboursOf(new DeadCell(1, 1)), is(3));
    }

    @Test
    public void have_3_dead_neighbours_when_in_corner() {
        // Given
        Grid grid = new Grid(3, 3);

        // When

        // Then
        assertThat(grid.countDeadNeighboursOf(new DeadCell(0, 0)), is(3));
    }

    @Test
    public void have_3_live_neighbours_when_in_corner() {
        // Given
        Grid grid = new Grid(3, 3);

        // When
        Cell firstLiveCell = new LiveCell(0, 1);
        Cell secondLiveCell = new LiveCell(1, 2);
        Cell thirdLiveCell = new LiveCell(1, 1);
        grid.setLive(firstLiveCell);
        grid.setLive(secondLiveCell);
        grid.setLive(thirdLiveCell);

        // Then
        assertThat(grid.countLiveNeighboursOf(new DeadCell(0, 2)), is(3));
    }

    @Test
    public void have_zero_live_neighbours_when_in_corner() {
        // Given
        Grid grid = new Grid(3, 3);

        // When

        // Then
        assertThat(grid.countLiveNeighboursOf(new DeadCell(0, 0)), is(0));
    }

    @Test
    public void have_5_dead_neighbours_when_middle_up() {
        // Given
        Grid grid = new Grid(3, 3);

        // When

        // Then
        assertThat(grid.countDeadNeighboursOf(new DeadCell(0, 1)), is(5));
    }
}
