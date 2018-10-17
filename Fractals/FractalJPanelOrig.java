package unit2_recursion.exercises;

// Fig. 15.24: FractalJPanelSierpinskeye.java
// FractalJPanelSierpinskeye demonstrates recursive drawing of a fractal.
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class FractalJPanelOrig extends JPanel
{
    private Color color; // stores color used to draw fractal
    private int level;   // stores current level of fractal

    private final int WIDTH = 400;  // defines width of JPanel
    private final int HEIGHT = 400; // defines height of JPanel

    // set the initial fractal level to the value specified
    // and set up JPanel specifications
    public FractalJPanelOrig ( int currentLevel )
    {
        color = Color.BLUE;  // initialize drawing color to blue
        level = currentLevel; // set initial fractal level
        setBackground( Color.WHITE );
        setPreferredSize( new Dimension( WIDTH, HEIGHT ) );
    } // end constructor FractalJPanelSierpinskeye

    // draw fractal recursively
    public void drawFractal( int level, int xA, int yA, int xB, int yB, int xC, int yC, Graphics g ) {
        // base case: draw a line connecting two given points
        if ( level == 0 ) {
            g.drawLine(xA, yA, xB, yB);
            g.drawLine(xB, yB, xC, yC);
            g.drawLine(xC, yC, xA, yA);
        }
        else {
//            // calculate midpoint between (xA, yA) and (xB, yB)
//            int xC = ( xA + xB ) / 2;
//            int yC = ( yA + yB ) / 2;
//
//            // calculate the fourth point (xD, yD) which forms an
//            // isosceles right triangle between (xA, yA) and (xC, yC)
//            // where the right angle is at (xD, yD)
//            int xD = xA + ( xC - xA ) / 2 - ( yC - yA ) / 2;
//            int yD = yA + ( yC - yA ) / 2 + ( xC - xA ) / 2;
//
//            // recursively draw the Fractal
//            drawFractal( level - 1, xD, yD, xA, yA, g );
//            drawFractal( level - 1, xD, yD, xC, yC, g );
//            drawFractal( level - 1, xD, yD, xB, yB, g );

        } // end else
    } // end method drawFractal

    // start the drawing of fractal
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );

        // draw fractal pattern
        g.setColor( color );
        // drawFractal( level, 100, 90, 290, 200, g );
        drawFractal(level, 100, 100, 300, 100, 200, (int) Math.sqrt(30000) + 100, g);
    } // end method paintComponent

    // set the drawing color to c
    public void setColor( Color c )
    {
        color = c;
    }

    // set the new level of recursion
    public void setLevel( int currentLevel )
    {
        level = currentLevel;
    }

    // returns level of recursion
    public int getLevel()
    {
        return level;
    }
};