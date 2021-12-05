package drawing;

import geometry.Vector;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class AwtDrawingApi implements DrawingApi {
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 1000;
    private final Graphics2D graphics2D;

    public AwtDrawingApi() {
        Frame frame = new Frame();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.setTitle("Graph visualizer");
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
        graphics2D = (Graphics2D) frame.getGraphics();
    }

    @Override
    public long getDrawingAreaWidth() {
        return WIDTH;
    }

    @Override
    public long getDrawingAreaHeight() {
        return HEIGHT;
    }

    @Override
    public void drawCircle(Vector center, double radius) {
        graphics2D.setPaint(Color.black);
        graphics2D.fill(new Ellipse2D.Double(center.x - radius, center.y - radius, 2 * radius, 2 * radius));
    }

    @Override
    public void drawLine(Vector p1, Vector p2) {
        graphics2D.setPaint(Color.black);
        graphics2D.draw(new Line2D.Double(p1.x, p1.y, p2.x, p2.y));
    }
}
