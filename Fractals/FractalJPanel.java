package unit2_recursion.exercises;

// Fig. 15.24: FractalJPanel.java
// FractalJPanel demonstrates recursive drawing of a fractal.
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class FractalJPanel extends JPanel
{
    private Color color; // stores color used to draw fractal
    private int level;   // stores current level of fractal

    private final int WIDTH = 400;  // defines width of JPanel
    private final int HEIGHT = 400; // defines height of JPanel

    private final double angle = (45 * Math.PI) / 180;
    private final int length = 50;
    private static int n = 1;
    private static int m = 1;

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public FractalJPanel( int currentLevel )
    {
        color = Color.BLUE;
        level = currentLevel;
        setBackground( Color.WHITE );
        setPreferredSize( new Dimension( WIDTH, HEIGHT ) );
    }

    public void drawFractal( int level, int n, int m, int xB, int yB, Graphics g ) {

        clearScreen();
        // System.out.println(n + " " + level);

        if (level > 0) {

            int xC = (int) (xB + length * Math.cos(angle * n));
            int yC = (int) (yB - length * Math.sin(angle * n));

            int xD = (int) (xB - length * Math.cos(angle * n));
            int yD = (int) (yB - length * Math.sin(angle * n));

            // System.out.printf("%d %d %d %d %d %.00f\n", level, xC, yC, xD, yD, angle*n*180/Math.PI);

            g.drawLine(200+xB, 250 + yB, 200 + xC, 250 + yC);
            g.drawLine(200+xB, 250 + yB, 200 + xD, 250 + yD);

//            drawFractal( level-1, n+1, m, xC, yC, g );
//            drawFractal( level-1, n, m+1, xD, yD, g );
            drawFractal( level-1, n, m+1, xD, yD, g );
        } else if (m <= level) {
            int xC = (int) (xB + length * Math.cos(angle * m));
            int yC = (int) (yB - length * Math.sin(angle * m));
            int xD = (int) (xB - length * Math.cos(angle * m));
            int yD = (int) (yB - length * Math.sin(angle * m));
            g.drawLine(200+xB, 250 + yB, 200 + xC, 250 + yC);
            g.drawLine(200+xB, 250 + yB, 200 + xD, 250 + yD);

        }
    }

    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );

        g.setColor( color );
        g.drawLine( 200, 300, 200, 250);
        drawFractal( level, n, m, 0, 0, g );
    }

    public void setColor( Color c )
    {
        color = c;
    }

    public void setLevel( int currentLevel )
    {
        level = currentLevel;
    }

    public int getLevel()
    {
        return level;
    }
}
