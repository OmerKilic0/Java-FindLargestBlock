import java.util.Scanner;

public class Main {

    public static int[] findLargestBlock(int[][] m){
        int size;
        int maxSize = 0;
        int row;
        int finalRow = 0;
        int col;
        int finalCol = 0;
        boolean flag;

        for(int i=0; i<(m.length); i++){
            for(int j=0; j<(m.length); j++){
                if(m[i][j] == 1){
                    size = 1;
                    flag = true;
                    row = i;
                    col = j;

                    while(size+i < m.length && size+j < m.length && flag){
                        for(int k=i; k<size+i; k++){
                            if(m[k][size+j] == 0){
                                flag = false;
                                break;
                            }
                        }
                        for(int k=j; k<size+j; k++){
                            if(m[size+i][k] == 0){
                                flag = false;
                                break;
                            }
                        }
                        if(flag){
                            size++;
                        }
                    }
                    if(maxSize < size){
                        maxSize = size;
                        finalRow = row;
                        finalCol = col;
                    }
                }
            }
        }
        int[] result = {finalRow, finalCol, maxSize};
        return result;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of rows in matrix: ");
        int row = scan.nextInt();
        int[][] matrix = new int[row][row];
        System.out.println("Enter the matrix row by row:");

        for(int i=0; i<row; i++){
            for(int j=0; j<row; j++){
                matrix[i][j] = scan.nextInt();
            }
        }

        int[] result;
        result = findLargestBlock(matrix);

        System.out.println("The maximum square submatrix is at (" + result[0] + ", " + result[1] + ") with size " + result[2]);
    }
}