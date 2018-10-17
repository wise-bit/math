package unit2_recursion.exercises;


import java.awt.*;
import javax.swing.JPanel;

public class FractalJPanelPineapple extends JPanel {

    private Color color;
    private int level;

    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;

    private static final int length = 50;
    private final double angle = (45 * Math.PI) / 180;
    private static int n = 1;


    public FractalJPanelPineapple (int currentLevel) {

        color = Color.BLUE;
        level = currentLevel;
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

    }

    public void drawFractal (int level, int xA, int yA, int xB,
                             int yB, Graphics g) {

        //if (level == 0)
        //	g.drawLine(xA, yA, xA, yB);
        // if (level > 0) {

        if (n < level) {

            // TODO PARAMETERS ARE MESSED UP
//            int xC = xB - 20;
//            int yC = yB + yB/2;
//
//            int xD = xB + 20;
//            int yD = yC;

            int xC = (int) (xB + length * Math.cos(angle * n));
            int yC = (int) (yB - length * Math.sin(angle * n));

            int xD = (int) (xB - length * Math.cos(angle * n));
            int yD = (int) (yB - length * Math.sin(angle * n));

            g.drawLine(xB, yB, xC, yC);
            g.drawLine(xB, yB, xD, yD);

            drawFractal(level - 1, xB, yB, xC, yC, g);
            drawFractal(level - 1, xB, yB, xD, yD, g);

            n++;
			/*
			int xC = (xA + xB) / 2;
			int yC = (yA + yB) / 2;


			int xD = xA + (xC - xA) / 2 - (yC - yA) / 2;
			int yD = yA + (yC - yA) / 2 + (xC - xA) / 2;

			drawFractal(level - 1, xD, yD, xA, yA, g);
			drawFractal(level - 1, xD, yD, xC, yC, g);
			drawFractal(level - 1, xD, yD, xB, yB, g);
			 */
        }

    }

    public void paintComponent (Graphics g) {


        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(WIDTH / 2, HEIGHT / 2);
        g2d.scale(1, -1);

        int x = 0;
        int y = 50;
        g2d.setColor(color);
        g2d.drawLine(0, 0, x, y);
        drawFractal(level, x, y, x, y, g2d);
    }

    public void setColor (Color c) {
        color = c;
    }

    public void setLevel (int currentLevel) {
        level = currentLevel;
    }

    public int getLevel() {
        return level;
    }
}


