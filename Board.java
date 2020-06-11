
/**
 * Draws the simulation
 *
 * @Michelle Bryson
 * @5/30/20
 */
public class Board
{
    // instance variables - replace the example below with your own
    private double majorAxis;
    private double posSun;
    private double minorAxis;
    private Calculations calc;
    private double yPos;

    /**
     * Constructor for objects of class Board
     */
    public Board(double majorAxis, double posSun)
    {
        // initialise instance variables
        this.majorAxis = majorAxis;
        this.posSun = posSun;
        Calculations calc = new Calculations(majorAxis, posSun);
        this.minorAxis = calc.getMinorAxis();
        this.yPos = calc.getYPos(200);
    }

    /**
     * Draws major and minor axes
     */
    public void drawAxes()
    {
        //draw major axis
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.line(-majorAxis/2, 0, majorAxis/2, 0);

        //draw minor axis
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.line(0, -minorAxis/2, 0, minorAxis/2);
    }
    
    /**
     * Draws sun and the other foci
     */
    public void drawSun(){
        //draw sun
        StdDraw.setPenRadius(0.1);
        StdDraw.setPenColor(StdDraw.YELLOW);
        StdDraw.point(posSun, 0);

        //draw other foci for reference
        StdDraw.setPenRadius(0.02);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.point(-posSun, 0);
    }
    
    /**
     * Draws the ellipse associated with the give foci and major axis
     */
    public void drawEllipse(){
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.ellipse(0, 0, majorAxis/2, minorAxis/2);
    }
    
    /**
     * Draws the planet given x and y coordinates
     */
    public void drawPlanet(double x, double y){
        StdDraw.setPenRadius(0.05);
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.point(x, y);;
    }
    
    /**
     * Draws a line from the planet to the sun
     */
    public void drawArea(double x, double y){
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.MAGENTA);
        StdDraw.line(x,y, posSun, 0);
    }

    
}
