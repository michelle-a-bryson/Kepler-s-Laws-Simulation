
/**
 * Driver for Kepler simulation project
 *
 * @Michelle Bryson
 * @5/30/20
 */

import java.util.Scanner;
import java.lang.Math;

public class Driver
{
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        //read in majorAxis
        System.out.println("Enter the length of the major axis of the orbit (below 600)");
        double majorAxis = scan.nextInt();
        //make sure majorAxis is valid
        while(majorAxis <= 0 || majorAxis >= 600){
            if(majorAxis <= 0){
                System.out.println("Major axis must be postitive. Please enter a valid number");
                majorAxis = scan.nextDouble();
            }
            else{
                System.out.println("Major axis must be below 600. Please enter a valid number");
                majorAxis = scan.nextDouble();
            }
        }

        //read in posSun
        System.out.println("Enter the position of the sun (x-coordinate)");
        double posSun = scan.nextInt();
        //make sure posSun is valid
        while(Math.abs(posSun) > majorAxis/2){
            System.out.println("Sun is outside orbit. Please enter a valid position");
            posSun = scan.nextDouble();
        }

        //create simulation
        Board simulation = new Board(majorAxis, posSun);
        Calculations math = new Calculations(majorAxis, posSun);

        //initialize setup
        StdDraw.enableDoubleBuffering();

        double x = majorAxis/2;
        double y = math.getYPos(x);
        System.out.println(math.toString());
        StdDraw.setCanvasSize(600, 600);
        StdDraw.setXscale(-300,300);
        StdDraw.setYscale(-300,300);

        while(true){
            //planet travels through top half of ellipse
            while(x> -majorAxis/2){
                StdDraw.clear();

                simulation.drawAxes();
                simulation.drawSun();
                simulation.drawEllipse();

                //draw sweeping area made by line to sun
                for(int i = 0; i < 20; i++){
                    simulation.drawArea(x+i, math.getYPos(x+i));
                }
                simulation.drawPlanet(x, y);

                StdDraw.show();
                StdDraw.pause(20);

                x--;
                y = math.getYPos(x);
                System.out.println(x + ", " + y);
            }
            //planet travels through bottom half of ellipse
            while(x< majorAxis/2){
                StdDraw.clear();

                simulation.drawAxes();
                simulation.drawSun();
                simulation.drawEllipse();

                for(int i = 0; i < 20; i++){
                    simulation.drawArea(x-i, -math.getYPos(x-i));
                }
                simulation.drawPlanet(x, y);

                StdDraw.show();
                StdDraw.pause(20);

                x++;
                y = -math.getYPos(x);
                System.out.println(x + ", " + y);
            }
        }

    }
}
