import java.util.ArrayList;
import java.util.List;

public class ExplorerSearch {

    /**
     * Returns how much land area an explorer can reach on a rectangular island.
     * 
     * The island is represented by a rectangular int[][] that contains
     * ONLY the following nunbers:
     * 
     * '0': represents the starting location of the explorer
     * '1': represents a field the explorer can walk through
     * '2': represents a body of water the explorer cannot cross
     * '3': represents a mountain the explorer cannot cross
     * 
     * The explorer can move one square at a time: up, down, left, or right.
     * They CANNOT move diagonally.
     * They CANNOT move off the edge of the island.
     * They CANNOT move onto a a body of water or mountain.
     * 
     * This method should return the total number of spaces the explorer is able
     * to reach from their starting location. It should include the starting
     * location of the explorer.
     * 
     * For example
     * 
     * @param island the locations on the island
     * @return the number of spaces the explorer can reach
     */
    public static int reachableArea(int[][] island) {
        // Implement your method here!
        // Please also make more test cases
        // I STRONGLY RECOMMEND testing some helpers you might make too

        // 1
        int[] startPoint = explorerFinder(island);
        boolean[][] visited = new boolean [island.length] [island[0].length];

        List<int[]> reachable =  reachableArea(island, startPoint, visited);
        return reachable.size();
    }

    //FIRST STEP is to LOCATE the explorer

    //this is done by first setting up a loop that can access each row inside the 2d array

    //then set up a loop that will access each item in the row
    public static int[] explorerFinder(int[][] island){
        
        for(int r = 0; r < island.length; r++){
            for(int c = 0; c < island[0].length; c++){
                if(island[r][c] == 0){
                    return new int[]{r,c};
                }
            }
        }
        throw new IllegalArgumentException("There isn't an explorer");
    }

    // public static List<int[]> possibleMoves(int[][] island, int[] current){


    //     return new List<int[]>;
    // }
    public static List<int[]> possibleMoves(int[][] island, int[] current){

        int curR = current[0];
        int curC = current[1];
        List<int[]> moves = new ArrayList<>();


        //UP
        int newR = curR -1;
        int newC = curC;
        if(newR >= 0 && island[newR][newC] != 2 && island[newR][newC] != 3){
            moves.add(new int[]{newR, newC});
        }

        //DOWN
        newR = curR + 1;
        newC = curC;
        if(newR < island.length && island[newR][newC] != 2 && island[newR][newC] != 3){
            moves.add(new int[]{newR, newC});
        }

        //LEFT
        newR = curR;
        newC = curC - 1;
        if(newC >= 0 && island[newR][newC] != 2 && island[newR][newC] != 3){
            moves.add(new int[]{newR, newC});
        }

         //RIGHT
         newR = curR;
         newC = curC + 1;
         if(newC < island[0].length && island[newR][newC] != 2 && island[newR][newC] != 3){
             moves.add(new int[]{newR, newC});
         }
 
        return moves;
    }

    public static List<int[]> reachableArea(int[][] island, int[]current, boolean[][] visited){
        int curR = current[0];
        int curC = current[1];

        if(visited[curR][curC]) return new ArrayList<>();

        //this one does have a reach goal like food, it just wants to know all the possible locals! 

        visited[curR][curC] = true;

        List<int[]> result = new ArrayList<>();
        //ADDING THE CURRENT ITTERATION LOCALE TO THE POSSIBLE MOVES
        // only adding a local to the list WHEN AND IF WE VISIT IT
        // how can this problematic? 
        result.add(current);

        //grabbing all the possible moves using the POSSIBLE MOVES method... FOR THE CURRENT ITERATION
        List<int[]> moves = possibleMoves(island, current);
        for(int[] move : moves){
            result.addAll(reachableArea(island, move, visited));
        }
        

        return result;
    }
}
