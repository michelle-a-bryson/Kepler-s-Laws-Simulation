
/**
 * Performs all calculations needed for the simulation
 *
 * @Michelle Bryson
 * @6/2/20
 */

import java.lang.Math;

public class Calculations
{
    // instance variables - replace the example below with your own
    private double majorAxis;
    private double posSun;

    /**
     * Constructor for objects of class Calculations
     */
    public Calculations(double majorAxis, double posSun)
    {
        // initialise instance variables
        this.majorAxis = majorAxis;
        this.posSun = posSun;
    }

    /**
     * Get the minor axis length based on major axis and foci
     * Used equation: c^2 = a^2 - b^2
     * 
     */
    public double getMinorAxis()
    {
        double a = majorAxis/2;
        double c = Math.abs(posSun);
        double b = Math.sqrt(a*a - c*c);
        double minorAxis = 2*b;
        return minorAxis;
    }
    
    /**
     * Get the y position based on semi-major axis, semi-minor axis, and x
     * Used equation: x^2/a^2 + y^2/b^2 = 1
     * 
     */
    public double getYPos(double x){
        double a = majorAxis/2;
        double c = Math.abs(posSun);
        double b = Math.sqrt(a*a - c*c);
        double y = b * Math.sqrt(1 - ((x*x)/(a*a)));
        return y;
    }
    
    public String toString(){
        String output = "";
        output += "major axis: " + majorAxis + "\n";
        output += "position of sun: " + posSun + "\n";
        output += "minor axis: " + getMinorAxis() + "\n";
        return output;
    }
}
