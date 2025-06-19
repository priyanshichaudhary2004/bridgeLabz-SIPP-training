import java.util.Random;

public class MatrixMultipleOperations {

    public static int[][] generateMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        Random rand = new Random();
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = rand.nextInt(10);
        return matrix;
    }

    public static int[][] transpose(int[][] matrix) {
        int[][] transposed = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                transposed[j][i] = matrix[i][j];
        return transposed;
    }

    public static int determinant2x2(int[][] matrix) {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    public static int determinant3x3(int[][] m) {
        return m[0][0]*(m[1][1]*m[2][2] - m[1][2]*m[2][1]) 
             - m[0][1]*(m[1][0]*m[2][2] - m[1][2]*m[2][0]) 
             + m[0][2]*(m[1][0]*m[2][1] - m[1][1]*m[2][0]);
    }

    public static double[][] inverse2x2(int[][] matrix) {
        int det = determinant2x2(matrix);
        if (det == 0) return null;
        double[][] inverse = new double[2][2];
        inverse[0][0] = matrix[1][1] / (double) det;
        inverse[0][1] = -matrix[0][1] / (double) det;
        inverse[1][0] = -matrix[1][0] / (double) det;
        inverse[1][1] = matrix[0][0] / (double) det;
        return inverse;
    }

    public static double[][] inverse3x3(int[][] m) {
        int det = determinant3x3(m);
        if (det == 0) return null;
        double[][] inv = new double[3][3];
        inv[0][0] = (m[1][1]*m[2][2] - m[1][2]*m[2][1]) / (double)det;
        inv[0][1] = -(m[0][1]*m[2][2] - m[0][2]*m[2][1]) / (double)det;
        inv[0][2] = (m[0][1]*m[1][2] - m[0][2]*m[1][1]) / (double)det;
        inv[1][0] = -(m[1][0]*m[2][2] - m[1][2]*m[2][0]) / (double)det;
        inv[1][1] = (m[0][0]*m[2][2] - m[0][2]*m[2][0]) / (double)det;
        inv[1][2] = -(m[0][0]*m[1][2] - m[0][2]*m[1][0]) / (double)det;
        inv[2][0] = (m[1][0]*m[2][1] - m[1][1]*m[2][0]) / (double)det;
        inv[2][1] = -(m[0][0]*m[2][1] - m[0][1]*m[2][0]) / (double)det;
        inv[2][2] = (m[0][0]*m[1][1] - m[0][1]*m[1][0]) / (double)det;
        return inv;
    }

    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row)
                System.out.print(val + "\t");
            System.out.println();
        }
    }

    public static void displayMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double val : row)
                System.out.printf("%.2f\t", val);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix2x2 = generateMatrix(2, 2);
        int[][] matrix3x3 = generateMatrix(3, 3);
        int[][] transposed = transpose(matrix3x3);
        int det2x2 = determinant2x2(matrix2x2);
        int det3x3 = determinant3x3(matrix3x3);
        double[][] inv2x2 = inverse2x2(matrix2x2);
        double[][] inv3x3 = inverse3x3(matrix3x3);

        System.out.println("2x2 Matrix:");
        displayMatrix(matrix2x2);
        System.out.println("Determinant: " + det2x2);
        System.out.println("Inverse:");
        if (inv2x2 != null) displayMatrix(inv2x2); else System.out.println("Not Invertible");

        System.out.println("\n3x3 Matrix:");
        displayMatrix(matrix3x3);
        System.out.println("Transpose:");
        displayMatrix(transposed);
        System.out.println("Determinant: " + det3x3);
        System.out.println("Inverse:");
        if (inv3x3 != null) displayMatrix(inv3x3); else System.out.println("Not Invertible");
    }
}
