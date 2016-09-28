import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by alebaffa on 28/09/16.
 */
public class TheCellShould {
    @Test
    public void has_zero_live_neighbours_when_the_only_live() {
        Grid grid = new Grid(4, 5);
        Cell cell = new LiveCell(2, 2);

        grid.setLive(cell);

        assertThat(grid.countLiveNeighboursOf(cell), is(0));
    }
}
