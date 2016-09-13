package tradeshift.Triangle;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * Created by Matt Flynn on 13/09/2016.
 *
 */
public class Triangle
{
    int sideA;
    int sideB;
    int sideC;
    static boolean validTriangle = false;


    public Triangle(int a, int b, int c)
    {
        this.sideA = a;
        this.sideB = b;
        this.sideC = c;
    }

    public Triangle()
    {
        //	this.triangle = null;
    }

    /**
     *
     * The below method takes in a triangle and returns a string defining the triangle type
     * A triangle can be either Equilateral, Isosceles or Scalene
     * A check to see if the triangle is valid is also performed.
     *
     * @param triangle
     * @return String TriangleType
     */
    public static String assessTrianlgeType(Triangle triangle)
    {
        String triangleType;
        if(triangle.isTriangleValid(triangle)){
            if(triangle.isEquilateral(triangle)){
                triangleType = "Equilateral";
            }
            else if(triangle.isIsosceles(triangle)){
                triangleType = "Isosceles";
            }
            else {
                triangleType = "Scalene";
            }
        }
        else {
            triangleType = "Not a valid triangle";
        }
        return triangleType;

    }

    /**
     *
     * An equilateral triangle is a triangle where all 3 sides have the same value.
     * The below method checks this.
     *
     * @param triangle
     * @return boolean
     */
    public boolean isEquilateral(Triangle triangle)
    {
        if (triangle.sideA == triangle.sideB && triangle.sideA == triangle.sideC)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     *
     * To determine whether an triangle is isosceles, we first rule out it being equilateral
     * Then two of the three values are equivalent, the triangle is isosceles
     *
     * @param triangle
     * @return boolean
     */
    public boolean isIsosceles(Triangle triangle)
    {
        if (isEquilateral(triangle))
        {
            return false;
        }
        else if (triangle.sideA == triangle.sideB || triangle.sideA == triangle.sideC || triangle.sideB == triangle.sideC)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     *
     * In this method we determine whether a triangle is Scalene by utilising
     * the other methods in our class.
     * If a triangle is neither equilateral or isosceles, it is therefore Scalene
     *
     * @param triangle
     * @return boolean
     */
    public boolean isScalene(Triangle triangle)
    {
        if(isIsosceles(triangle) || isEquilateral(triangle))
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    /**
     *
     *This simple method performs a check to make sure every side of the triangle is
     *greater than zero.
     *
     * @param triangle
     * @return boolean
     */
    public boolean isTriangleValid (Triangle triangle)
    {
        if (sideA > 0 && sideB > 0 && sideC > 0)
        {
            return true;
        }
        else{
            return false;
        }
    }

    /**
     *
     * The below method initiates the user input for the triangle dimensions,
     * calls for validation of those inputs and also performs some exception handling.
     *
     * @return Triangle
     */
    public Triangle getTriangleInput()
    {
        Triangle triangle = new Triangle();
        do {
            Scanner input = new Scanner(System.in);
            try {
                //Make three calls to fetchIntFromUser method to acquire our side values
                int sideA = fetchIntFromUser(input);
                int sideB = fetchIntFromUser(input);
                int sideC = fetchIntFromUser(input);
                triangle = new Triangle(sideA, sideB, sideC);

                if (triangle.isTriangleValid(triangle))
                {
                    //we modify the boolean we're using to check if the triangle is valid
                    validTriangle = true;
                    input.close();
                }
                else{
                    //if the triangle is not valid, through an exception
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException | NoSuchElementException ex)
            {
                //exception prints error message and requests valid inputs
                System.out.println("Please input valid ints - value must be great than zero");
                input.next();
            }
        }
        //if the triangle is valid we can return it and exit this method
        while(validTriangle == false);
        return triangle;
    }

    /**
     *
     * This s method fetches the nextInt from the user
     *
     * @param input
     * @return userValue
     */
    public int fetchIntFromUser(Scanner input)
    {
        int userValue = input.nextInt();
        return userValue;
    }
}
