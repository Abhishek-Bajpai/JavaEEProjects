import junit.framework.TestCase;
/**
    @Author Abhishek Bajpai
    @Version 1.0
 */
public class BoxProblemTest extends TestCase {

    public void testUno(){
        int x = 10;
        int y = 10;
        int z = 10;
        int[] availableCubesToFill = {2000};
        int expectedOutput = 1000;
        assertEquals(expectedOutput, BoxProblem.findCubes(x,y,z,availableCubesToFill));
    }

    public void testDos(){
        int x = 10;
        int y = 10;
        int z = 10;
        int[] availableCubesToFill = {900};
        int expectedOutput = -1;
        assertEquals(expectedOutput, BoxProblem.findCubes(x,y,z,availableCubesToFill));
    }

    public void testTres(){
        int x = 4;
        int y = 4;
        int z = 8;
        int[] availableCubesToFill = {10, 10, 1};
        int expectedOutput = 9;
        assertEquals(expectedOutput, BoxProblem.findCubes(x,y,z,availableCubesToFill));
    }

    public void testCuatro(){
        int x = 5;
        int y = 5;
        int z = 5;
        int[] availableCubesToFill = {67, 7, 1};
        int expectedOutput = 62;
        assertEquals(expectedOutput, BoxProblem.findCubes(x,y,z,availableCubesToFill));
    }

    public void testCinco(){
        int x = 5;
        int y = 5;
        int z = 6;
        int[] availableCubesToFill = {61, 4, 1};
        int expectedOutput = 59;
        assertEquals(expectedOutput, BoxProblem.findCubes(x,y,z,availableCubesToFill));
    }

    /**
     * This test (testSeis) will run into StackOverflowError because int is being used and algorithm calculations will exceed its bounds
     */
    public void testSeis(){ //1000 1000 1000 0 0 0 46501 0 2791 631 127 19 1
        int x = 1000;
        int y = 1000;
        int z = 1000;
        int[] availableCubesToFill = {0, 0, 0, 46501, 0, 2791, 631, 127, 19, 1};
        int expectedOutput = 50070;
        assertEquals(expectedOutput, BoxProblem.findCubes(x,y,z,availableCubesToFill));
    }

    public void testSiete(){
        int x = 1;
        int y = 1;
        int z = 9;
        int[] availableCubesToFill = {9, 1};
        int expectedOutput = 9;
        assertEquals(expectedOutput, BoxProblem.findCubes(x,y,z,availableCubesToFill));
    }


}