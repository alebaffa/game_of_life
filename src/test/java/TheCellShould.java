import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
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
        Coordinates coordinates = new Coordinates(2, 2);

        // When
        grid.setLive(coordinates);

        // Then
        assertThat(getLiveCellsIn(grid, coordinates), is(0));
    }

    @Test
    public void have_3_live_neighbours_when_in_middle() {
        // Given
        Grid grid = new Grid(3, 3);

        // When
        grid.setLive(new Coordinates(0, 0));
        grid.setLive(new Coordinates(0, 1));
        grid.setLive(new Coordinates(0, 2));

        // Then
        assertThat(getLiveCellsIn(grid, new Coordinates(1, 1)), is(3));
    }

    @Test
    public void have_3_dead_neighbours_when_in_corner() {
        // Given
        Grid grid = new Grid(3, 3);

        // Then
        assertThat(getDeadCellsIn(grid, new Coordinates(0, 0)), is(3));
    }

    @Test
    public void have_5_dead_neighbours_when_middle_up() {
        // Given
        Grid grid = new Grid(3, 3);

        // Then
        assertThat(getDeadCellsIn(grid, new Coordinates(0, 1)), is(5));
    }

    @Test
    public void have_3_live_neighbours_when_in_corner() {
        // Given
        Grid grid = new Grid(3, 3);

        // When
        grid.setLive(new Coordinates(0, 1));
        grid.setLive(new Coordinates(1, 2));
        grid.setLive(new Coordinates(1, 1));

        // Then
        assertThat(getLiveCellsIn(grid, new Coordinates(0, 2)), is(3));
    }

    @Test
    public void have_zero_live_neighbours_when_in_corner() {
        // Given
        Grid grid = new Grid(3, 3);

        // Then
        assertThat(getLiveCellsIn(grid, new Coordinates(0, 1)), is(0));
    }

    @Test
    public void live_in_next_generation_when_3_live_neighbours(){
        // Given
        Grid grid = new Grid(3, 3);

        // When
        grid.setLive(new Coordinates(0, 0));
        grid.setLive(new Coordinates(0, 1));
        grid.setLive(new Coordinates(0, 2));

        // Then
        assertThat(grid.calculateNextGenerationOf(new DeadCell(new Coordinates(1, 1))), is(instanceOf(LiveCell.class)));

    }

    @Test
    public void die_in_next_generation_when_less_than_2_live_neighbours(){
        // Given
        Grid grid = new Grid(3, 3);

        // When
        grid.setLive(new Coordinates(0, 0));

        // Then
        assertThat(grid.calculateNextGenerationOf(new LiveCell(new Coordinates(1, 1))), is(instanceOf(DeadCell.class)));

    }

    @Test
    public void die_in_next_generation_when_more_than_3_live_neighbours(){
        // Given
        Grid grid = new Grid(3, 3);

        // When
        grid.setLive(new Coordinates(0, 0));
        grid.setLive(new Coordinates(0, 1));
        grid.setLive(new Coordinates(0, 2));
        grid.setLive(new Coordinates(1, 0));

        // Then
        assertThat(grid.calculateNextGenerationOf(new LiveCell(new Coordinates(1, 1))), is(instanceOf(DeadCell.class)));

    }


    private Integer getLiveCellsIn(Grid grid, Coordinates coordinates) {
        return grid.countLiveAndDeadNeighboursOf(coordinates).get("live");
    }

    private Integer getDeadCellsIn(Grid grid, Coordinates coordinates) {
        return grid.countLiveAndDeadNeighboursOf(coordinates).get("dead");
    }
}
