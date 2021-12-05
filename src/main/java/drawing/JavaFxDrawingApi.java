package drawing;

import javafx.application.Application;
import geometry.Vector;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class JavaFxDrawingApi extends Application implements DrawingApi {
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 1000;
    private static GraphicsContext context;

    public JavaFxDrawingApi() {
        if (context == null) {
            Canvas canvas = new Canvas(WIDTH, HEIGHT);
            context = canvas.getGraphicsContext2D();
        }
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Graph visualizer");
        Group root = new Group();
        root.getChildren().add(context.getCanvas());
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void run() {
        new Thread(JavaFxDrawingApi::launch).start();
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
        context.setFill(Color.BLACK);
        context.fillOval(center.x - radius, center.y - radius, 2 * radius, 2 * radius);
    }

    @Override
    public void drawLine(Vector p1, Vector p2) {
        context.setStroke(Color.BLACK);
        context.strokeLine(p1.x, p1.y, p2.x, p2.y);
    }
}
