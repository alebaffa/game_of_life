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
        Coordinates coordinates = new Coordinates(2, 2);

        // When
        grid.setLive(coordinates);

        // Then
        assertThat(grid.countLiveNeighboursOf(coordinates), is(0));
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
        assertThat(grid.countLiveNeighboursOf(new Coordinates(1, 1)), is(3));
    }

    @Test
    public void have_3_dead_neighbours_when_in_corner() {
        // Given
        Grid grid = new Grid(3, 3);

        // When

        // Then
        assertThat(grid.countDeadNeighboursOf(new Coordinates(0, 0)), is(3));
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
        assertThat(grid.countLiveNeighboursOf(new Coordinates(0, 2)), is(3));
    }

    @Test
    public void have_zero_live_neighbours_when_in_corner() {
        // Given
        Grid grid = new Grid(3, 3);

        // When

        // Then
        assertThat(grid.countLiveNeighboursOf(new Coordinates(0, 1)), is(0));
    }

    @Test
    public void have_5_dead_neighbours_when_middle_up() {
        // Given
        Grid grid = new Grid(3, 3);

        // When

        // Then
        assertThat(grid.countDeadNeighboursOf(new Coordinates(0, 1)), is(5));
    }
}
