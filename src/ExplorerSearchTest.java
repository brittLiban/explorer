import static org.junit.Assert.*;
import org.junit.Test;

public class ExplorerSearchTest {
    @Test
    public void testReachableArea_someUnreachable() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,0,1},
            {1,1,1,2,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(14, actual);
    }

    // Add more tests here!
    // Come up with varied cases

    //testing explorerFinder
    @Test
    public void testExplorerLocation_first() {
        int[][] island = {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,0,1},
            {1,1,1,2,1,1},
        };

        int[] expected = {3, 4};
        assertArrayEquals(expected, ExplorerSearch.explorerFinder(island));
    }

    // @Test
    // public void testExplorerLocation_NoExplorer() {
    //     int[][] island = {
    //         {1,1,1,3,1,1},
    //         {3,2,3,1,3,1},
    //         {1,1,1,1,3,3},
    //         {3,1,2,1,1,1},
    //         {1,1,1,2,1,1},
    //     };

    //    //how to test this
    //     assertThrows(throw new IllegalArgumentException("There isn't an explorer"), ExplorerSearch.explorerFinder(island));
    // }

    @Test
    public void testExplorerLocation_firstElem() {
        int[][] island = {
            {0,1,1,3,1,1},
            
        };

        int[] expected = {0, 0};
        assertArrayEquals(expected, ExplorerSearch.explorerFinder(island));
    }
}
