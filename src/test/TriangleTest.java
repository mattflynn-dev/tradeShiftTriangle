package test;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;
import java.util.Scanner;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import static org.mockito.Mockito.doReturn;


import tradeshift.Triangle.Triangle;

/**
 *
 * Created by Matt Flynn on 13/09/2016.
 *
 */
public class TriangleTest
{

    @InjectMocks
    public Triangle triangleClass;

    @Spy
    public Triangle triangleSpy;

    static Triangle triangle = new Triangle();

    /**
     * TODO Auto-generated JavaDoc
     *
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * TODO Auto-generated JavaDoc
     *
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception
    {
    }

    /**
     * Test method for {@link tradeshift.Triangle.Triangle#Triangle(int, int, int)}.
     */
    @Test
    public void testTriangleIntIntInt()
    {
        Triangle testTriangle = new Triangle(4,5,6);
        assertNotNull(testTriangle);
    }

    /**
     * Test method for {@link tradeshift.Triangle.Triangle#Triangle()}.
     */
    @Test
    public void testTriangle()
    {
        Assert.assertTrue(true);
    }

    /**
     * Test method for {@link tradeshift.Triangle.Triangle#assessTrianlgeType(tradeshift.Triangle.Triangle)}.
     */
    @Test
    public void testAssessEquilateralTrianlgeType()
    {
        Triangle testTriangle = new Triangle(5,5,5);
        assertNotNull(testTriangle);
        assertEquals("Equilateral", Triangle.assessTrianlgeType(testTriangle));
    }

    /**
     * Test method for {@link tradeshift.Triangle.Triangle#assessTrianlgeType(tradeshift.Triangle.Triangle)}.
     */
    @Test
    public void testAssessIsoscelesTrianlgeType()
    {
        Triangle testTriangle = new Triangle(7,4,7);
        assertNotNull(testTriangle);
        assertEquals("Isosceles", Triangle.assessTrianlgeType(testTriangle));
    }
    /**
     * Test method for {@link tradeshift.Triangle.Triangle#assessTrianlgeType(tradeshift.Triangle.Triangle)}.
     */
    @Test
    public void testAssessScaleneTrianlgeType()
    {
        Triangle testTriangle = new Triangle(4,5,6);
        assertNotNull(testTriangle);
        assertEquals("Scalene", Triangle.assessTrianlgeType(testTriangle));
    }

    /**
     * Test method for {@link tradeshift.Triangle.Triangle#assessTrianlgeType(tradeshift.Triangle.Triangle)}.
     */
    @Test
    public void testAssessNotValidTrianlgeType()
    {
        Triangle testTriangle = new Triangle(0,0,0);
        assertNotNull(testTriangle);
        assertEquals("Not a valid triangle", Triangle.assessTrianlgeType(testTriangle));
    }

    /**
     * Test method for {@link tradeshift.Triangle.Triangle#isEquilateral(tradeshift.Triangle.Triangle)}.
     */
    @Test
    public void testIsEquilateralSuccess()
    {
        Triangle testTriangleSuccess = new Triangle(5,5,5);
        Triangle testTriangleFailA = new Triangle(3,5,5);
        Triangle testTriangleFailB = new Triangle(3,3,5);

        assertTrue(triangle.isEquilateral(testTriangleSuccess));
        assertFalse(triangle.isEquilateral(testTriangleFailA));
        assertFalse(triangle.isEquilateral(testTriangleFailB));
    }

    /**
     * Test method for {@link tradeshift.Triangle.Triangle#isIsosceles(tradeshift.Triangle.Triangle)}.
     */
    @Test
    public void testIsIsoscelesSuccess()
    {
        Triangle testTriangleSuccessA = new Triangle(7,4,7);
        assertTrue(triangle.isIsosceles(testTriangleSuccessA));

        Triangle testTriangleSuccessB = new Triangle(4,4,7);
        assertTrue(triangle.isIsosceles(testTriangleSuccessB));

        Triangle testTriangleSuccessC = new Triangle(4,7,7);
        assertTrue(triangle.isIsosceles(testTriangleSuccessC));

        Triangle testTriangleFail = new Triangle(7,7,7);
        assertFalse(triangle.isIsosceles(testTriangleFail));
    }


    /**
     * Test method for {@link tradeshift.Triangle.Triangle#isScalene(tradeshift.Triangle.Triangle)}.
     */
    @Test
    public void testIsScaleneSuccess()
    {
        Triangle testTriangle = new Triangle(2,3,7);
        assertTrue(triangle.isScalene(testTriangle));
    }

    /**
     * Test method for {@link tradeshift.Triangle.Triangle#isScalene(tradeshift.Triangle.Triangle)}.
     */
    @Test
    public void testIsScaleneFailIsosceles()
    {
        Triangle testTriangle = new Triangle(7,3,7);
        assertFalse(triangle.isScalene(testTriangle));
    }

    /**
     * Test method for {@link tradeshift.Triangle.Triangle#isScalene(tradeshift.Triangle.Triangle)}.
     */
    @Test
    public void testIsScaleneFailEquilateral()
    {
        Triangle testTriangle = new Triangle(5,5,5);
        assertFalse(triangle.isScalene(testTriangle));
    }

    /**
     * Test method for {@link tradeshift.Triangle.Triangle#isTriangleValid(tradeshift.Triangle.Triangle)}.
     */
    @Test
    public void testIsTriangleValidSuccess()
    {
        Triangle testTriangleSuccess = new Triangle(1,2,3);
        assertTrue(testTriangleSuccess.isTriangleValid(testTriangleSuccess));

        Triangle testTriangleFailA = new Triangle(0,0,0);
        assertFalse(testTriangleFailA.isTriangleValid(testTriangleFailA));

        Triangle testTriangleFailB = new Triangle(1,0,3);
        assertFalse(testTriangleFailB.isTriangleValid(testTriangleFailB));

        Triangle testTriangleFailC = new Triangle(1,1,0);
        assertFalse(testTriangleFailC.isTriangleValid(testTriangleFailC));
    }

    /**
     * The below tests uses a spy to avoid requiring user input
     * Test method for {@link tradeshift.Triangle.Triangle#getTriangleInput(tradeshift.Triangle.Triangle)}.
     */
    @Test
    public void testGetTriangleInputSuccess()
    {
        Triangle testTriangle = new Triangle();

        Scanner testInput = new Scanner(System.in);
        doReturn(5).when(triangleSpy).fetchIntFromUser(Matchers.any(Scanner.class));
        testTriangle = triangleSpy.getTriangleInput();
        testInput.close();
    }

    /**
     * The below tests uses a spy to avoid requiring user input
     * Test method for {@link tradeshift.Triangle.Triangle#getTriangleInput(tradeshift.Triangle.Triangle)}.
     */
    @Test
    public void testGetTriangleInputError()
    {

        Scanner testInput = new Scanner(System.in);
        try
        {
            doReturn(0).when(triangleSpy).fetchIntFromUser(Matchers.any(Scanner.class));
            Mockito.when(triangleSpy.isTriangleValid(Matchers.any(Triangle.class))).thenThrow(new NoSuchElementException("Exception")
            {
                private static final long serialVersionUID = -6307750949241697025L;
            });
            Triangle testTriangle = triangleSpy.getTriangleInput();
        }
        catch(NoSuchElementException ex)
        {
            Assert.assertTrue(ex instanceof NoSuchElementException);
            testInput.close();
        }
    }
}

