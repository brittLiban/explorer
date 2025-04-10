import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class ExplorerSearchTest {
    @Test
    public void testReachableArea_someUnreachable() {
        int[][] island = {
                { 1, 1, 1, 3, 1, 1 },
                { 3, 2, 3, 1, 3, 1 },
                { 1, 1, 1, 1, 3, 3 },
                { 3, 1, 2, 1, 0, 1 },
                { 1, 1, 1, 2, 1, 1 },
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(14, actual);
    }

    @Test
    public void testReachableArea_noMoves() {
        int[][] island = {
                { 1, 1, 1, 1, 1 },
                { 1, 3, 3, 3, 1 },
                { 1, 3, 0, 3, 1 },
                { 1, 3, 3, 3, 1 },
                { 1, 1, 1, 1, 1 }
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual);
    }

    @Test
    public void testReachableArea_surroundedByMountains() {
        int[][] island = {
                { 1, 1, 1, 1, 1 },
                { 1, 3, 3, 3, 1 },
                { 1, 3, 0, 3, 1 },
                { 1, 3, 3, 3, 1 },
                { 1, 1, 1, 1, 1 }
        };

        assertEquals(1, ExplorerSearch.reachableArea(island));
    }

    // Add more tests here!
    // Come up with varied cases

    // testing explorerFinder
    @Test
    public void testExplorerLocation_first() {
        int[][] island = {
                { 1, 1, 1, 3, 1, 1 },
                { 3, 2, 3, 1, 3, 1 },
                { 1, 1, 1, 1, 3, 3 },
                { 3, 1, 2, 1, 0, 1 },
                { 1, 1, 1, 2, 1, 1 },
        };

        int[] expected = { 3, 4 };
        assertArrayEquals(expected, ExplorerSearch.explorerFinder(island));
    }

    @Test
    public void testExplorerLocation_firstElem() {
        int[][] island = {
                { 0, 1, 1, 3, 1, 1 },

        };

        int[] expected = { 0, 0 };
        assertArrayEquals(expected, ExplorerSearch.explorerFinder(island));
    }

    @Test
    public void testExplorerLocation_lastElem() {
        int[][] island = {
                { 1, 1, 1, 3, 1, 1 },
                { 3, 2, 3, 1, 3, 1 },
                { 1, 1, 1, 1, 3, 3 },
                { 3, 1, 2, 1, 1, 1 },
                { 1, 1, 1, 2, 1, 0 },

        };

        int[] expected = { 4, 5 };
        assertArrayEquals(expected, ExplorerSearch.explorerFinder(island));
    }

    @Test
    public void testExplorerLocation_midElem() {
        int[][] island = {
                { 1, 1, 1, 3, 1, 1 },
                { 3, 2, 3, 1, 3, 1 },
                { 1, 1, 0, 1, 3, 3 },
                { 3, 1, 2, 1, 1, 1 },
                { 1, 1, 1, 2, 1, 1 },

        };

        int[] expected = { 2, 2 };
        assertArrayEquals(expected, ExplorerSearch.explorerFinder(island));
    }

    // Testing possible Moves -- YOU AINT KOBE

    @Test
    public void testPossibleMoves_twoDirectionsOpen() {
        int[][] island = {
                { 1, 1, 1, 3, 1, 1 },
                { 3, 2, 3, 1, 3, 1 },
                { 1, 1, 0, 1, 3, 3 },
                { 3, 1, 2, 1, 1, 1 },
                { 1, 1, 1, 2, 1, 1 },

        };

        int[] location = { 2, 2 };
        List<int[]> moves = ExplorerSearch.possibleMoves(island, location);
        Set<String> moveSet = toSet(moves);

        assertEquals(2, moves.size());
        assertTrue(moveSet.contains("2,1")); // left
        assertTrue(moveSet.contains("2,3")); // right
    }

    @Test
    public void testPossibleMoves_allDirectionsOpen() {
        int[][] island = {
                { 1, 1, 1, 3, 1, 1 },
                { 3, 2, 1, 1, 3, 1 },
                { 1, 1, 0, 1, 3, 3 },
                { 3, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 2, 1, 1 },

        };

        int[] location = { 2, 2 };
        List<int[]> moves = ExplorerSearch.possibleMoves(island, location);
        Set<String> moveSet = toSet(moves);

        assertEquals(4, moves.size());
        assertTrue(moveSet.contains("2,1")); // left
        assertTrue(moveSet.contains("2,3")); // right
        assertTrue(moveSet.contains("1,2")); // up
        assertTrue(moveSet.contains("3,2")); // down
    }

    @Test
    public void testPossibleMoves_noDirectionsOpen() {
        int[][] island = {
                { 1, 1, 1, 3, 1, 1 },
                { 3, 2, 3, 1, 3, 1 },
                { 1, 3, 0, 3, 3, 3 },
                { 3, 1, 3, 1, 1, 1 },
                { 1, 1, 1, 2, 1, 1 },

        };

        int[] location = { 2, 2 };
        List<int[]> moves = ExplorerSearch.possibleMoves(island, location);

        assertEquals(0, moves.size());

    }

    // stealing this from SalamanderTest - Thanks Prof. Auberon!
    private Set<String> toSet(List<int[]> list) {
        Set<String> set = new HashSet<>();
        for (int[] arr : list) {
            set.add(arr[0] + "," + arr[1]);
        }
        return set;
    }
}
