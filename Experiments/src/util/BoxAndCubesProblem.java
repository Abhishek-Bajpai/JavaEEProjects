package util;
import java.util.Arrays;
import java.util.Scanner;

public class BoxAndCubesProblem {

    public static void main(String[] args)
    {
        Scanner scanner =new Scanner(System.in);
        System.out.println("Enter your input value : ");

        String[] inputString = scanner.nextLine().split(" ");
        scanner.close();

        int[] boxDimensions = new int[3];
        int[] availableCubesToFill = new int[inputString.length-3];


        for(int i = 0; i < 3 ; i++){
            boxDimensions[i]= Integer.parseInt(inputString[i]);
        }


        for(int i=3, x=0; x<availableCubesToFill.length; i++, x++) {
            //System.out.println("Cubes are - " + inputString[i]);
            availableCubesToFill[x] = Integer.parseInt(inputString[i]);
        }

        System.out.println("Box x y z .. " + Arrays.toString(boxDimensions));
        System.out.println("Box volume is .. " + boxVolume(boxDimensions));
        System.out.println("Cube available are - "  +  Arrays.toString(availableCubesToFill));

        System.out.println("--------------------------------------------------------------------------");
        System.out.println(getMinimumCubes(boxDimensions[0],boxDimensions[1],boxDimensions[2],availableCubesToFill));
        System.out.println("--------------------------------------------------------------------------");
    }

    private static int boxVolume(int[] boxDimensions) {
        return boxDimensions[0]*boxDimensions[1]*boxDimensions[2];
    }

    public static int getMinimumCubes(int x, int y,int z,int[] availableCubesToFill) {
        boolean[][][] grid = new boolean[x][y][z];
        return put(grid, 0, x*y*z, availableCubesToFill);
    }

    public static int put(boolean[][][] grid, int count, int cur_min, int[] availableCubesToFill) {
        int i = 0, j = 0, k=0;
        if(count >= cur_min)
            return cur_min;
        //find input position
        for(i = 0; i < grid.length; i++){
            for(j = 0; j < grid[0].length; j++){
                for(k =0;k < grid[0][0].length;k++) {
                    if (!grid[i][j][k]) {
                        int ret = -1;
                        for(int z=availableCubesToFill.length-1;z>=0;z--) {
                            int s = (int)Math.pow(2,z);
                            for (int a = availableCubesToFill[z]; a >= 1; a--) {
                                if (filled(grid, s, i, j, k, true)) {
                                    availableCubesToFill[z]--;
                                    ret = Math.max(ret, put(grid, count + 1, Math.max(ret, cur_min), availableCubesToFill));
                                    //backtrack
                                    filled(grid, s, i, j, k, false);
                                }

                            }

                        }

                        return ret;
                    }
                }
            }
        }
        //all filled
        return count;
    }

    public static boolean filled(boolean[][][] grid, int s, int i, int j, int k, boolean f){
        if((s+i)>=grid.length||(s+j)>=grid[0].length||(s+k)>=grid[0][0].length)
            return true;
        for(int a = 0; a < s; a++){
            for(int b = 0; b < s; b++){
                for(int c = 0; c < s; c++) {
                    if (grid[i + a][j + b][k + c] == f)
                        return false;
                }
            }
        }
        for(int a = 0; a < s; a++)
            for(int b = 0; b < s; b++)
                for(int c = 0; c < s; c++)
                    grid[i+a][j+b][k+c] = f;


        return true;
    }
}
