package twospointers;

import java.util.Arrays;

public class P028_Medium_RotatingTheBox {

    /*

    Problem: Rotating the Box
    med
    30 min
    Understand how to apply the two pointers technique to simulate the rotation of a box matrix and the effect of gravity on stones. This lesson helps you manipulate 2D arrays by implementing stone movement after rotation, develop efficient algorithms for grid problems, and reinforce problem-solving skills with obstacles and gravity constraints.
    Statement
    You are given an m×n matrix of characters boxGrid representing a side-view of a box. Each cell in the box contains one of the following:

    A stone '#'

    A stationary obstacle '*'

    An empty space '.'

    The box is rotated 90 degrees clockwise, causing stones to fall due to gravity. Each stone falls downward until it
    lands on an obstacle, another stone, or the bottom of the box. Gravity does not affect obstacle positions,
    and the rotation’s inertia does not affect stones’ horizontal positions.

    It is guaranteed that every stone in boxGrid initially rests on an obstacle, another stone, or the bottom of the box.

    Return an n×m matrix representing the box after the rotation described above.

    Solution
    The problem can be solved by dividing it into two distinct phases. First, gravity is simulated in the original box by
    allowing each stone to move as far right as possible within its row until it encounters either an obstacle or another stone.
    This process is efficiently performed using a two-pointer approach, where an emptySlot pointer keeps track of the next available position for a stone while scanning the row from right to left.

    After all stones have settled, the entire box is rotated 90° clockwise. During this rotation, every cell in the original m×n
     grid is mapped to a new position in the rotated n×m grid according to the transformation:

    (row, col)→(col, m−1−row)

    By treating gravity simulation and rotation as separate operations, the solution becomes both conceptually simple and computationally efficient.

    Now, let’s look at the solution steps below:

    Read and store m (number of rows) and n (number of columns) from boxGrid.

    Apply gravity to each row using two pointers. For each row from
    0 to m−1
    , initialize emptySlot to n - 1 (the rightmost column, where a stone would land first).

    Traverse col from n - 1 down to 0:

    If the current cell is an obstacle '*', reset emptySlot to col - 1, as no stone can pass through an obstacle.

    If the current cell is a stone '#', move it to emptySlot by setting the current cell to '.'
    and boxGrid[row][emptySlot] to '#', then decrement emptySlot by 1 to mark the next available slot.

    If the current cell is empty '.', do nothing and continue scanning left.

    Rotate the box 90 degrees clockwise. Create a new rotated matrix of size n × m, initialized with '.'.

    For each cell (row, col) in the gravity-adjusted boxGrid, map it to rotated[col][m - 1 - row].

    Return the rotated matrix as the final result.

    Let’s look at the following illustration to get a better understanding of the solution:

    public char[][] rotateTheBox(char[][] boxGrid) {
        // Determine the number of rows (m) and columns (n) in the box.

        // Step 1: Apply gravity to each row of the boxGrid.
        // Since the box is rotated clockwise, gravity pulls stones toward the end of each row.
        // Iterate through each row of the grid:
            // Track the rightmost available cell (empty spot) using a pointer.
            // Start this pointer at the last column (index n - 1).

            // Traverse the current row's cells from right to left (starting from column n - 1):
                // If the current cell contains an obstacle ('*'):
                    // Any stones to the left of this obstacle cannot fall past it.
                    // Update the pointer to point to the cell immediately to the left of the obstacle.

                // Else if the current cell contains a stone ('#'):
                    // Move the stone to the column tracked by the pointer.
                    // If the stone was actually moved (pointer is not current column), mark original cell as empty ('.').
                    // Decrement the pointer to the next available position to the left.

                // Otherwise, the cell is empty ('.'):
                    // Do nothing; let the pointer stay at this empty position to be filled by a stone from the left.

        // Step 2: Rotate the grid 90 degrees clockwise.
        // Create a new character matrix 'rotatedGrid' with dimensions n rows and m columns.

        // Iterate through each cell at row 'r' and column 'c' in the processed boxGrid:
            // Map the element to its new coordinates in 'rotatedGrid'.
            // The new row index in the rotated grid corresponds to the original column index 'c'.
            // The new column index in the rotated grid is calculated as (original_total_rows - 1 - r).
            // Assign boxGrid[r][c] to rotatedGrid[new_row][new_col].

        // Return the final rotated matrix.
        return new char[][]{};
    }

     */

    private char[][] rotateTheBox(char[][] gridCopy) {
    }

    public static void main(String[] args) {

        P028_Medium_RotatingTheBox sol = new P028_Medium_RotatingTheBox();

        char[][] testCases[] = {
                {{'#'}, {'*'}, {'#'}, {'.'}}  ,

                {{'#', '.', '.', '#', '*'},
                        {'.', '#', '#', '.', '.'}},

                {{'#', '#', '#'},
                        {'#', '#', '#'},
                        {'#', '#', '#'}},

                {{'#', '*', '#', '.'},
                        {'.', '*', '.', '#'},
                        {'#', '.', '*', '#'}},

                {{'.', '#', '.'},
                        {'#', '.', '#'},
                        {'.', '.', '*'},
                        {'#', '#', '.'}},
        };

        for (int i = 0; i < testCases.length; i++) {
            char[][] boxGrid = testCases[i];
            char[][] gridCopy = new char[boxGrid.length][];
            for (int r = 0; r < boxGrid.length; r++) {
                gridCopy[r] = Arrays.copyOf(boxGrid[r], boxGrid[r].length);
            }
            char[][] result = sol.rotateTheBox(gridCopy);

            System.out.println((i + 1) + ".\tboxGrid:");
            for (char[] rowLine : boxGrid) {
                System.out.println("\t  " + Arrays.toString(rowLine));
            }
            System.out.println("\n\tResult (rotated):");
            for (char[] rowLine : result) {
                System.out.println("\t  " + Arrays.toString(rowLine));
            }
            System.out.println("-".repeat(100));
        }

    }



}
