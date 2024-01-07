// Given a row and colum wise (nxn) sorted matrix, write a program to search for a key in the
// given matrix.
// If the matrix isn't already sorted, it would be efficient to sort it first, and then search for the key.
public class SearchSortedMatrix {
    public static void search(int[][] matrix, int n, int x) {
        // Search for key 'x' in 'matrix' of size 'n' by 'n'
        int i = 0;
        int j = n - 1;   // int j = matrix[0].length - 1 if not nxn matrix
        while (i < n && j >= 0) {
            if (matrix[i][j] == x) {
                System.out.println(x + " found at (" + i + "," + j + ")");
                return;
            }
            if (matrix[i][j] > x) {
                j--;
            } else {
                i++;
            }
        }
        System.out.println(x + " not found.");
    }

    public static void sort(int[][] matrix, int n) {
        // Sort a given matrix using insertion sort algorithm, row and column wise
        insertionSort(matrix, n);   // sort row-wise
        transpose(matrix, n);       // transpose for column-wise
        insertionSort(matrix, n);   // sort-column wise
        transpose(matrix, n);       // transpose to original form
    }

    public static void insertionSort(int [][] matrix, int n) {
        int rows = n;   // int rows = matrix.length
        for (int i = 0; i < rows; i++) {
            int cols = matrix[i].length;
            for (int j = 1; j < cols; j++) {
                int key = matrix[i][j];
                int k = j - 1;
                while (k >= 0 && matrix[i][k] > key) {
                    matrix[i][k + 1] = matrix[i][k];
                    k--;
                }
                matrix[i][k + 1] = key;
            }
        }
    }

    public static void transpose(int[][] matrix, int n) {
        // Transpose a given matrix; useful for sorting column wise
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static boolean isSorted(int[][] matrix) {
        // Determine if a given matrix is sorted

        for (int[] row : matrix) if (!isSortedHelper(row)) return false;    // Check rows

        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int j = 0; j < cols; j++) {    // Check columns
            int[] column = new int[rows];
            for (int i = 0; i < rows; i++) column[i] = matrix[i][j];
            if (!isSortedHelper(column)) return false;
        }
        return true;
    }

    private static boolean isSortedHelper(int[] arr) {
        // Helper method to check if a given array is sorted
        int n = arr.length;
        for (int i = 1; i < n; i++) if (arr[i] < arr[i - 1]) return false;
        return true;
    }

    public static void display(int[][] matrix) {
        // Print a given matrix on the screen
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            System.out.print("|");
            for (int j = 0; j < cols; j++) System.out.print(matrix[i][j] + " ");
            System.out.println("|");
        }
    }

    public static void spiralPrint(int[][] matrix, int rows, int cols) {
        // Print a given matrix in Spiral form
        int i, k = 0, l = 0, r = rows, c = cols;
        while(k < r && l < c) {
            for (i = l; i < c; i++)     // left to right
                System.out.print(matrix[k][i] + " ");
            k++;
            for (i = k; i < r; i++)     // top to bottom
                System.out.print(matrix[i][c-1] + " ");
            c--;
            if (k < r) {
                for (i = c-1; i >= l; i--)  // right to left
                    System.out.print(matrix[r-1][i] + " ");
                r--;
            }
            if (l < c) {
                for (i = r-1; i >= k; i--)  // bottom to top
                    System.out.print(matrix[i][l] + " ");
                l++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] sortedMatrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 51}};
        int n1 = sortedMatrix.length;

        System.out.println("sortedMatrix: "); display(sortedMatrix);
        System.out.println("Is sortedMatrix sorted: " + isSorted(sortedMatrix));
        int x = 32;
        search(sortedMatrix, n1, x);
        x = 40;
        search(sortedMatrix, n1, x);
        x = 100;
        search(sortedMatrix, n1, x);
        System.out.println();

        int[][] unsortedMatrix = {
                {90, 70, 35, 97},
                {15, 30, 10, 18},
                {20, 14, 16, 80},
                {11, 33, 39, 50}};
        int n2 = unsortedMatrix.length;
        System.out.println("unsortedMatrix before: "); display(unsortedMatrix);
        System.out.println("Is unsortedMatrix sorted: " + isSorted(unsortedMatrix));

        sort(unsortedMatrix, n2);
        System.out.println("unsortedMatrix after: "); display(unsortedMatrix);
        System.out.println("Is unsortedMatrix sorted: " + isSorted(unsortedMatrix));
        x = 40;
        search(unsortedMatrix, n2, x);
        x = 100;
        search(unsortedMatrix, n2, x);
        x = 90;
        search(unsortedMatrix, n2, x);

        System.out.print("sortedMatrix in Spiral form: ");
        spiralPrint(sortedMatrix, sortedMatrix.length, sortedMatrix[0].length);
        System.out.println();
        System.out.print("unsortedMatrix in Spiral form: ");
        spiralPrint(unsortedMatrix, unsortedMatrix.length, unsortedMatrix[0].length);
    }
}
