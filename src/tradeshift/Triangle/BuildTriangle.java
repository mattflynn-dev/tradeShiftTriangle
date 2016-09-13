package tradeshift.Triangle;

import tradeshift.Triangle.Triangle;

/**
 * Created by Matt Flynn on 13/09/2016.
 */
public class BuildTriangle
{
    /**
     * The main method here request the user for 3 integer values
     * Creates a triangle using the user supplied values
     * And assesses the triangle type by calling assessTriangleType method
     *
     * @param args
     */
    public static void main(String[] args)
    {
        System.out.println("Please input 3 separate ints");

        Triangle testTriangle = new Triangle();

        testTriangle = testTriangle.getTriangleInput();

        System.out.println("Your Triangle is: " + Triangle.assessTrianlgeType(testTriangle) + "!");
    }
}
