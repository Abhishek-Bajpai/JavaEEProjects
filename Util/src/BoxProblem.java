/**
    @Author Abhishek Bajpai
    @Version 1.0
 */
public class BoxProblem {

    public BoxProblem()
    {
    }

    public static int findCubes(int x, int y, int z,int[] availableCubestoFill)
    {
        boolean[][][] grid = new boolean[x][y][z];
        int remainingVolume = x*y*z;
        int remainingDimension =  Math.min(Math.min(x,y),z);
        int currentIdx = availableCubestoFill.length-1;
        return getMinimumCubes(grid,0, remainingVolume,remainingDimension, availableCubestoFill, currentIdx);
    }

    public static int getMinimumCubes(boolean[][][] grid, int count, int remainingVolume,int remainingDimension, int[] availableCubestoFill, int currentIdx)
    {
        if(remainingVolume==0)
            return count;

        int nextCubeDimension = (int)Math.pow(2,currentIdx);
        int nextCubeVolume = nextCubeDimension*nextCubeDimension*nextCubeDimension;
        while(nextCubeDimension>remainingDimension)
        {
            currentIdx--;
            nextCubeDimension = (int)Math.pow(2,currentIdx);
            nextCubeVolume = nextCubeDimension*nextCubeDimension*nextCubeDimension;
        }


        if(currentIdx<0||(availableCubestoFill[currentIdx]<=0&&currentIdx==0))
            return -1;

        if(availableCubestoFill[currentIdx]<0)
            return -1;

        int count_up = count;
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++)
                for(int k=0;k<grid[0][0].length;k++)
                    if(fillable(grid,nextCubeDimension,i,j,k))
                    {
                        remainingDimension = fill(grid,nextCubeDimension,i,j,k);
                        availableCubestoFill[currentIdx]--;
                        count_up = getMinimumCubes(grid, count+1,remainingVolume-nextCubeVolume,remainingDimension,availableCubestoFill,availableCubestoFill[currentIdx]==0?currentIdx-1:currentIdx);
                        if(count_up==-1)
                        {
                            unfill(grid,nextCubeDimension,i,j,k);
                            count_up = getMinimumCubes(grid, count,remainingVolume,Math.max(Math.max(i,j),k),availableCubestoFill,currentIdx-1);
                        }

                    }


        return count_up;
    }

    public static int fill(boolean[][][] grid, int s, int i, int j, int k){
        for(int a = i; a < s+i; a++)
            for(int b = j; b < s+j; b++)
                for(int c = k; c < s+k; c++)
                    grid[i][j][k] = true;
        return Math.max(Math.max(grid.length-s+i,grid[0].length-s+j),grid[0][0].length-s+k);
    }

    public static void unfill(boolean[][][] grid, int s, int i, int j, int k){
        for(int a = i; a < s+i; a++)
            for(int b = j; b < s+j; b++)
                for(int c = k; c < s+k; c++)
                    grid[i][j][k] = false;
    }

    public static boolean fillable(boolean[][][] grid, int s, int i, int j, int k){
        if((s+i)>grid.length
                ||(s+j)>grid[0].length
                ||(s+k)>grid[0][0].length)
            return false;
        for(int a = i; a < s+i; a++)
            for(int b = j; b < s+j; b++)
                for(int c = k; c < s+k; c++)
                    if(grid[a][b][c]==true)
                        return false;

        return true;
    }
}
