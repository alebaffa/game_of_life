import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by alebaffa on 28/09/16.
 */
public class TheGridShould {
    @Test
    public void contains_only_dead_cells_when_created() {
        Grid grid = new Grid(4, 5);

        assertThat(grid.sizeOfDeadCells(), is(20));
    }
}
