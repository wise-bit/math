package unit2_recursion.exercises;

// Fig. 15.24: FractalJPanelSierpinskeye.java
// FractalJPanelSierpinskeye demonstrates recursive drawing of a fractal.
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class FractalJPanelSierpinskeye extends JPanel
{
    private Color color; // stores color used to draw fractal
    private int level;   // stores current level of fractal

    private final int WIDTH = 400;
    private final int HEIGHT = 400;

    private Image backgroundImage;

    public FractalJPanelSierpinskeye(int currentLevel ) throws IOException{
        color = Color.BLUE;  // initialize drawing color to blue
        level = currentLevel; // set initial fractal level
        setBackground( Color.WHITE );
        setPreferredSize( new Dimension( WIDTH, HEIGHT ) );
        backgroundImage = ImageIO.read(new File("C:\\Users\\satra\\IdeaProjects\\ISCU41\\src\\unit2_recursion\\exercises\\occult-icons_eye-512.png"));
    } // end constructor FractalJPanelSierpinskeye

    // draw fractal recursively
    public void drawFractal( int level, int xA, int yA, int xB, int yB, int xC, int yC, Graphics g ) {
        // base case: draw a line connecting two given points
        if (level == 0) {
            g.drawLine(xA, yA, xB, yB);
            g.drawLine(xB, yB, xC, yC);
            g.drawLine(xC, yC, xA, yA);
        } else {
            drawFractal(level - 1, (xA + xB) / 2, (yA + yB) / 2, (xB + xC) / 2, (yB + yC) / 2, xB, yB, g);
            drawFractal(level - 1, (xA + xC) / 2, (yA + yC) / 2, (xB + xC) / 2, (yB + yC) / 2, xC, yC, g);
            drawFractal(level - 1, (xA + xC) / 2, (yA + yC) / 2, (xA + xB) / 2, (yA + yB) / 2, xA, yA, g);
        }
    }

    // start the drawing of fractal
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );

        // draw fractal pattern
        g.setColor( color );
        drawFractal(level, 100, 300, 300, 300, 200, 300 - (int) Math.sqrt(30000), g);

        // background
        g.drawImage(backgroundImage, 175, 215, 50, 50, this);
    }

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